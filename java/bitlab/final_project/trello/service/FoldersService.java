package bitlab.final_project.trello.service;

import bitlab.final_project.trello.models.Folders;

import java.util.List;

public interface FoldersService {
    List<Folders> findAll();
    void addFolder(Folders folders);

    Folders findById(Long id);

    void deleteFolder(Long id);

    String sendWarning();
}
