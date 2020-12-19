package com.example.demo_zuoye3.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Smart {
    @Id(autoincrement = true)
    private Long mid;
    private String img;
    private String title;
    private String name;
    @Generated(hash = 1748436246)
    public Smart(Long mid, String img, String title, String name) {
        this.mid = mid;
        this.img = img;
        this.title = title;
        this.name = name;
    }
    @Generated(hash = 452030878)
    public Smart() {
    }
    public Long getMid() {
        return this.mid;
    }
    public void setMid(Long mid) {
        this.mid = mid;
    }
    public String getImg() {
        return this.img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
