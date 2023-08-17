package com.flora.backend.services;



import com.flora.backend.dtos.Blogs.BlogSaveDTO;
import com.flora.backend.dtos.Blogs.BlogView;
import com.flora.backend.dtos.Product.ProductView;
import com.flora.backend.dtos.ResponsePageDTO;
import com.flora.backend.dtos.TagView;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface BlogService {
    BlogSaveDTO addBlog(BlogSaveDTO productSaveDTO);

    BlogView updateBlog(Long productId, BlogSaveDTO productSaveDTO);
    boolean deleteBlog(Long productId);

    ResponsePageDTO<BlogView> getFilteredBlogs(int pageSize, int pageNumber, String title,String tag, String category);

    BlogView getBlog(Long id);
    List<TagView> getTags();
    List<BlogView> getLatestFourBlogs();
}
