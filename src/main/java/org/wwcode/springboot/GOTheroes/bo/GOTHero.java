package org.wwcode.springboot.GOTheroes.bo;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="GOT_HEROES")
public class GOTHero{

    @Column(name="HERO_NAME")
    @JsonProperty("hero-name")
    private String name;

    @Id
    @Column(name="HERO_ID")
    @JsonProperty("hero-id")
    private int id;

    @Column(name="HERO_ALLEGIANCE")
    @JsonProperty("hero-allegiance")
    private String allegiance;

    @Column(name="HERO_TITLE")
    @JsonProperty("hero-title")
    private String title;

    @Column(name="HERO_IMAGE_URL")
    @JsonProperty("hero-image-url")
    private String imageUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAllegiance() {
        return allegiance;
    }

    public void setAllegiance(String allegiance) {
        this.allegiance = allegiance;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
