package com.sb.sbdemo.service.impl;

import com.github.pagehelper.PageHelper;
import com.sb.sbdemo.access.PageAccess;
import com.sb.sbdemo.dao.FfaDemandMapper;
import com.sb.sbdemo.model.FfaDemand;
import com.sb.sbdemo.page.PageInfo;
import com.sb.sbdemo.service.FfaDemandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ye on 1/8/18.
 */
@Service
public class FfaDemandServiceImpl implements FfaDemandService {
    private static final Logger logger = LoggerFactory.getLogger(FfaDemandServiceImpl.class);
    @Autowired
    private FfaDemandMapper ffaDemandMapper;

    @Override
    @PageAccess
    public List<FfaDemand> queryList(PageInfo pageInfo) {
//        PageHelper.startPage(pageInfo);
        logger.info("----------");
        return this.ffaDemandMapper.queryList();
    }
}
