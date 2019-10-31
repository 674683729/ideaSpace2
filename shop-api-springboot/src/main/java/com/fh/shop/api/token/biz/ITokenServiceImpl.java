package com.fh.shop.api.token.biz;

import com.fh.shop.api.common.ServerResponse;
import com.fh.shop.api.utils.RedisUtil;
import com.fh.shop.api.utils.SystemConst;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service("tokenService")
@Transactional(rollbackFor = Exception.class)
public class ITokenServiceImpl implements ITokenService {

    //生成token
    @Override
    @Transactional(readOnly = true)
    public ServerResponse createToken() {
        String token = UUID.randomUUID().toString();
        //将token存储到redis中
        RedisUtil.setEx(token,token,SystemConst.REDIS_TOKEN_TIME);//30分钟存活时间
        return ServerResponse.success(token);
    }

}
