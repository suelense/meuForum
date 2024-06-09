package br.com.alura.forum.controller;

import br.com.alura.forum.domain.topic.Topic;
import br.com.alura.forum.domain.topic.TopicData;
import br.com.alura.forum.domain.topic.TopicRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("topics")
public class TopicController {
    @Autowired
    private TopicRepository repository;

    @PostMapping
    @Transactional
    public void registerTopic(@RequestBody @Valid TopicData data) throws Exception {
        var topic = new Topic(data);
        if (!repository.existsByTitle(topic.getTitle())) {
            repository.save(topic);
        } else {
            throw new RuntimeException("Email já cadastrado!");
        }
    }


}
