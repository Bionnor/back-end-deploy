package com.flora.backend.services;



import com.flora.backend.dtos.Blogs.BlogSaveDTO;
import com.flora.backend.dtos.Blogs.BlogView;
import com.flora.backend.dtos.Product.ProductView;
import com.flora.backend.dtos.ResponsePageDTO;
import com.flora.backend.dtos.TagView;
import com.flora.backend.entities.*;
import com.flora.backend.exceptions.DataAccessException;
import com.flora.backend.exceptions.ResourceNotFoundException;
import com.flora.backend.mappers.BlogMapper;
import com.flora.backend.mappers.ProductMapper;
import com.flora.backend.repository.BlogRepository;
import com.flora.backend.repository.TagRepository;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static com.flora.backend.Utils.ResponsePageUtils.createResponsePage;

@Service
@AllArgsConstructor
@Transactional
@NoArgsConstructor
@Slf4j
public class BlogServiceImp implements BlogService{
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private  TagRepository tagRepository;
    @Autowired
    private BlogMapper blogMapper;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public BlogSaveDTO addBlog(BlogSaveDTO blogSaveDTO) {
        try {
            Blog blog = blogMapper.fromBlogSaveToBlog(blogSaveDTO);
            return blogMapper.fromBlogToBlogSave(blogRepository.save(blog));
        } catch (DataAccessException ex) {
            // Handle database-related issues
            throw new RuntimeException("Error while adding blog", ex);
        }
    }

    @Override
    public BlogView updateBlog(Long blogId, BlogSaveDTO blogSaveDTO) {
        try {
            Blog existingBlog = blogRepository.findById(blogId).orElseThrow(() -> new ResourceNotFoundException("Blog not found !"));
            blogMapper.updateFromBlogToBlogSaveDTO(blogSaveDTO, existingBlog);
            return blogMapper.fromBlogToBlogView(blogRepository.save(existingBlog));
        } catch (ResourceNotFoundException ex) {
            // Handle blog not found
            throw ex;
        } catch (DataAccessException ex) {
            // Handle database-related issues
            throw new RuntimeException("Error while updating blog", ex);
        }
    }
    @Override
    public boolean deleteBlog(Long blogId) {
        try {
            Blog existingBlog = blogRepository.findById(blogId).orElseThrow(() -> new ResourceNotFoundException("Blog not found !"));
            if (existingBlog != null) {
                blogRepository.delete(existingBlog);
                return true;
            }
            return false;
        } catch (ResourceNotFoundException ex) {
            // Handle blog not found
            throw ex;
        } catch (DataAccessException ex) {
            // Handle database-related issues
            throw new RuntimeException("Error while deleting blog", ex);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public ResponsePageDTO<BlogView> getFilteredBlogs(int pageSize, int pageNumber, String title, String tag, String category) {
        try {
            Specification<Blog> specification = (root, query, criteriaBuilder) -> {
                List<Predicate> predicates = new ArrayList<>();

                if (title != null) {
                    predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("title")), "%" + title.toLowerCase() + "%"));
                }

                if (tag != null) {
                    Join<Blog, Tag> tagJoin = root.join("tag");
                    predicates.add(criteriaBuilder.equal(tagJoin.get("name"), tag));
                }

                if (category != null) {
                    Join<Blog, Category> categoryJoin = root.join("category");
                    predicates.add(criteriaBuilder.equal(categoryJoin.get("name"), category));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            };

            Page<Blog> pages = blogRepository.findAll(specification, PageRequest.of(pageNumber, pageSize));
            return createResponsePage(blogMapper.getBlogPage(pages), pages.getTotalPages(), pageNumber, pageSize);
        } catch (DataAccessException ex) {
            // Handle database-related issues
            throw new RuntimeException("Error while retrieving filtered blogs", ex);
        }
    }


    @Override
    public BlogView getBlog(Long id) {
        try {
            return blogMapper.fromBlogToBlogView(
                    blogRepository.findById(id).orElseThrow(
                            () -> new ResourceNotFoundException("Blog not found !")
                    ));
        } catch (ResourceNotFoundException ex) {
            // Handle blog not found
            throw new RuntimeException("Blog not found", ex);
        } catch (DataAccessException ex) {
            // Handle database-related issues
            throw new RuntimeException("Error while retrieving blog", ex);
        }
    }
    public List<BlogView> getLatestFourBlogs() {
        PageRequest pageRequest = PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC, "publicationDate"));
        return blogMapper.fromBlogListToBlogViewList(blogRepository.findAll(pageRequest).getContent());
    }
    @Override
    public List<TagView> getTags() {
        return blogMapper.fromListTagToListTagView(tagRepository.findAll());
    }


}
