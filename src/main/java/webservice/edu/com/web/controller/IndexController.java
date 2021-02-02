package webservice.edu.com.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import webservice.edu.com.service.PostService;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostService postService;
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("post",postService.findAllDesc());
        return "index";
    }

    @GetMapping("/api/post")
    public String postSave(){
        return "post-save";
    }
}
