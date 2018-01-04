package com.example.synchronizer.controller;

import com.example.synchronizer.model.HumanModel;
import com.example.synchronizer.repository.HumanRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class DemoController {

    private HumanRepository humanRepository;

    DemoController(HumanRepository humanRepository) {
        this.humanRepository = humanRepository;
    }

    @RequestMapping("/hello")
    public String hello(Model model) {

        int cnt = humanRepository.count();
        HumanModel human = humanRepository.fetchById(1);
        List<HumanModel> humans = humanRepository.fetchAll();


        model.addAttribute("count", cnt);
        model.addAttribute("message", "Hello world");
        model.addAttribute("name", human.getNameName());
        model.addAttribute("age", human.getAgeAge());
        model.addAttribute("sex", human.isSex());
        model.addAttribute("humans", humans);

        return "hello";
    }

}
