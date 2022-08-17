package com.cj.jerryShop.service.impl;

import com.cj.jerryShop.dao.ProductMapper;
import com.cj.jerryShop.entity.ProductVO;
import com.cj.jerryShop.service.ProductService;
import com.cj.jerryShop.staticVariable.AboutResultVO;
import com.cj.jerryShop.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ResultVO queryRecommendProduct() {
        return new ResultVO(AboutResultVO.RESULT_VO_SUCCEED_CODE,"success",productMapper.selectRecommendProducts());
    }
}
