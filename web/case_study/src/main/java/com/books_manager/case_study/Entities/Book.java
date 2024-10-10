package com.books_manager.case_study.Entities;

public class Book {
    private int id;
    private String title;
    private String author;
    private int authorId;
    private String publisher;
    private String isbn;
    private String genre;
    private int pages_count;
    private double price;



    public Book(int id, String title, int authorId, String publisher, String isbn, String genre, int pages_count, double price) {
        this.id = id;
        this.title = title;
        this.authorId = authorId;
        this.publisher = publisher;
        this.isbn = isbn;
        this.genre = genre;
        this.pages_count = pages_count;
        this.price = price;
    }

    public Book(int id, String title, String author, int authorId, String publisher, String isbn, String genre, int pages_count, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.authorId = authorId;
        this.publisher = publisher;
        this.isbn = isbn;
        this.genre = genre;
        this.pages_count = pages_count;
        this.price = price;
    }

    public Book(String title, String author, String publisher, String isbn, String genre, int pages_count, double price) {

        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.genre = genre;
        this.pages_count = pages_count;
        this.price = price;
    }

    public Book(String title, int authorId, String publisher, String isbn, String genre, int pages_count, double price) {

        this.title = title;
        this.authorId = authorId;
        this.publisher = publisher;
        this.isbn = isbn;
        this.genre = genre;
        this.pages_count = pages_count;
        this.price = price;
    }



    public int getAuthorId() {
        return authorId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPages_count() {
        return pages_count;
    }

    public void setPages_count(int pages_count) {
        this.pages_count = pages_count;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", authorId=" + authorId + '\'' +
                ", publisher='" + publisher + '\'' +
                ", isbn='" + isbn + '\'' +
                ", genre='" + genre + '\'' +
                ", pages_count=" + pages_count +
                ", price=" + price +
                '}';
    }
}
