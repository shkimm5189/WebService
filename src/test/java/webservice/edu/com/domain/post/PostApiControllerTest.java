package webservice.edu.com.domain.post;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import webservice.edu.com.domain.PostRepository;
import webservice.edu.com.web.dto.PostRequest;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostApiControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostRepository postRepository;

    @After
    public void tearDown() throws Exception{
        postRepository.deleteAll();
    }

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
}
