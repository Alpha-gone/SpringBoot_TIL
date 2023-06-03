package com.example.simpleboard.reply.service;

import com.example.simpleboard.crud.CRUDAbstractService;
import com.example.simpleboard.post.db.PostEntity;
import com.example.simpleboard.post.db.PostRepository;
import com.example.simpleboard.reply.db.ReplyEntity;
import com.example.simpleboard.reply.db.ReplyRepository;
import com.example.simpleboard.reply.model.ReplyDto;
import com.example.simpleboard.reply.model.ReplyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyService extends CRUDAbstractService<ReplyDto,ReplyEntity> {
//    private final ReplyRepository replyRepo;
//    private final PostRepository postRepo;
//
//    public ReplyEntity create(ReplyRequest request){
//        var post = postRepo.findById(request.getPostId()).get();
//
//        var entity = ReplyEntity.builder()
//                .post(post)
//                .userName(request.getUserName())
//                .password(request.getPassword())
//                .status("REGISTERED")
//                .title(request.getTitle())
//                .content(request.getContent())
//                .repliedAt(LocalDateTime.now())
//                .build();
//
//        return replyRepo.save(entity);
//    }
//
//    public List<ReplyEntity> findAllByPostId(Long postId){
//        return replyRepo.findAllByPostIdAndStatusOrderByIdDesc(postId, "REGISTERED");
//    }
}
