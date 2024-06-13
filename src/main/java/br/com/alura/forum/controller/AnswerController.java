package br.com.alura.forum.controller;

import br.com.alura.forum.domain.answer.AnswerData;
import br.com.alura.forum.domain.answer.AnswerRepository;
import br.com.alura.forum.domain.answer.AnswerService;
import br.com.alura.forum.domain.answer.AnswerDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("answers")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @Autowired
    private AnswerRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity registerAnswer(@RequestBody @Valid AnswerData data) {
        var dto = answerService.registerAnswer(data);
        var answer = repository.getReferenceById(dto.id());
        return ResponseEntity.ok(new AnswerDTO(answer));
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<List<AnswerDTO>> showAnswerByTopic(@PathVariable Long id) {
        var list = repository.findAllByTopic_id(id).stream().map(AnswerDTO::new).toList();
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteAnswer(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
