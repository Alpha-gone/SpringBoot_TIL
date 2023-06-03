package com.example.simpleboard.reply.controller;

import com.example.simpleboard.crud.CRUDAbstractCApiController;
import com.example.simpleboard.reply.db.ReplyEntity;
import com.example.simpleboard.reply.model.ReplyDto;
import com.example.simpleboard.reply.model.ReplyRequest;
import com.example.simpleboard.reply.service.ReplyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/reply")
public class ReplyController extends CRUDAbstractCApiController<ReplyDto, ReplyEntity> {
//    private final ReplyService service;
//
//    @PostMapping("")
//    public ReplyEntity create(@Valid @RequestBody ReplyRequest request){
//        return service.create(request);
//    }
}
