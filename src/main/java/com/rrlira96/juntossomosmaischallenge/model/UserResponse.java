package com.rrlira96.juntossomosmaischallenge.model;

import com.rrlira96.juntossomosmaischallenge.model.vo.UserVo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UserResponse {
    private int pageNumber;
    private int pageSize;
    private int totalCount;
    private List<UserVo> users;
}
