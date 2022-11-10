package com.wfl.sunyi.controller;

import com.wfl.sunyi.BlowUpJVM;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Hello interface")
@RestController
public class HelloWorld {
    @RequestMapping(value = "hi",method = RequestMethod.GET)
    @Operation(summary = "hello summary")
    public String HelloWorld01(@RequestParam(value = "userName") String userName)
    {
        int lenName = 0;
        lenName = userName.length();

        boolean b = lenName > 4 ? true : false;
        if (b) {
            BlowUpJVM.testStackOverFlow();
            userName = "" + lenName;
        }
        return "Hello" + userName;
    }
}
