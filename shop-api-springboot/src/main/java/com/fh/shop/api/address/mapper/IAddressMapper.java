package com.fh.shop.api.address.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.shop.api.address.po.Address;

import java.util.List;

public interface IAddressMapper extends BaseMapper<Address> {
    List<Address> findMemberAddress(Long memberId);

    Address findAddressById(String addressId);
}
