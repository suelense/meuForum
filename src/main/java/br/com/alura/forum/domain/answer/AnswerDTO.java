package br.com.alura.forum.domain.answer;

import java.time.LocalDateTime;

public record AnswerDTO(Long id,
                        String message,
                        LocalDateTime creation_date,
                        Long topicId,
                        Long userId,
                        String userName) {
    public AnswerDTO(Answer answer) {
        this(answer.getId(),
                answer.getMessage(),
                answer.getCreation_date(),
                answer.getTopic().getId(),
                answer.getUser().getId(),
                answer.getUser().getName());
    }
}
