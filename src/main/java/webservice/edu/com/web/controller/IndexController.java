package webservice.edu.com.web.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import webservice.edu.com.service.PostService;
import webservice.edu.com.web.dto.post.PostResponse;

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
    
    @GetMapping("/api/post/{id}")
    public String postUpdate(@PathVariable Long id,Model model){
        PostResponse response = postService.findById(id);
        model.addAttribute("post",response);
        return "post-update";
    }
}
