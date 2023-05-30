package bitlab.final_project.trello.repositories;

import bitlab.final_project.trello.models.Folders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoldersRep extends JpaRepository<Folders, Long> {
}
