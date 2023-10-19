package api.quiz.question.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import api.quiz.question.model.QuestionModel;

public interface QuestionRepository extends JpaRepository<QuestionModel,Long> {

    @Query("FROM QuestionModel q WHERE q.category = :category")
    List<QuestionModel> getAllByCategory(@Param("category") String category);    
}

