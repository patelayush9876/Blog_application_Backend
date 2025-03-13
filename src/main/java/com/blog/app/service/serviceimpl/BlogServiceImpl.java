package com.blog.app.service.serviceimpl;

import com.blog.app.models.Blog;
import com.blog.app.repository.BlogRepository;
import com.blog.app.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public Blog addBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    public Page<Blog> getAllBlogs(int page, int size) {
        return blogRepository.findAll(PageRequest.of(page, size));
    }

    public Optional<Blog> getBlogById(Long id) {
        return blogRepository.findById(id);
    }

    public Blog updateBlog(Long id, Blog updatedBlog) {
        return blogRepository.findById(id)
                .map(blog -> {
                    blog.setTitle(updatedBlog.getTitle());
                    blog.setContent(updatedBlog.getContent());
                    blog.setAuthor(updatedBlog.getAuthor());
                    return blogRepository.save(blog);
                }).orElseThrow(() -> new RuntimeException("Blog not found"));
    }

    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }



}
