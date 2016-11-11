package com.erich.grosner.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface BlogPostRepository extends Repository<BlogPost, UUID> {

    Page<BlogPost> findAll(Pageable pageable);

}
