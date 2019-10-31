package com.fh.shop.api.member.controller;

import com.fh.shop.api.annotation.Check;
import com.fh.shop.api.common.ServerResponse;
import com.fh.shop.api.member.biz.IMemberService;
import com.fh.shop.api.member.po.Member;
import com.fh.shop.api.member.vo.MemberVo;
import com.fh.shop.api.utils.KeyUtil;
import com.fh.shop.api.utils.RedisUtil;
import com.fh.shop.api.utils.SystemConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("members")
public class MemberController {
    @Resource(name = "memberService")
    private IMemberService memberService;

    //查询当前登陆的会员信息
    @Check
    @GetMapping("findMember")
    public ServerResponse findMember(MemberVo memberVo) {
        return ServerResponse.success(memberVo.getRealName());
    }

    //退出
    @Check
    @PostMapping("logout")
    public ServerResponse lonout(MemberVo memberVo){
        RedisUtil.del(KeyUtil.buildLoginMemberKey(memberVo.getMemberName(),memberVo.getUuid()));
        return ServerResponse.success();
    }

    //手机号登陆
    @PostMapping("smsLogin")
    public ServerResponse smsLogin(String phone, String smsCode){
        return memberService.smsLogin(phone,smsCode);
    }

    //会员账号登录
    @PostMapping("login")
    public ServerResponse memberLogin(Member member) {
        return memberService.memberLogin(member);
    }

    //通过手机查询会员
    @GetMapping("phone")
    public ServerResponse findMemberByPhone(String phone) {
        return memberService.findMemberOne("phone",phone);
    }

    //通过邮箱查询会员
    @GetMapping("email")
    public ServerResponse findMemberByEmail(String email) {
        return memberService.findMemberOne("email", email);
    }

    //通过会员名查询会员
    @GetMapping
    public ServerResponse findMemberByName(String memberName) {
        return memberService.findMemberOne("memberName", memberName);
    }
    
    //注册
    @PostMapping
    public ServerResponse addMember(Member member) {
        return memberService.addMember(member);
    }



}
