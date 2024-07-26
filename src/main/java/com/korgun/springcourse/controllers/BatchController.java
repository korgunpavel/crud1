package com.korgun.springcourse.controllers;

import com.korgun.springcourse.dao.PersonDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test-batch-update")
public class BatchController {

    public final PersonDAO personDAO;

    public BatchController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping
    public String index(){
        return "batch/index";
    }

    @GetMapping("/without")
    public String without(){
        personDAO.testOrdinaryUpdate();
        return "redirect:/people";
    }

    @GetMapping("/with")
    public String with(){
        personDAO.testBatchUpdate();
        return "redirect:/people";
    }
}
