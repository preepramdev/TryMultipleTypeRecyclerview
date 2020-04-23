package com.maxnimal.tryrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.maxnimal.tryrecyclerview.item.BaseOrderDetailItem;
import com.maxnimal.tryrecyclerview.item.ButtonItem;
import com.maxnimal.tryrecyclerview.item.EmptyItem;
import com.maxnimal.tryrecyclerview.item.NoticeItem;
import com.maxnimal.tryrecyclerview.item.OrderItem;
import com.maxnimal.tryrecyclerview.item.SectionItem;
import com.maxnimal.tryrecyclerview.item.SummaryItem;
import com.maxnimal.tryrecyclerview.item.TitleItem;
import com.maxnimal.tryrecyclerview.item.TotalItem;
import com.maxnimal.tryrecyclerview.item.UserDetailItem;
import com.maxnimal.tryrecyclerview.viewholder.ButtonViewHolder;
import com.maxnimal.tryrecyclerview.viewholder.EmptyViewHolder;
import com.maxnimal.tryrecyclerview.viewholder.NoticeViewHolder;
import com.maxnimal.tryrecyclerview.viewholder.OrderViewHolder;
import com.maxnimal.tryrecyclerview.viewholder.SectionViewHolder;
import com.maxnimal.tryrecyclerview.viewholder.SummaryViewHolder;
import com.maxnimal.tryrecyclerview.viewholder.TitleViewHolder;
import com.maxnimal.tryrecyclerview.viewholder.TotalViewHolder;
import com.maxnimal.tryrecyclerview.viewholder.UserDetailViewHolder;

import java.util.ArrayList;
import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<BaseOrderDetailItem> orderDetailItemList;

    public OrderAdapter() {
        orderDetailItemList = new ArrayList<>();
    }

    public void setOrderItemList(List<BaseOrderDetailItem> orderDetailItemList) {
        this.orderDetailItemList = orderDetailItemList;
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onPositiveButtonClick();

        void onNegativeButtonClick();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == OrderDetailType.TYPE_USER_DETAIL) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_user_detail, parent, false);
            return new UserDetailViewHolder(view);

        } else if (viewType == OrderDetailType.TYPE_TITLE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_title, parent, false);
            return new TitleViewHolder(view);

        } else if (viewType == OrderDetailType.TYPE_SECTION) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_section, parent, false);
            return new SectionViewHolder(view);

        } else if (viewType == OrderDetailType.TYPE_ORDER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_order, parent, false);
            return new OrderViewHolder(view);

        } else if (viewType == OrderDetailType.TYPE_SUMMARY) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_summary, parent, false);
            return new SummaryViewHolder(view);

        } else if (viewType == OrderDetailType.TYPE_TOTAL) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_total, parent, false);
            return new TotalViewHolder(view);

        } else if (viewType == OrderDetailType.TYPE_NOTICE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_notice, parent, false);
            return new NoticeViewHolder(view);

        } else if (viewType == OrderDetailType.TYPE_BUTTON) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_button, parent, false);
            return new ButtonViewHolder(view);

        } else if (viewType == OrderDetailType.TYPE_EMPTY) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_empty, parent, false);
            return new EmptyViewHolder(view);

        }
        throw new NullPointerException("View Type " + viewType + " doesn't match with any existing order detail type");

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        BaseOrderDetailItem orderDetailItem = orderDetailItemList.get(position);

        if (holder instanceof UserDetailViewHolder) {
            UserDetailViewHolder userDetailViewHolder = (UserDetailViewHolder) holder;
            UserDetailItem userDetailItem = (UserDetailItem) orderDetailItem;
            setupUserDetail(userDetailViewHolder, userDetailItem);

        } else if (holder instanceof TitleViewHolder) {
            TitleViewHolder titleViewHolder = (TitleViewHolder) holder;
            TitleItem titleItem = (TitleItem) orderDetailItem;
            setupTitle(titleViewHolder, titleItem);

        } else if (holder instanceof SectionViewHolder) {
            SectionViewHolder sectionViewHolder = (SectionViewHolder) holder;
            SectionItem sectionItem = (SectionItem) orderDetailItem;
            setupSection(sectionViewHolder, sectionItem);

        } else if (holder instanceof OrderViewHolder) {
            OrderViewHolder orderViewHolder = (OrderViewHolder) holder;
            OrderItem orderItem = (OrderItem) orderDetailItem;
            setupOrder(orderViewHolder, orderItem);

        } else if (holder instanceof SummaryViewHolder) {
            SummaryViewHolder summaryViewHolder = (SummaryViewHolder) holder;
            SummaryItem summaryItem = (SummaryItem) orderDetailItem;
            setupSummary(summaryViewHolder, summaryItem);

        } else if (holder instanceof TotalViewHolder) {
            TotalViewHolder totalViewHolder = (TotalViewHolder) holder;
            TotalItem totalItem = (TotalItem) orderDetailItem;
            setupTotal(totalViewHolder, totalItem);

        } else if (holder instanceof NoticeViewHolder) {
            NoticeViewHolder noticeViewHolder = (NoticeViewHolder) holder;
            NoticeItem noticeItem = (NoticeItem) orderDetailItem;
            setupNotice(noticeViewHolder, noticeItem);

        } else if (holder instanceof ButtonViewHolder) {
            ButtonViewHolder buttonViewHolder = (ButtonViewHolder) holder;
            ButtonItem buttonItem = (ButtonItem) orderDetailItem;
            setupButton(buttonViewHolder, buttonItem);

        } else if (holder instanceof EmptyViewHolder) {
            EmptyViewHolder emptyViewHolder = (EmptyViewHolder) holder;
            EmptyItem emptyItem = (EmptyItem) orderDetailItem;
            setupEmpty(emptyViewHolder, emptyItem);

        }
    }

    private void setupUserDetail(UserDetailViewHolder userDetailViewHolder, UserDetailItem userDetailItem) {
        userDetailViewHolder.tvUserName.setText(userDetailItem.getName());
    }

    private void setupTitle(TitleViewHolder titleViewHolder, TitleItem titleItem) {
        titleViewHolder.tvTitle.setText(titleItem.getTitle());
    }

    private void setupSection(SectionViewHolder sectionViewHolder, SectionItem sectionItem) {
        sectionViewHolder.tvSection.setText(sectionItem.getSection());
        sectionViewHolder.layoutSectionContainer.setBackgroundColor(sectionItem.getBackgroundColor());
    }

    private void setupOrder(OrderViewHolder orderViewHolder, OrderItem orderItem) {
        orderViewHolder.tvOrderName.setText(orderItem.getName());
        orderViewHolder.tvOrderDetail.setText(orderItem.getDetail());
        orderViewHolder.tvOrderPrice.setText(orderItem.getPrice());
    }

    private void setupSummary(SummaryViewHolder summaryViewHolder, SummaryItem summaryItem) {
        summaryViewHolder.tvSummaryName.setText(summaryItem.getName());
        summaryViewHolder.tvSummaryPrice.setText(summaryItem.getPrice());
    }

    private void setupTotal(TotalViewHolder totalViewHolder, TotalItem totalItem) {
        totalViewHolder.tvTotalPrice.setText(totalItem.getTotalPrice());
    }

    private void setupNotice(NoticeViewHolder noticeViewHolder, NoticeItem noticeItem) {
        // Nothing to do ...
    }

    private void setupButton(ButtonViewHolder buttonViewHolder, ButtonItem buttonItem) {
        buttonViewHolder.btnPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null) {
                    onItemClickListener.onPositiveButtonClick();
                }
            }
        });
        buttonViewHolder.btnNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null) {
                    onItemClickListener.onNegativeButtonClick();
                }
            }
        });
    }

    private void setupEmpty(EmptyViewHolder emptyViewHolder, EmptyItem emptyItem) {
        // Nothing to do ...
    }

    @Override
    public int getItemViewType(int position) {
        return orderDetailItemList.get(position).getType();
    }

    @Override
    public int getItemCount() {
        return orderDetailItemList.size();
    }
}
