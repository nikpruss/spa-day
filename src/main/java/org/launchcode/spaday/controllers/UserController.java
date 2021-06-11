package org.launchcode.spaday.controllers;

import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("add")
    public String displayAddUserForm() {
        return "user/add";
    }

    @GetMapping
    public String displayIndexForm(Model model) {
        model.addAttribute("users", UserData.getAll());
        return "user/index";
    }

    @PostMapping("add")
    public String processAddUserForm(Model model, @ModelAttribute User user, @RequestParam String verify) {
        String userPassword = user.getPassword();
        String welcome;
        Boolean error = false;
        if (userPassword.equals(verify)) {
            welcome = "Welcome" + user.getUsername();
            model.addAttribute("welcome",welcome);
            UserData.add(user);
        } else {
            error = true;
            model.addAttribute("error", error);
            model.addAttribute("username", user.getUsername());
            model.addAttribute("email", user.getEmail());
            return "user/add";
        }
        return "redirect:";
    }

    @GetMapping("display/{userID}")
    public String displayUserDetails(Model model, @PathVariable int userID) {
        User displayUser = UserData.getById(userID);
        model.addAttribute("username", displayUser.getUsername());
        model.addAttribute("email", displayUser.getEmail());
        return "user/display";
    }

}
