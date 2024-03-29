package com.fh.shop.api.member.biz;

import com.fh.shop.api.common.ServerResponse;
import com.fh.shop.api.member.po.Member;

public interface IMemberService {

    ServerResponse addMember(Member member);

    ServerResponse memberLogin(Member member);

    ServerResponse findMemberOne(String key, Object value);

    ServerResponse smsLogin(String phone, String smsCode);
}
