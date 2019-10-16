package com.fynnjason.fjokgo.bean;

import java.util.List;


public class StaffDetailBean extends BaseBean {

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {

        private String reserved1;
        private int id;
        private String userName;
        private String realName;
        private int departmentId;
        private String position;
        private double commissionAmount;
        private double score;
        private List<?> ownTags;
        private List<DepartmentTagsBean> departmentTags;
        private List<?> ownPrivileges;
        private List<DepartmentPrivilegesBean> departmentPrivileges;
        private List<?> departmentPermissions;
        private List<PersonnelPermissionsBean> personnelPermissions;

        public String getReserved1() {
            return reserved1;
        }

        public void setReserved1(String reserved1) {
            this.reserved1 = reserved1;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public int getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(int departmentId) {
            this.departmentId = departmentId;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public double getCommissionAmount() {
            return commissionAmount;
        }

        public void setCommissionAmount(double commissionAmount) {
            this.commissionAmount = commissionAmount;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public List<?> getOwnTags() {
            return ownTags;
        }

        public void setOwnTags(List<?> ownTags) {
            this.ownTags = ownTags;
        }

        public List<DepartmentTagsBean> getDepartmentTags() {
            return departmentTags;
        }

        public void setDepartmentTags(List<DepartmentTagsBean> departmentTags) {
            this.departmentTags = departmentTags;
        }

        public List<?> getOwnPrivileges() {
            return ownPrivileges;
        }

        public void setOwnPrivileges(List<?> ownPrivileges) {
            this.ownPrivileges = ownPrivileges;
        }

        public List<DepartmentPrivilegesBean> getDepartmentPrivileges() {
            return departmentPrivileges;
        }

        public void setDepartmentPrivileges(List<DepartmentPrivilegesBean> departmentPrivileges) {
            this.departmentPrivileges = departmentPrivileges;
        }

        public List<?> getDepartmentPermissions() {
            return departmentPermissions;
        }

        public void setDepartmentPermissions(List<?> departmentPermissions) {
            this.departmentPermissions = departmentPermissions;
        }

        public List<PersonnelPermissionsBean> getPersonnelPermissions() {
            return personnelPermissions;
        }

        public void setPersonnelPermissions(List<PersonnelPermissionsBean> personnelPermissions) {
            this.personnelPermissions = personnelPermissions;
        }

        public static class DepartmentTagsBean {


            private int id;
            private String name;
            private String type;

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
        }

        public static class DepartmentPrivilegesBean {


            private int id;
            private String name;

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
        }

        public static class PersonnelPermissionsBean {

            private int id;
            private int staffId;
            private String type;
            private String checkType;
            private int targetId;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getStaffId() {
                return staffId;
            }

            public void setStaffId(int staffId) {
                this.staffId = staffId;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getCheckType() {
                return checkType;
            }

            public void setCheckType(String checkType) {
                this.checkType = checkType;
            }

            public int getTargetId() {
                return targetId;
            }

            public void setTargetId(int targetId) {
                this.targetId = targetId;
            }
        }
    }
}
