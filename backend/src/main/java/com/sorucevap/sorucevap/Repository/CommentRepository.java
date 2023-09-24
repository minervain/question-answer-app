package com.sorucevap.sorucevap.Repository;

import com.sorucevap.sorucevap.Entites.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository <Comment,Long> {
}
