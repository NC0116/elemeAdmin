package com.neusoft.domin;

public class Admin {
    private Integer adminId;
    private String adminName;
    private String possWord;

    public Admin() {
    }

    public Admin(Integer adminId, String adminName, String possWord) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.possWord = possWord;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPossWord() {
        return possWord;
    }

    public void setPossWord(String possWord) {
        this.possWord = possWord;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                ", possWord='" + possWord + '\'' +
                '}';
    }
}
