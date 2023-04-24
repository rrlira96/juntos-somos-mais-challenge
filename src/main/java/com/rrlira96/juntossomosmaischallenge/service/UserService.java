package com.rrlira96.juntossomosmaischallenge.service;


import com.rrlira96.juntossomosmaischallenge.model.Coordinates;
import com.rrlira96.juntossomosmaischallenge.model.Location;
import com.rrlira96.juntossomosmaischallenge.model.User;
import com.rrlira96.juntossomosmaischallenge.model.vo.LocationVo;
import com.rrlira96.juntossomosmaischallenge.model.vo.UserVo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.rrlira96.juntossomosmaischallenge.utils.Constants.*;

@Service
public class UserService {

    private static String NATIONALITY = "BR";

    public static List<UserVo> userVos = new ArrayList<>();


    public static void mapUserToUserVo(List<User> users) {
        userVos = users.stream()
                .map(user -> new UserVo(
                        calculateType(user.getLocation()),
                        normalizeGender(user.getGender()),
                        user.getName(),
                        mapLocationToLocationVo(user.getLocation()),
                        user.getEmail(),
                        user.getDob().getDate(),
                        user.getRegistered().getDate(),
                        Collections.singletonList(parsePhoneNumber(user.getPhone())),
                        Collections.singletonList(parsePhoneNumber(user.getCell())),
                        user.getPicture(),
                        NATIONALITY))
                .collect(Collectors.toList());

    }

    public static String parsePhoneNumber(String phone) {
        return COUNTRY_CODE.get("BR") + phone.replaceAll("\\D", "");
    }

    public static String normalizeGender(String gender) {
        return gender.equals("male") ? "m" : "f";
    }

    private static LocationVo mapLocationToLocationVo(Location location) {
        return new LocationVo(
                setRegion(location.getState()),
                location.getStreet(),
                location.getCity(),
                location.getState(),
                location.getPostcode(),
                location.getCoordinates(),
                location.getTimezone());
    }

    private static String setRegion(String state) {
        return STATE_REGION_BR.get(state);
    }

    public static String calculateType(Location location) {
        Coordinates coordinates = location.getCoordinates();
        double lat = Double.parseDouble(coordinates.getLatitude());
        double lon = Double.parseDouble(coordinates.getLongitude());
        String type;

        if ((lat >= SPECIAL_MIN_LAT && lat <= SPECIAL_MAX_LAT) && (lon >= SPECIAL_MAX_LON && lon <= SPECIAL_MIN_LON) ||
                ((lat >= SPECIAL_2_MIN_LAT && lat <= SPECIAL_2_MAX_LAT) && (lon >= SPECIAL_2_MAX_LON && lon <= SPECIAL_2_MIN_LON))) {
            type = "special";
        } else if ((lat >= NORMAL_MIN_LAT && lat <= NORMAL_MAX_LAT) && (lon >= NORMAL_MAX_LON && lon <= NORMAL_MIN_LON)) {
            type = "normal";
        } else {
            type = "laborious";
        }
        return type;
    }


    public List<UserVo> filterEligibleUsers(Optional<String> region, Optional<String> type) {
        if (region.isPresent() && type.isPresent()) {
            return userVos.stream()
                    .filter(u -> u.getLocation().getRegion().equals(region.get()))
                    .filter(u -> u.getType().equals(type.get()))
                    .collect(Collectors.toList());
        } else if (region.isPresent()) {
            return userVos.stream()
                    .filter(u -> u.getLocation().getRegion().equals(region.get()))
                    .collect(Collectors.toList());
        } else if (type.isPresent()) {
            return userVos.stream()
                    .filter(u -> u.getType().equals(type.get()))
                    .collect(Collectors.toList());
        } else {
            return userVos;
        }
    }
}
