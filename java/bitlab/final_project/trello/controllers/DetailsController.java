package bitlab.final_project.trello.controllers;

import bitlab.final_project.trello.models.Folders;
import bitlab.final_project.trello.models.TaskCategories;
import bitlab.final_project.trello.models.Tasks;
import bitlab.final_project.trello.service.CategoryService;
import bitlab.final_project.trello.service.FoldersService;
import bitlab.final_project.trello.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class DetailsController {
    @Autowired
    private FoldersService foldersService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private TaskService taskService;

    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model) {
        Folders folders = foldersService.findById(id);
        List<TaskCategories> categories = categoryService.findAllCategories();
        List<Tasks> tasksList = taskService.findAllTasks(id);
        categories.removeAll(folders.getCategories());

        String warning = foldersService.sendWarning();
        model.addAttribute("warning", warning);

        model.addAttribute("folders", folders);
        model.addAttribute("categories", categories);
        model.addAttribute("tasksList", tasksList);
        return "details";
    }
}
