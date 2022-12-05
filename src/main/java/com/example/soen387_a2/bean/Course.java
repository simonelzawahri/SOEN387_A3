package com.example.soen387_a2.bean;

import java.io.Serializable;

public class Course implements Serializable{


    //private static final long serialVersionUID = 1;
    private int code;
    private String title;
    private String semester;
    private String days;
    private String time;
    private String instructor;
    private String room;
    private String startDate;
    private String endDate;
    private int instructorId;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public String toString() {
        return "Course{" +
                "code=" + code +
                ", title='" + title + '\'' +
                ", semester=" + semester +
                ", days=" + days +
                ", time='" + time + '\'' +
                ", instructor='" + instructor + '\'' +
                ", room='" + room + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", instructorId=" + instructorId +
                '}';
    }
}