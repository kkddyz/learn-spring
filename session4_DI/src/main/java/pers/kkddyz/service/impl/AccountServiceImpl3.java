package pers.kkddyz.service.impl;

import pers.kkddyz.service.IAccountService;

import java.util.*;

/**
 * @author pers.pers.kkddyz
 */
public class AccountServiceImpl3 implements IAccountService {
    private String[] myStrings;
    private List<String> myList;
    private Set<String> mySet;
    private Map<String,String> myMap;
    private Properties myProps;

    public void setMyStrings(String[] myStrings) {
        this.myStrings = myStrings;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }


    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void setMyProps(Properties myProps) {
        this.myProps = myProps;
    }

    @Override
    public void saveAccount() {
        System.out.println("print myStrings");
        System.out.println(Arrays.toString(myStrings));

        System.out.println("print myList");
        System.out.println(myList);

        System.out.println("print mySet");
        System.out.println(mySet);

        System.out.println("print myMap");
        System.out.println(myMap);

        System.out.println("print myProps");
        System.out.println(myProps);
    }
}
