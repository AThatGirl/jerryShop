package com.cj.jerryShop.service.impl;

import com.cj.jerryShop.dao.CategoryMapper;
import com.cj.jerryShop.entity.CategoryVO;
import com.cj.jerryShop.service.CategoryService;
import com.cj.jerryShop.staticVariable.AboutResultVO;
import com.cj.jerryShop.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;


    @Override
    public ResultVO queryAllCategory() {
        List<CategoryVO> categoryVOS = categoryMapper.selectAllCategories();
        return new ResultVO(AboutResultVO.RESULT_VO_SUCCEED_CODE,"success",categoryVOS);
    }
}
