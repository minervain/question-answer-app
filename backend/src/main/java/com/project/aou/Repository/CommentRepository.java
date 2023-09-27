package com.project.aou.Repository;

import com.project.aou.Entites.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository <Comment,Long> {
    List<Comment> findByUserIdAndPostId(Long userId,Long PostId);

    List<Comment> findByUserId(Long userId);

    List<Comment> findByPostId(Long postId);
}
