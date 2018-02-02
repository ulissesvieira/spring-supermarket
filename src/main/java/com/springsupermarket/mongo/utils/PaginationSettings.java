package com.springsupermarket.mongo.utils;

public class PaginationSettings {
    private Integer currentPage;
    private Integer itemsPerPage;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getItemsPerPage() {
        return itemsPerPage;
    }

    public void setItemsPerPage(Integer itensPerPage) {
        this.itemsPerPage = itensPerPage;
    }
}