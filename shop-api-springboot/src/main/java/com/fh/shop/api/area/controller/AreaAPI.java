package com.fh.shop.api.area.controller;

import com.fh.shop.api.annotation.Check;
import com.fh.shop.api.area.biz.IAreaService;
import com.fh.shop.api.common.ServerResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("areas")
@CrossOrigin("*")
public class AreaAPI {
    @Resource(name = "areaService")
    private IAreaService areaService;

    //查询地区全部集合
    @GetMapping
    public ServerResponse findAllAreaList() {
        return areaService.findAllAreaList();
    }


}
