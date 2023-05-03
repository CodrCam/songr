package com.chamcocat.songr;

import com.chamcocat.songr.model.Album;
import com.chamcocat.songr.repository.AlbumRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class AlbumRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AlbumRepository albumRepository;

    private Album album1;

    @BeforeEach
    public void setUp() {
        album1 = new Album("DAMN.", "Kendrick Lamar", 14, 3600, "https://imageUrl1.com");
    }

    @AfterEach
    public void tearDown() {
        entityManager.clear();
    }

    @Test
    public void testSaveAlbum() {
        Album savedAlbum = albumRepository.save(album1);
        assertThat(savedAlbum).isNotNull();
        assertThat(savedAlbum.getId()).isNotNull();
    }

    @Test
    public void testFindAlbumById() {
        Album savedAlbum = entityManager.persistFlushFind(album1);
        Album foundAlbum = albumRepository.findById(savedAlbum.getId()).orElse(null);
        assertThat(foundAlbum).isNotNull();
        assertThat(foundAlbum.getId()).isEqualTo(savedAlbum.getId());
    }

    @Test
    public void testFindAllAlbums() {
        entityManager.persistFlushFind(album1);
        List<Album> albums = (List<Album>) albumRepository.findAll();
        assertThat(albums).isNotEmpty();
    }

    @Test
    public void testUpdateAlbum() {
        Album savedAlbum = entityManager.persistFlushFind(album1);
        savedAlbum.setTitle("New Title");
        albumRepository.save(savedAlbum);
        Album updatedAlbum = entityManager.find(Album.class, savedAlbum.getId());
        assertThat(updatedAlbum.getTitle()).isEqualTo("New Title");
    }

    @Test
    public void testDeleteAlbum() {
        Album savedAlbum = entityManager.persistFlushFind(album1);
        albumRepository.delete(savedAlbum);
        Album deletedAlbum = entityManager.find(Album.class, savedAlbum.getId());
        assertThat(deletedAlbum).isNull();
    }
}
