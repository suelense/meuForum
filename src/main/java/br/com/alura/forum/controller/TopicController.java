package br.com.alura.forum.controller;

import br.com.alura.forum.domain.topic.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("topics")
public class TopicController {
    @Autowired
    private TopicRepository repository;

    @Autowired
    private TopicService topicService;

    @PostMapping
    @Transactional
    public ResponseEntity registerTopic(@RequestBody @Valid TopicData data,
                                        UriComponentsBuilder uriComponentsBuilder) {
        var dto = topicService.topicSave(data);
        var uri = uriComponentsBuilder.path("/topics/{id}").buildAndExpand(dto.id()).toUri();
        var topic = repository.getReferenceById(dto.id());
        return ResponseEntity.created(uri).body(new TopicDTO(topic));
    }

    @GetMapping
    public ResponseEntity<List<TopicDTO>> listTopic(@PageableDefault Pageable pageable) {
        var list = repository.findAllByStatusTrue(pageable).stream().map(TopicDTO::new).toList();
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteTopic(@PathVariable Long id) {
        var topic = repository.getReferenceById(id);
        topic.delete();
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity updateCourse(@PathVariable Long id, TopicUpdateDTO data) {
        var topic = repository.getReferenceById(id);
        topic.updateCourse(data);
        return ResponseEntity.ok(new TopicDTO(topic));
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity showTopic(@PathVariable Long id) {
        var topic = repository.getReferenceById(id);
        return ResponseEntity.ok(new TopicDTO(topic));
    }

    @GetMapping("/course/{id}")
    @Transactional
    public ResponseEntity<List<TopicDTO>> showTopicByCourse(@PathVariable Long id) {
        var list = repository.findAllByCourse_id(id).stream().map(TopicDTO::new).toList();
        return ResponseEntity.ok(list);
    }
}
