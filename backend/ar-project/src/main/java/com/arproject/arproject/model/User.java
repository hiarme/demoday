package com.arproject.arproject.model;


import org.hibernate.type.ImageType;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.File;
import java.net.URI;

@Entity
@Table(name = "user")
public class User {

    private int id;
    private String userName;
    private String name;
    private File resume;
    private URI github;
    private URI portfolio;
    private ImageType image;

  // *** POJO ***
    public User() {}


  // *** GETTER's/SETTER's ***
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    @Column(name = "username")
    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    @Column(name = "name")
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    @Column(name = "resume")
    public File getResume() { return resume; }

    public void setResume(File resume) { this.resume = resume; }

    @Column(name = "github")
    public URI getGithub() { return github; }

    public void setGithub(URI github) { this.github = github; }

    @Column(name = "portfolio")
    public URI getPortfolio() { return portfolio; }

    public void setPortfolio(URI portfolio) { this.portfolio = portfolio; }

    @Column(name = "image")
    public ImageType getImage() { return image; }

    public void setImage(ImageType image) { this.image = image; }


  // *** Equals & HashCode ***
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id == user.id;
    }

    @Override
    public int hashCode() {
        return id;
    }


  // *** toString ***
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", resume=" + resume +
                ", github=" + github +
                ", portfolio=" + portfolio +
                ", image=" + image +
                '}';
    }
}
