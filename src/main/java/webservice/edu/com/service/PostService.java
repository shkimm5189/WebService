package webservice.edu.com.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import webservice.edu.com.domain.post.Post;
import webservice.edu.com.domain.post.PostRepository;
import webservice.edu.com.web.dto.post.PostRequest;
import webservice.edu.com.web.dto.post.PostResponse;
import webservice.edu.com.web.dto.post.PostUpdateRequest;

import javax.transaction.Transactional;
import java.util.List;


@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long save(PostRequest request){
        return postRepository.save(request.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostUpdateRequest request){
        Post post = postRepository.findById(id).orElseThrow(() -> new
                IllegalArgumentException("해당 게시글 없습니다. id = "+id));

        post.update(request.getTitle(),request.getContent());
        return id;

        //return postRepository.save()
    }

    @Transactional
    public PostResponse findById(Long id){
        Post entity = postRepository.findById(id).orElseThrow(() -> new
                IllegalArgumentException("해당 게시글 없습니다. id + "+id));
        return new PostResponse(entity);
    }
    @Transactional(readOnly = true)
    public List<PostListResponse> findAllDesc(){
        return postRepository.findAllDesc().stream()
                .map(Post)
    }


}
