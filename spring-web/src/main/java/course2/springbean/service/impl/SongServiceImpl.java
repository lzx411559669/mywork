package course2.springbean.service.impl;

import course2.springbean.model.Song;
import course2.springbean.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SongServiceImpl implements SongService {
    private static Map<String, Song> songMap = new HashMap<>();
    static {
        Song song = new Song();
        song.setId("001");
        song.setSubjectId("s001");
        song.setLyrics("...");
        song.setName("成都");
       songMap.put(song.getId(),song);
    }


    @Override
    public Song add(Song song) {
        return null;
    }

    @Override
    public Song get(String songId) {

        return songMap.get(songId);
    }

    @Override
    public List<Song> list(String subjectId) {

        List<Song> songs = new ArrayList<>();
        for (Map.Entry<String,Song> songEntry:songMap.entrySet()
             ) {
            if (songEntry.getValue().getSubjectId().equals(subjectId)){
                songs.add(songEntry.getValue());
            }
        }
        return  songs;

    }
}
