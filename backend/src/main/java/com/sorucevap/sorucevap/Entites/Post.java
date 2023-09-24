package com.sorucevap.sorucevap.Entites;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "post")
@Data
public class Post {

    @Id
    Long id;
    Long postId;
    Long userId;
    @Lob
    @Column(columnDefinition = "text")
    String text;

}
