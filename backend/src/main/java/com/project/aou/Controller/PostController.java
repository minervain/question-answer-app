package com.project.aou.Controller;

import com.project.aou.Entites.Post;
import com.project.aou.Service.PostService;
import com.project.aou.dto.PostCreateRequest;
import com.project.aou.dto.PostUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")


public class PostController {
    @Autowired
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAllPosts(@RequestParam Optional <Long>userId){

        return postService.getAllPosts(userId);
    }
    @PostMapping
    public Post createOnePost(@RequestBody PostCreateRequest newPost){
        return postService.createOnePost(newPost);
    }

    @GetMapping("/{postId}")
    public Post getOnePost(@PathVariable Long postId){
        return postService.geOnePostId(postId);
    }

        @PutMapping("/{postId}")
    public Post updateOnePost(@PathVariable Long postId, @RequestBody PostUpdateRequest updatePost){
        return postService.updateOnePostId(postId,updatePost);
        }

        @DeleteMapping("/{postId}")
        public  void deleteOnePost(@PathVariable Long postId){
         postService.deleteOnePostId(postId);
        }





}
