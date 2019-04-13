package com.ttyc.stream.obj;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class NewCityOrderVO {

    /**
     * 城市id
     */
    private Long cityId;
    /**
     * 城市类型 1直营 2加盟
     */
    private Integer cityType;
    /**
     * 城市名称
     */
    private String cityName;
    /**
     * 城市申请编码
     */
    private String applySn;
    /**
     * 订单类型 1：城市采购 2:城市三包 3:城市借货 4:城市还货 5:报废 6:调拨
     */
    private Integer orderType;
    /**
     * 采购类型 1配件 2整车
     */
    private Integer buyType;
    /**
     * 调入城市id（仅城市调拨）
     */
    private Long allocationCityId;
    /**
     * 采购主体
     */
    private String franchiseeName;
    /**
     * 采购人
     */
    private Long createUser;
    /**
     * 采购人名称
     */
    private String createUserName;
    
}