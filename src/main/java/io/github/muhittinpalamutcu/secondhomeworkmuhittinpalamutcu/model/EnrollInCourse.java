package io.github.muhittinpalamutcu.secondhomeworkmuhittinpalamutcu.model;

public class EnrollInCourse {
    private int id;
    private String courseCode;

    public EnrollInCourse(int id, String courseCode) {
        this.id = id;
        this.courseCode = courseCode;
    }

    public EnrollInCourse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
