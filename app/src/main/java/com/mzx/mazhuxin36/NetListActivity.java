
package com.mzx.mazhuxin36;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;


import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class NetListActivity extends AppCompatActivity {
    private static final String TAG = "NetListActivity";
    private VideoAdapter mAdapter;
    private Handler mHandler = new Handler();
    private List<VideoInfo> mDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_list);
        ListView mListView = findViewById(R.id.lv);
        mDataList = new ArrayList<>();
        mAdapter = new VideoAdapter(mDataList,this);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                VideoInfo videoInfo = mDataList.get(position);
                Intent intent = new Intent(NetListActivity.this, WebActivity.class);
                intent.putExtra(WebActivity.WEB_URL, videoInfo.getFilePath());
                startActivity(intent);
            }
        });
        initData();
    }

    private void initData() {
        String raUrl = "http://ramedia.sinaapp.com/videoList.json";
        HttpProxy.getInstance().load(raUrl, new HttpProxy.NetInputCallback() {
            @Override
            public void onSuccess(InputStream inputStream) {
                String respJson = null;
                try {
                    respJson = NetInputUtils.readString(inputStream);
                    Log.i(TAG, "---response json:\n " + respJson);
                    VideoListResponse videoListResponse = convertJsonToBean(respJson);
                    final List<VideoInfo> list = videoListResponse.getList();
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            mAdapter.setData(list);
                            mAdapter.notifyDataSetChanged();
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private VideoListResponse convertJsonToBean(String json) {
        Gson gson = new Gson();
        VideoListResponse response = gson.fromJson(json, VideoListResponse.class);
        return response;
    }
}