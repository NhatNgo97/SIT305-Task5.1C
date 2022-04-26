package com.example.task51;

public class News {
    private String title, description, genre;
    private Integer img, id;
    private boolean isTopNews;


    public News(Integer id,String title, String description, Integer img, boolean isTopNews, String genre) {
        this.title = title;
        this.description = description;
        this.img = img;
        this.id = id;
        this.isTopNews = isTopNews;
        this.genre = genre;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public Integer getImg() {
        return img;
    }

    public boolean isTopNews() {
        return isTopNews;
    }

    public void setImg(Integer img) {
        this.img = img;
    }

    public Integer getId() {
        return id;
    }

    public String getGenre() {
        return genre;
    }
}
