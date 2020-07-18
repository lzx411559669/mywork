package course2.springbean;

import course2.springbean.model.SongList;
import course2.springbean.model.Subject;
import course2.springbean.service.SongListService;
import course2.springbean.service.SubjectService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * Application
 */
public class Application {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("course2.springbean");

       /* SubjectService subjectService = context.getBean(SubjectService.class);
        //获取歌曲
        Subject subject = subjectService.get("s001");
        if (subject!=null) {
            System.out.println("专辑：" + subject.getName() + " 音乐家：" + subject.getMusician() + " 包含：" + subject.getSongs().size() + " 首歌");
        }else{
            System.out.println("null");
        }*/
        SongListService songListService = context.getBean(SongListService.class);
        SongList songList = songListService.get("41299401");
        System.out.println(songList == null);
        System.out.println(songList.getName());


    }
}