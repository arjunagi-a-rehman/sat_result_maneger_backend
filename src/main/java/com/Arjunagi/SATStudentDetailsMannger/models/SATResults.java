package com.Arjunagi.SATStudentDetailsMannger.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Collections;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
public class SATResults {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String name;
    private String address;
    @OrderBy("score DESC")
    private Float score;
    private String pincode;
    private Boolean passed;
    private String city;
    private String country;
    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime createdAt;
    @Column(updatable = false)
    @CreatedBy
    private String createdBy;
    @Column(insertable = false)
    @LastModifiedDate
    private LocalDateTime updatedAt;
    @Column(insertable = false)
    @LastModifiedBy
    private String updatedBy;
}
