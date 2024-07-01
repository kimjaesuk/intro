package com.ohgiraffers.blog.jaesuk.model.dto;

public class BlogDTO {

    private String blogTitle;
    public  String blogContent;

    @Override
    public String toString() {
        return "BlogDTO{" +
                "blogTitle='" + blogTitle + '\'' +
                ", blogContent='" + blogContent + '\'' +
                '}';
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public BlogDTO(String blogTitle, String blogContent) {
        this.blogTitle = blogTitle;
        this.blogContent = blogContent;
    }

    public BlogDTO() {
    }
}
