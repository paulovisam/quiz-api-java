package api.quiz.alternative.model;

import api.quiz.question.model.QuestionModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "alternatives")
@Getter
@Setter
public class AlternativeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "text")
    private String text;

    @Column(name = "correct")
    private Boolean correct;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private QuestionModel question;
}
