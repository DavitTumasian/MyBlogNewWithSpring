package com.example.repository;

import com.example.model.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
//    @Modifying
//    @Transactional
//     void addPost();
//     void updatePost();
//     void removePost();
}
