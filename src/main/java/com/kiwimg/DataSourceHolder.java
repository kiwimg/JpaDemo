package com.kiwimg;

/**
 * Created by Administrator on 2017/6/10.
 */
public class DataSourceHolder {
    //线程本地环境
    private static final ThreadLocal<String> dataSources = new ThreadLocal<String>();

    //设置数据源
    public static void setDataSource(String customerType) {
        dataSources.set(customerType);
    }
    //获取数据源
    public static String getDataSource() {
        return (String) dataSources.get();
    }
    //清除数据源
    public static void clear() {
        dataSources.remove();
    }
}
