package com.cisc181.core;
import java.util.*;


public class PersonException extends Exception {
	private Person Person;
	public PersonException(Person Person)
	{
		this.Person = Person;
	}
}
