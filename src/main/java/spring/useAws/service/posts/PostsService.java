package spring.useAws.service.posts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.useAws.domain.posts.Posts;
import spring.useAws.domain.posts.PostsRepository;
import spring.useAws.web.Dto.PostsResponceDto;
import spring.useAws.web.Dto.PostsSaveRequestDto;
import spring.useAws.web.Dto.PostsUpdateRequestDto;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponceDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponceDto(entity);
    }
}
