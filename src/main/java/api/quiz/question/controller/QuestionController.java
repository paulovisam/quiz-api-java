package api.quiz.question.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import api.quiz.alternative.model.AlternativeModel;
import api.quiz.alternative.repository.AlternativeRepository;
import api.quiz.alternative.view.AlternativeSimpleView;
import api.quiz.question.model.QuestionModel;
import api.quiz.question.repository.QuestionRepository;
import api.quiz.question.view.QuestionView;

@RequestMapping(value = "/question")
@RestController
public class QuestionController {
    @Autowired
    private QuestionRepository questionRepository;
    
    @Autowired
    private AlternativeRepository alternativeRepository;
    
    private ModelMapper modelMapper;
    @PostMapping(value = "/create")
    public QuestionView create(@RequestBody QuestionView questionView) {
        this.modelMapper = new ModelMapper();
        QuestionModel question = modelMapper.map((questionView), QuestionModel.class);
        return modelMapper.map(questionRepository.save(question), QuestionView.class);
    }

    @GetMapping(value = "/read")
    public QuestionView read(@RequestParam(name = "id") Long id) {
        this.modelMapper = new ModelMapper();
        QuestionModel questionModel = questionRepository.findById(id).get();
        // questionModel.setAlternatives(alternativeRepository.getAllAlternativeByQuestionId(id));
        QuestionView questionView = modelMapper.map(questionModel, QuestionView.class);
        List<AlternativeModel> alternatives = alternativeRepository.getAllAlternativeByQuestionId(id);
        List<AlternativeSimpleView> alternativeViews = alternatives.stream()
            .map(alternative -> modelMapper.map(alternative, AlternativeSimpleView.class))
            .collect(Collectors.toList());
        questionView.setAlternatives(alternativeViews);    
        return questionView;

    }
    @PutMapping(value = "/update")
    public QuestionView update(@RequestBody QuestionView questionView) {
        this.modelMapper = new ModelMapper();
        QuestionModel question = modelMapper.map((questionView), QuestionModel.class);
        return modelMapper.map(questionRepository.save(question), QuestionView.class);
    }

    @DeleteMapping(value = "/delete")
    public void delete(@RequestParam(name = "id") Long id) {
        this.modelMapper = new ModelMapper();
        questionRepository.deleteById(id);
    }
}
