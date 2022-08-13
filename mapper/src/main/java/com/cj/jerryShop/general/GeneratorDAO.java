package com.cj.jerryShop.general;


import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 逆向工程
 *
 * @author 杰瑞
 * @date 2022/08/06
 */
public interface GeneratorDAO<T> extends Mapper<T>, MySqlMapper<T> {
}
