package com.champlain.oop2a1;

import java.time.LocalDate;

public class Person {

    private final String aName;
    private final LocalDate aDOB;
    private final String aEmail;
    private boolean aPurchasedPass = false;

    public Person(String pName, LocalDate pDOB, String pEmail) {
        if(pName.isBlank()){
            throw new IllegalArgumentException("Your name is not valid!");
        }
        else if(pDOB == null || pDOB.toString().isEmpty() || pDOB.isAfter(LocalDate.now()) ){
            throw new IllegalArgumentException("Your Date of Birth is not valid!");
        }
        else if(pEmail.isBlank() || !pEmail.contains("@") || !pEmail.contains(".")){
            throw new IllegalArgumentException("Your Email is not valid!");
        }
        this.aName = pName;
        this.aDOB = pDOB;
        this.aEmail = pEmail;
    }

    public boolean purchaseParkingPass() {
       if(!isPurchasedParkingPass()){
           this.aPurchasedPass = true;
           return true;
       }
       return false;
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
            return this.aPurchasedPass;
    }
}
