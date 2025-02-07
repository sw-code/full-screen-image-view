package com.github.full_screen_image_view_demo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import io.swcode.fullscreenimageview.FullScreenImageViewActivity;
import io.swcode.fullscreenimageview.FullScreenParameter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ImagePickerAdapter extends RecyclerView.Adapter<ImagePickerAdapter.ViewHolder> {

    private List<Uri> mItems;
    private Context context;
    private RecyclerView recyclerView;

    public ImagePickerAdapter(RecyclerView recyclerView, Context context, List<Uri> items) {
        this.context = context;
        mItems = items;
        this.recyclerView = recyclerView;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_image_picker_item, parent, false));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.item = mItems.get(position);

        Picasso.get()
                .load(holder.item)
                .into((ImageView) holder.itemView);

        holder.ivItem.setOnClickListener(view -> {
            Intent fullImageIntent = new Intent(context, FullScreenImageViewActivity.class);
            ArrayList<String> uriString = new ArrayList<>();
            for (Uri uri : mItems) {
                uriString.add(uri.toString());
            }
            fullImageIntent.putExtra(FullScreenParameter.URI_LIST_DATA, uriString);
            fullImageIntent.putExtra(FullScreenParameter.IMAGE_FULL_SCREEN_CURRENT_POS, position);
            context.startActivity(fullImageIntent);
        });
        holder.ivCancel.setOnClickListener(view -> removeItem(holder.item));
    }

    public void updateListItem(List<Uri> data) {
        mItems.clear();
        mItems.addAll(data);
        notifyDataSetChanged();
    }

    public void addItem(Uri uri) {
        mItems.add(uri);
        notifyItemInserted(mItems.size());
        recyclerView.scrollToPosition(mItems.size());
    }

    public void removeItem(Uri item) {
        int index = mItems.indexOf(item);
        mItems.remove(item);
        notifyItemRemoved(index);
    }

    public List<Uri> getAllImages() {
        return mItems;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivItem;
        ImageView ivCancel;
        public Uri item;

        public ViewHolder(View itemView) {
            super(itemView);
            ivItem = itemView.findViewById(R.id.iv_item);
            ivCancel = itemView.findViewById(R.id.iv_cancel);
        }
    }


}
                                