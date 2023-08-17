package com.flora.backend.mappers;

import com.flora.backend.dtos.BlogCategoryView;
import com.flora.backend.dtos.Blogs.BlogSaveDTO;
import com.flora.backend.dtos.Blogs.BlogView;
import com.flora.backend.dtos.InvoiceView;
import com.flora.backend.dtos.TagView;
import com.flora.backend.entities.BlogCategory;
import com.flora.backend.entities.Invoice;
import com.flora.backend.entities.Blog;
import com.flora.backend.entities.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface BlogMapper {

    BlogView fromBlogToBlogView(Blog blog);
    Blog fromBlogViewToBlog(BlogView blogView);
    @Mapping(target="idCategory", source="category.id")
    BlogSaveDTO fromBlogToBlogSave(Blog blog);
    @Mapping(target="category.id", source="idCategory")
    Blog fromBlogSaveToBlog(BlogSaveDTO blogSaveDTO);

    TagView fromTagToTagView(Tag tag);
    List<BlogView> fromBlogToBlogViews(List<Blog> blogs);

    List<BlogView> getBlogPage(Page<Blog> pages);

    @Mapping(target = "id", ignore = true) // Ignore updating the ID
    @Mapping(target="category.id", source="idCategory", ignore = true)
    void updateFromBlogToBlogSaveDTO(BlogSaveDTO blogSaveDTO, @MappingTarget Blog blog);

    List<TagView> fromListTagToListTagView(List<Tag> all);

    List<BlogView> fromBlogListToBlogViewList(List<Blog> content);
}
