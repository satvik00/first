package com.example.userinterface;

public class Articles {
    String title;
    String author;
    String add;
    String imageurl;
    String desc;
    public Articles(){}

    public Articles(String ttle, String Author, String Add, String Imageurl){
        title=ttle;
        author=Author;
        add=Add;
        imageurl=Imageurl;
    }
    public String getdesc(){
        return desc;
    }
    public String getTitle(){
        return title;
    }
    public String getUrl(){
        return add;
    }
    public String getAuthor(){
        return author;
    }
    public String getUrlToImage(){
        return imageurl;
    }
}
