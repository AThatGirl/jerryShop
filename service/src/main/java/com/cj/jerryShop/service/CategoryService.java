package com.cj.jerryShop.service;

import com.cj.jerryShop.vo.ResultVO;

public interface CategoryService {

    public ResultVO queryAllCategory();

    public ResultVO queryFirstLevelCategories();

}
