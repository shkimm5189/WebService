package webservice.edu.com.web.dto.post;

import lombok.Getter;
import webservice.edu.com.domain.post.Post;

import java.time.LocalDateTime;

@Getter
public class PostResponse {
    private Long id ;
    private String title;
    private String content;
    private String author;
    private LocalDateTime updateDate;

    public PostResponse(Post entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }

}
