package com.maxnimal.tryrecyclerview;

import android.os.Handler;
import android.util.Log;

import com.google.gson.Gson;

import java.util.Random;

public class FakeNetwork {
    public static void getFakeOrderDetail(final OnResultCallback onResultCallback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                OrderDetail orderDetail = createFakeOrderDetail();
                if (onResultCallback != null) {
                    onResultCallback.onOrderDetailCallback(orderDetail);
                }
            }
        }, 1000);
    }

    private static OrderDetail createFakeOrderDetail() {
        /*String fakeJson = "{\"food_list\":[{\"order_name\":\"Chicken\",\"amount\":2,\"price\":400},{\"order_name\":\"Egg\",\"amount\":24,\"price\":120}],\"book_list\":[{\"ISBN\":\"9780804139038\",\"book_name\":\"The Martian: A Novel\",\"author\":\"Andy Weir\",\"publish_date\":\"11 February 2014\",\"publication\":\"Broadway Books\",\"price\":314,\"pages\":384},{\"ISBN\":\"9781449327972\",\"book_name\":\"Embedded Android: Porting, Extending, and Customizing\",\"author\":\"Karim Yaghmour\",\"publish_date\":\"12 March 2013\",\"publication\":\"O'Reilly Media, Inc.\",\"price\":475,\"pages\":412},{\"ISBN\":\"9780545229937\",\"book_name\":\"The Hunger Games\",\"author\":\"Suzanne Collins\",\"publish_date\":\"1 September 2009\",\"publication\":\"Scholastic Inc.\",\"price\":279,\"pages\":384}],\"music_list\":[{\"artist\":\"Green Day\",\"album\":\"American Idiot\",\"release_date\":\"8 September 2004\",\"track\":9,\"price\":330}]}";
        return new Gson().fromJson(fakeJson, OrderDetail.class);*/

        String[] fakeJsonList = {
                "{\"food_list\":[{\"order_name\":\"Chicken\",\"amount\":2,\"price\":400},{\"order_name\":\"Egg\",\"amount\":24,\"price\":120}],\"book_list\":[{\"ISBN\":\"9780804139038\",\"book_name\":\"The Martian: A Novel\",\"author\":\"Andy Weir\",\"publish_date\":\"11 February 2014\",\"publication\":\"Broadway Books\",\"price\":314,\"pages\":384},{\"ISBN\":\"9781449327972\",\"book_name\":\"Embedded Android: Porting, Extending, and Customizing\",\"author\":\"Karim Yaghmour\",\"publish_date\":\"12 March 2013\",\"publication\":\"O'Reilly Media, Inc.\",\"price\":475,\"pages\":412},{\"ISBN\":\"9780545229937\",\"book_name\":\"The Hunger Games\",\"author\":\"Suzanne Collins\",\"publish_date\":\"1 September 2009\",\"publication\":\"Scholastic Inc.\",\"price\":279,\"pages\":384}],\"music_list\":[{\"artist\":\"Green Day\",\"album\":\"American Idiot\",\"release_date\":\"8 September 2004\",\"track\":9,\"price\":330}]}",
                "{\"food_list\":[],\"book_list\":[],\"music_list\":[]}",
                "{\"food_list\":null,\"book_list\":null,\"music_list\":null}",
                "{ }",
                "",
                "null"
        };
        int index = new Random().nextInt(fakeJsonList.length);
        Log.e("FakeNetwork", "Response with data set " + index);
        return new Gson().fromJson(fakeJsonList[index], OrderDetail.class);
    }

    public interface OnResultCallback {
        void onOrderDetailCallback(OrderDetail orderDetail);
    }
}
