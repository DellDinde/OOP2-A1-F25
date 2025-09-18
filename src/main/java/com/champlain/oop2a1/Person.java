package com.champlain.oop2a1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person {

    private final String aName;
    private final LocalDate aDOB;
    private final String aEmail;
    private boolean aPurchasedPass = true;
    private List<Person> aPerson = new ArrayList<Person>();

    public Person(String pName, LocalDate pDOB, String pEmail) {
        if(pName.isBlank()){
            throw new IllegalArgumentException("Person name is not valid!");
        }
        else if(pDOB.isAfter(LocalDate.now())){
            throw new IllegalArgumentException("Person DOB is not valid!");
        }
        else if(pEmail.isBlank() || !pEmail.contains("@")){
            throw new IllegalArgumentException("Person Email is not valid!");
        }
        this.aName = pName;
        this.aDOB = pDOB;
        this.aEmail = pEmail;
        saveAPerson();
    }
    private void saveAPerson(){
        aPerson.add(new Person(this.aName, this.aDOB, this.aEmail));
    }
    public boolean purchaseParkingPass() {
        for (Person person : this.aPerson) {
            if (person.toString().equals(this.aName)) {
                return false;
            }
        }
        return this.aPurchasedPass;
    }

    public String getName() {
        String name;
        name = this.aName;
        return name;
    }

    public LocalDate getDOB() {
        LocalDate dob;
        dob = aDOB;
        return dob;
    }

    public String getEmailAddress() {
        String email;
        email = this.aEmail;
        return email;
    }

    public boolean isPurchasedParkingPass() {
        return purchaseParkingPass();
    }
}
