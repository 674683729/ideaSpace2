package com.fh.shop.api.brand.biz;

import com.fh.shop.api.brand.param.BrandSearchParam;
import com.fh.shop.api.brand.po.Brand;
import com.fh.shop.api.common.ServerResponse;

public interface IBrandService {
    ServerResponse findSellWellBrand();

    void add(Brand brand);

    ServerResponse findBrandAll();

    ServerResponse delete(Long id);

    ServerResponse find(Long id);

    ServerResponse update(Brand brand);

    ServerResponse batchDelete(String ids);

    ServerResponse findPageList(BrandSearchParam brandSearchParam);
}
