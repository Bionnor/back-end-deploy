package com.flora.backend.dtos.Blogs;

import com.flora.backend.dtos.BlogCategoryView;
import com.flora.backend.entities.Comment;
import com.flora.backend.entities.Tag;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogSaveDTO {
    private Long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime publicationDate;
    private LocalDateTime lastModified;
    private Set<Tag> tags ;
    private Long IdCategory;
    private int likes;
    private boolean isPublished;
    private String featuredImage;
    private Long views;
}
