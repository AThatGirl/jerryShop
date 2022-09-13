package com.cj.jerryShop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 首页类别商品推荐
 *
 * @author 杰瑞
 * @date 2022/09/11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoryVO {


    private Integer categoryId;

    private String categoryName;

    private Integer categoryLevel;

    private Integer parentId;

    private String categoryIcon;

    private String categorySlogan;

    private String categoryPic;

    private String categoryBgColor;
    //实现首页类别显示
    private List<CategoryVO> categories;
    //实现首页分类商品推荐
    private List<ProductVO> products;

}