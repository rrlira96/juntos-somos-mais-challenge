package com.rrlira96.juntossomosmaischallenge.controller;

import com.rrlira96.juntossomosmaischallenge.model.UserResponse;
import com.rrlira96.juntossomosmaischallenge.model.vo.UserVo;
import com.rrlira96.juntossomosmaischallenge.service.UserService;
import com.rrlira96.juntossomosmaischallenge.utils.PaginationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static com.rrlira96.juntossomosmaischallenge.utils.Constants.DEFAULT_PAGE_NUMBER;
import static com.rrlira96.juntossomosmaischallenge.utils.Constants.DEFAULT_PAGE_SIZE;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<UserResponse> getUsers(@RequestParam Optional<String> region,
                                                 @RequestParam Optional<String> type,
                                                 @RequestParam(defaultValue = DEFAULT_PAGE_NUMBER) int pageNumber,
                                                 @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize) {

        List<UserVo> userVos = userService.filterEligibleUsers(region, type);
        List<UserVo> paginatedUserVos = PaginationUtil.paginate(userVos, pageSize, pageNumber);
        UserResponse userResponse = new UserResponse(pageNumber, pageSize, userVos.size(), paginatedUserVos);

        return ResponseEntity.ok().body(userResponse);
    }

}
