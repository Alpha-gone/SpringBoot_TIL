package com.example.simpleboard.post.service;

import com.example.simpleboard.board.db.BoardRepository;
import com.example.simpleboard.common.Api;
import com.example.simpleboard.common.Pagination;
import com.example.simpleboard.post.db.PostEntity;
import com.example.simpleboard.post.db.PostRepository;
import com.example.simpleboard.post.model.PostRequest;
import com.example.simpleboard.post.model.PostViewRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final BoardRepository boardRepo;
    private final PostRepository postRepo;

    public PostEntity create(PostRequest request){
        var board = boardRepo.findById(request.getBoardId()).get();

        var entity = PostEntity.builder()
                .board(board)
                .userName(request.getUserName())
                .password(request.getPassword())
                .email(request.getEmail())
                .status("RESISTERED")
                .title(request.getTitle())
                .content(request.getContent())
                .postedAt(LocalDateTime.now())
                .build();

        return postRepo.save(entity);

    }

    public PostEntity view(PostViewRequest request) {
        return postRepo.findById(request.getPostId())
                .map(entity -> {
                    if(!entity.getPassword().equals(request.getPassword())){
                        var format = "패스워드가 맞지않습니다 %s vs %s";
                        throw new RuntimeException(
                                String.format(format,
                                        entity.getPassword(),
                                        request.getPassword()
                                )
                        );
                    }

                    return entity;
                }).orElseThrow(() -> new RuntimeException("해당 개시글이 존재하지 않습니다 : "+ request.getPostId()));
    }

    public Api<List<PostEntity>> all(Pageable pageable) {
        var list = postRepo.findAll(pageable);

        var pagination = Pagination.builder()
                .page(list.getNumber())
                .size(list.getSize())
                .currentElements(list.getNumberOfElements())
                .totalElements(list.getTotalElements())
                .totalPage(list.getTotalPages())
                .build();

        var response = Api.<List<PostEntity>>builder()
                .body(list.toList())
                .pagination(pagination)
                .build();
        return response;
    }

    public void delete(PostViewRequest request) {
        postRepo.findFirstByIdAndStatusOrderByIdDesc(request.getPostId(), "RESISTERED")
                .map(entity -> {
                    if(!entity.getPassword().equals(request.getPassword())){
                        var format = "패스워드가 맞지않습니다 %s vs %s";
                        throw new RuntimeException(
                                String.format(format,
                                        entity.getPassword(),
                                        request.getPassword()
                                )
                        );
                    }
                    return entity;
                }).orElseThrow(() -> new RuntimeException("해당 개시글이 존재하지 않습니다 : "+ request.getPostId()));
    }
}
