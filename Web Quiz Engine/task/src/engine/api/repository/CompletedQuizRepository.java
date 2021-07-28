package engine.api.repository;

import engine.api.entity.CompletedQuiz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompletedQuizRepository extends JpaRepository<CompletedQuiz, Integer> {

    Page<CompletedQuiz> findAllByEmail(String email, Pageable pageable);
}
