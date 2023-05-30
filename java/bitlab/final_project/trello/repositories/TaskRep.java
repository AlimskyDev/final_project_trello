package bitlab.final_project.trello.repositories;

import bitlab.final_project.trello.models.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRep extends JpaRepository<Tasks, Long> {
    List<Tasks> findAllByFoldersId(Long id);
}