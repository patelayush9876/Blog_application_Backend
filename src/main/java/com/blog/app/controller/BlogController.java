package com.blog.app.controller;

import com.blog.app.models.Blog;
import com.blog.app.service.BlogService;
import com.blog.app.service.PythonSummaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Optional;

@RestController
@RequestMapping("/api/blogs")
@RequiredArgsConstructor
public class BlogController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private PythonSummaryService summaryService;

    @PostMapping
    public ResponseEntity<Blog> createBlog(@RequestBody Blog blog) {
        return ResponseEntity.ok(blogService.addBlog(blog));
    }

    @GetMapping
    public Page<Blog> getAllBlogs(@RequestParam(defaultValue = "0") int page) {
        return blogService.getAllBlogs(page, 5);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable Long id) {
        return blogService.getBlogById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable Long id, @RequestBody Blog blog) {
        return ResponseEntity.ok(blogService.updateBlog(id, blog));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlog(@PathVariable Long id) {
        blogService.deleteBlog(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/summary")
    public ResponseEntity<String> summarizeBlog(@PathVariable Long id) {
        Optional<Blog> blog = blogService.getBlogById(id);
        return ResponseEntity.ok(summaryService.generateSummary(blog.get().getContent()));
    }
}
