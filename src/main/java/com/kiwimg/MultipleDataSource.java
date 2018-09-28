package com.kiwimg;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 获取数据源（依赖于spring）
 * @author su
 */
public class MultipleDataSource extends AbstractRoutingDataSource {


    protected Object determineCurrentLookupKey() {
        String das = DataSourceHolder.getDataSource();
        return das;
    }
}
