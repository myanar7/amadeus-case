package com.mustafayanar.amadeus.model;

public class DateTime {
    
    private Integer day;
    private Integer month;
    private Integer year;
    private Integer hour;
    private Integer minute;

    public DateTime() {
    }

    public Integer getDay() {
        return day;
    }

    public Integer getMonth() {
        return month;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getHour() {
        return hour;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public String toString() {
        return "DateTime{" +
                "day='" + day + '\'' +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                ", hour='" + hour + '\'' +
                ", minute='" + minute + '\'' +
                '}';
    }

    @Override 
    public boolean equals (Object obj) {
        if (obj instanceof DateTime) {
            DateTime dateTime = (DateTime) obj;
            return this.day.equals(dateTime.getDay()) && this.month.equals(dateTime.getMonth()) && this.year.equals(dateTime.getYear()) && this.hour.equals(dateTime.getHour()) && this.minute.equals(dateTime.getMinute());
        }
        return false;
    }
}