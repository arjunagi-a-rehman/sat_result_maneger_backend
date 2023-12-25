package com.Arjunagi.SATStudentDetailsMannger.mapper;

import com.Arjunagi.SATStudentDetailsMannger.dtos.SATResultsDto;
import com.Arjunagi.SATStudentDetailsMannger.models.SATResults;

public class SATResultsMapper {
    public static SATResultsDto SATResultToSATResultsDto(SATResults satResults,SATResultsDto satResultsDto){

        satResultsDto.setAddress(satResults.getAddress());
        satResultsDto.setName(satResults.getName());
        satResultsDto.setScore(satResults.getScore());
        satResultsDto.setPincode(satResults.getPincode());
        satResultsDto.setCity(satResults.getCity());
        satResultsDto.setCountry(satResults.getCountry());
        satResultsDto.setPassed(satResults.getPassed());

        return satResultsDto;
    }
    public static SATResults SATResultsDtoToSATResults(SATResultsDto satResultsDto,SATResults satResults){
        satResults.setAddress(satResultsDto.getAddress());
        satResults.setName(satResultsDto.getName());
        satResults.setScore(satResultsDto.getScore());
        satResults.setPincode(satResultsDto.getPincode());
        satResults.setCity(satResultsDto.getCity());
        satResults.setCountry(satResultsDto.getCountry());
        satResults.setPassed(satResultsDto.getPassed());

        return satResults;
    }
}
