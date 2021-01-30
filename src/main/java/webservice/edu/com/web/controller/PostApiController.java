package webservice.edu.com.web.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import webservice.edu.com.service.PostService;
import webservice.edu.com.web.dto.PostRequest;
import webservice.edu.com.web.dto.PostResponse;

@RequiredArgsConstructor
@RestController
public class PostApiController {
    private final PostService postService;

    @PostMapping("/api/post")
    public Long save(@RequestBody PostRequest request){
        return postService.save(request);
    }

    @PutMapping("/api/post/{id}")
    public Long Update(@PathVariable Long id, @RequestBody PostRequest updateRequest){
        return postService.update(id,updateRequest);
    }

    @GetMapping("/api/post/{id}")
    public PostResponse findById(@PathVariable Long id){
        return postService.findById(id);
    }

}
