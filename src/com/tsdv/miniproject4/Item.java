package com.tsdv.miniproject4;

public class Item {
    private String key;
    private StaffInfo staffInfo;

    public Item(String key, StaffInfo staffInfo) {
        this.key = key;
        this.staffInfo = staffInfo;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public StaffInfo getStaffInfo() {
        return staffInfo;
    }

    public void setStaffInfo(StaffInfo staffInfo) {
        this.staffInfo = staffInfo;
    }
}
