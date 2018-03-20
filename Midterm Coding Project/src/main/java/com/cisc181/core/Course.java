package com.cisc181.core;

import java.util.*;
import com.cisc181.eNums.eMajor;

public class Course {
	
	public UUID CourseID;
	public String CourseName;
	public int GradePoints;
	private eMajor eMajor;
	
	public Course() {}
	
	public Course(UUID courseID, String courseName, int gradePoints, com.cisc181.eNums.eMajor eMajor) {
		this.CourseID = courseID;
		this.CourseName = courseName;
		this.GradePoints = gradePoints;
		this.eMajor = eMajor;
	}

	public UUID getCourseID() {
		return CourseID;
	}

	public void setCourseID(UUID courseID) {
		CourseID = courseID;
	}

	public String getCourseName() {
		return CourseName;
	}

	public void setCourseName(String courseName) {
		CourseName = courseName;
	}

	public int getGradePoints()
	{
		return GradePoints;
	}

	public void setGradePoints(int gradePoints) {
		GradePoints = gradePoints;
	}

	public eMajor geteMajor() {
		return eMajor;
	}

	public void seteMajor(eMajor eMajor) {
		this.eMajor = eMajor;
	}
	
}
