package com.fh.shop.api.brand.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.shop.api.brand.param.BrandSearchParam;
import com.fh.shop.api.brand.po.Brand;

import java.util.List;

public interface IBrandMapper extends BaseMapper<Brand> {

    Long findTotalCount(BrandSearchParam brandSearchParam);

    List<Brand> findPageList(BrandSearchParam brandSearchParam);
}
