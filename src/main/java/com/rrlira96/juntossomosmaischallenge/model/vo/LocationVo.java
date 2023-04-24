package com.rrlira96.juntossomosmaischallenge.model.vo;

import com.rrlira96.juntossomosmaischallenge.model.Coordinates;
import com.rrlira96.juntossomosmaischallenge.model.Timezone;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LocationVo {
    private String region;
    private String street;
    private String city;
    private String state;
    private int postcode;
    private Coordinates coordinates;
    private Timezone timezone;
}
