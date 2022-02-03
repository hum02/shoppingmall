package com.shoppingmall.domain.item;

import com.shoppingmall.constant.ItemSellStatus;
import com.shoppingmall.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@Entity
@Table(name="item")
public class Item extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="item_id")
    private Long id;  //상품번호

    @Column(nullable = false,length = 50)
    private String itemNm;

    private int price;
    private int stockNumber;

    @Lob
    private String itemDetail;

    @Enumerated
    private ItemSellStatus itemSellStatus;

    @Builder
    public Item(Long id, String itemNm, int price, int stockNumber, String itemDetail, ItemSellStatus itemSellStatus) {
        this.id = id;
        this.itemNm = itemNm;
        this.price = price;
        this.stockNumber = stockNumber;
        this.itemDetail = itemDetail;
        this.itemSellStatus = itemSellStatus;
    }
}
