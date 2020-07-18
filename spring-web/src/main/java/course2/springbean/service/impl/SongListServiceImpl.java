package course2.springbean.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import course2.springbean.model.Song;
import course2.springbean.model.SongList;
import course2.springbean.service.SongListService;
import course2.springresource.service.FileService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SongListServiceImpl implements SongListService {
    private static Map<String,SongList> songLists = new HashMap<>();
    @PostConstruct
    public void init(){
        ApplicationContext context = new AnnotationConfigApplicationContext("course2.springresource");
        FileService fileService = context.getBean(FileService.class);
        String content = fileService.getContent("classpath:data/songlists.json");
        SongList [] lists = JSON.parseObject(content,SongList[].class);
        for (SongList songList : lists){
            songLists.put(songList.getId(),songList);
        }
      /*  List<Map> lists = JSON.parseArray(content,Map.class);
        for (Map map: lists
             ) {
            SongList songList = new SongList();
            songList.setName(map.get("name").toString());
            songList.setId(map.get("id").toString());
            songLists.put(songList.getId(),songList);
        }*/

    /*    JSONArray tableData = JSONArray.parseArray(content);
        for (Object obs:tableData){
            Map songMap = (Map)obs;
            SongList songList = new SongList();
            songList.setName(songMap.get("name").toString());
            songList.setId(songMap.get("id").toString());
            String name = songMap.get("name").toString();
            System.out.println(name);
           // SongList songList = (SongList)obs;
            songLists.put(songList.getId(),songList);

        }
*/
    }

    @Override
    public SongList get(String songListId) {
        return songLists.get(songListId);
    }
}
