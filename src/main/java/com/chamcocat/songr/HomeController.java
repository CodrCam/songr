package com.chamcocat.songr;

import com.chamcocat.songr.model.Album;
import com.chamcocat.songr.repository.AlbumRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class HomeController {

    private final AlbumRepository albumRepository;

    public HomeController(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/capitalize/{text}")
    public String capitalize(@PathVariable("text") String text, Model model) {
        model.addAttribute("capitalized", text.toUpperCase());
        return "capitalize";
    }

    @GetMapping("/albums")
    public String albums(Model model) {
        model.addAttribute("albums", albumRepository.findAll());
        return "albums";
    }

    @PostMapping("/albums")
    public String addAlbum(@RequestParam String title,
                           @RequestParam String artist,
                           @RequestParam Integer song_count,
                           @RequestParam Integer length_in_seconds,
                           @RequestParam String image_url) {
        Album album = new Album(title, artist, song_count, length_in_seconds, image_url);
        albumRepository.save(album);
        return "redirect:/albums";
    }
}