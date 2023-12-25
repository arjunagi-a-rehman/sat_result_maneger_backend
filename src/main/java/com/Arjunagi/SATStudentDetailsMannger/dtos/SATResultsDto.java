package com.Arjunagi.SATStudentDetailsMannger.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        name = "SATResults",
        description = "Schema holds the SAT candidates and their result data"
)
public class SATResultsDto {
    @Schema(
            description = "student name",
            example = "kallu sharma"
    )
    private String name;
    @Schema(
            description = "student address ",
            example = "patli gali 2nd main"
    )
    private String address;
    @Schema(
            description = "total score secured by student out of 1600",
            example = "800"
    )
    private Float score;
    @Schema(
            description = "Postal pin code",
            example = "560064"
    )
    private String pincode;
    @Schema(
            description = "This field indicates whether student passed or not",
            example = "true"
    )
    private Boolean passed;
    @Schema(
            description = "Candidates city name",
            example = "bangalore"
    )
    private String city;
    @Schema(
            description = "candidates country name",
            example = "india"
    )
    private String country;
}
