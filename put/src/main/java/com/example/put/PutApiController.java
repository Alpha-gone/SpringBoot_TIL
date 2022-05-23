package com.example.put;

import com.example.put.dto.PostRequestDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PutApiController {

    @PutMapping("/put/{userId}")
    public PostRequestDTO put(@RequestBody PostRequestDTO postRequestDTO, @PathVariable(name = "userId") Long id){
        System.out.println(id);
        System.out.println(postRequestDTO);
        return postRequestDTO;
    }
}
