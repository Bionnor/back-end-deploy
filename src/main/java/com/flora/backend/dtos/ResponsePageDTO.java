package com.flora.backend.dtos;

import lombok.Data;

import java.util.List;
@Data
public class ResponsePageDTO<T> {
    private int currentPage;
    private int totalPages;
    private int pageSize;
    private List<T> responseList;
}
