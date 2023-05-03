package com.chamcocat.songr.repository;


import com.chamcocat.songr.model.Album;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<Album, Long> {
}
