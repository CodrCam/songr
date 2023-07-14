package com.chamcocat.songr;

import com.chamcocat.songr.model.Album;
import com.chamcocat.songr.model.AppUser;
import com.chamcocat.songr.model.Song;
import com.chamcocat.songr.repository.AlbumRepository;
import com.chamcocat.songr.repository.AppUserRepository;
import com.chamcocat.songr.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    @GetMapping("/")
    public String home(HttpSession session, Model model) {
        if(session.getAttribute("username") != null) {
            model.addAttribute("username", session.getAttribute("username"));
        }
        return "index";
    }

    @GetMapping("/signup")
    public String showSignupPage(Model model) {
        model.addAttribute("appUser", new AppUser());
        return "signup";
    }

    @PostMapping("/signup")
    public String signUp(@ModelAttribute AppUser user, Model model) {
        AppUser existingUser = appUserRepository.findByUsername(user.getUsername());
        if(existingUser != null) {
            model.addAttribute("error", "Username already taken");
            return "signup";
        }

        appUserRepository.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
        AppUser user = appUserRepository.findByUsername(username);
        if(user != null && user.checkPassword(password)) {
            session.setAttribute("username", user.getUsername());
            return "redirect:/";
        }

        model.addAttribute("error", "Invalid username or password");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
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
