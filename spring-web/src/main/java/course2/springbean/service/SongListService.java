package course2.springbean.service;

import course2.springbean.model.SongList;

public interface SongListService {
    //获取一个歌单的信息
    SongList get(String songListId);
}
