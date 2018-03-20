package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eTitle;

public class Staff_Test {
	
	private static ArrayList<Staff> LOI = new ArrayList<Staff>();

	@SuppressWarnings("deprecation")
	@BeforeClass
	public static void setup() throws PersonException 
	{
		Staff Brendan = new Staff("Brendan", "James", "Azueta", new Date(1999, 1, 21), "111 Raymond Street",
				"(516)-111-1111", "bazueta@udel.edu", "Sunday 4-5", 2, 500000, new Date(2018, 9, 15), eTitle.MR);
		
		Staff Marc = new Staff("Marc", "Anthony", "Marasco", new Date(1999, 7, 9), "222 Raymond Street",
				"(516)-222-2222", "ellioth4321@gmail.com", "Tuesday 2-3", 3, 333333, new Date(2008, 3, 14), eTitle.MR);
		
		Staff Kenneth = new Staff("Kenneth", "Thomas", "Hoefer", new Date(1999, 8, 18), "333 Raymond Street",
				"(516)-333-3333", "hugh@gmail.com", "Friday 12 - 1", 2, 666666, new Date(2005, 1, 14), eTitle.MR);
		
		Staff Trevor = new Staff("Trevor", "Allen", "McNally", new Date(1999, 2, 24), "444 Raymond Street",
				"(516)-444-4444", "kate@gmail.com", "Monday 10 - 11", 1, 100000, new Date(2008, 3, 14), eTitle.MR);
		
		Staff Sean = new Staff("Sean", "Patrick", "Byrne", new Date(1999, 4, 16), "555 Raymond Street",
				"(516)-555-5555", "foxmulder@fbi.com", "Monday 3 - 4", 3, 400000, new Date(1993, 3, 14), eTitle.MR);
		
		LOI.add(Brendan);
		LOI.add(Marc);
		LOI.add(Kenneth);
		LOI.add(Trevor);
		LOI.add(Sean);
	}
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		double money = 0.0;
		for(Staff i : LOI)
		{
			money+=i.getSalary();
		}
		money/=5;
		assertEquals(money,399999.8,.1);
		
		boolean exception1 = false;
		try
		{
			Staff Baz = new Staff("Baz", "James", "Baz", new Date(1900, 1, 1), "1400 Bazian Lane",
					"(666)-141-4141", "BazGuy@hotmail.com", "Tuesday 12-3", 2, 400000, new Date(2018, 1, 21), eTitle.MR);
		}
		catch(PersonException e)
		{
			exception1 = true;
		}
		assertTrue(exception1);
		
		boolean exception2 = false;
		try
		{
			Staff Baz = new Staff("Baz", "James", "Baz", new Date(1999, 1, 21), "1400 Bazian Lane",
					"(666)-141-141", "BazGuy@hotmail.com", "Tuesday 12-3", 2, 400000, new Date(2018, 1, 21), eTitle.MR);
		}
		catch(PersonException e)
		{
			exception2 = true;
		}
		assertTrue(exception2);
	}	
	
}
