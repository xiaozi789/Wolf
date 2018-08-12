package com.qishi.admin.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "pac_verify_code")
public class VerifyCodeEntity {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private String id;

    /**
     * 业务id，如用户id，手机号码
     */
    @Column(name = "business_no")
    private String businessNo;

    /**
     * 验证码
     */
    @Column(name = "verify_code")
    private String verifyCode;

    /**
     * 业务类型，MSS0000001：骑士公众号；MSS0000002：商户版APP
     */
    @Column(name = "business_type")
    private String businessType;

    /**
     * 验证类型，00：email，01：sms
     */
    @Column(name = "verify_mode")
    private String verifyMode;

    /**
     * 截止时间
     */
    @Column(name = "dead_line_time")
    private Date deadLineTime;

    /**
     * 验证码模板
     */
    @Column(name = "template_key")
    private String templateKey;

    /**
     * 状态，00：未使用，01：已使用
     */
    private String status;

    /**
     * 使用时间
     */
    @Column(name = "use_time")
    private Date useTime;

    /**
     * 插入时间
     */
    @Column(name = "insert_time")
    private Date insertTime;

    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取业务id，如用户id，手机号码
     *
     * @return business_no - 业务id，如用户id，手机号码
     */
    public String getBusinessNo() {
        return businessNo;
    }

    /**
     * 设置业务id，如用户id，手机号码
     *
     * @param businessNo 业务id，如用户id，手机号码
     */
    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo == null ? null : businessNo.trim();
    }

    /**
     * 获取验证码
     *
     * @return verify_code - 验证码
     */
    public String getVerifyCode() {
        return verifyCode;
    }

    /**
     * 设置验证码
     *
     * @param verifyCode 验证码
     */
    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode == null ? null : verifyCode.trim();
    }

    /**
     * 获取业务类型，MSS0000001：骑士公众号；MSS0000002：商户版APP
     *
     * @return business_type - 业务类型，MSS0000001：骑士公众号；MSS0000002：商户版APP
     */
    public String getBusinessType() {
        return businessType;
    }

    /**
     * 设置业务类型，MSS0000001：骑士公众号；MSS0000002：商户版APP
     *
     * @param businessType 业务类型，MSS0000001：骑士公众号；MSS0000002：商户版APP
     */
    public void setBusinessType(String businessType) {
        this.businessType = businessType == null ? null : businessType.trim();
    }

    /**
     * 获取验证类型，00：email，01：sms
     *
     * @return verify_mode - 验证类型，00：email，01：sms
     */
    public String getVerifyMode() {
        return verifyMode;
    }

    /**
     * 设置验证类型，00：email，01：sms
     *
     * @param verifyMode 验证类型，00：email，01：sms
     */
    public void setVerifyMode(String verifyMode) {
        this.verifyMode = verifyMode == null ? null : verifyMode.trim();
    }

    /**
     * 获取截止时间
     *
     * @return dead_line_time - 截止时间
     */
    public Date getDeadLineTime() {
        return deadLineTime;
    }

    /**
     * 设置截止时间
     *
     * @param deadLineTime 截止时间
     */
    public void setDeadLineTime(Date deadLineTime) {
        this.deadLineTime = deadLineTime;
    }

    /**
     * 获取验证码模板
     *
     * @return template_key - 验证码模板
     */
    public String getTemplateKey() {
        return templateKey;
    }

    /**
     * 设置验证码模板
     *
     * @param templateKey 验证码模板
     */
    public void setTemplateKey(String templateKey) {
        this.templateKey = templateKey == null ? null : templateKey.trim();
    }

    /**
     * 获取状态，00：未使用，01：已使用
     *
     * @return status - 状态，00：未使用，01：已使用
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态，00：未使用，01：已使用
     *
     * @param status 状态，00：未使用，01：已使用
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取使用时间
     *
     * @return use_time - 使用时间
     */
    public Date getUseTime() {
        return useTime;
    }

    /**
     * 设置使用时间
     *
     * @param useTime 使用时间
     */
    public void setUseTime(Date useTime) {
        this.useTime = useTime;
    }

    /**
     * 获取插入时间
     *
     * @return insert_time - 插入时间
     */
    public Date getInsertTime() {
        return insertTime;
    }

    /**
     * 设置插入时间
     *
     * @param insertTime 插入时间
     */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
}