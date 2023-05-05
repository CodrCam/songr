package com.chamcocat.songr.model;

import jakarta.persistence.*;

@Entity
@Table(name = "songs")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private int length_in_seconds;
    private int track_number;


    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;


    public Song() {
    }

    public Song(String title, int length_in_seconds, int track_number, Album album) {
        this.title = title;
        this.length_in_seconds = length_in_seconds;
        this.track_number = track_number;
        this.album = album;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength_in_seconds() {
        return length_in_seconds;
    }

    public void setLength_in_seconds(int length_in_seconds) {
        this.length_in_seconds = length_in_seconds;
    }

    public int getTrack_number() {
        return track_number;
    }

    public void setTrack_number(int track_number) {
        this.track_number = track_number;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}

