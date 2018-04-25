package com.glitter.demo.bean;

import java.util.Date;

public class PositionGroup {

    private Long positionGroupId;

    private Long orgId;

    private String groupName;

    private Byte deleteFlag;

    private Date createTime;

    private Date updateTime;


    public Long getPositionGroupId() {
        return positionGroupId;
    }

    public void setPositionGroupId(Long positionGroupId) {
        this.positionGroupId = positionGroupId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
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