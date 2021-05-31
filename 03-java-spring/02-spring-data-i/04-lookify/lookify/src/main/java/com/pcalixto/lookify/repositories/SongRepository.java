package com.pcalixto.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pcalixto.lookify.models.Song;

@Repository
public interface SongRepository extends PagingAndSortingRepository<Song, Long>{
    List<Song> findAll();
}


