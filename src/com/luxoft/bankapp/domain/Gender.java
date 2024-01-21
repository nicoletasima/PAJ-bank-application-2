package com.luxoft.bankapp.domain;

public enum Gender {
	MALE("Mr.", "m"), FEMALE("Ms.", "f");

	// task3 - make field greeting final
    private final String greeting;
	// task - make field stringLine final
    private final String stringLine;

	private Gender(String greeting, String stringLine) {
        this.greeting = greeting;
        this.stringLine = stringLine;
    }

	public String getGreeting() {
		return greeting;
	}
	
	 public static Gender parse(String stringLine) {
        for (Gender gender: values()) {
            if (stringLine.equals(gender.stringLine)) {
                return gender;
            }
        }
        return null;
    }
}
