package com.mzx.mazhuxin36;


import java.util.List;

public class VideoListResponse {
    private String result;
    private List<VideoInfo> list;
    public void setResult(String result) { this.result = result; }
    public String getResult() { return result; }

    public void setList(List<VideoInfo> list) { this.list = list; }
    public List<VideoInfo> getList() {
        return list;
    }

}
