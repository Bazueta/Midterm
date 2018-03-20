package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import com.cisc181.eNums.eMajor;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.UUID;

public class Student_Test {
	private static ArrayList<Course> cors = new ArrayList<Course>();
	private static ArrayList<Semester> sems = new ArrayList<Semester>();
	private static ArrayList<Section> sects = new ArrayList<Section>();
	private static ArrayList<Student> studs = new ArrayList<Student>();
	private static ArrayList<Enrollment> enrollments = new ArrayList<Enrollment>();
	
	
	@BeforeClass
	public static void setup() throws PersonException {
		final UUID ciscUUID = UUID.randomUUID();
		final UUID physUUID = UUID.randomUUID();
		final UUID chemUUID = UUID.randomUUID();
		cors.add(new Course(ciscUUID, "CISC181", 4, eMajor.COMPSI));
		cors.add(new Course(physUUID, "PHYS207", 4, eMajor.PHYSICS));
		cors.add(new Course(chemUUID, "CHEM103", 4, eMajor.CHEM));
		final UUID fall = UUID.randomUUID();
		final UUID spring = UUID.randomUUID();
		sems.add(new Semester(fall, new Date(2017, 8, 29), new Date(2017, 12, 17)));
		sems.add(new Semester(spring, new Date(2018, 2, 5), new Date(2018, 5, 24)));
		int room = 200;
		for(Semester s: sems)
		{
			for(Course c: cors)
			{
				sects.add(new Section(c.getCourseID(), s.getSemesterID(), UUID.randomUUID(), room));
				room += 2;
			}
		}
		
		studs.add(new Student("Brendan", "James", "Azueta", new Date(1999, 1, 21), eMajor.COMPSI,
				"238 Raymond Street", "(516)-502-8926", "bazueta@udel.edu"));
		studs.add(new Student("Marc", "James", "Marasco", new Date(1999, 1, 23), eMajor.COMPSI,
				"245 Raymond Street", "(516)-503-8926", "bazueta@udel.edu"));
		studs.add(new Student("Jack", "Andrew", "Azueta", new Date(1999, 1, 25), eMajor.COMPSI,
				"288 Raymond Street", "(516)-504-8926", "bazueta@udel.edu"));
		studs.add(new Student("Trevor", "James", "McNally", new Date(1999, 1, 26), eMajor.COMPSI,
				"224 Raymond Street", "(516)-505-8926", "bazueta@udel.edu"));
		studs.add(new Student("Sean", "James", "Bryne", new Date(1999, 1, 27), eMajor.COMPSI,
				"274 Raymond Street", "(516)-506-8926", "bazueta@udel.edu"));
		studs.add(new Student("Emily", "Tess", "Azueta", new Date(1999, 1, 28), eMajor.COMPSI,
				"253 Raymond Street", "(516)-507-8926", "bazueta@udel.edu"));
		studs.add(new Student("Kenny", "James", "Hoefer", new Date(1999, 1, 29), eMajor.COMPSI,
				"231 Raymond Street", "(516)-508-8926", "bazueta@udel.edu"));
		studs.add(new Student("Ryan", "James", "D'Accordo", new Date(1999, 1, 12), eMajor.COMPSI,
				"235 Raymond Street", "(516)-509-8926", "bazueta@udel.edu"));
		studs.add(new Student("Alex", "James", "Bruno", new Date(1999, 1, 15), eMajor.COMPSI,
				"233 Raymond Street", "(516)-510-8926", "bazueta@udel.edu"));
		studs.add(new Student("Ken", "James", "Pan", new Date(1999, 1, 19), eMajor.COMPSI,
				"69 Trap Street", "(516)-511-8926", "bazueta@udel.edu"));
		
		for(Student s : studs)
		{
			for(Section se : sects)
			{
				enrollments.add(new Enrollment(s.getStudentID(), se.getSectionID()));
			}
		}
		for(Enrollment e : enrollments)
		{
			e.setGrade(90.0);
		}

	}
		

	@Test
	public void test() {
	double TotalCredits = 0.0;
	double TotalEarned = 0.0;
	
	for(Enrollment e : enrollments)
	{
		for(Course c: cors) 
		{
			TotalEarned += c.getGradePoints() * e.getGrade();
			TotalCredits += c.getGradePoints();

		}
	}
	assertEquals((TotalEarned/TotalCredits), 90.0, .1);
	
	double TotalStudents = 0.0;
	double TotalGrades = 0.0;
	
	for(Enrollment e: enrollments)
	{
		TotalStudents += 1;
		TotalGrades += e.getGrade();
	}
	assertEquals((TotalGrades/TotalStudents), 90.0, .1);
	}
}



