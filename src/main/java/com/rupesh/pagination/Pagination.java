package com.rupesh.pagination;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Pagination {

    private final Long totalRecords;
    private final Long pageSize;
    private final Long currentPage;
    private final Long totalPages;

    public Pagination(Long totalRecords, Long pageSize, Long currentPage, Long totalPages) {
        this.totalRecords = totalRecords;
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.totalPages = totalPages;
    }

}
