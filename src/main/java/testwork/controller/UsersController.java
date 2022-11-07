package testwork.controller;

import lombok.extern.slf4j.Slf4j;
import testwork.model.User;
import testwork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/admin")
public class UsersController {

    @Autowired
    UserService service;


    @GetMapping()
    public String getAllUsers(ModelMap map) {
        log.info("inside get all users");
        map.addAttribute("users", service.listUsers());
        return "admin";
    }

    @PostMapping()
    public String addUser(@ModelAttribute User user) {
        log.info("trying add User");
        service.add(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        service.deleteUser(id);
        return "redirect:/admin";
    }

    @GetMapping("/test")
    public void testGetUser(){
        User user = service.getUser(1L);
        System.out.println(user.getEmail());
    }

    @PatchMapping("/{id}")
    public String editUser(@PathVariable("id")Long id, User user){
        service.editUser(user, id);
        return "redirect:/admin";
    }

}


