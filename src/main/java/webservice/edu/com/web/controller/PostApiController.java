package webservice.edu.com.web.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import webservice.edu.com.service.PostService;
import webservice.edu.com.web.dto.PostRequest;

@RequiredArgsConstructor
@RestController
public class PostApiController {
    private final PostService postService;

    @PostMapping("/api/post")
    public Long save(@RequestBody PostRequest request){
        return postService.save(request);
    }
}
