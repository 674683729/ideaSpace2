package com.fh.shop.api.sort.controller;

import com.fh.shop.api.common.ServerResponse;
import com.fh.shop.api.sort.biz.ISortService;
import com.fh.shop.api.sort.po.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/sort")
@CrossOrigin("*")
public class SortController {

    @Resource
    private ISortService sortService;

    @RequestMapping("findSortList")
    public ServerResponse findSortList(){
        List<Sort> sortList = sortService.findSortList();
        return ServerResponse.success(sortList);
    }
}
