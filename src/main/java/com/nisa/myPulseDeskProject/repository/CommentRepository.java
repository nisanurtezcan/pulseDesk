package com.nisa.myPulseDeskProject.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.nisa.myPulseDeskProject.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
