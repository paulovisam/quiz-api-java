package api.quiz.question.view;


import java.util.List;

import api.quiz.alternative.view.AlternativeSimpleView;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionView {
    private Long id;    
    private String text;
    private String category;    
    private Long level;
    private List<AlternativeSimpleView> alternatives;
}
