package com.rrlira96.juntossomosmaischallenge.utils;

import java.util.List;

public class PaginationUtil {

    public static <T> List<T> paginate(List<T> list, int pageSize, int pageNumber) {
        pageSize = Math.min(pageSize, list.size());
        int startIndex = (pageNumber - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, list.size());
        return list.subList(startIndex, endIndex);
    }
}