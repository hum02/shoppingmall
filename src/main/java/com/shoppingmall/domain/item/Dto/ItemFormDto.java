package com.shoppingmall.domain.item.Dto;

import com.shoppingmall.constant.ItemSellStatus;
import com.shoppingmall.domain.item.Item;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class ItemFormDto {

    private Long id;

    @NotBlank(message = "상품명은 필수 입력 값입니다.")
    private String itemNm;

    @NotNull(message = "가격은 필수 입력 값입니다.")
    private Integer price;

    @NotBlank(message = "상품 상세는 필수 입력 값입니다.")
    @Lob
    private String itemDetail;

    @NotNull(message = "재고는 필수 입력 값입니다.")
    private Integer stockNumber;

    private ItemSellStatus itemSellStatus;

    // 상품 수정 시 사용되는 멤버변수들
    private List<ItemImgDto> itemImgDtoList = new ArrayList<>();
    private List<Long> itemImgIds = new ArrayList<>();

    private static ModelMapper modelMapper = new ModelMapper();

    // DTO -> Entity
    public Item createItem(){
        Item item=Item.builder()
                .itemNm(this.itemNm).itemDetail(this.itemDetail)
                .itemSellStatus(this.itemSellStatus).price(this.price)
                .stockNumber(this.stockNumber).build();
        return item;
    }

    // Entity -> DTO
    public static ItemFormDto of(Item item){
        ItemFormDto itemFormDto=ItemFormDto.builder().itemDetail(item.getItemDetail())
                .itemNm(item.getItemNm()).price(item.getPrice()).itemSellStatus(item.getItemSellStatus())
                .stockNumber(item.getStockNumber()).build();
        return itemFormDto;
    }

    @Builder
    public ItemFormDto(Long id, String itemNm, Integer price, String itemDetail, Integer stockNumber, ItemSellStatus itemSellStatus, List<ItemImgDto> itemImgDtoList, List<Long> itemImgIds) {
        this.id = id;
        this.itemNm = itemNm;
        this.price = price;
        this.itemDetail = itemDetail;
        this.stockNumber = stockNumber;
        this.itemSellStatus = itemSellStatus;
        this.itemImgDtoList = itemImgDtoList;
        this.itemImgIds = itemImgIds;
    }
}