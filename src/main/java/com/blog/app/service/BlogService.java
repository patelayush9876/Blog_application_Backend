package com.blog.app.service;

import com.blog.app.models.Blog;
import org.springframework.data.domain.Page;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

public interface BlogService {

    public Blog addBlog(Blog blog);

    public Page<Blog> getAllBlogs(int page, int size);

    public Optional<Blog> getBlogById(Long id);

    public Blog updateBlog(Long id, Blog updatedBlog);

    public void deleteBlog(Long id);

}
