package api.quiz.alternative.view;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlternativeSimpleView {
    private Long id;
    private String text;
    private Boolean correct;
}