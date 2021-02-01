package webservice.edu.com.domain.post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import webservice.edu.com.web.dto.post.PostRequest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostApiControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostRepository postRepository;

   // @After
//    public void tearDown() throws Exception{
//        postRepository.deleteAll();
//    }

    @Test
    public void Post_등록하기()throws Exception{
        //given
        String title = "제목";
        String content = "내용";
        PostRequest request = PostRequest.builder()
                .title(title)
                .content(content)
                .author("나에용")
                .build();

        String url = "http://localhost:" + port + "/api/post";

        //when
        ResponseEntity<Long> responseEntity =restTemplate.postForEntity(url,request,Long.class);
        //then

    }

    @Test
    public void Post_수정하기() throws Exception{
        //given
        Post savePost = postRepository.save(Post.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        Long updateId = savePost.getId();
        String expectedTitle = "changed title";
        String expectedContent = "changed content";

        PostRequest request = PostRequest.builder()
                .title(expectedTitle)
                .content(expectedContent)
                .build();
        String url = "http://localhost:" + port+"/api/post/"+updateId;

        HttpEntity<PostRequest> requestEntity = new HttpEntity<>(request);

        //when
    ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT,requestEntity,Long.class);
        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Post> all =postRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(expectedTitle);
        assertThat(all.get(0).getContent()).isEqualTo(expectedContent);
    }
}
