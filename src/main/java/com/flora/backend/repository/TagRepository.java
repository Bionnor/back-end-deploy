package com.flora.backend.repository;

import com.flora.backend.entities.Comment;
import com.flora.backend.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag,Long> {

}
