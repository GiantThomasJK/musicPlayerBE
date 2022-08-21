package com.springboot.musicplayer.service;

import com.springboot.musicplayer.dto.SongDto;
import com.springboot.musicplayer.repository.model.Song;
import com.springboot.musicplayer.repository.model.SongPage;
import com.springboot.musicplayer.utils.SongSourceUpload;
import com.springboot.musicplayer.utils.SongThumbnailUpload;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.io.IOException;
import java.util.List;

public interface SongService {
    List<SongDto> findAllDto(Boolean shuffle);


    List<Song> findAll();

    long count(String name, String author, String genre);

    SongDto findById(String id);
    List<SongDto> findByName(String name);
    Boolean checkSong(Song song);

    String save(Song song);

    SongPage getPage(String name, String author, String genre, int index, Integer limit, Pageable pageable);

    Song editSong(Song song);

    String delete(Song song) throws IOException;

    List<SongDto> getRelatedSong(String songId);

    Song uploadSongSource(Song song, @ModelAttribute SongSourceUpload songUpload) throws IOException;

    Song uploadSongThumbnail(Song song, @ModelAttribute SongThumbnailUpload songThumbnailUpload) throws IOException;

    SongDto updateStream(SongDto song);
}
