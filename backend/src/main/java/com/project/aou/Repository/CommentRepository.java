package com.project.aou.Repository;

import com.project.aou.Entites.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository <Comment,Long> {
}
