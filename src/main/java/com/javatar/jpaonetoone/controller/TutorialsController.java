package com.javatar.jpaonetoone.controller;

import com.javatar.jpaonetoone.model.Tutorial;
import com.javatar.jpaonetoone.repository.TutorialDetailsRepository;
import com.javatar.jpaonetoone.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tutorials")
public class TutorialsController {

    @Autowired
    private TutorialRepository tutorialRepository;
    @Autowired
    private TutorialDetailsRepository tutorialDetailsRepository;

    @PostMapping
    public Tutorial save(@RequestBody Tutorial tutorial){
        return tutorialRepository.save(tutorial);
    }
}
