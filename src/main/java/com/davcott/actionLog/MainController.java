package com.davcott.actionLog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class MainController {

    @GetMapping(path = "/all")
    public String getMain() {
        return "Hello, World!";
    }

    @GetMapping(path = "/error")
    public String getError() {
        return "error, dude!";
    }

}
