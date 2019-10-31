package com.fh.shop.api.cart.controller;

import com.fh.shop.api.annotation.Check;
import com.fh.shop.api.cart.biz.ICartService;
import com.fh.shop.api.common.ServerResponse;
import com.fh.shop.api.member.vo.MemberVo;
import com.fh.shop.api.utils.SystemConst;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/carts")
public class CartApi {
    @Resource
    private ICartService cartService;
    @Autowired
    private HttpServletRequest request;

    //购物车商品查询
    @Check
    @GetMapping
    public ServerResponse findCarts(MemberVo memberVo){
        return cartService.findCarts(memberVo.getId());
    }

    //新增购物车商品
    @Check
    @PostMapping
    public ServerResponse addCart(Long productId, Long count,MemberVo memberVo) {
        Long memberId = memberVo.getId();
        return cartService.addCart(memberId, productId, count);
    }

    //删除购物车商品
    @Check
    @DeleteMapping("/{productId}")
    public ServerResponse deleteCartItem(@PathVariable Long productId,MemberVo memberVo){
        Long memberId = memberVo.getId();
        return cartService.deleteCartItem(memberId, productId);
    }


}
