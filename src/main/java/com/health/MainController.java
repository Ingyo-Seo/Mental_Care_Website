package com.health;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
    public String root() {
		return "redirect:/Index";
    }
	
	@GetMapping("/Index")
    public String main() {
        return "index";
    }
	
	@GetMapping("/Homepage")
    public String home() {
        return "homepage";
    }
	
}
