package pers.kkddyz.service.impl;


import pers.kkddyz.service.IAccountService;

import java.util.Date;

/**
 * @author pers.pers.kkddyz
 * 账户操作业务实现
 */
public class AccountServiceImpl implements IAccountService {

    /*
        如果是经常变化的数据不适合注入(需要修改配置文件)
        一般用途,注入该对象的依赖的对象
     */

    private String serviceName;
    private Integer serviceID;
    private Date createTime;


    public AccountServiceImpl() {
        System.out.println("无参构造器,创建了accountService对象");
    }

    public AccountServiceImpl(String serviceName, Date createTime) {
        this.serviceName = serviceName;
        this.createTime = createTime;
        System.out.println("含参构造器,创建了accountService对象");
    }

    public AccountServiceImpl(Integer serviceID, Date createTime) {
        this.serviceID = serviceID;
        this.createTime = createTime;
        System.out.println("含参构造器,创建了accountService对象");
    }

    public AccountServiceImpl(String service, String serviceID, Date createTime) {

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
