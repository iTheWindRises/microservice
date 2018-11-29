package com.zwj.thrift.user.dto;

/**
 * @program microservice
 * @description:
 * @author: wj
 * @create: 2018/11/20 15:27
 */
public class TeacherDTO extends UserDTO{
    private String info;
    private Integer stars;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }
}
