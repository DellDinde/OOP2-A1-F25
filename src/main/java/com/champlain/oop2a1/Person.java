package com.champlain.oop2a1;

import java.time.LocalDate;

/**
 * The {@code Person} class <i>stores and validates</i> the information of the user
 *That means it does not work alone hence will need other classes for user input.
 * <p>
 * This can be checked by loading the sample data from {@link PersonViewController}
 * </p>
 * <blockquote><pre>
 *      this.aPerson = new Person("John Doe", LocalDate.of(2000, 1, 1), "john@gmail.com");
 * </pre></blockquote>
 *
 *<p>
 *     It also checks whether the person has parking pass or not.
 *</p>
 * */

public final class Person {

    /**
     * {@code String} to store the Person's Name
     * */
    private final String aName;

    /**
     * {@code LocalDate} to store the Person's date of birth
     * */
    private final LocalDate aDOB;

    /**
     * {@code String} to store the Person's email address
     * */
    private final String aEmail;

    /**
     * {@code boolean} to store the Person's parking pass status
     * */
    private boolean aPurchasedPass = false;

    /**
     * Initializes newly created <i>Persons</i> by accepting the details through the following parameters
     * <p>Also does the input validation of each parameter. Then assigns them to the corresponding <b>attributes</b> </p>
     * @param pName to store the passed value of the Person's Name
     * @param pDOB  to store the passed value of the Person's date of birth
     * @param pEmail to store the passed value of the Person's Email address
     * @throws IllegalArgumentException when an invalid value is passed
     */
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

    /**
     * Checks if the current instance of a Person has a parking pass.
     * @return {@code true} if the Person has no parking pass and {@code false} if they do.
     */
    public boolean purchaseParkingPass() {
       if(!isPurchasedParkingPass()){
           this.aPurchasedPass = true;
           return true;
       }
       return false;
    }

    /**
     * Gets the Person's Name from the attribute {@code aName}
     * @return a copy of {@code aName}
     */
    public String getName() {
        String name;
        name = this.aName;
        return name;
    }

    /**
     * Gets the Person's Date of Birth from the attribute {@code aDOB}
     * @return a copy of {@code aDOB}
     */
    public LocalDate getDOB() {
        LocalDate dob;
        dob = aDOB;
        return dob;
    }

    /**
     * Gets the Person's Email Address from the attribute {@code aEmail}
     * @return a copy of {@code aEmail}
     */
    public String getEmailAddress() {
        String email;
        email = this.aEmail;
        return email;
    }

    /**
     * To check the parking pass status of a Person
     * @return the attribute {@code aPurchasedParkingPass}, that is, the parking pass status of a Person
     */
    public boolean isPurchasedParkingPass() {
        return this.aPurchasedPass;
    }
}