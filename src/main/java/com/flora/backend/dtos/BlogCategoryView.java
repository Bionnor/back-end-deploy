package com.flora.backend.dtos;

import com.flora.backend.entities.Blog;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogCategoryView {

    private Long id;

    private String name;

}
