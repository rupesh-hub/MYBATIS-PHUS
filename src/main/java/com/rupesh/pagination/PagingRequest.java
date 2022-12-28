package com.rupesh.pagination;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class PagingRequest {

    private Long currentPage;
    private Long pageSize;
    private Map<String, Object> searchField;

}
