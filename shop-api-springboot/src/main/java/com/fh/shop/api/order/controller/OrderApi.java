package com.fh.shop.api.order.controller;

import com.fh.shop.api.annotation.ApiIdempotent;
import com.fh.shop.api.annotation.Check;
import com.fh.shop.api.common.ServerResponse;
import com.fh.shop.api.member.vo.MemberVo;
import com.fh.shop.api.order.biz.IOrderService;
import com.fh.shop.api.order.param.OrderParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/orders")
public class OrderApi {
    @Resource(name = "orderService")
    private IOrderService orderService;


    //添加订单
    @ApiIdempotent
    @Check
    @PostMapping
    public ServerResponse addOrder(OrderParam orderParam, MemberVo memberVo) {
        Long memberId = memberVo.getId();
        return orderService.addOrder(memberId,orderParam);
    }

}
