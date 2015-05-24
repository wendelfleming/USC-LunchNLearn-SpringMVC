package edu.usc.lunchnlearn.springmvc.dao.bean;

import javax.persistence.*;

/**
 * Created by wfleming on 5/22/15.
 */

@Entity
@Table(name = "Game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic
    private String name;

    @ManyToOne
    @JoinColumn(name = "studioid", referencedColumnName = "id")
    private Studio studio;

    @ManyToOne
    @JoinColumn(name = "genreid", referencedColumnName = "id")
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "platformid", referencedColumnName = "id")
    private Platform platform;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }


    @Override
    public String toString() {
        return getName();
    }


}
