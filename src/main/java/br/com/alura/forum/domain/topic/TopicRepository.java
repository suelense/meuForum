package br.com.alura.forum.domain.topic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    Page<Topic> findAllByStatusTrue(Pageable pageable);

    boolean existsByTitle(String title);

    boolean existsByMessage(String message);

    List<Topic> findAllByCourse_id(Long id);
}
