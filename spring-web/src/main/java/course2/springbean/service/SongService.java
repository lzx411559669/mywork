package course2.springbean.service;

import course2.springbean.model.Song;

import java.util.List;

public interface SongService {
    Song add(Song song);
    Song get(String songId);
    List<Song> list(String subjectId);
}
