package com.wfl.sunyi.controller;

import com.wfl.sunyi.Person;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Tag(name = "xss")
public class xsscontroller {

    @GetMapping("/home")
    @Operation(summary = "index")
    public String index() {
        return "index";
    }

    @GetMapping ("/xss")
    @Operation(summary = "input")
    public String input(){
        return "xss/xss";
    }

    @PostMapping ("/xssoutput")
    @Operation(summary = "out put message")
    public String outputmessage(@RequestParam("name") String name, Model model){
        Person person = new Person(name);
        model.addAttribute("myperson",person);
        return "xss/xssoutput";
    }

}
