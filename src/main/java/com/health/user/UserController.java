package com.health.user;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;
    
    @GetMapping("/Signup")
    public String signup(Model model) {
    	model.addAttribute("userCreateForm", new UserCreateAccount());
        return "signup";
    }   
    
    @PostMapping("/Signup")
    public String signup(@Valid UserCreateAccount userCreateForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup";
        }

        if (!userCreateForm.getUserpassword().equals(userCreateForm.getUserpasswordconfirm())) {
            bindingResult.rejectValue("userpasswordconfirm", "passwordInCorrect", 
                    "2개의 패스워드가 일치하지 않습니다.");
            return "signup";
        }

        userService.create(
        		userCreateForm.getUserid(), 
        		userCreateForm.getUserpassword(),
                userCreateForm.getUseremail(),
                userCreateForm.getUsernickname()
                );

        return "redirect:/Homepage";
    }
    
	
	@GetMapping("/Signin")
    public String signin() {
        return "signin";
    }
}
