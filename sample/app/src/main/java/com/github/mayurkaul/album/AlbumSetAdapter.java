package com.github.mayurkaul.album;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mayurkaul.R;

import deviceinfo.mayur.medialibrary.data.MediaDataContext;
import deviceinfo.mayur.medialibrary.data.MediaSet;

/**
 * Created by mayurkaul on 06/11/17.
 */

class AlbumSetAdapter extends RecyclerView.Adapter<AlbumViewHolder> {

    private final MediaSet mSet;
    private final MediaDataContext mContext;
    private final OnAlbumItemClickListener mListener;

    AlbumSetAdapter(MediaSet set, OnAlbumItemClickListener listener, MediaDataContext context)
    {
        mSet = set;
        mContext = context;
        mListener = listener;
    }

    @Override
    public AlbumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.albumitem,parent,false);
        return new AlbumViewHolder(itemView,mContext);
    }

    @Override
    public void onBindViewHolder(AlbumViewHolder holder, int position) {
        holder.bind(mSet.getSubMediaSet(position));
        holder.addClickListener(mListener);
    }

    @Override
    public int getItemCount() {
        return mSet.getSubMediaSetCount();
    }

    public interface OnAlbumItemClickListener{
        void onAlbumItemClicked(MediaSet item);
    }
}
