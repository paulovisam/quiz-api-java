package api.quiz.alternative.view;

import api.quiz.question.view.QuestionView;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlternativeView {
    private Long id;
    private String text;
    private Boolean correct;
    private QuestionView question;
}