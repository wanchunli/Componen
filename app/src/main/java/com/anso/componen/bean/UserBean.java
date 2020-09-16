package com.anso.componen.bean;

import java.util.List;


public class UserBean {

    /**
     * loginname : system
     * name : 系统管理员
     * permissionInfos : [{"id":73,"name":"运营管理","type":"menu","permissionValue":"s:operationManagement","parentId":68,"treeId":null,"pageId":null,"icon":"fenxi","uri":null,"orderNum":0}]
     * dept : {"id":7,"groupId":null,"parentId":3,"path":"1,3,7","level":"TEAM","type":null,"name":"抄表一班","aliasName":null,"desc":"抄表一班","orderNum":0,"createTime":1551923146539,"updateTime":null,"createUserId":1,"updateUserId":null,"isEnabled":true,"isDelete":false}
     * headImg : 15
     * tel : null
     * jobNumber : 131
     * collect : true
     * roles : [{"id":1,"code":"SUPERADMIN","name":"超级管理员","remark":"超级管理员","isEnable":true,"collect":true,"createTime":1540546495172,"updateTime":1548146173402}]
     * analyst : true
     */

    private int id;
    private String loginname;
    private String loginType;
    private String name;
    private DeptBean dept;
    private String headImg;
    private String tel;
    private String jobNumber;
    private boolean collect;
    private boolean analyst;
    private List<PermissionInfosBean> permissionInfos;
    private List<RolesBean> roles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DeptBean getDept() {
        return dept;
    }

    public void setDept(DeptBean dept) {
        this.dept = dept;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public boolean isCollect() {
        return collect;
    }

    public void setCollect(boolean collect) {
        this.collect = collect;
    }

    public boolean isAnalyst() {
        return analyst;
    }

    public void setAnalyst(boolean analyst) {
        this.analyst = analyst;
    }

    public List<PermissionInfosBean> getPermissionInfos() {
        return permissionInfos;
    }

    public void setPermissionInfos(List<PermissionInfosBean> permissionInfos) {
        this.permissionInfos = permissionInfos;
    }

    public List<RolesBean> getRoles() {
        return roles;
    }

    public void setRoles(List<RolesBean> roles) {
        this.roles = roles;
    }

    public static class DeptBean {
        /**
         * id : 7
         * groupId : null
         * parentId : 3
         * path : 1,3,7
         * level : TEAM
         * type : null
         * name : 抄表一班
         * aliasName : null
         * desc : 抄表一班
         * orderNum : 0
         * createTime : 1551923146539
         * updateTime : null
         * createUserId : 1
         * updateUserId : null
         * isEnabled : true
         * isDelete : false
         */

        private int id;
        private String groupId;
        private int parentId;
        private String path;
        private String level;
        private String type;
        private String name;
        private String aliasName;
        private String desc;
        private int orderNum;
        private long createTime;
        private long updateTime;
        private int createUserId;
        private String updateUserId;
        private boolean isEnabled;
        private boolean isDelete;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGroupId() {
            return groupId;
        }

        public void setGroupId(String groupId) {
            this.groupId = groupId;
        }

        public int getParentId() {
            return parentId;
        }

        public void setParentId(int parentId) {
            this.parentId = parentId;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAliasName() {
            return aliasName;
        }

        public void setAliasName(String aliasName) {
            this.aliasName = aliasName;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public int getOrderNum() {
            return orderNum;
        }

        public void setOrderNum(int orderNum) {
            this.orderNum = orderNum;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }

        public int getCreateUserId() {
            return createUserId;
        }

        public void setCreateUserId(int createUserId) {
            this.createUserId = createUserId;
        }

        public String getUpdateUserId() {
            return updateUserId;
        }

        public void setUpdateUserId(String updateUserId) {
            this.updateUserId = updateUserId;
        }

        public boolean isIsEnabled() {
            return isEnabled;
        }

        public void setIsEnabled(boolean isEnabled) {
            this.isEnabled = isEnabled;
        }

        public boolean isIsDelete() {
            return isDelete;
        }

        public void setIsDelete(boolean isDelete) {
            this.isDelete = isDelete;
        }
    }

    public static class PermissionInfosBean {
        /**
         * id : 73
         * name : 运营管理
         * type : menu
         * permissionValue : s:operationManagement
         * parentId : 68
         * treeId : null
         * pageId : null
         * icon : fenxi
         * uri : null
         * orderNum : 0
         */

        private int id;
        private String name;
        private String type;
        private String permissionValue;
        private int parentId;
        private int treeId;
        private int pageId;
        private String icon;
        private String uri;
        private int orderNum;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getPermissionValue() {
            return permissionValue;
        }

        public void setPermissionValue(String permissionValue) {
            this.permissionValue = permissionValue;
        }

        public int getParentId() {
            return parentId;
        }

        public void setParentId(int parentId) {
            this.parentId = parentId;
        }

        public int getTreeId() {
            return treeId;
        }

        public void setTreeId(int treeId) {
            this.treeId = treeId;
        }

        public int getPageId() {
            return pageId;
        }

        public void setPageId(int pageId) {
            this.pageId = pageId;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public int getOrderNum() {
            return orderNum;
        }

        public void setOrderNum(int orderNum) {
            this.orderNum = orderNum;
        }
    }

    public static class RolesBean {
        /**
         * id : 1
         * code : SUPERADMIN
         * name : 超级管理员
         * remark : 超级管理员
         * isEnable : true
         * collect : true
         * createTime : 1540546495172
         * updateTime : 1548146173402
         */

        private int id;
        private String code;
        private String name;
        private String remark;
        private boolean isEnable;
        private boolean collect;
        private long createTime;
        private long updateTime;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public boolean isIsEnable() {
            return isEnable;
        }

        public void setIsEnable(boolean isEnable) {
            this.isEnable = isEnable;
        }

        public boolean isCollect() {
            return collect;
        }

        public void setCollect(boolean collect) {
            this.collect = collect;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", loginname='" + loginname + '\'' +
                ", loginType='" + loginType + '\'' +
                ", name='" + name + '\'' +
                ", dept=" + dept +
                ", headImg='" + headImg + '\'' +
                ", tel='" + tel + '\'' +
                ", jobNumber='" + jobNumber + '\'' +
                ", collect=" + collect +
                ", analyst=" + analyst +
                ", roles=" + roles +
                '}';
    }
}
