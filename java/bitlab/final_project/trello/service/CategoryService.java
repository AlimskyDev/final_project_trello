package bitlab.final_project.trello.service;

import bitlab.final_project.trello.models.TaskCategories;

import java.util.List;

public interface CategoryService {
    void deleteCat(Long idC, Long idF);
    List<TaskCategories> findAllCategories();

    void addCategory(Long idC, Long idF);

    void addCat(String name);

    void delCat(Long id);


}
