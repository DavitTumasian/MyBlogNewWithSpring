package com.example.model;

import javax.persistence.*;

@Entity
@Table
public class PostEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "category_id")
    private long category_id;
    @Column(name = "title")
    private String title;
//    @Column(name = "postPic")
//    private String postPic;
    @Column(name = "description")
    private String description;
    @Column(name = "time")
    private String timeStamp;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(long category_id) {
        this.category_id = category_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public String getpostPic() {
//        return postPic;
//    }

//    public void setImage(String image) {
//        this.postPic = postPic;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", category_id='" + category_id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                '}';
    }
}


