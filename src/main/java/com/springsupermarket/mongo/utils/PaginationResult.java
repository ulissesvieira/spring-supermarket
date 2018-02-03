package com.springsupermarket.mongo.utils;

import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class PaginationResult <T> {
    private Long totalItems;
    private Integer currentPage;
    private Integer pageSize;
    private Integer totalPages;
    private Integer startPage;
    private Integer endPage;
    private Integer[] pages;
    List<T> items;

    public PaginationResult(Page<T> page) {
        items = page.getContent();
        totalPages = page.getTotalPages();
        totalItems = page.getTotalElements();
        currentPage = page.getNumber() + 1;
        pageSize = page.getSize();

        if (totalPages <= 10) {
            // less than 10 total pages so show all
            startPage = 1;
            endPage = totalPages;
        } else {
            // more than 10 total pages so calculate start and end pages
            if (currentPage <= 6) {
                startPage = 1;
                endPage = 10;
            } else if (currentPage + 4 >= totalPages) {
                startPage = totalPages - 9;
                endPage = totalPages;
            } else {
                startPage = currentPage - 5;
                endPage = currentPage + 4;
            }
        }

        ArrayList<Integer> pages = new ArrayList<>();
        for (int i = startPage; i < endPage + 1; i++)
            pages.add(i);
        this.pages = pages.toArray(new Integer[pages.size()]);
    }

    public Long getTotalItems() {
        return totalItems;
    }
    public Integer getCurrentPage() {
        return currentPage;
    }
    public Integer getPageSize() {
        return pageSize;
    }
    public Integer getTotalPages() {
        return totalPages;
    }
    public Integer getStartPage() {
        return startPage;
    }
    public Integer getEndPage() {
        return endPage;
    }
    public Integer[] getPages() {
        return pages;
    }
    public List<T> getItems() {
        return items;
    }
}
