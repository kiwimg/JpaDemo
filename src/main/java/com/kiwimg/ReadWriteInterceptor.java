package com.kiwimg;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.PatternMatchUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2017/6/10.
 */
public class ReadWriteInterceptor {
    private static final Random random = new Random();
    private List<String> readMethodList = new ArrayList<String>();
    private List<String> writeMethodList = new ArrayList<String>();
    private String masterName;
    private boolean readOnly;
    private int weight;

    public Object readOrWriteDB(ProceedingJoinPoint pjp) throws Throwable {
        Object retVal = null;
        String masterName = getMasterName();
        boolean isReadOnly = isReadOnly();
        String methodName = pjp.getSignature().getName();
        if (isReadOnly && isChooseReadDB(methodName)) {
            int weight = getWeight();
            if (weight == 0) {
                DataSourceHolder.setDataSource(getSlaves(masterName));
            } else if (weight > 0) {
                int randomVaule = random.nextInt(100);
                if (randomVaule < weight) { //随机, 如果随机数大于配置权重则去从库查询
                    DataSourceHolder.setDataSource(getSlaves(masterName));
                } else {
                    DataSourceHolder.setDataSource(masterName);
                }
            } else {
                DataSourceHolder.setDataSource(masterName);
            }
        } else {
            DataSourceHolder.setDataSource(masterName);
        }

        retVal = pjp.proceed();
        DataSourceHolder.clear();
        return retVal;
    }

    /**
     * 约定规约
     *
     * @param name
     * @return
     */
    public String getSlaves(String name) {
        return name + "_readOnly";
    }

    private boolean isChooseReadDB(String methodName) {
        for (String mappedName : this.readMethodList) {
            if (isMatch(methodName, mappedName)) {
                return true;
            }
        }
        return false;
    }

    private boolean isMatch(String methodName, String mappedName) {
        return PatternMatchUtils.simpleMatch(mappedName, methodName);
    }

    public List<String> getReadMethodList() {
        return readMethodList;
    }

    public void setReadMethodList(List<String> readMethodList) {
        this.readMethodList = readMethodList;
    }

    public List<String> getWriteMethodList() {
        return writeMethodList;
    }

    public void setWriteMethodList(List<String> writeMethodList) {
        this.writeMethodList = writeMethodList;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
