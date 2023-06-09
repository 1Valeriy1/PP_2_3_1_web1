package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping(value = "/")
    public String users(Model model){
        model.addAttribute("users", service.listUsers());
        return "users";
    }
//сохранение юзера
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("user", new User());
        return "add";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("user") User user) {
        service.add(user);
        return "redirect:/";
    }

    @PutMapping("/update")
    public String update(@ModelAttribute("user") User user) {
        service.upd(user);
        return "redirect:/";
    }

    // изменеие юзера
    @GetMapping("/find/{id}")
    public String find(@PathVariable( value = "id") long id, Model model) {
        User user = service.getUserById(id);
        model.addAttribute("user", user);
        return "update";
    }
    // удаление юзера
    @DeleteMapping("/delete/{id}")
    public String deleteUserById(@PathVariable("id") Long id){
        this.service.delete(id);
        return "redirect:/";
    }
}

