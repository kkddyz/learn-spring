package pers.kkddyz.service.impl;


import pers.kkddyz.service.IAccountService;

import java.util.Date;

/**
 * @author pers.pers.kkddyz
 * 账户操作业务实现
 */
public class AccountServiceImplCopy implements IAccountService {



    private String serviceName;
    private Integer serviceID;
    private Date createTime;

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setServiceID(Integer serviceID) {
        this.serviceID = serviceID;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "AccountServiceImplCopy{" +
                "name='" + serviceName + '\'' +
                ", age=" + serviceID +
                ", birthday=" + createTime +
                '}';
    }

    @Override
    public void saveAccount() {
        System.out.println("执行service的saveAccount方法");
        System.out.println(this.toString());
    }
}
