package com.project.aou.Service;

import com.project.aou.Entites.Post;
import com.project.aou.Entites.User;
import com.project.aou.Repository.PostRepository;
import com.project.aou.dto.PostCreateRequest;
import com.project.aou.dto.PostUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private PostRepository postRepository;
    private UserService userService;

    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public List<Post> getAllPosts(Optional<Long> userId) {
        if(userId.isPresent()){
            return postRepository.findByUserId(userId.get());
        }
        else return postRepository.findAll();
    }

    public Optional<Post> getOnePost(Long postId) {
        return postRepository.findById(postId);
    }

    public Post createOnePost(PostCreateRequest newPost) {
        User user=userService.getOneUser((newPost.getId()));
        if(user==null){
            return null;
        }
        Post toSave=new Post();
        toSave.setId(newPost.getId());
        toSave.setText(newPost.getText());
        toSave.setTitle(newPost.getTitle());
        toSave.setUser(user);
        return postRepository.save(toSave);

    }

    public Post geOnePostId(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    public Post updateOnePostId(Long postId, PostUpdateRequest updatePost) {
        Optional<Post> post=postRepository.findById(postId);
        if(post.isPresent()){
            Post toUpdate=post.get();
            toUpdate.setTitle(updatePost.getTitle());
            toUpdate.setText(updatePost.getText());
            postRepository.save(toUpdate);
            return toUpdate;

        }
return null;


    }

    public void deleteOnePostId(Long postId) {
        postRepository.deleteById(postId);
    }
}
