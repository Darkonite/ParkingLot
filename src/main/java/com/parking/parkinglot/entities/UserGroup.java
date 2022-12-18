package com.parking.parkinglot.entities;

import jakarta.annotation.security.DeclareRoles;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;

@DeclareRoles({"WRITE_USERS"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"WRITE_USERS"}))

public class UserGroup {

    private Long id;
    private String username;
    private String userGroup;

    @Id
    @GeneratedValue
    public Long getId(){return id;}

    public void setId(Long id){this.id=id;}
    public String getUsername(){return username;}
    public void setUsername(String username){this.username=username;}
    public String getUserGroup(){return userGroup;}
    public void setUserGroup(String userGroup){this.userGroup=userGroup;}

}
