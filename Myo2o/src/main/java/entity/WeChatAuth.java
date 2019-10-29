package entity;

import java.util.Date;

public class WeChatAuth {
    private Long webchatAuthId;
    private Long openId;
    private Date createTime;
    private PersonInfo personInfo;

    public WeChatAuth(Long openId, Date createTime, PersonInfo personInfo) {
        this.openId = openId;
        this.createTime = createTime;
        this.personInfo = personInfo;
    }

    public void setWebchatAuthId(Long webchatAuthId) {
        this.webchatAuthId = webchatAuthId;
    }

    public void setOpenId(Long openId) {
        this.openId = openId;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }

    public Long getWebchatAuthId() {
        return webchatAuthId;
    }

    public Long getOpenId() {
        return openId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public PersonInfo getPersonInfo() {
        return personInfo;
    }
}
