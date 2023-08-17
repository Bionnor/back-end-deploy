package com.flora.backend.dtos;

import com.flora.backend.entities.Blog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentView {
    private Long id;
    private String commenterName;
    private String content;
    private LocalDateTime commentDate;
}
