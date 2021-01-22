package webservice.edu.com.domain.post;

import org.junit.After;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;
import webservice.edu.com.domain.Post;
import webservice.edu.com.domain.PostRepository;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;
    /*
    Junit 단위 테스트가 끝날 때마다 수행되는 메소드를 지정
    여러 테스트 동시 실행 시 테스트용 DB(H2)에 데이터가 그대로남아 있을 경우, 다음 테스트시 실패할수있음.
     */
    @After
    public void cleanup(){
        postRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postRepository.save(Post.builder()
                .title(title)
                .content(content)
                .author("shkimm5189@naver.com")
                .build());
        //when
        List<Post> postList = postRepository.findAll();

        //then
        Post post = postList.get(0);
        assertThat(post.getTitle()).isEqualTo(title);
        assertThat(post.getContent()).isEqualTo(content);
    }

}
