package api.quiz.alternative.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import api.quiz.alternative.model.AlternativeModel;

public interface AlternativeRepository extends JpaRepository<AlternativeModel, Long> {
    
    @Query("FROM AlternativeModel a WHERE a.question.id = :id")
    List<AlternativeModel> getAllAlternativeByQuestionId(@Param("id") Long id);

}
