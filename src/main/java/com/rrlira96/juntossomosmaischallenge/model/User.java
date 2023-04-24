package com.rrlira96.juntossomosmaischallenge.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private String gender;
    private Name name;
    private Location location;
    private String email;
    private Dob dob;
    private Registered registered;
    private String phone;
    private String cell;
    private Picture picture;
}
