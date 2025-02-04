package com.firstproject.myFirstProject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstDym {
    @GetMapping("Nadeem")
    public String first (){
        return "Dayam";
    }

}
