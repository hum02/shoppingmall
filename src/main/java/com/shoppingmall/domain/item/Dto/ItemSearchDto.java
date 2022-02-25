package com.shoppingmall.domain.item.Dto;

import com.shoppingmall.constant.ItemSellStatus;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ItemSearchDto {
    private String searchDateType;
    private ItemSellStatus searchSellStatus;
    private String searchBy;
    private String searchQuery = "";

    @Builder
    public ItemSearchDto(String searchDateType, ItemSellStatus searchSellStatus, String searchBy, String searchQuery) {
        this.searchDateType = searchDateType;
        this.searchSellStatus = searchSellStatus;
        this.searchBy = searchBy;
        this.searchQuery = searchQuery;
    }
}
