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


    /**
     * 查询分类列表（三个级别的分类）
     *
     * @return {@link ResultVO}
     */
    @Override
    public ResultVO queryAllCategory() {
        List<CategoryVO> categoryVOS = categoryMapper.selectAllCategories();
        return new ResultVO(AboutResultVO.RESULT_VO_SUCCEED_CODE,"success",categoryVOS);
    }

    /**
     * 查询一级分类，同时查询销量最高的6个商品
     *
     * @return {@link ResultVO}
     */
    @Override
    public ResultVO queryFirstLevelCategories() {
        List<CategoryVO> categoryVOS = categoryMapper.selectFirstLevelCategories();
        ResultVO resultVO = new ResultVO(AboutResultVO.RESULT_VO_SUCCEED_CODE, "success", categoryVOS);
        return resultVO;
    }
}
