package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
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
//    @PutMapping("/")
//    public String newUserForm(Model model, @RequestBody User user) {
//        model.addAttribute("save", service.listUsers());
//        return "save";
//    }
//    // изменеие юзера
//    @PutMapping("/{id}")
//    public String updateUser(@PathVariable("id") Long id, Model model){
//        model.addAttribute();
//        return null;
//    }
//    // удаление юзера
//    @DeleteMapping("/{id}")
//    public String deleteUserbyId(@PathVariable("id") Long id, Model model){
//        model.addAttribute("delete", service.);
//        return "delete";
//    }
}

