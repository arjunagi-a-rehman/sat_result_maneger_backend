package com.Arjunagi.SATStudentDetailsMannger.services.Imp;

import com.Arjunagi.SATStudentDetailsMannger.dtos.SATResultsDto;
import com.Arjunagi.SATStudentDetailsMannger.exception.RecordAlreadyExistException;
import com.Arjunagi.SATStudentDetailsMannger.exception.ResourceNotFoundException;
import com.Arjunagi.SATStudentDetailsMannger.mapper.SATResultsMapper;
import com.Arjunagi.SATStudentDetailsMannger.models.SATResults;
import com.Arjunagi.SATStudentDetailsMannger.repository.ISATResultsRepo;
import com.Arjunagi.SATStudentDetailsMannger.services.ISATResultsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DefaultSATResultServices implements ISATResultsServices {
    List<SATResults> sortedSatResults;
    @Autowired
    ISATResultsRepo satResultsRepo;
    /**
     * Creates the sat result and student data in db
     *
     * @param satResultsDto
     */
    @Override
    public void createStudentResultRecord(SATResultsDto satResultsDto) {
        if(satResultsRepo.findByName(satResultsDto.getName().toLowerCase()).isPresent()){
            throw new RecordAlreadyExistException("The student record with name:"+satResultsDto.getName()+" Already exist");
        }
        boolean passed=(satResultsDto.getScore()/1600)>=0.3;
        satResultsDto.setPassed(passed);
        satResultsRepo.save(SATResultsMapper.SATResultsDtoToSATResults(satResultsDto,new SATResults()));
        if (sortedSatResults==null){
            sortedSatResults=satResultsRepo.findAllByOrderByScoreDesc();
        }else {
            addNewResult(satResultsRepo.findByName(satResultsDto.getName()).orElseThrow());
        }
    }

    /**
     * @param name
     * @return
     */
    @Override
    public Integer getRankByName(String name) {
        if(sortedSatResults==null){
            sortedSatResults=satResultsRepo.findAllByOrderByScoreDesc();
        }
        SATResults satResults=satResultsRepo.findByName(name).orElseThrow(()->new ResourceNotFoundException("Student result","name",name));
        int index = Collections.binarySearch(sortedSatResults, satResults,
                (result1, result2) -> Float.compare(result2.getScore(), result1.getScore()));
        return index+1;
    }

    /**
     * @return
     */
    @Override
    public List<SATResultsDto> getAll() {
        List<SATResultsDto> satResultsDtoList=new ArrayList<>();
        for(SATResults satResults:satResultsRepo.findAll()){
            satResultsDtoList.add(SATResultsMapper.SATResultToSATResultsDto(satResults,new SATResultsDto()));
        }
        return satResultsDtoList;
    }

    /**
     * @param name
     * @param score
     */
    @Override
    public Boolean updateScore(String name, Float score) {
        SATResults satResults=satResultsRepo.findByName(name).orElseThrow(()->new ResourceNotFoundException("Student result","name",name));
        if(sortedSatResults==null){
            sortedSatResults=satResultsRepo.findAllByOrderByScoreDesc();
        }
        sortedSatResults.remove(satResults);
        satResults.setScore(score);
        addNewResult(satResults);
        satResultsRepo.save(satResults);
        return true;
    }

    /**
     * @param name
     * @return
     */
    @Override
    public Boolean deleteRecord(String name) {
        SATResults satResults=satResultsRepo.findByName(name).orElseThrow(()->new ResourceNotFoundException("Student result","name",name));
        if(sortedSatResults==null){
            sortedSatResults.remove(satResults);
        }
        satResultsRepo.delete(satResults);
        return true;
    }

    private void addNewResult(SATResults newResult) {
        //  list is initially sorted, if not, you can sort it before adding.
        int insertionIndex = Collections.binarySearch(sortedSatResults, newResult,
                (result1, result2) -> Float.compare(result2.getScore(), result1.getScore()));

        if (insertionIndex < 0) {
            // Convert the insertion point to the actual insertion index
            insertionIndex = -insertionIndex - 1;
        }
        sortedSatResults.add(insertionIndex, newResult);
    }
}
