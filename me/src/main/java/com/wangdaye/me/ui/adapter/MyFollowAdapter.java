package com.wangdaye.me.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.wangdaye.base.unsplash.User;
import com.wangdaye.common.base.adapter.BaseAdapter;
import com.wangdaye.me.R;

import java.util.List;

/**
 * My follow adapter.
 *
 * Adapter for {@link RecyclerView} to show follow information.
 *
 * */

public class MyFollowAdapter extends BaseAdapter<User, MyFollowModel, MyFollowHolder> {

    @Nullable private ItemEventCallback callback;

    public MyFollowAdapter(Context context, List<User> list) {
        super(context, list);
    }

    @NonNull
    @Override
    public MyFollowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyFollowHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_my_follow_user, parent, false)
        );
    }

    @Override
    protected void onBindViewHolder(@NonNull MyFollowHolder holder, MyFollowModel model) {
        holder.onBindView(model, callback);
    }

    @Override
    protected void onBindViewHolder(@NonNull MyFollowHolder holder, MyFollowModel model,
                                    @NonNull List<Object> payloads) {
        onBindViewHolder(holder, model);
    }

    public void onViewRecycled(@NonNull MyFollowHolder holder) {
        holder.onRecycled();
    }

    @Override
    protected MyFollowModel getViewModel(User model) {
        return new MyFollowModel(model);
    }

    public interface ItemEventCallback {
        void onFollowItemClicked(View avatar, View background, User user);
        void onFollowUserOrCancel(User user, int adapterPosition, boolean follow);
    }

    public MyFollowAdapter setItemEventCallback(@Nullable ItemEventCallback c) {
        callback = c;
        return this;
    }
}

