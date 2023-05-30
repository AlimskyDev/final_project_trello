package bitlab.final_project.trello.service.impl;

import bitlab.final_project.trello.models.Folders;
import bitlab.final_project.trello.models.TaskCategories;
import bitlab.final_project.trello.repositories.FoldersRep;
import bitlab.final_project.trello.service.FoldersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoldersServiceImpl implements FoldersService {
    @Autowired
    private FoldersRep foldersRep;

    @Override
    public List<Folders> findAll(){
        List<Folders> folders = foldersRep.findAll();
        return folders;
    }

    @Override
    public void addFolder(Folders folders) {
        foldersRep.save(folders);
    }

    @Override
    public Folders findById(Long id) {
        return foldersRep.findById(id).orElse(null);
    }

    @Override
    public void deleteFolder(Long id) {
        foldersRep.deleteById(id);
    }

    @Override
    public String sendWarning() {
        String warning = "Finish all tasks and delete them";
        return warning;
    }
}
