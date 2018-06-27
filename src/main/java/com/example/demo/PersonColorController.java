package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
@Controller
public class PersonColorController {

    @Autowired
    PersonRepository personRepo;

    @Autowired
    ColorRepository colorRepo;

    @RequestMapping("/")
    public String index(Model model)
    {

        model.addAttribute("personlist",personRepo.findAll());
        model.addAttribute("colorlist",colorRepo.findAll());
        return "index";
    }

    @RequestMapping("/addColor")
    public String addColor(Model model)
    {
        model.addAttribute("aColor", new Color());
        model.addAttribute("personColor",personRepo.findAll());
        return "colors";
    }

    @RequestMapping("/savecolor")
    public String saveColor(@ModelAttribute("aColor") Color color, Model model)
    {
        colorRepo.save(color);
        return "redirect:/";
    }

    @PostConstruct
    public void fillTables()
    {
        Person p = new Person();
        p.setPersonName("Zola Great");
        personRepo.save(p);

        p = new Person();
        p.setPersonName("Konstanitin");
        personRepo.save(p);

        p= new Person();
        p.setPersonName("Tofik");
        personRepo.save(p);
    }
}
