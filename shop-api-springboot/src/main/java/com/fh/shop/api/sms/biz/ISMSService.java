package com.fh.shop.api.sms.biz;

import com.fh.shop.api.common.ServerResponse;

public interface ISMSService {
    ServerResponse postPhoneCode(String phone);
}
