package com.example.simpleboard.reply.service;

import com.example.simpleboard.crud.Converter;
import com.example.simpleboard.post.db.PostRepository;
import com.example.simpleboard.reply.db.ReplyEntity;
import com.example.simpleboard.reply.model.ReplyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Component
public class ReplyConverter implements Converter<ReplyDto, ReplyEntity> {

    private final PostRepository repository;

    @Override
    public ReplyDto toDto(ReplyEntity replyEntity) {
       return ReplyDto.builder()
                .id(replyEntity.getId())
                .postId(replyEntity.getPost().getId())
                .status(replyEntity.getStatus())
                .title(replyEntity.getTitle())
                .content(replyEntity.getContent())
                .userName(replyEntity.getUserName())
                .password(replyEntity.getPassword())
                .repliedAt(replyEntity.getRepliedAt())
                .build();
    }

    @Override
    public ReplyEntity toEntity(ReplyDto replyDto) {
        var postEntity = repository.findById(replyDto.getPostId());

        return ReplyEntity.builder()
                .id(replyDto.getId()) // null save | not null update
                .post(postEntity.orElse(null))
                .status(replyDto.getStatus() != null ? replyDto.getStatus() : "REGISTERED")
                .title(replyDto.getTitle())
                .content(replyDto.getContent())
                .userName(replyDto.getUserName())
                .password(replyDto.getPassword())
                .repliedAt(replyDto.getRepliedAt() != null ? replyDto.getRepliedAt() : LocalDateTime.now())
                .build();
    }
}
