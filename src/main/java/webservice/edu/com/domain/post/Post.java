package webservice.edu.com.domain.post;

import lombok.*;
import webservice.edu.com.domain.BaseTimeEntity;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Post extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 500 , nullable = false)
    private String title;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    private String author;
    @Builder
    public Post(String title, String content,String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
    public void update(String title , String content){
        this.title = title;
        this.content = content;
    }
}
