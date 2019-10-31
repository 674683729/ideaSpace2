package com.fh.shop.api.sort.biz;

import com.alibaba.fastjson.JSONObject;
import com.fh.shop.api.sort.mapper.ISortMapper;
import com.fh.shop.api.sort.po.Sort;
import com.fh.shop.api.sort.vo.SortVo;
import com.fh.shop.api.utils.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("sortService")
@Transactional(rollbackFor = Exception.class)
public class ISortServiceImpl implements ISortService {
    @Autowired
    private ISortMapper sortMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Sort> findSortList() {
        String sortListJson = RedisUtil.get("sortList");
        if (StringUtils.isNotEmpty(sortListJson)){
            List<Sort> sortList = JSONObject.parseArray(sortListJson, Sort.class);
            return sortList;
        }

        List<Sort> sortList = sortMapper.selectList(null);
        sortListJson = JSONObject.toJSONString(sortList);
        RedisUtil.set("sortList", sortListJson);
        return sortList;
    }


    private List<SortVo> buildSortVoList(List<Sort> sortList) {
        List<SortVo> sortVoList = new ArrayList<>();
        for (Sort sort : sortList) {
            SortVo sortVo = new SortVo();
            sortVo.setId(sort.getId());
            sortVo.setName(sort.getSortName());
            sortVo.setPId(sort.getFatherId());
            sortVoList.add(sortVo);
        }
        return sortVoList;
    }
}
