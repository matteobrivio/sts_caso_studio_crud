package it.sts.stscasostudiocrud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class PublicController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "homepage");
        return "homepage";
    }

}
