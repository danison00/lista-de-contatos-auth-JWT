package com.dan.jwt.domain;


public enum Roles {

    ADMIN("admin"), USER("user");

    private String role;

    
    private Roles(String role) {
        this.role = role;
    }


    public String getRole() {
        return role;
    }

    

}
