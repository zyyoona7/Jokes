package com.zyyoona7.jokes.model.bean;

/**
 * Created by zyyoona7 on 2016/6/29.
 * 获取随机笑话时趣图笑话bean
 */

public class RandomImageJoke {
    private String content;

    private String hashId;

    private long unixtime;

    private String url;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public long getUnixtime() {
        return unixtime;
    }

    public void setUnixtime(long unixtime) {
        this.unixtime = unixtime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
