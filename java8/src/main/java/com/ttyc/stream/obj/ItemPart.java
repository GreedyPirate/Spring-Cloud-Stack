package com.ttyc.stream.obj;

import lombok.Builder;

@Builder
public class ItemPart {

        private String itemSn;

        private String goodsName;

        private String goodsCode;

        private Integer goodsCount;

        private String goodsRemark;

        private String unitDesc;

        private String unitPrice;

        private Integer goodsType;

        private String totalPrice;

}