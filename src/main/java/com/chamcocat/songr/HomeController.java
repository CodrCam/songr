package com.chamcocat.songr;

import com.chamcocat.songr.model.Album;
import com.chamcocat.songr.model.Song;
import com.chamcocat.songr.repository.AlbumRepository;
import com.chamcocat.songr.repository.SongRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Controller
public class HomeController {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private SongRepository songRepository;

    @GetMapping("/")
    public String home(Model model) {
        return "index";
    }

    @GetMapping("/hello")
    public String helloWorld(Model model) {
        model.addAttribute("message", "Hello, World!");
        return "hello-world";
    }

    @GetMapping("/capitalize/{text}")
    public String capitalize(@PathVariable String text, Model model) {
        model.addAttribute("text", text.toUpperCase());
        return "capitalize";
    }

    @GetMapping("/albums")
    public String albums(Model model) {
        List<Album> albums = albumRepository.findAll();
        model.addAttribute("albums", albums);
        return "albums";
    }

    @PostMapping("/albums")
    public String addAlbum(@ModelAttribute Album album) {
        albumRepository.save(album);
        return "redirect:/albums";
    }

    @GetMapping("/albums/{id}")
    public String albumDetails(@PathVariable Long id, Model model) {
        Album album = albumRepository.findById(id).orElse(null);
        model.addAttribute("album", album);
        return "album-details";
    }

    @GetMapping("/song")
    public String showSongs(Model model) {
        List<Song> songs = songRepository.findAll();
        model.addAttribute("songs", songs);
        return "song";
    }

    @GetMapping("/albums/{id}/songs/add")
    public String showAddSongForm(@PathVariable Long id, Model model) {
        Album album = albumRepository.findById(id).orElse(null);
        if (album != null) {
            model.addAttribute("album", album);
            model.addAttribute("song", new Song());
            return "add-song";
        }
        return "redirect:/albums";
    }

    @PostMapping("/albums/{id}/songs")
    public String addSongToAlbum(@PathVariable Long id, @ModelAttribute Song song) {
        Album album = albumRepository.findById(id).orElse(null);
        if (album != null) {
            song.setAlbum(album);
            songRepository.save(song);
        }
        return "redirect:/albums/" + id;
    }
}
