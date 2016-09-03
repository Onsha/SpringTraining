package com.training.spring.bean;

import com.training.spring.bean.log.api.EventType;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by oleksandr
 */
public class Event {
    private String id;
    private String message;
    private Date date;
    private DateFormat dateFormat;
    private EventType type;

    public Event(Date date, DateFormat dateFormat) {
        this.type = EventType.INFO;
        this.date = date;
        this.dateFormat = dateFormat;
    }

    public Event(String id, String message, Date date, DateFormat dateFormat) {
        this.id = id;
        this.message = message;
        this.date = date;
        this.dateFormat = dateFormat;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public DateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public String getFormattedDate(){
        return dateFormat.format(date);
    }

    @Override
    public String toString() {
        return " --- " + type +
                " ---> " + message;
    }
}
