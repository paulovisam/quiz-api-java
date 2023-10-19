package api.quiz.alternative.controller;

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
import api.quiz.alternative.view.AlternativeView;
import api.quiz.question.model.QuestionModel;
import api.quiz.question.repository.QuestionRepository;

@RequestMapping(value = "alternative")
@RestController
public class AlternativeController {
    @Autowired
    private AlternativeRepository alternativeRepository;

    @Autowired
    private QuestionRepository questionRepository;

    private ModelMapper modelMapper;

    @PostMapping(value = "/create")
    public AlternativeView create(@RequestBody AlternativeView alternativeView, @RequestParam(name = "question_id") Long question_id) {
        this.modelMapper = new ModelMapper();
        QuestionModel questionModel = questionRepository.findById(question_id).get();

        AlternativeModel alternative = modelMapper.map(alternativeView, AlternativeModel.class);
        alternative.setQuestion(questionModel);
        System.out.println(question_id);

        // return null;
        return modelMapper.map(alternativeRepository.save(alternative), AlternativeView.class);
    }
    @GetMapping(value = "/read")
    public AlternativeView read(@RequestParam(name = "id") Long id) {
        this.modelMapper = new ModelMapper();
        return modelMapper.map(alternativeRepository.findById(id).get(), AlternativeView.class);

    }

    @PutMapping(value = "/update")
    public AlternativeView update(@RequestBody AlternativeView alternativeView) {
        this.modelMapper = new ModelMapper();
        AlternativeModel alternative = modelMapper.map((alternativeView), AlternativeModel.class);
        return modelMapper.map(alternativeRepository.save(alternative), AlternativeView.class);
    }

    @DeleteMapping(value = "/delete")
    public void delete(@RequestParam(name = "id") Long id) {
        this.modelMapper = new ModelMapper();
        alternativeRepository.deleteById(id);
    }
}
