package com.Arjunagi.SATStudentDetailsMannger.services;

import com.Arjunagi.SATStudentDetailsMannger.dtos.SATResultsDto;

import java.util.List;

public interface ISATResultsServices {
    /**
     * Creates the sat result and student data in db
     * @param satResultsDto
     */
    void createStudentResultRecord(SATResultsDto satResultsDto);

    Integer getRankByName(String name);

   List<SATResultsDto> getAll();

     Boolean updateScore(String name, Float score);

    Boolean deleteRecord(String name);
}
