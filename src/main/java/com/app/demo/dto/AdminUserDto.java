package com.app.demo.dto;

import com.app.demo.model.Status;
import com.app.demo.model.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminUserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String status;

    public User toUser() {
        User user = new User();

        user.setId(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(username);
        user.setStatus(Status.valueOf(status));

        return user;
    }

    public static AdminUserDto fromUser(User user) {
        AdminUserDto adminUserDto = new AdminUserDto();
        adminUserDto.setId(user.getId());
        adminUserDto.setFirstName(user.getFirstName());
        adminUserDto.setLastName(user.getLastName());
        adminUserDto.setUsername(user.getUsername());
        adminUserDto.setStatus(user.getStatus().name());
        return adminUserDto;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }



    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public void setStatus(String status) {
        this.status = status;
    }
}
