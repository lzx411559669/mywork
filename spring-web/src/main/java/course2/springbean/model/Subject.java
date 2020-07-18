package course2.springbean.model;

import java.time.LocalDate;
import java.util.List;

public class Subject {
    private String id;
    private String name;
    private String cover;
    private String musician;
    private LocalDate publisedDate;
    List<Song> songs;

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

    public String getMusician() {
        return musician;
    }

    public void setMusician(String musician) {
        this.musician = musician;
    }

    public LocalDate getPublisedDate() {
        return publisedDate;
    }

    public void setPublisedDate(LocalDate publisedDate) {
        this.publisedDate = publisedDate;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
