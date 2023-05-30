package bitlab.final_project.trello.service.impl;

import bitlab.final_project.trello.models.Folders;
import bitlab.final_project.trello.models.TaskCategories;
import bitlab.final_project.trello.repositories.CategoryRep;
import bitlab.final_project.trello.repositories.FoldersRep;
import bitlab.final_project.trello.service.CategoryService;
import bitlab.final_project.trello.service.FoldersService;
import ch.qos.logback.core.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRep categoryRep;
    @Autowired
    private FoldersRep foldersRep;

    @Override
    public void deleteCat(Long idC, Long idF) {
        TaskCategories taskCategory = categoryRep.findById(idC).orElseThrow();
        Folders folders = foldersRep.findById(idF).orElseThrow();
        List<TaskCategories> categories = folders.getCategories();
        categories.remove(taskCategory);
        foldersRep.save(folders);
    }

    @Override
    public List<TaskCategories> findAllCategories() {
        List<TaskCategories> categories = categoryRep.findAll();
        return categories;
    }

    @Override
    public void addCategory(Long idC, Long idF) {
        TaskCategories taskCategory = categoryRep.findById(idC).orElseThrow();
        Folders folders = foldersRep.findById(idF).orElseThrow();
        List<TaskCategories> categories = folders.getCategories();
        if (!categories.contains(taskCategory)) {
            categories.add(taskCategory);
        }
        foldersRep.save(folders);
    }

    @Override
    public void addCat(String name) {
        TaskCategories taskCategories = new TaskCategories(null, name);
        categoryRep.save(taskCategories);
    }

    @Override
    public void delCat(Long id) {
        categoryRep.deleteById(id);
    }
}
