package com.rrlira96.juntossomosmaischallenge.service;

import com.rrlira96.juntossomosmaischallenge.model.Coordinates;
import com.rrlira96.juntossomosmaischallenge.model.Location;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserServiceTest {

    @Test
    void testParsingPhoneNumber() {
        assertEquals("+558683709831", UserService.parsePhoneNumber("(86) 8370-9831"));
    }

    @Test
    void testNormalizeGender() {
        assertEquals("f", UserService.normalizeGender("female"));
        assertEquals("m", UserService.normalizeGender("male"));
    }

    @Test
    void testTypeCalculation() {
        Location specialLocation = Location
                .builder().coordinates(Coordinates.builder()
                        .latitude("-40.000000")
                        .longitude("-7.000000")
                        .build())
                .build();

        Location normalLocation = Location
                .builder().coordinates(Coordinates.builder()
                        .latitude("-50.000000")
                        .longitude("-30.000000")
                        .build())
                .build();

        Location laboriousLocation = Location
                .builder()
                .coordinates(Coordinates
                        .builder()
                        .latitude("-76.000000")
                        .longitude("137.000000")
                        .build())
                .build();

        assertEquals("special", UserService.calculateType(specialLocation));
        assertEquals("normal", UserService.calculateType(normalLocation));
        assertEquals("laborious", UserService.calculateType(laboriousLocation));
    }
}