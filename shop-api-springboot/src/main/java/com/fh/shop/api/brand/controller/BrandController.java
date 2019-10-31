package com.fh.shop.api.brand.controller;

import com.fh.shop.api.annotation.Check;
import com.fh.shop.api.brand.biz.IBrandService;
import com.fh.shop.api.common.ServerResponse;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/brand")
@CrossOrigin("*")
public class BrandController {
    @Resource
    private IBrandService brandService;

    //查询热销品牌
    @RequestMapping("findSellWellBrand")
    @Check
    public ServerResponse findSellWellBrand(){
        ServerResponse list = brandService.findSellWellBrand();
        return list;
    }
}
