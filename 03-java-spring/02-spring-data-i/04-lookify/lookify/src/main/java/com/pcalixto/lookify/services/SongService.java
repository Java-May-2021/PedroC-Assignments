package com.pcalixto.lookify.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pcalixto.lookify.models.Song;
import com.pcalixto.lookify.repositories.SongRepository;

@Service
public class SongService {
	// adding the song repository as a dependency
	private final SongRepository songRepository;

	public SongService(SongRepository songRepository) {
		this.songRepository = songRepository;
	}

	// returns all songs
	public List<Song> allSongs() {
		return songRepository.findAll();
	}

	// returns matching songs
	public List<Song> findSongByArtist(String artist) {
		Iterable<Song> allSongs = songRepository.findAll();

		List<Song> matchingSongs = new ArrayList<>();
		for(Song song: allSongs){
			if (song.getArtist().toLowerCase().indexOf(artist.toLowerCase()) >= 0) {
				matchingSongs.add(song);
			}
		}

	    return matchingSongs;
	}

	// returns top ten songs
	public List<Song> topTenSongs() {
		Sort sort = Sort.by(Sort.Direction.DESC, "rating");
		Iterable<Song> allSongs = songRepository.findAll(sort);
		
		List<Song> topTen = new ArrayList<>();
		int count = 0;
		for(Song song: allSongs){
			// System.out.println(s);
			topTen.add(song);
			count++;
			if (count >= 10) {
				break;
			}
		}

	    return topTen;
	}
	
	// creates a song
	public Song createSong(Song song) {
		return songRepository.save(song);
	}
	
	// updates a song
	public Song updateSong(Song song) {
		return songRepository.save(song);
	}

	// deletes a song
	public void deleteSong(Long id) {
		songRepository.deleteById(id);
	}
	
	// retrieves a song
	public Song findSong(Long id) {
		return songRepository.findById(id).orElse(null);
	}

}
