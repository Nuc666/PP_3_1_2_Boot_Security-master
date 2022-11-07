package testwork.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import testwork.model.User;
import testwork.service.UserService;

import java.security.Principal;


@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public String getUser(ModelMap model, Principal principal){
//        User user = userService.getUser(principal.getName())
//        todo: передать пользователя из БД в Модель
        return "/user";
    }
}
