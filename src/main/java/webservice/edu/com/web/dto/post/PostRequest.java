package webservice.edu.com.web.dto.post;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import webservice.edu.com.domain.post.Post;

@Getter
@NoArgsConstructor
public class PostRequest {
    private String title;
    private String content;
    private String author;
    @Builder
    public PostRequest(String title,String content,String author){
        this.title  = title;
        this.content = content;
        this.author = author;
    }

    public Post toEntity(){
        return Post.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }


}
