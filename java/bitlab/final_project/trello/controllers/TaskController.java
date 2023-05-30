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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/addTask")
    public String addTask(Tasks tasks){
        taskService.addTask(tasks);
        return "redirect:/details/"+tasks.getFolders().getId();
    }

    @GetMapping("/taskView/{id}")
    public String viewMore(Model model, @PathVariable("id") Long id) {
        Tasks tasks = taskService.findById(id);
        model.addAttribute("tasks", tasks);
        return "taskView";
    }

    @PostMapping("/saveTask")
    public String saveTask(Tasks tasks) {
        taskService.saveTasks(tasks);
        return "redirect:/details/"+tasks.getFolders().getId();
    }

    @PostMapping("/deleteTask")
    public String deleteTask(@RequestParam(name = "id") Long id,
                             @RequestParam(name = "folder_id") Long folder_id) {
        taskService.deleteTask(id);
        return "redirect:/details/" + folder_id;
    }
}
