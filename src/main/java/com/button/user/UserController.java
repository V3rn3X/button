package com.button.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/index")
    String addEmployeeForm(final Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "index";
    }

    @PostMapping("/index")
    String addEmployee(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "index";
        }
        service.saveUsers(List.of(user));
        return "redirect:/index";
    }
}
