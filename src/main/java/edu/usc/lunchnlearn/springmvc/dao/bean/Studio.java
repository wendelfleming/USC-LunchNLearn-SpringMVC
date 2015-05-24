package edu.usc.lunchnlearn.springmvc.dao.bean;

import javax.persistence.*;

/**
 * Created by wfleming on 5/22/15.
 */

@Entity
@Table(name = "Studio")
public class Studio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic
    private String name;

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

    @Override
    public String toString() {
        return getName();
    }


}
