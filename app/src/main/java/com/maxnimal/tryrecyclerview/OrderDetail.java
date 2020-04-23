package com.maxnimal.tryrecyclerview;

import java.util.List;

public class OrderDetail {
    private List<Food> foodList;
    private List<Book> bookList;
    private List<Music> musicList;

    public List<Food> getFoodList() {
        return foodList;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public List<Music> getMusicList() {
        return musicList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }

    public static class Food {
        private String orderName;
        private int amount;
        private int price;

        public String getOrderName() {
            return orderName;
        }

        public int getAmount() {
            return amount;
        }

        public int getPrice() {
            return price;
        }

        public void setOrderName(String orderName) {
            this.orderName = orderName;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }

    public static class Book {
        private String isbn;
        private String bookName;
        private String author;
        private String publishDate;
        private String publication;
        private int price;
        private int pages;

        public String getIsbn() {
            return isbn;
        }

        public String getBookName() {
            return bookName;
        }

        public String getAuthor() {
            return author;
        }

        public String getPublishDate() {
            return publishDate;
        }

        public String getPublication() {
            return publication;
        }

        public int getPrice() {
            return price;
        }

        public int getPages() {
            return pages;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        public void setBookName(String bookName) {
            this.bookName = bookName;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setPublishDate(String publishDate) {
            this.publishDate = publishDate;
        }

        public void setPublication(String publication) {
            this.publication = publication;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }
    }

    public static class Music {
        private String artist;
        private String album;
        private String releaseDate;
        private int track;
        private int price;

        public String getArtist() {
            return artist;
        }

        public String getAlbum() {
            return album;
        }

        public String getReleaseDate() {
            return releaseDate;
        }

        public int getTrack() {
            return track;
        }

        public int getPrice() {
            return price;
        }

        public void setArtist(String artist) {
            this.artist = artist;
        }

        public void setAlbum(String album) {
            this.album = album;
        }

        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }

        public void setTrack(int track) {
            this.track = track;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }
}
