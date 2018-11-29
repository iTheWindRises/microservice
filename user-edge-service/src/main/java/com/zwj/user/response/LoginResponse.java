package com.zwj.user.response;

/**
 * @program microservice
 * @description:
 * @author: wj
 * @create: 2018/11/14 18:42
 */
public class LoginResponse extends Response {
    private String token;

    public LoginResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
