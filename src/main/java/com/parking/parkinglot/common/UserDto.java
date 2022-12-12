package com.parking.parkinglot.common;

public class UserDto {
    String email;
    String username;
    Long id;

    public UserDto(String email, String username, Long id) {
        this.email = email;
        this.username = username;
        this.id = id;
    }

    public UserDto(String email, String username) {
        this.email = email;
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public Long getId() { return id; }
}
