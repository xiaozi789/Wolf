package com.qishi.admin.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
public class VerifyCodeBean implements Serializable
{

    private String id;


    private String businessNo;

    private String verifyCode;


    private String businessType;


    private String verifyMode;


    private Date deadLineTime;


    private String templateKey;


    private String status;


    private Date useTime;


    private Date insertTime;


}