package webservice.edu.com.web.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import webservice.edu.com.service.PostService;
import webservice.edu.com.web.dto.post.PostRequest;
import webservice.edu.com.web.dto.post.PostResponse;
import webservice.edu.com.web.dto.post.PostUpdateRequest;

@RequiredArgsConstructor
@RestController
public class PostApiController {
    private final PostService postService;

    @PostMapping("/api/post")
    public Long save(@RequestBody PostRequest request){
        return postService.save(request);
    }

    @PutMapping("/api/post/{id}")
    public Long Update(@PathVariable Long id, @RequestBody PostUpdateRequest updateRequest){
        return postService.update(id,updateRequest);
    }

    @GetMapping("/api/post/{id}")
    public PostResponse findById(@PathVariable Long id){
        return postService.findById(id);
    }

    @DeleteMapping("/api/post/{id}")
    public Long delete(@PathVariable Long id){
        postService.delete(id);
        return id;
    }
}
