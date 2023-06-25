package com.javatar.jpaonetoone.controller;

import com.javatar.jpaonetoone.model.Comment;
import com.javatar.jpaonetoone.repository.CommentRepository;
import com.javatar.jpaonetoone.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tutorials")
public class CommentController {

    @Autowired
    private TutorialRepository tutorialRepository;
    @Autowired
    private CommentRepository commentRepository;

    @PostMapping("/{tutorialId}/comments")
    public Comment save(@PathVariable("tutorialId") Long tutorialId,
                        @RequestBody Comment comment) throws Exception {
        Comment comment1 = tutorialRepository.findById(tutorialId).map(tutorial -> {
            comment.setTutorial(tutorial);
            return commentRepository.save(comment);
        }).orElseThrow(() -> new Exception("Not Fond"));
        return comment1;
    }

    @GetMapping("/{tutorialId}/comments")
    public List<Comment> findAllCommentByTutorialId(
            @PathVariable("tutorialId") Long tutorialId) throws Exception {
        if (!tutorialRepository.existsById(tutorialId))
            throw new Exception("Not fond");
        return commentRepository.findByTutorialId(tutorialId);
    }
}
