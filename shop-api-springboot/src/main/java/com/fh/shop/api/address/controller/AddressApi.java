package com.fh.shop.api.address.controller;

import com.fh.shop.api.address.biz.IAddressService;
import com.fh.shop.api.address.po.Address;
import com.fh.shop.api.annotation.Check;
import com.fh.shop.api.common.ServerResponse;
import com.fh.shop.api.member.vo.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/address")
public class AddressApi {
    @Resource(name = "addressService")
    private IAddressService addressService;

    //修改地址
    @Check
    @PutMapping
    public ServerResponse updateAddress(@RequestBody Address address,MemberVo member) {
        return addressService.updateAddress(member.getId(),address);
    }

    //回显
    @Check
    @GetMapping("findById")
    public ServerResponse findById(String id) {
        return addressService.findById(id);
    }


    //新增地址
    @Check
    @PostMapping
    public ServerResponse addAddress(Address address,MemberVo member) {
        return addressService.addAddress(member.getId(),address);
    }

    //删除地址
    @Check
    @DeleteMapping("/{id}")
    public ServerResponse deleteAddress(@PathVariable String id) {
        return addressService.deleteAddress(id);
    }

    //查询当前会员的收货地址信息
    @Check
    @GetMapping
    public ServerResponse findMemberAddress(MemberVo member) {
        return addressService.findMemberAddress(member.getId());
    }

}
