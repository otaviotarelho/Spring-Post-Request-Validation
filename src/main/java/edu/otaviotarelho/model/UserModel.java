package edu.otaviotarelho.model;

import lombok.*;

@Data
@Getter
@Setter
public class UserModel {

    private String userName;
    private String email;
    private Contact contact;

}
