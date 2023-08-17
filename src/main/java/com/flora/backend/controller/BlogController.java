package com.flora.backend.controller;



import com.flora.backend.dtos.Blogs.BlogSaveDTO;
import com.flora.backend.dtos.Blogs.BlogView;
import com.flora.backend.dtos.ResponsePageDTO;

import com.flora.backend.dtos.TagView;
import com.flora.backend.services.BlogService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private BlogService blogService;


    @GetMapping
    public ResponsePageDTO<BlogView> getFilteredBlogs(
            @RequestParam(required = false) String title,
            @RequestParam(required = false)  String category,
            @RequestParam(required = false) String tag,
            @RequestParam(defaultValue = "5") int pageSize,
            @RequestParam(defaultValue = "0") int pageNumber) {
        return blogService.getFilteredBlogs(pageSize, pageNumber,title, tag, category);
    }

    @GetMapping("/lastBlog")
    public List<BlogView> getLastBlogs() {
        return blogService.getLatestFourBlogs();
    }

    @PutMapping("/{blogId}")
    public ResponseEntity<BlogView> updateBlog(@PathVariable Long blogId, @RequestBody BlogSaveDTO updatedBlog) {
        BlogView result = blogService.updateBlog(blogId, updatedBlog);
        log.info(result.toString());
        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{blogId}")
    public ResponseEntity<Void> deleteBlog(@PathVariable Long blogId) {
        boolean isDeleted = blogService.deleteBlog(blogId);

        if (isDeleted) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }


    @PostMapping("/")
    public BlogSaveDTO addBlog(@RequestBody BlogSaveDTO blogSaveDTO) {
        return blogService.addBlog(blogSaveDTO);
    }
    @GetMapping ("/tags")
    public List<TagView> getTags() {
        return blogService.getTags();
    }
    @GetMapping("/{id}")
    public BlogView getBlog(@PathVariable Long id) {

        return blogService.getBlog(id);
    }
}
