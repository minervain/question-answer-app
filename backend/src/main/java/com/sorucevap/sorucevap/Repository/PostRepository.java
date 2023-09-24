package com.sorucevap.sorucevap.Repository;

import com.sorucevap.sorucevap.Entites.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository <Post,Long> {
}
