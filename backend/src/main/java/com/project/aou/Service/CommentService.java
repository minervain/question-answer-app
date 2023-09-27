package com.project.aou.Service;

import com.project.aou.Entites.Comment;
import com.project.aou.Entites.Post;
import com.project.aou.Entites.User;
import com.project.aou.Repository.CommentRepository;
import com.project.aou.dto.CommentRequest;
import com.project.aou.dto.CommentUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CommentService {
    private CommentRepository commentRepository;
    private UserService userService;
    private PostService postService;

    public CommentService(CommentRepository commentRepository, UserService userService, PostService postService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.postService = postService;
    }

    public List<Comment> getAllCommentsWithParam(Optional<Long> userId, Optional<Long> postId) {

        if(userId.isPresent() && postId.isPresent()){
            return commentRepository.findByUserIdAndPostId(userId.get(),postId.get());
        } else if (userId.isPresent()) {
            return commentRepository.findByUserId(userId.get());

        } else if (postId.isPresent()) {
            return commentRepository.findByPostId(postId.get());
            
        }
        else return commentRepository.findAll();

    }

    public Comment getOneCommentById(Long commentId) {

        return commentRepository.findById(commentId).orElse(null);
    }

    public Comment createOneComment(CommentRequest request) {
        User user=userService.getOneUser(request.getId());
        Post post=postService.geOnePostId(request.getId());

        if(post!=null && user!=null){

            Comment commentToSave=new Comment();
            commentToSave.setId(request.getId());
            commentToSave.setPost(post);
            commentToSave.setUser(user);
            commentToSave.setText(request.getText());
            return commentRepository.save(commentToSave);

        }else

        return null;
    }

    public Comment updateOneComment(Long commentId, CommentUpdateRequest request) {

        Optional <Comment> comment=commentRepository.findById(commentId);
        if(comment.isPresent()){
            Comment commentToUpdate=comment.get();
            commentToUpdate.setText(request.getText());
          return   commentRepository.save(commentToUpdate);

        }
        else return null;

    }

    public void deleteOneCommentByID( Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
