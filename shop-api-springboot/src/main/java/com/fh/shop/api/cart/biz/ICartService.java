package com.fh.shop.api.cart.biz;

import com.fh.shop.api.common.ServerResponse;

public interface ICartService {
    ServerResponse addCart(Long memberId, Long productId, Long count);

    ServerResponse findCarts(Long id);

    ServerResponse deleteCartItem(Long memberId, Long productId);
}
