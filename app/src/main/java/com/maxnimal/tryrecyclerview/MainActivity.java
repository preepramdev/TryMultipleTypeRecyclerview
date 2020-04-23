package com.maxnimal.tryrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.maxnimal.tryrecyclerview.item.BaseOrderDetailItem;
import com.maxnimal.tryrecyclerview.item.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private RecyclerView rvOrderDetail;
    private OrderAdapter orderAdapter;

    private OrderDetail mOrderDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mOrderDetail = new OrderDetail();

        bindView();
        setupView();
//        fakeApi();
        callService();
    }

    private void bindView() {
        rvOrderDetail = (RecyclerView) findViewById(R.id.rv_order_detail);
    }

    private void setupView() {
        rvOrderDetail.setLayoutManager(new LinearLayoutManager(this));
        orderAdapter = new OrderAdapter();
        rvOrderDetail.setAdapter(orderAdapter);

        orderAdapter.setOnItemClickListener(new OrderAdapter.OnItemClickListener() {
            @Override
            public void onPositiveButtonClick() {
                Toast.makeText(MainActivity.this, "Positive Button Clicked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNegativeButtonClick() {
                Toast.makeText(MainActivity.this, "Negative Button Clicked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onOrderRemove(OrderItem orderItem) {
                List<BaseOrderDetailItem> oldOrderItemList = createOrderDetailList(mOrderDetail);
                boolean isOrderRemoved = removeOrder(mOrderDetail, orderItem);
                List<BaseOrderDetailItem> newOrderItemList = createOrderDetailList(mOrderDetail);

                if (isOrderRemoved) {
                    updateOrderDetailList(oldOrderItemList, newOrderItemList);
                    Toast.makeText(MainActivity.this, "Order " + orderItem.getName() + " was removed", Toast.LENGTH_SHORT).show();
                }
            }
        });
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

//        setOrderDetail(mOrderDetail);
    }

    private void callService() {
        FakeNetwork.getFakeOrderDetail(new FakeNetwork.OnResultCallback() {
            @Override
            public void onOrderDetailCallback(OrderDetail orderDetail) {
                mOrderDetail = orderDetail;
                List<BaseOrderDetailItem> orderDetailItemList = createOrderDetailList(orderDetail);
                List<BaseOrderDetailItem> emptyList = new ArrayList<>();
                updateOrderDetailList(emptyList, orderDetailItemList);
            }
        });
    }

    private List<BaseOrderDetailItem> createOrderDetailList (OrderDetail orderDetail) {
        String name = "Sleeping For Less";
        String yourOrderTitle = getString(R.string.your_order);
        String summaryTitle = getString(R.string.summary);

        String foodTitle = getString(R.string.food);
        String bookTitle = getString(R.string.book);
        String musicTitle = getString(R.string.music);
        String currency = getString(R.string.baht_unit);

        int foodTitleColor = ContextCompat.getColor(this, R.color.sky_light_blue);
        int bookTitleColor = ContextCompat.getColor(this, R.color.funny_dark_pink);
        int musicTitleColor = ContextCompat.getColor(this, R.color.natural_green);

        List<BaseOrderDetailItem> orderDetailItemList = new ArrayList<>();
        orderDetailItemList.add(OrderDetailConverter.createUserDetail(name));
        if (isOrderDetailAvailable(orderDetail)) {
            orderDetailItemList.add(OrderDetailConverter.createTitle(yourOrderTitle));
            orderDetailItemList.addAll(OrderDetailConverter.createSectionAndOrder(orderDetail, foodTitle, bookTitle, musicTitle, currency, foodTitleColor, bookTitleColor, musicTitleColor));
            orderDetailItemList.add(OrderDetailConverter.createTitle(summaryTitle));
            orderDetailItemList.addAll(OrderDetailConverter.createSummary(orderDetail, foodTitle, bookTitle, musicTitle, currency));
            orderDetailItemList.add(OrderDetailConverter.createTotal(orderDetail, currency));
            orderDetailItemList.add(OrderDetailConverter.createNotice());
            orderDetailItemList.add(OrderDetailConverter.createButton());
        } else {
            orderDetailItemList.add(OrderDetailConverter.createTitle(yourOrderTitle));
            orderDetailItemList.add(OrderDetailConverter.createNoOrder());
            orderDetailItemList.add(OrderDetailConverter.createTitle(summaryTitle));
            orderDetailItemList.add(OrderDetailConverter.createTotal(orderDetail, currency));
        }
        orderDetailItemList.add(OrderDetailConverter.createEmpty());
        return orderDetailItemList;
    }

    private void updateOrderDetailList(List<BaseOrderDetailItem> oldOrderItemList, List<BaseOrderDetailItem> newOrderItemList) {
        orderAdapter.setOrderItemList(newOrderItemList);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new OrderListDiffCallback(oldOrderItemList, newOrderItemList));
        diffResult.dispatchUpdatesTo(orderAdapter);
    }

    private boolean isOrderDetailAvailable(OrderDetail orderDetail) {
        return orderDetail != null &&
                ((orderDetail.getFoodList() != null && !orderDetail.getFoodList().isEmpty()) ||
                        (orderDetail.getBookList() != null && !orderDetail.getBookList().isEmpty()) ||
                        (orderDetail.getMusicList() != null && !orderDetail.getMusicList().isEmpty()));
    }

    private boolean removeOrder(OrderDetail orderDetail, OrderItem orderItem) {
        if (orderDetail != null) {
            int index = getFoodOrderIndex(orderDetail.getFoodList(), orderItem);
            if (index != -1) {
                orderDetail.getFoodList().remove(index);
                return true;
            }
            index = getBookOrderIndex(orderDetail.getBookList(), orderItem);
            if (index != -1) {
                orderDetail.getBookList().remove(index);
                return true;
            }
            index = getMusicOrderIndex(orderDetail.getMusicList(), orderItem);
            if (index != -1) {
                orderDetail.getMusicList().remove(index);
                return true;
            }
        }
        return false;
    }

    private int getFoodOrderIndex(List<OrderDetail.Food> foodOrderDetailList, OrderItem orderItem) {
        if (foodOrderDetailList != null && orderItem != null) {
            for (int index = 0; index < foodOrderDetailList.size(); index++) {
                OrderDetail.Food food = foodOrderDetailList.get(index);
                if (food.getOrderName().equals(orderItem.getName())) {
                    return index;
                }
            }
        }
        return -1;
    }

    private int getBookOrderIndex(List<OrderDetail.Book> bookOrderDetailList, OrderItem orderItem) {
        if (bookOrderDetailList != null && orderItem != null) {
            for (int index = 0; index < bookOrderDetailList.size(); index++) {
                OrderDetail.Book book = bookOrderDetailList.get(index);
                if (book.getBookName().equals(orderItem.getName())) {
                    return index;
                }
            }
        }
        return -1;
    }

    private int getMusicOrderIndex(List<OrderDetail.Music> musicOrderDetailList, OrderItem orderItem) {
        if (musicOrderDetailList != null && orderItem != null) {
            for (int index = 0; index < musicOrderDetailList.size(); index++) {
                OrderDetail.Music music = musicOrderDetailList.get(index);
                if (music.getAlbum().equals(orderItem.getName())) {
                    return index;
                }
            }
        }
        return -1;
    }
}
