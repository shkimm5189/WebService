package webservice.edu.com.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webservice.edu.com.domain.Post;
import webservice.edu.com.domain.PostRepository;
import webservice.edu.com.web.dto.PostRequest;
import webservice.edu.com.web.dto.PostResponse;

import javax.transaction.Transactional;


@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long save(PostRequest request){
        return postRepository.save(request.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostRequest request){
        Post post = postRepository.findById(id).orElseThrow(() -> new
                IllegalArgumentException("해당 게시글 없습니다. id = "+id));

        post.update(request.getTitle(), request.getContent());
        return id;
    }

    @Transactional
    public PostResponse findById(Long id){
        Post entity = postRepository.findById(id).orElseThrow(() -> new
                IllegalArgumentException("해당 게시글 없습니다. id + "+id));
        return new PostResponse(entity);
    }
}
