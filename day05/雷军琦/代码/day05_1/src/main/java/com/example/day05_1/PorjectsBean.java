package com.example.day05_1;

public class PorjectsBean {
    private String name;
    private Integer imgtou;

    public PorjectsBean(String name, Integer imgtou) {
        this.name = name;
        this.imgtou = imgtou;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getImgtou() {
        return imgtou;
    }

    public void setImgtou(Integer imgtou) {
        this.imgtou = imgtou;
    }
}
