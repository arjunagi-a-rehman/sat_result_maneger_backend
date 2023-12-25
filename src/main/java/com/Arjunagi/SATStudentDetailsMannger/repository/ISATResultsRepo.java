package com.Arjunagi.SATStudentDetailsMannger.repository;

import com.Arjunagi.SATStudentDetailsMannger.models.SATResults;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ISATResultsRepo extends JpaRepository<SATResults,Integer> {
    Optional<SATResults> findByName(String name);
    List<SATResults> findAllByOrderByScoreDesc();
    @Query("SELECT COUNT(s) + 1 FROM SATResults s WHERE s.score > (SELECT score FROM SATResults WHERE name = :studentName)")
    int calculateRank(String studentName);
}
