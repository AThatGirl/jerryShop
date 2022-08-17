package com.cj.jerryShop.service.impl;

import com.cj.jerryShop.dao.IndexImgMapper;
import com.cj.jerryShop.entity.IndexImg;
import com.cj.jerryShop.service.IndexImgService;
import com.cj.jerryShop.staticVariable.AboutResultVO;
import com.cj.jerryShop.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("indexImgService")
public class IndexImgServiceImpl implements IndexImgService {

    @Autowired
    private IndexImgMapper indexImgMapper;


    @Override
    public ResultVO queryIndexImgs() {
        List<IndexImg> indexImgs = indexImgMapper.selectIndexImgs();
        if (indexImgs.size()==0){
            return new ResultVO(AboutResultVO.RESULT_VO_FAIL_CODE,"fail",null);
        }else {
            return new ResultVO(AboutResultVO.RESULT_VO_SUCCEED_CODE,"success",indexImgs);
        }
    }
}
