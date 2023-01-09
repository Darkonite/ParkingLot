package com.parking.parkinglot.common;

public class UserDto {
    String email;
    String username;
    Long id;
    String password;

    public UserDto(Long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
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

    public String getPassword() {
        return password;
    }
}
