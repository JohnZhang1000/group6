package com.example.wanzhijingapplication;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class SqBean {
    @Id(autoincrement = true)
    private Long id;
    private String url;
    private String text;
    @Generated(hash = 1761600025)
    public SqBean(Long id, String url, String text) {
        this.id = id;
        this.url = url;
        this.text = text;
    }
    @Generated(hash = 761430409)
    public SqBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getText() {
        return this.text;
    }
    public void setText(String text) {
        this.text = text;
    }
   
}
