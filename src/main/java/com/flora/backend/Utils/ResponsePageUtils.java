package com.flora.backend.Utils;

import com.flora.backend.dtos.ResponsePageDTO;

import java.util.List;

public class ResponsePageUtils {
    public static <T> ResponsePageDTO<T> createResponsePage(List<T> responseList, int totalPages, int currentPage, int pageSize) {
        ResponsePageDTO<T> responsePageDTO = new ResponsePageDTO<>();
        responsePageDTO.setResponseList(responseList);
        responsePageDTO.setTotalPages(totalPages);
        responsePageDTO.setCurrentPage(currentPage);
        responsePageDTO.setPageSize(pageSize);
        return responsePageDTO;
    }
}
