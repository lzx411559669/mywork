package course2.springbean.model;

import java.time.LocalDate;
import java.util.List;

public class SongList {
    //歌单唯一ID
    private String id;
    //歌单名称
    private String name;
    //歌单封面
    private String cover;
    //歌单发布者
    private String author;
    //发布时间
    private LocalDate publishedDate;
    //包含的歌曲Id
    private List<String> songId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public List<String> getSongId() {
        return songId;
    }

    public void setSongId(List<String> songId) {
        this.songId = songId;
    }
}
