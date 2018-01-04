package com.example.synchronizer.controller;

import com.example.synchronizer.repository.HumanRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

    private HumanRepository humanRepository;

    DemoController(HumanRepository humanRepository) {
        this.humanRepository = humanRepository;
    }

    @RequestMapping("/hello")
    public String hello(Model model) {

        int cnt = humanRepository.count();

        model.addAttribute("count", String.valueOf(cnt));
        model.addAttribute("message", "Hello world");

        return "hello";
    }

}
