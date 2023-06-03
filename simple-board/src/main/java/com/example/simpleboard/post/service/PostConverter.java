package com.example.simpleboard.post.service;

import com.example.simpleboard.post.db.PostEntity;
import com.example.simpleboard.post.model.PostDto;
import org.springframework.stereotype.Service;

@Service
public class PostConverter {
    public PostDto toDto(PostEntity entity){
        return PostDto.builder()
                .id(entity.getId())
                .boardId(entity.getBoard().getId())
                .userName(entity.getUserName())
                .status(entity.getStatus())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .title(entity.getTitle())
                .content(entity.getContent())
                .postedAt(entity.getPostedAt())
                .build();
    }
}
