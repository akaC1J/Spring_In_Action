package com.kirill.classes.customEditors;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;

public class PhoneEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String stripped = stripNonNumeric(text);
        String areaCode = stripped.substring(0,3);
        String prefix = stripped.substring(3,6);
        String number = stripped.substring(6);
        PhoneNumber phone = new PhoneNumber(areaCode, prefix, number);
        setValue(phone);
    }

    private String stripNonNumeric(String original){
        StringBuilder allNumeric = new StringBuilder();
        for(int i=0; i<original.length(); i++) {
            char c = original.charAt(i);
            if(Character.isDigit(c)) {
                allNumeric.append(c);
            }
        }
        return allNumeric.toString();
    }


}
