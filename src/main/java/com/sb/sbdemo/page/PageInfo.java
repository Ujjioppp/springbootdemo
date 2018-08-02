package com.sb.sbdemo.page;

import java.io.Serializable;

/**
 * Created by ye on 1/8/18.
 */
public class PageInfo extends com.github.pagehelper.PageInfo implements Serializable {
    @Override
    public int getPageNum() {
        return super.getPageNum() == 0 ? 1 : super.getPageNum();
    }

    @Override
    public int getPageSize() {
        return super.getPageSize() == 0 ? 20 : super.getPageSize();
    }
}
