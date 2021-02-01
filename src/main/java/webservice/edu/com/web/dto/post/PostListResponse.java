package webservice.edu.com.web.dto.post;

import lombok.Getter;
import webservice.edu.com.domain.post.Post;

import java.time.LocalDateTime;

@Getter
public class PostListResponse {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime updateDate;

    public PostListResponse(Post entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.updateDate = entity.getUpdateDate();
    }

}
