package spring.useAws.web.Dto;

import lombok.Getter;
import spring.useAws.domain.posts.Posts;

@Getter
public class PostsResponceDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponceDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
