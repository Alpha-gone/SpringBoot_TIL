package com.example.simpleboard.post.db;

import com.example.simpleboard.board.db.BoardEntity;
import com.example.simpleboard.reply.db.ReplyEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity(name="post")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    private BoardEntity board;

    private String userName;
    private String password;
    private String email;
    private String status;
    private String title;

    @Column(columnDefinition = "text")
    private String content;

    private LocalDateTime postedAt;

    @OneToMany(mappedBy = "post")
    private List<ReplyEntity> replyList = List.of();
}
