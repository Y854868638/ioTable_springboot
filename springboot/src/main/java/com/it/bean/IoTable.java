package com.it.bean;

public class IoTable {
    private  String Tag;
    private  String Describe;
    private  String Type;
    private  String IoAdd;
    private  String Remark;

    public String getTag() {
        return Tag;
    }

    public void setTag(String tag) {
        Tag = tag;
    }

    public String getDescribe() {
        return Describe;
    }

    public void setDescribe(String describe) {
        Describe = describe;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getIoAdd() {
        return IoAdd;
    }

    public void setIoAdd(String ioAdd) {
        IoAdd = ioAdd;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    @Override
    public String toString() {
        return "IoTabel{" +
                "Tag='" + Tag + '\'' +
                ", Describe='" + Describe + '\'' +
                ", Type='" + Type + '\'' +
                ", IoAdd='" + IoAdd + '\'' +
                ", Remark='" + Remark + '\'' +
                '}';
    }
}
