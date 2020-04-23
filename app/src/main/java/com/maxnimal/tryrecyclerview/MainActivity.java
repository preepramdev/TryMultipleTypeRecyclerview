package com.maxnimal.tryrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private OrderDetail mOrderDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mOrderDetail = new OrderDetail();

        fakeApi();
    }

    private void fakeApi() {
        List<OrderDetail.Food> foodList = new ArrayList();
        List<OrderDetail.Book> bookList = new ArrayList();
        List<OrderDetail.Music> musicList = new ArrayList();

        for (int i = 0; i <= 3; i++) {
            OrderDetail.Food food = new OrderDetail.Food();
            OrderDetail.Book book = new OrderDetail.Book();
            OrderDetail.Music music = new OrderDetail.Music();

            food.setOrderName("Food " + i);
            food.setAmount(i + 1);
            food.setPrice(100 * (i + 1));

            Log.e(TAG, "fakeApi: Food OrderName " + food.getOrderName());
            Log.e(TAG, "fakeApi: Food Amount " + food.getAmount());
            Log.e(TAG, "fakeApi: Food Price " + food.getPrice());

            book.setIsbn("bookisbn" + i);
            book.setBookName("Book Name " + i);
            book.setAuthor("Author " + i);
            book.setPublishDate("01/02/200" + i);
            book.setPublication("Publication " + i);
            book.setPrice(120 * (i + 1));
            book.setPages(18 * (i + 1));

            Log.e(TAG, "fakeApi: Book Isbn " + book.getIsbn());
            Log.e(TAG, "fakeApi: Book Name " + book.getBookName());
            Log.e(TAG, "fakeApi: Book Author " + book.getAuthor());
            Log.e(TAG, "fakeApi: Book PublishDate " + book.getPublishDate());
            Log.e(TAG, "fakeApi: Book Publication " + book.getPublication());
            Log.e(TAG, "fakeApi: Book Price " + book.getPrice());
            Log.e(TAG, "fakeApi: Book Pages " + book.getPages());

            music.setArtist("Artist " + i);
            music.setAlbum("Album " + i);
            music.setReleaseDate("01/02/200" + i);
            music.setTrack(i);
            music.setPrice(150 * (i + 1));

            Log.e(TAG, "fakeApi: Music Artist " + music.getArtist());
            Log.e(TAG, "fakeApi: Music Album " + music.getAlbum());
            Log.e(TAG, "fakeApi: Music ReleaseDate " + music.getReleaseDate());
            Log.e(TAG, "fakeApi: Music Track " + music.getTrack());
            Log.e(TAG, "fakeApi: Music Price " + music.getPrice());

            foodList.add(food);
            bookList.add(book);
            musicList.add(music);
        }
        mOrderDetail.setFoodList(foodList);
        mOrderDetail.setBookList(bookList);
        mOrderDetail.setMusicList(musicList);
        Log.e(TAG, "fakeApi: mOrderDetail " + mOrderDetail);
    }
}
