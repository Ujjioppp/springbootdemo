package com.sb.sbdemo.service;

import com.sb.sbdemo.model.FfaDemand;
import com.sb.sbdemo.page.PageInfo;

import java.util.List;

/**
 * Created by ye on 1/8/18.
 */
public interface FfaDemandService {
    List<FfaDemand> queryList(PageInfo pageInfo);
}
