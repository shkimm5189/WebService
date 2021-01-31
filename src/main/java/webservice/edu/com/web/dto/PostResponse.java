package webservice.edu.com.web.dto;

import lombok.Getter;
import webservice.edu.com.domain.post.Post;

@Getter
public class PostResponse {
    private Long id ;
    private String title;
    private String content;
    private String author;

    public PostResponse(Post entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
