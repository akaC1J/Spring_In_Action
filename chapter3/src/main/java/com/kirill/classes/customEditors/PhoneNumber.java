package com.kirill.classes.customEditors;

public class PhoneNumber {
    private String areaCode;
    private String prefix;
    private String number;
    public PhoneNumber() { }
    public PhoneNumber(String areaCode, String prefix,
                       String number) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.number = number;
    }

    @Override
    public String toString() {
        return areaCode+prefix+number;
    }
}
