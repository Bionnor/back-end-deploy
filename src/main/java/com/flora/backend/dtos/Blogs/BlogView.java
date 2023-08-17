package com.flora.backend.dtos.Blogs;

import com.flora.backend.dtos.BlogCategoryView;
import com.flora.backend.dtos.Category.CategoryView;
import com.flora.backend.dtos.CommentView;
import com.flora.backend.dtos.Review.ReviewShow;
import com.flora.backend.dtos.TagView;
import com.flora.backend.entities.Comment;
import com.flora.backend.entities.Tag;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BlogView {
    private Long id;

    private String title;

    private String content;

    private String author;

    private LocalDateTime publicationDate;

    private LocalDateTime lastModified;

    private Set<TagView> tags;

    private List<CommentView> comments;
    private BlogCategoryView category;

    private int likes;

    private boolean isPublished;

    private String featuredImage;

    private Long views;

}
