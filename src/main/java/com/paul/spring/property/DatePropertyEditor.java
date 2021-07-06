package com.paul.spring.property;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePropertyEditor extends PropertyEditorSupport {

    private String format = "yyyy-MM-dd HH:mm:ss";

    private SimpleDateFormat dateFormat = new SimpleDateFormat(format);

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            Date parse = dateFormat.parse(text);
            this.setValue(parse);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new IllegalArgumentException(e);
        }
    }
}
