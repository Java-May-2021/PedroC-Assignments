package com.pcalixto.lookify.controllers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.pcalixto.lookify.models.Song;
import com.pcalixto.lookify.services.SongService;

@Controller
public class MainController {
    private final SongService songService;
    
    public MainController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping("/")
	public String index() {
		return "index.jsp";
	}

	@GetMapping("/dashboard")
	public String dashboard(Model viewmodel) {
		List<Song> songs = this.songService.allSongs();
		viewmodel.addAttribute("songs", songs);
		viewmodel.addAttribute("mode", "dashboardMode");
		viewmodel.addAttribute("searchTerm", "");
		return "dashboard.jsp";
	}

	@GetMapping("/search/{artist}")
	public String search(@PathVariable("artist") String artist,
						 Model viewmodel) {
		if (artist.length() < 1) {
			return "redirect:/dashboard";
		}
		List<Song> songs = this.songService.findSongByArtist(artist);
		viewmodel.addAttribute("songs", songs);
		viewmodel.addAttribute("mode", "searchMode");
		viewmodel.addAttribute("searchTerm", artist);
		return "dashboard.jsp";
	}

	@GetMapping("/search/topTen")
	public String topTen(Model viewmodel) {
		List<Song> songs = this.songService.topTenSongs();
		viewmodel.addAttribute("songs", songs);
		return "topTen.jsp";
	}

	@GetMapping("/songs/{id}")
	public String showSong(@PathVariable("id") Long id,
			  			   Model viewmodel) {
		Song song = songService.findSong(id);
		viewmodel.addAttribute("song", song);
		return "showSong.jsp";
	}
	
	@DeleteMapping("/songs/{id}")
	public String deleteSong(@PathVariable("id") Long id) {
		songService.deleteSong(id);
		return "redirect:/dashboard";
	}

	@GetMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Song song,
						  Model viewmodel) {
		addRatingListViewModel(viewmodel);
	    return "newSong.jsp";
	}

	@PostMapping("/songs/new")
	public String newSong(@Valid @ModelAttribute("song") Song song, 
			   			  BindingResult result,
			   			  Model viewmodel) {
		if (result.hasErrors()) {
			addRatingListViewModel(viewmodel);
			return "newSong.jsp";
		} else {
			songService.createSong(song);
			return "redirect:/dashboard";
		}		
	}
	
	private void addRatingListViewModel(Model viewmodel) {
	    Map<String,String> rating = new LinkedHashMap<String,String>();
	    rating.put("0", "Select a rating");
	    rating.put("1", "1");
	    rating.put("2", "2");
	    rating.put("3", "3");
	    rating.put("4", "4");
	    rating.put("5", "5");
	    rating.put("6", "6");
	    rating.put("7", "7");
	    rating.put("8", "8");
	    rating.put("9", "9");
	    rating.put("10", "10");
	    viewmodel.addAttribute("ratingList", rating);
	}
}
