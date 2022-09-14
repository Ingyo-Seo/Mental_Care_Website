package com.health.care;

import java.security.Principal;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.health.user.UserEntity;
import com.health.user.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class CareController {
	private final UserService userService;
	private final CareService careService;
	
	private final CareRepository careRepository;
	
    @RequestMapping("/Healthcare")
    public String detail(Model model) {
        List<CareEntity> careList = this.careRepository.findAll();
        model.addAttribute("healthcareList", careList);
        return "healthcare";
    }
	
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/Healthcare/Create")
    public String createHealthcare(Principal principal) {
        UserEntity userEntity = this.userService.getUser(principal.getName());
        this.careService.createHealthcare(userEntity);
        return "redirect:/Healthcare";
    }
}
