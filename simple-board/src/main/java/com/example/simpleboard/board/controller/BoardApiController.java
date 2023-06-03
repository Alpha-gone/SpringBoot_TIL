package com.example.simpleboard.board.controller;

import com.example.simpleboard.board.db.BoardEntity;
import com.example.simpleboard.board.model.BoardDto;
import com.example.simpleboard.board.model.BoardRequest;
import com.example.simpleboard.board.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/board")
public class BoardApiController {
    private final BoardService boardService;

    @PostMapping("")
    public BoardDto create(@Valid @RequestBody BoardRequest request){
        return boardService.create(request);
    }

    @GetMapping("/id/{id}")
    public BoardDto view(@PathVariable Long id){
        return boardService.view(id);
    }
}
