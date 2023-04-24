package com.rrlira96.juntossomosmaischallenge.model.vo;

import com.rrlira96.juntossomosmaischallenge.model.Name;
import com.rrlira96.juntossomosmaischallenge.model.Picture;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UserVo {
    private String type;
    private String gender;
    private Name name;
    private LocationVo location;
    private String email;
    private String birthday;
    private String registered;
    private List<String> telephoneNumbers;
    private List<String> mobileNumbers;
    private Picture picture;
    private String nationality;

}
