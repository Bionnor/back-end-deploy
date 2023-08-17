package com.flora.backend.loader;

import com.flora.backend.entities.*;
import com.flora.backend.repository.*;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Slf4j
@Order(9)
public class BlogDataLoader implements CommandLineRunner {
    @Autowired
    private  BlogRepository blogRepository;
    @Autowired
    private  BlogCategoryRepository blogCategoryRepository;
    @Autowired
    private  TagRepository tagRepository;


    @Override
    @Transactional
    public void run(String... args) {
        generateSampleData();
    }

    private void generateSampleData() {
        for (int i = 1; i <= 6; i++) {
            BlogCategory category = createCategory("Category " + i);
            Blog blog = createBlog("Title " + i, "Content " + i, "Author " + i,category);
            Comment comment1 = createComment("Commenter 1", "Comment Content 1",blog);
            Comment comment2 = createComment("Commenter 2", "Comment Content 2",blog);
            blog.getComments().add(comment1);
            blog.getComments().add(comment2);
            Set<Tag> tags = createTags("Tag " + i);
            blog.getTags().addAll(tags);
            blogRepository.save(blog);
        }
    }

    private Blog createBlog(String title, String content, String author,BlogCategory category) {
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setContent(content);
        blog.setViews(25L);
        blog.setAuthor(author);
        blog.setCategory(category);
        blog.setPublicationDate(LocalDateTime.now());
        blog.setLastModified(LocalDateTime.now());
        return blog;
    }
    private BlogCategory createCategory(String categoryName) {
        BlogCategory category = new BlogCategory();
        category.setName(categoryName);
        return blogCategoryRepository.save(category);
    }

    private Comment createComment(String commenterName, String content,Blog blog) {
        Comment comment = new Comment();
        comment.setCommenterName(commenterName);
        comment.setContent(content);
        comment.setBlog(blog);
        comment.setCommentDate(LocalDateTime.now());
        return comment;
    }

    private Set<Tag> createTags(String... tagNames) {
        Set<Tag> tags = new HashSet<>();
        for (String tagName : tagNames) {
            Tag tag = new Tag();
            tag.setName(tagName);
            tags.add(tag);
            tagRepository.save(tag);
        }
        return tags;
    }


}
