package com.cj.jerryShop.dao;

import com.cj.jerryShop.entity.Category;
import com.cj.jerryShop.entity.CategoryVO;
import com.cj.jerryShop.general.GeneratorDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper extends GeneratorDAO<Category> {

    //连接查询，需要已知查询的级数
    public List<CategoryVO> selectAllCategories();

    //子查询，无论多少级都可以查到
    public List<CategoryVO> selectAllCategories2(Integer parentId);

}