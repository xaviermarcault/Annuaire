package com.actorep.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.actorep.model.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Integer> {

}
