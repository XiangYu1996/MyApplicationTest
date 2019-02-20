package com.example.asus_pc.listview;

import java.io.Serializable;

/**
 * Created by ASUS-PC on 2019/1/23.
 */

class UserInfo implements Serializable{
    private String mUserName;
    private int mAge;
    private String mAvatarUrl;
    private float mWeight;


    public UserInfo(String userName,int age){
        mUserName = userName;
        mAge = age;
    }
    public String getUserName(){ return mUserName;}
    public void setUserName(String userName){mUserName = userName;}
    public int getAge(){return mAge;}
    public void setAge(int age){ mAge = age;}

}
