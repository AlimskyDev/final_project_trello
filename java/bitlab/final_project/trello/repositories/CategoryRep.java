package bitlab.final_project.trello.repositories;

import bitlab.final_project.trello.models.TaskCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRep extends JpaRepository<TaskCategories, Long> {
}
