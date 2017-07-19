package com.paul.zmm_personal;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 联系人信息
 *
 * @author chenyunyun hzchenyunyun1@corp.netease.com
 * @since 2016年8月15日
 */
public class KaolaContact implements Serializable {

    private static final long serialVersionUID = 2867921966430277897L;

    /**
     * id
     */
    private Long id=100L;

    /**
     * 用户名
     */
    private String userName="zmm";

    /**
     * 用户id
     */
    private Long userId=123L;

    /**
     * 姓名
     */
    private String name="zmm";

    /**
     * 生日
     */
    private Date birthday= new Date();

    /**
     * 证件类型:1身份证 2护照 3军人证 4回乡证 5台胞证 6港澳通行证 7其他
     */
    private Integer idType=1;

    /**
     * 证件号码
     */
    private String idNum="28393";

    /**
     * 性别：0未知 1男2女
     */
    private Integer gender=1;

    /**
     * 区号
     */
    private String phoneAreaNum="0989";

    /**
     * 电话号码
     */
    private String phoneNum="23452354";

    /**
     * 分机号码
     */
    private String phoneExtNum="239808";

    /**
     * 手机号
     */
    private String mobile="082380";

    /**
     * 邮箱
     */
    private String email="29038@153";

    /**
     * 省
     */
    private String provinceCode="23";

    /**
     * 市
     */
    private String cityCode="23";

    /**
     * 区
     */
    private String districtCode="23";

    /**
     * 详细地址
     */
    private String address="lwelfjwelf";

    /**
     * 扩展字段
     */
    private String extInfo="lwefjlf";

    /**
     * 邮编
     */
    private String postCode="92389";

    /**
     * 创建时间
     */
    private Long createTime=8988L;

    /**
     * 默认状态 1 默认，0 非默认
     */
    private Integer defaultFlag=1;

    /**
     * 修改时间
     */
    private Long updateTime=8080823L;

    /**
     * 手机号是否验证
     */
    private Integer mobileVflag=1;

    /**
     * 邮箱是否验证
     */
    private Integer emailVflag=1;

    /**
     * 证件号是否验证
     */
    private Integer idNumVflag=1;

    /**
     * 上次使用时间
     */
    private Long lastUseTime=8023480L;

    /**
     * 使用次数
     */
    private Integer useNum=1;

    /**
     * 省名称
     */
    private String provinceName="k;wekf;";

    /**
     * 市名称
     */
    private String cityName="klwef";

    /**
     * 区名称
     */
    private String districtName="jlwefk";

    /** 电话号码的加密串 */
    private String mobileEnc="fwle";
    
	/**
	 * 地址的验证状态
	 */
	private int verifyStatus=1;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(String extInfo) {
        this.extInfo = extInfo;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Integer getDefaultFlag() {
        return defaultFlag;
    }

    public void setDefaultFlag(Integer defaultFlag) {
        this.defaultFlag = defaultFlag;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getMobileVflag() {
        return mobileVflag;
    }

    public void setMobileVflag(Integer mobileVflag) {
        this.mobileVflag = mobileVflag;
    }

    public Integer getEmailVflag() {
        return emailVflag;
    }

    public void setEmailVflag(Integer emailVflag) {
        this.emailVflag = emailVflag;
    }

    public Long getLastUseTime() {
        return lastUseTime;
    }

    public void setLastUseTime(Long lastUseTime) {
        this.lastUseTime = lastUseTime;
    }

    public Integer getUseNum() {
        return useNum;
    }

    public void setUseNum(Integer useNum) {
        this.useNum = useNum;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPhoneAreaNum() {
        return phoneAreaNum;
    }

    public void setPhoneAreaNum(String phoneAreaNum) {
        this.phoneAreaNum = phoneAreaNum;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPhoneExtNum() {
        return phoneExtNum;
    }

    public void setPhoneExtNum(String phoneExtNum) {
        this.phoneExtNum = phoneExtNum;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public Integer getIdNumVflag() {
        return idNumVflag;
    }

    public void setIdNumVflag(Integer idNumVflag) {
        this.idNumVflag = idNumVflag;
    }

    public String getMobileEnc() {
        return mobileEnc;
    }

    public void setMobileEnc(String mobileEnc) {
        this.mobileEnc = mobileEnc;
    }
    
    public int getVerifyStatus() {
		return verifyStatus;
	}

	public void setVerifyStatus(int verifyStatus) {
		this.verifyStatus = verifyStatus;
	}

	@Override
    public String toString() {
        return "KaolaContact [id=" + id + ", userName=" + userName + ", userId=" + userId + ", name=" + name
                + ", birthday=" + birthday + ", idType=" + idType + ", idNum=" + idNum + ", gender=" + gender
                + ", phoneAreaNum=" + phoneAreaNum + ", phoneNum=" + phoneNum + ", phoneExtNum=" + phoneExtNum
                + ", mobile=" + mobile + ", email=" + email + ", provinceCode=" + provinceCode + ", cityCode="
                + cityCode + ", districtCode=" + districtCode + ", address=" + address + ", extInfo=" + extInfo
                + ", postCode=" + postCode + ", createTime=" + createTime + ", defaultFlag=" + defaultFlag
                + ", updateTime=" + updateTime + ", mobileVflag=" + mobileVflag + ", emailVflag=" + emailVflag
                + ", idNumVflag=" + idNumVflag + ", lastUseTime=" + lastUseTime + ", useNum=" + useNum
                + ", provinceName=" + provinceName + ", cityName=" + cityName + ", districtName=" + districtName
                + ", mobileEnc=" + mobileEnc + ", verifyStatus=" +verifyStatus +"]";
    }

}
