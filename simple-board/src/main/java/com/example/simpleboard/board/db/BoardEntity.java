package com.example.simpleboard.board.db;

import com.example.simpleboard.post.db.PostEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "board")
@Data
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String boardName;

    private String status;


    @OneToMany(mappedBy = "board")
    @Where(clause = "status = 'RESISTERED'")
    @OrderBy("id desc")
    private List<PostEntity> postList = List.of();
}
