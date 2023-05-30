package bitlab.final_project.trello.controllers;


import bitlab.final_project.trello.models.Folders;
import bitlab.final_project.trello.models.TaskCategories;
import bitlab.final_project.trello.repositories.CategoryRep;
import bitlab.final_project.trello.repositories.FoldersRep;
import bitlab.final_project.trello.service.CategoryService;
import bitlab.final_project.trello.service.FoldersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Locale;


@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private FoldersRep foldersRep;

    @Autowired
    private CategoryRep categoryRep;

    @PostMapping("/deleteCategory")
    public String deleteCategory(@RequestParam (name = "idCategory") Long categoriesId,
                                 @RequestParam (name = "idFolders") Long foldersId) {
        categoryService.deleteCat(categoriesId, foldersId);
        return "redirect:/details/"+foldersId;
    }

    @PostMapping("/addCategory")
    public String addCat(@RequestParam (name = "idCategory") Long categoriesId,
                         @RequestParam (name = "idFolders") Long foldersId) {
        categoryService.addCategory(categoriesId, foldersId);
        return "redirect:/details/"+foldersId;
    }

    @GetMapping("/categories")
    public String categories(Model model) {
        List<TaskCategories> categories = categoryService.findAllCategories();
        model.addAttribute("categories", categories);
        return "/categories";
    }

    @PostMapping("/addCat")
    public String addCat(@RequestParam(name = "name") String name) {
        categoryService.addCat(name);
        return "redirect:/categories";
    }

    @PostMapping("/delCat")
    public String delCat(@RequestParam(name = "catId") Long id) {
        categoryService.delCat(id);
        List<Folders> folders = foldersRep.findAll();
        for (Folders folder : folders)
        {
            if (folder.getCategories().contains(categoryRep.findById(id))) {
                folder.getCategories().remove(categoryRep.findById(id));
            }
        }
        return "redirect:/categories";
    }

}