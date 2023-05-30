package bitlab.final_project.trello.controllers;

import bitlab.final_project.trello.models.Folders;
import bitlab.final_project.trello.models.Tasks;
import bitlab.final_project.trello.service.FoldersService;
import bitlab.final_project.trello.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private FoldersService foldersService;
    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public String mainPage(Model model) {
        List<Folders> folders = foldersService.findAll();
        model.addAttribute("folders", folders);
        return "index";
    }

    @PostMapping("/addfolder")
    public String addFolder(Folders folders) {
        foldersService.addFolder(folders);
        return "redirect:/";
    }

    @PostMapping("/delFolder")
    public String deleteFolder(@RequestParam("folderId") Long folderId, Model model) {
        List<Tasks> tasksList = taskService.findAllTasks(folderId);
        if (tasksList.size() == 0) {
            foldersService.deleteFolder(folderId);
            return "redirect:/";
        }
        String warning = foldersService.sendWarning();
        model.addAttribute("warning", warning);
        return "redirect:/";
    }
}