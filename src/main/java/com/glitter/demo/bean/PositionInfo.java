package com.glitter.demo.bean;

import java.util.Date;

public class PositionInfo {

    private Long positionId;

    private Long orgId;

    private String positionName;

    private Long positionGroupId;

    private Byte deleteFlag;

    private Date createTime;

    private Date updateTime;


    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName == null ? null : positionName.trim();
    }

    public Long getPositionGroupId() {
        return positionGroupId;
    }

    public void setPositionGroupId(Long positionGroupId) {
        this.positionGroupId = positionGroupId;
    }

    public Byte getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Byte deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}