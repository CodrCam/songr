package com.chamcocat.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
@Controller
public class HomeController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/capitalize/{text}")
    public String capitalize(@PathVariable("text") String text, Model model) {
        String capitalizedText = text.toUpperCase();
        model.addAttribute("capitalizedText", capitalizedText);
        return "capitalize";
    }

    @GetMapping("/")
    public String splash() {
        return "index";
    }

    @GetMapping("/albums")
    public String albums(Model model) {
        Album album1 = new Album("DAMN.", "Kendrick Lamar", 14, 3600, "https://static.hiphopdx.com/2017/04/Kendrick-Lamar-DAMN-album-cover-featured-827x620.jpg");
        Album album2 = new Album("Traumazine", "Megan Thee Stallion", 12, 4200, "https://imageUrl2.com");
        Album album3 = new Album("I Decided.", "Big Sean", 14, 3200, "https://imageUrl3.com");

        List<Album> albums = Arrays.asList(album1, album2, album3);
        model.addAttribute("albums", albums);
        return "albums";
    }

    @GetMapping("/error")
    public String handleError() {
        return "error";
    }

}

