package com.rrlira96.juntossomosmaischallenge.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Location {
    private String street;
    private String city;
    private String state;
    private int postcode;
    private Coordinates coordinates;
    private Timezone timezone;
}
