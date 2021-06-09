package org.example.springboot.web;

import lombok.RequiredArgsConstructor;
import org.example.springboot.service.posts.PostsService;
import org.example.springboot.web.dto.posts.PostsResponseDto;
import org.example.springboot.web.dto.posts.PostsSaveRequestDto;
import org.example.springboot.web.dto.posts.PostsUpdateRequestDto;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long Save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    // @PathVariable - URL경로상의 변수를 넣어준다.
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        System.out.println("update");
        return postsService.update(id, requestDto);
    }

    // 데이터를 조회한다.
    // PostsResponseDto - View용 DTO?
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id) {
        return postsService.findById(id);
    }

    // 데이터를 삭제한다.
    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }
}
