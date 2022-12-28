package com.rupesh.util.global;

import com.rupesh.pagination.Pagination;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class GlobalUtil<T> {

    public static <T> GlobalResponse<T> globalResponse(final String message,
                                                       final HttpStatus httpStatus,
                                                       final T data,
                                                       final Pagination pagination) {
        return GlobalResponse
                .<T>builder()
                .message(message)
                .status(httpStatus)
                .statusCode(httpStatus.value())
                .timeStamp(LocalDateTime.now())
                .data(data)
                .pagination(pagination)
                .build();
    }

    public static Long getCurrentPage(final Long page){
        return page == null ? 1 : page; // DEFAULT : 1
    }

    public static Long getPageSize(final Long pageSize){
        return pageSize == null ? 10 : pageSize; // DEFAULT : 10
    }

}