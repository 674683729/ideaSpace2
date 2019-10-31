package com.fh.shop.api.brand.param;

import com.fh.shop.api.common.Page;
import lombok.Data;

import java.io.Serializable;

@Data
public class BrandSearchParam extends Page implements Serializable {
    private String brandName;

    private Integer isSellWell;

}
