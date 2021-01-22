package webservice.edu.com.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webservice.edu.com.domain.PostRepository;
import webservice.edu.com.web.dto.PostRequest;

import javax.transaction.Transactional;


@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long save(PostRequest request){
        return postRepository.save(request.toEntity().getId());
    }
}
