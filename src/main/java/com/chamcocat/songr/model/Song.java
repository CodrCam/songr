package com.chamcocat.songr.model;

import jakarta.persistence.*;

@Entity
@Table(name = "songs")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private int lengthInSeconds;
    private int trackNumber;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    public Song() {
    }

    public Song(String title, int lengthInSeconds, int trackNumber, Album album) {
        this.title = title;
        this.lengthInSeconds = lengthInSeconds;
        this.trackNumber = trackNumber;
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

    public int getLengthInSeconds() {
        return lengthInSeconds;
    }

    public void setLengthInSeconds(int lengthInSeconds) {
        this.lengthInSeconds = lengthInSeconds;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}

