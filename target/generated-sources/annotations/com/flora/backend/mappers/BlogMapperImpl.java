package com.flora.backend.mappers;

import com.flora.backend.dtos.BlogCategoryView;
import com.flora.backend.dtos.Blogs.BlogSaveDTO;
import com.flora.backend.dtos.Blogs.BlogView;
import com.flora.backend.dtos.CommentView;
import com.flora.backend.dtos.TagView;
import com.flora.backend.entities.Blog;
import com.flora.backend.entities.BlogCategory;
import com.flora.backend.entities.Comment;
import com.flora.backend.entities.Tag;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-17T16:25:39+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19 (Eclipse Adoptium)"
)
@Component
public class BlogMapperImpl implements BlogMapper {

    @Override
    public BlogView fromBlogToBlogView(Blog blog) {
        if ( blog == null ) {
            return null;
        }

        BlogView blogView = new BlogView();

        if ( blog.getId() != null ) {
            blogView.setId( blog.getId() );
        }
        if ( blog.getTitle() != null ) {
            blogView.setTitle( blog.getTitle() );
        }
        if ( blog.getContent() != null ) {
            blogView.setContent( blog.getContent() );
        }
        if ( blog.getAuthor() != null ) {
            blogView.setAuthor( blog.getAuthor() );
        }
        if ( blog.getPublicationDate() != null ) {
            blogView.setPublicationDate( blog.getPublicationDate() );
        }
        if ( blog.getLastModified() != null ) {
            blogView.setLastModified( blog.getLastModified() );
        }
        Set<TagView> set = tagSetToTagViewSet( blog.getTags() );
        if ( set != null ) {
            blogView.setTags( set );
        }
        List<CommentView> list = commentListToCommentViewList( blog.getComments() );
        if ( list != null ) {
            blogView.setComments( list );
        }
        if ( blog.getCategory() != null ) {
            blogView.setCategory( blogCategoryToBlogCategoryView( blog.getCategory() ) );
        }
        blogView.setLikes( blog.getLikes() );
        blogView.setPublished( blog.isPublished() );
        if ( blog.getFeaturedImage() != null ) {
            blogView.setFeaturedImage( blog.getFeaturedImage() );
        }
        if ( blog.getViews() != null ) {
            blogView.setViews( blog.getViews() );
        }

        return blogView;
    }

    @Override
    public Blog fromBlogViewToBlog(BlogView blogView) {
        if ( blogView == null ) {
            return null;
        }

        Blog blog = new Blog();

        if ( blogView.getId() != null ) {
            blog.setId( blogView.getId() );
        }
        if ( blogView.getTitle() != null ) {
            blog.setTitle( blogView.getTitle() );
        }
        if ( blogView.getContent() != null ) {
            blog.setContent( blogView.getContent() );
        }
        if ( blogView.getAuthor() != null ) {
            blog.setAuthor( blogView.getAuthor() );
        }
        if ( blogView.getPublicationDate() != null ) {
            blog.setPublicationDate( blogView.getPublicationDate() );
        }
        if ( blogView.getLastModified() != null ) {
            blog.setLastModified( blogView.getLastModified() );
        }
        Set<Tag> set = tagViewSetToTagSet( blogView.getTags() );
        if ( set != null ) {
            blog.setTags( set );
        }
        List<Comment> list = commentViewListToCommentList( blogView.getComments() );
        if ( list != null ) {
            blog.setComments( list );
        }
        if ( blogView.getCategory() != null ) {
            blog.setCategory( blogCategoryViewToBlogCategory( blogView.getCategory() ) );
        }
        blog.setLikes( blogView.getLikes() );
        blog.setPublished( blogView.isPublished() );
        if ( blogView.getFeaturedImage() != null ) {
            blog.setFeaturedImage( blogView.getFeaturedImage() );
        }
        if ( blogView.getViews() != null ) {
            blog.setViews( blogView.getViews() );
        }

        return blog;
    }

    @Override
    public BlogSaveDTO fromBlogToBlogSave(Blog blog) {
        if ( blog == null ) {
            return null;
        }

        BlogSaveDTO blogSaveDTO = new BlogSaveDTO();

        Long id = blogCategoryId( blog );
        if ( id != null ) {
            blogSaveDTO.setIdCategory( id );
        }
        if ( blog.getId() != null ) {
            blogSaveDTO.setId( blog.getId() );
        }
        if ( blog.getTitle() != null ) {
            blogSaveDTO.setTitle( blog.getTitle() );
        }
        if ( blog.getContent() != null ) {
            blogSaveDTO.setContent( blog.getContent() );
        }
        if ( blog.getAuthor() != null ) {
            blogSaveDTO.setAuthor( blog.getAuthor() );
        }
        if ( blog.getPublicationDate() != null ) {
            blogSaveDTO.setPublicationDate( blog.getPublicationDate() );
        }
        if ( blog.getLastModified() != null ) {
            blogSaveDTO.setLastModified( blog.getLastModified() );
        }
        Set<Tag> set = blog.getTags();
        if ( set != null ) {
            blogSaveDTO.setTags( new LinkedHashSet<Tag>( set ) );
        }
        blogSaveDTO.setLikes( blog.getLikes() );
        blogSaveDTO.setPublished( blog.isPublished() );
        if ( blog.getFeaturedImage() != null ) {
            blogSaveDTO.setFeaturedImage( blog.getFeaturedImage() );
        }
        if ( blog.getViews() != null ) {
            blogSaveDTO.setViews( blog.getViews() );
        }

        return blogSaveDTO;
    }

    @Override
    public Blog fromBlogSaveToBlog(BlogSaveDTO blogSaveDTO) {
        if ( blogSaveDTO == null ) {
            return null;
        }

        Blog blog = new Blog();

        if ( blogSaveDTO != null ) {
            blog.setCategory( blogSaveDTOToBlogCategory( blogSaveDTO ) );
        }
        if ( blogSaveDTO.getId() != null ) {
            blog.setId( blogSaveDTO.getId() );
        }
        if ( blogSaveDTO.getTitle() != null ) {
            blog.setTitle( blogSaveDTO.getTitle() );
        }
        if ( blogSaveDTO.getContent() != null ) {
            blog.setContent( blogSaveDTO.getContent() );
        }
        if ( blogSaveDTO.getAuthor() != null ) {
            blog.setAuthor( blogSaveDTO.getAuthor() );
        }
        if ( blogSaveDTO.getPublicationDate() != null ) {
            blog.setPublicationDate( blogSaveDTO.getPublicationDate() );
        }
        if ( blogSaveDTO.getLastModified() != null ) {
            blog.setLastModified( blogSaveDTO.getLastModified() );
        }
        Set<Tag> set = blogSaveDTO.getTags();
        if ( set != null ) {
            blog.setTags( new LinkedHashSet<Tag>( set ) );
        }
        blog.setLikes( blogSaveDTO.getLikes() );
        blog.setPublished( blogSaveDTO.isPublished() );
        if ( blogSaveDTO.getFeaturedImage() != null ) {
            blog.setFeaturedImage( blogSaveDTO.getFeaturedImage() );
        }
        if ( blogSaveDTO.getViews() != null ) {
            blog.setViews( blogSaveDTO.getViews() );
        }

        return blog;
    }

    @Override
    public TagView fromTagToTagView(Tag tag) {
        if ( tag == null ) {
            return null;
        }

        TagView tagView = new TagView();

        if ( tag.getId() != null ) {
            tagView.setId( tag.getId() );
        }
        if ( tag.getName() != null ) {
            tagView.setName( tag.getName() );
        }

        return tagView;
    }

    @Override
    public List<BlogView> fromBlogToBlogViews(List<Blog> blogs) {
        if ( blogs == null ) {
            return null;
        }

        List<BlogView> list = new ArrayList<BlogView>( blogs.size() );
        for ( Blog blog : blogs ) {
            list.add( fromBlogToBlogView( blog ) );
        }

        return list;
    }

    @Override
    public List<BlogView> getBlogPage(Page<Blog> pages) {
        if ( pages == null ) {
            return null;
        }

        List<BlogView> list = new ArrayList<BlogView>();
        for ( Blog blog : pages ) {
            list.add( fromBlogToBlogView( blog ) );
        }

        return list;
    }

    @Override
    public void updateFromBlogToBlogSaveDTO(BlogSaveDTO blogSaveDTO, Blog blog) {
        if ( blogSaveDTO == null ) {
            return;
        }

        if ( blog.getCategory() == null ) {
            blog.setCategory( new BlogCategory() );
        }
        blogSaveDTOToBlogCategory1( blogSaveDTO, blog.getCategory() );
        if ( blogSaveDTO.getTitle() != null ) {
            blog.setTitle( blogSaveDTO.getTitle() );
        }
        else {
            blog.setTitle( null );
        }
        if ( blogSaveDTO.getContent() != null ) {
            blog.setContent( blogSaveDTO.getContent() );
        }
        else {
            blog.setContent( null );
        }
        if ( blogSaveDTO.getAuthor() != null ) {
            blog.setAuthor( blogSaveDTO.getAuthor() );
        }
        else {
            blog.setAuthor( null );
        }
        if ( blogSaveDTO.getPublicationDate() != null ) {
            blog.setPublicationDate( blogSaveDTO.getPublicationDate() );
        }
        else {
            blog.setPublicationDate( null );
        }
        if ( blogSaveDTO.getLastModified() != null ) {
            blog.setLastModified( blogSaveDTO.getLastModified() );
        }
        else {
            blog.setLastModified( null );
        }
        if ( blog.getTags() != null ) {
            Set<Tag> set = blogSaveDTO.getTags();
            if ( set != null ) {
                blog.getTags().clear();
                blog.getTags().addAll( set );
            }
        }
        else {
            Set<Tag> set = blogSaveDTO.getTags();
            if ( set != null ) {
                blog.setTags( new LinkedHashSet<Tag>( set ) );
            }
        }
        blog.setLikes( blogSaveDTO.getLikes() );
        blog.setPublished( blogSaveDTO.isPublished() );
        if ( blogSaveDTO.getFeaturedImage() != null ) {
            blog.setFeaturedImage( blogSaveDTO.getFeaturedImage() );
        }
        else {
            blog.setFeaturedImage( null );
        }
        if ( blogSaveDTO.getViews() != null ) {
            blog.setViews( blogSaveDTO.getViews() );
        }
        else {
            blog.setViews( null );
        }
    }

    @Override
    public List<TagView> fromListTagToListTagView(List<Tag> all) {
        if ( all == null ) {
            return null;
        }

        List<TagView> list = new ArrayList<TagView>( all.size() );
        for ( Tag tag : all ) {
            list.add( fromTagToTagView( tag ) );
        }

        return list;
    }

    @Override
    public List<BlogView> fromBlogListToBlogViewList(List<Blog> content) {
        if ( content == null ) {
            return null;
        }

        List<BlogView> list = new ArrayList<BlogView>( content.size() );
        for ( Blog blog : content ) {
            list.add( fromBlogToBlogView( blog ) );
        }

        return list;
    }

    protected Set<TagView> tagSetToTagViewSet(Set<Tag> set) {
        if ( set == null ) {
            return null;
        }

        Set<TagView> set1 = new LinkedHashSet<TagView>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Tag tag : set ) {
            set1.add( fromTagToTagView( tag ) );
        }

        return set1;
    }

    protected CommentView commentToCommentView(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentView commentView = new CommentView();

        if ( comment.getId() != null ) {
            commentView.setId( comment.getId() );
        }
        if ( comment.getCommenterName() != null ) {
            commentView.setCommenterName( comment.getCommenterName() );
        }
        if ( comment.getContent() != null ) {
            commentView.setContent( comment.getContent() );
        }
        if ( comment.getCommentDate() != null ) {
            commentView.setCommentDate( comment.getCommentDate() );
        }

        return commentView;
    }

    protected List<CommentView> commentListToCommentViewList(List<Comment> list) {
        if ( list == null ) {
            return null;
        }

        List<CommentView> list1 = new ArrayList<CommentView>( list.size() );
        for ( Comment comment : list ) {
            list1.add( commentToCommentView( comment ) );
        }

        return list1;
    }

    protected BlogCategoryView blogCategoryToBlogCategoryView(BlogCategory blogCategory) {
        if ( blogCategory == null ) {
            return null;
        }

        BlogCategoryView blogCategoryView = new BlogCategoryView();

        if ( blogCategory.getId() != null ) {
            blogCategoryView.setId( blogCategory.getId() );
        }
        if ( blogCategory.getName() != null ) {
            blogCategoryView.setName( blogCategory.getName() );
        }

        return blogCategoryView;
    }

    protected Tag tagViewToTag(TagView tagView) {
        if ( tagView == null ) {
            return null;
        }

        Tag tag = new Tag();

        if ( tagView.getId() != null ) {
            tag.setId( tagView.getId() );
        }
        if ( tagView.getName() != null ) {
            tag.setName( tagView.getName() );
        }

        return tag;
    }

    protected Set<Tag> tagViewSetToTagSet(Set<TagView> set) {
        if ( set == null ) {
            return null;
        }

        Set<Tag> set1 = new LinkedHashSet<Tag>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( TagView tagView : set ) {
            set1.add( tagViewToTag( tagView ) );
        }

        return set1;
    }

    protected Comment commentViewToComment(CommentView commentView) {
        if ( commentView == null ) {
            return null;
        }

        Comment comment = new Comment();

        if ( commentView.getId() != null ) {
            comment.setId( commentView.getId() );
        }
        if ( commentView.getCommenterName() != null ) {
            comment.setCommenterName( commentView.getCommenterName() );
        }
        if ( commentView.getContent() != null ) {
            comment.setContent( commentView.getContent() );
        }
        if ( commentView.getCommentDate() != null ) {
            comment.setCommentDate( commentView.getCommentDate() );
        }

        return comment;
    }

    protected List<Comment> commentViewListToCommentList(List<CommentView> list) {
        if ( list == null ) {
            return null;
        }

        List<Comment> list1 = new ArrayList<Comment>( list.size() );
        for ( CommentView commentView : list ) {
            list1.add( commentViewToComment( commentView ) );
        }

        return list1;
    }

    protected BlogCategory blogCategoryViewToBlogCategory(BlogCategoryView blogCategoryView) {
        if ( blogCategoryView == null ) {
            return null;
        }

        BlogCategory blogCategory = new BlogCategory();

        if ( blogCategoryView.getId() != null ) {
            blogCategory.setId( blogCategoryView.getId() );
        }
        if ( blogCategoryView.getName() != null ) {
            blogCategory.setName( blogCategoryView.getName() );
        }

        return blogCategory;
    }

    private Long blogCategoryId(Blog blog) {
        if ( blog == null ) {
            return null;
        }
        BlogCategory category = blog.getCategory();
        if ( category == null ) {
            return null;
        }
        Long id = category.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected BlogCategory blogSaveDTOToBlogCategory(BlogSaveDTO blogSaveDTO) {
        if ( blogSaveDTO == null ) {
            return null;
        }

        BlogCategory blogCategory = new BlogCategory();

        if ( blogSaveDTO.getIdCategory() != null ) {
            blogCategory.setId( blogSaveDTO.getIdCategory() );
        }

        return blogCategory;
    }

    protected void blogSaveDTOToBlogCategory1(BlogSaveDTO blogSaveDTO, BlogCategory mappingTarget) {
        if ( blogSaveDTO == null ) {
            return;
        }
    }
}
