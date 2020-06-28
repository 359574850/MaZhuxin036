package com.mzx.mazhuxin36;

public class VideoInfo {
    private String title;
    private String filePath;
    private String thumbPath;
    private String id;
    private String profile;

   public String getTitle() {

       return title;
   }
   public String setTitle(String title) {
       this.title = title;
       return title;
   }
   public String getFilePath() {
       return filePath;
   }
    public void setFilePath(String filePath) {
       this.filePath = filePath;
   }
    public String getThumbPath() {
       return thumbPath;
   }
    public void setThumbPath(String thumbPath) {
       this.thumbPath = thumbPath;
   }
   public String getId() {
       return id;
   }
   public void setId(String id) {
       this.id = id;
   }
   public void setProfile(String profile) {
       this.profile = profile;
   }

}
