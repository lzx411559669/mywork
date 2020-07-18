package course2.springbean.service.impl;

import course2.springbean.model.Song;
import course2.springbean.model.Subject;
import course2.springbean.service.SongService;
import course2.springbean.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SongService songService;
    public static Map<String,Subject> subjectMap = new HashMap<>();
    static {
        Subject subject = new Subject();
        subject.setId("s001");
        subject.setName("成都");
        subject.setMusician("赵雷");
        subjectMap.put(subject.getId(),subject);
    }


    @Override
    public Subject get(String subjectId) {
        Subject subject = subjectMap.get(subjectId);
        List<Song> songs = songService.list(subjectId);
        subject.setSongs(songs);
        return subject;
    }
}
