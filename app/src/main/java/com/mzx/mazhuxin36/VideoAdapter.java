package com.mzx.mazhuxin36;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class VideoAdapter extends BaseAdapter {
    private  String TAG = "VideoAdapter";
    private List<VideoInfo> mDataList = new ArrayList<>();
    private Context mContext;
    private LayoutInflater mInflater;

    public VideoAdapter(List<VideoInfo> list, Context context) {
        this.mDataList = list;
        this.mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }


    @Override
    public int getCount() {
        int count = (null == mDataList ? 0 : mDataList.size());
        Log.i(TAG, "---getCount() " + count);
        return count;
    }

    @Override
    public VideoInfo getItem(int position) {
        Log.i(TAG, "---getItem() " + position);
        return mDataList. get(position);
    }

    @Override
    public long getItemId(int position) {
        Log.i(TAG, "---getItemId() " + position);
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        Log.i(TAG, "---getView() " + position + "convertView: "+convertView);
        final ViewHolder holder;
        if(null == convertView) {
            convertView = mInflater.inflate(R.layout.item_news, null);
            holder = new ViewHolder();
            holder.iconIV = convertView.findViewById(R.id.iv_icon);
            holder.tltTV = convertView.findViewById(R.id.tv_title);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        VideoInfo item = mDataList.get(position);
        holder.tltTV.setText(item.getTitle());
        ImageLoader.getInstance().load(holder.iconIV, item.getThumbPath());

        return convertView;
    }

    public void setData(List<VideoInfo> list) {
        mDataList.clear();
        if (null != list) {
            mDataList.addAll(list);
        }
    }


    private class  ViewHolder {
        ImageView iconIV;
        TextView tltTV;
    }


}
