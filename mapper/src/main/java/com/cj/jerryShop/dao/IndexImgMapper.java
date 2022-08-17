package com.cj.jerryShop.dao;

import com.cj.jerryShop.entity.IndexImg;
import com.cj.jerryShop.general.GeneratorDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndexImgMapper extends GeneratorDAO<IndexImg> {

    public List<IndexImg> selectIndexImgs();


}