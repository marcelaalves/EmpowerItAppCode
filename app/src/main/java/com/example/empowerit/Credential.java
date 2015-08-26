package com.example.empowerit;

/**
 * Created by Marcela on 23/08/15.
 */
public class Credential {

    private String cliente_id;

    private String access_token;




    public Credential(String id, String token) {

        this.cliente_id = id;

        this.access_token = token;
    }

    public String getToken() {
        return access_token;
    }

    public void setToken(String token) {
        this.access_token = token;
    }

    public String getId() {
        return cliente_id;
    }

    public void setId(String id) {
        this.cliente_id = id;
    }

}
