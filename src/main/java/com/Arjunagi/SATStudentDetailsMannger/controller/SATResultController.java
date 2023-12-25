package com.Arjunagi.SATStudentDetailsMannger.controller;

import com.Arjunagi.SATStudentDetailsMannger.dtos.ErrorResponseDto;
import com.Arjunagi.SATStudentDetailsMannger.dtos.ResponseDto;
import com.Arjunagi.SATStudentDetailsMannger.dtos.SATResultsDto;
import com.Arjunagi.SATStudentDetailsMannger.services.ISATResultsServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CURD API's for student sat result data",
        description = "CURD REST API's in to create, update, fetch and delete sat score for students"
)
@RestController
@AllArgsConstructor
@RequestMapping(path = "/api",produces = MediaType.APPLICATION_JSON_VALUE)
public class SATResultController {
    ISATResultsServices satResultsServices;

    @Operation(
            summary = "Create SAT result REST API",
            description = "This Rest API I create new sat result record by student name "
    )
    @ApiResponses(
            {
                    @ApiResponse(
                            responseCode = "201",
                            description = "HTTP Status CREATED"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "HTTP Status Internal Server Error",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorResponseDto.class)
                            )
                    )
            }
    )
    @PostMapping("/student/result")
    public ResponseEntity<ResponseDto> createStudentResultRecord(@RequestBody SATResultsDto satResultsDto){
        satResultsServices.createStudentResultRecord(satResultsDto);
        return new ResponseEntity<>(new ResponseDto("201","The data inserted successfully"), HttpStatus.CREATED);
    }

    @Operation(
            summary = "Fetch Student rank Details REST API",
            description = "API to Fetch rank  based on student name"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @GetMapping("/student/rank")
    public ResponseEntity<Integer> getRankByName(@RequestParam String name){
        return ResponseEntity.ok(satResultsServices.getRankByName(name));
    }

    @Operation(
            summary = "Fetch All data REST API",
            description = "API to Fetch all the datda"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @GetMapping("/sat/all")
    public ResponseEntity<List<SATResultsDto>> getAll(){
        return ResponseEntity.ok(satResultsServices.getAll());
    }

    @Operation(
            summary = "Update student score REST API",
            description = "API to update update student marks"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "Expectation Failed"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @PatchMapping("/student/score/{name}")
    public ResponseEntity<ResponseDto> updateScore(@PathVariable String name,@RequestParam Integer score){
        Boolean isUpdated=satResultsServices.updateScore(name, Float.valueOf(score));
        if(isUpdated){
            return new ResponseEntity<>(new ResponseDto("200","marks updated"),HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(new ResponseDto("417","update operation failed. Please try again or contact Dev team"),HttpStatus.EXPECTATION_FAILED);
        }
    }

    @Operation(
            summary = "Delete sat result Details REST API",
            description = "API to Delete result details Details based on student name"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "Expectation Failed"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @DeleteMapping("/result/student")
    public ResponseEntity<ResponseDto> deleteRecord(@RequestParam String name){
        Boolean isDeleted=satResultsServices.deleteRecord(name);
        if (isDeleted){
            return new ResponseEntity<>(new ResponseDto("200","deleted successful"),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(new ResponseDto("417","Delete operation failed. Please try again or contact Dev team"),HttpStatus.EXPECTATION_FAILED);
        }
    }
}
