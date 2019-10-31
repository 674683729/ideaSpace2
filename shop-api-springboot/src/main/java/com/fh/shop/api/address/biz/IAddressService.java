package com.fh.shop.api.address.biz;

import com.fh.shop.api.address.po.Address;
import com.fh.shop.api.common.ServerResponse;

public interface IAddressService {
    ServerResponse addAddress(Long memberId, Address address);

    ServerResponse findMemberAddress(Long memberId);

    ServerResponse deleteAddress(String id);

    ServerResponse findById(String id);

    ServerResponse updateAddress(Long id, Address address);
}
