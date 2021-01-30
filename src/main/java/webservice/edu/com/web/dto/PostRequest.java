package webservice.edu.com.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import webservice.edu.com.domain.Post;

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
    @Builder
    public PostRequest(String title , String content){
        this.title = title;
        this.content = content;
    }
    public Post toEntity(){
        return Post.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }


}
