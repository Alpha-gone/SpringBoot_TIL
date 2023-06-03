package com.example.simpleboard.reply.db;

import com.example.simpleboard.post.db.PostEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity(name = "reply")
public class ReplyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @ToString.Exclude
    @JsonIgnore
    private PostEntity post;

    private String userName;
    private String password;
    private String status;
    private String title;

    @Column(columnDefinition = "text")
    private String content;
    private LocalDateTime repliedAt;
}
