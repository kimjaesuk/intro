package com.ohgiraffers.chap06fileupload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping
    public String defaultLocation(){
        return "main";
    }
    @GetMapping("/main")
    public void main (){

    }
}
