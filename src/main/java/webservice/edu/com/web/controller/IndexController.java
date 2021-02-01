package webservice.edu.com.web.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/post/save")
    public String postSave(){
        return "post-save";
    }
}
