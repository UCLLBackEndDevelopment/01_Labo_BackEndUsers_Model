package demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

class UserTest {

    //given
    private String validNameElke = "Elke";
    private int validAgeElke = 44;
    private String validEmailElke = "elke.steegmans@ucll.be";
    private String validPasswordElke = "ikgahetnietvertellenhoor";

    // //constructor
    // //happy case
    // @Test
    // void givenValidValues_whenCreatingUser_thenUserIsCreatedWithThoseValues() {
    //     //when
    //     User elke = new User(validNameElke, validAgeElke, validEmailElke, validPasswordElke);
    
    //     //then
    //     assertNotNull(elke);
    //     assertEquals(validNameElke, elke.getName());
    //     assertEquals(validAgeElke, elke.getAge());
    //     assertEquals(0, elke.countYearsOfMembership());
    //     assertEquals(validEmailElke, elke.getEmail());
    //     assertEquals("@$-"+validPasswordElke+"&%#", elke.getPassword());        
    // }
    
    // //constructor
    // //unhappy case
    // //invalid negative age
    // @Test
    // void givenInvalidNegativeAge_whenCreatingUser_thenUserIsCreatedWithAge0() {
    //     //when
    //     User elke = new User(validNameElke, -5, validEmailElke, validPasswordElke);
    
    //     //then
    //     assertNotNull(elke);
    //     assertEquals(validNameElke, elke.getName());
    //     assertEquals(0, elke.getAge());
    //     assertEquals(0, elke.countYearsOfMembership());
    //     assertEquals(validEmailElke, elke.getEmail());
    //     assertEquals("@$-"+validPasswordElke+"&%#", elke.getPassword());        
    // }
    
    // //countMembershipYearsAfter1999
    // //happy case
    // @Test
    // void givenUserWithMemberschipYearsAfter1999_whenAskForMembershipYearsAfter1999_thenCorrectNumberIsReturned(){
    //     //given
    //     User elke = new User(validNameElke, validAgeElke, validEmailElke, validPasswordElke);
    //     elke.addMembershipYear(2003);
    //     elke.addMembershipYear(1999);
    //     elke.addMembershipYear(2000);

    //     //when
    //     int result = elke.countMembershipYearsAfter1999();

    //     //then
    //     assertEquals(2, result);
    // }

    // //countMembershipYearsAfter1999
    // //unhappy case
    // //no membership years after 1999
    // @Test
    // void givenUserWithNoMemberschipYearsAfter1999_whenAskForMembershipYearsAfter1999_then0IsReturned(){
    //     //given
    //     User elke = new User(validNameElke, validAgeElke, validEmailElke, validPasswordElke);
    //     elke.addMembershipYear(1999);
    //     elke.addMembershipYear(1978);

    //     //when
    //     int result = elke.countMembershipYearsAfter1999();

    //     //then
    //     assertEquals(0, result);
    // }

    // //constructor
    // //unhappy case
    // //invalid email (no @)
    // //TIP: go to the Java API to the String class and use the method contains
    // @Test
    // void givenInvalidEmail_whenCreatingUser_thenUserIsCreatedWithEmailNull() {
    //     //when
    //     User elke = new User(validNameElke, validAgeElke, "elke.steegmans.ucll.be", validPasswordElke);
    
    //     //then
    //     assertNotNull(elke);
    //     assertEquals(validNameElke, elke.getName());
    //     assertEquals(validAgeElke, elke.getAge());
    //     assertEquals(0, elke.countYearsOfMembership());
    //     assertNull(elke.getEmail());
    //     assertEquals("@$-"+validPasswordElke+"&%#", elke.getPassword());        
    // }

    // //constructor
    // //unhappy case
    // //invalid password (empty string)
    // //TIP: go to the Java API to the String class and use the method isBlank
    // @Test
    // void givenInvalidPassword_whenCreatingUser_thenUserIsCreatedWithDefaultPasswordt() {
    //     //when
    //     User elke = new User(validNameElke, validAgeElke, validEmailElke, "    ");
    
    //     //then
    //     assertNotNull(elke);
    //     assertEquals(validNameElke, elke.getName());
    //     assertEquals(validAgeElke, elke.getAge());
    //     assertEquals(0, elke.countYearsOfMembership());
    //     assertEquals(validEmailElke, elke.getEmail());
    //     assertEquals("@$-t&%#", elke.getPassword());        
    // }

    // //getFirstmembershipYear
    // //happy case
    // //TIP: go to the Java API to the ArrayList class and search for some methods that you can use
    // @Test
    // void givenUserWithMemberschipYears_whenAskForFirstMembershipYear_thenYearTheFarestInThePastIsReturned(){
    //     //given
    //     User elke = new User(validNameElke, validAgeElke, validEmailElke, validPasswordElke);
    //     elke.addMembershipYear(2003);
    //     elke.addMembershipYear(1999);
    //     elke.addMembershipYear(2000);

    //     //when
    //     int firstMembershipYear = elke.getFirstMembershipYear();
    
    //     //then
    //     assertEquals(1999, firstMembershipYear);
    // }
    
    // //getFirstmembershipYear
    // //unhappy case
    // //TIP: go to the Java API to the ArrayList class and search for some methods that you can use
    // //no membership years
    // @Test
    // void givenUserWithNoMemberschipYears_whenAskForFirstMembershipYear_then0IsReturned(){
    //     //given
    //     User elke = new User(validNameElke, validAgeElke, validEmailElke, validPasswordElke);
    
    //     //when
    //     int firstMembershipYear = elke.getFirstMembershipYear();
    
    //     //then
    //     assertEquals(0, firstMembershipYear);
    // }

    // //toString
    // //happy case
    // @Test
    // void givenValidUser_whenToString_thenUserObjectisReturnedInStringRepresentation() {
    //     //given
    //     User elke = new User(validNameElke, validAgeElke, validEmailElke, validPasswordElke);

    //     //when
    //     String result = elke.toString();

    //     //then
    //     assertEquals("Elke is 44 years old and has as email elke.steegmans@ucll.be", result);
    // }

    // //getNumberOfMembershipYearsIn2000
    // //happy case
    // @Test
    // void givenUserWithMemberschipYearsIn2000_whenAskForNumberOfMembershipYearsIn2000_thenCorrectNumberIsReturned(){
    //     //given
    //     User elke = new User(validNameElke, validAgeElke, validEmailElke, validPasswordElke);
    //     elke.addMembershipYear(2003);
    //     elke.addMembershipYear(1999);
    //     elke.addMembershipYear(2000);
    //     elke.addMembershipYear(1978);
    //     elke.addMembershipYear(2023);
        
    //     //when
    //     int numberOfMembershipIn2000 = elke.getNumberOfMembershipYearsIn2000();
    
    //     //then
    //     assertEquals(3, numberOfMembershipIn2000);
    // }


    // //getNumberOfMembershipYearsIn2000
    // //unhappy case
    // @Test
    // void givenUserWithNoMemberschipYearsIn2000_whenAskForNumberOfMembershipYearsIn2000_then0IsReturned(){
    //     //given
    //     User elke = new User(validNameElke, validAgeElke, validEmailElke, validPasswordElke);
    //     elke.addMembershipYear(1980);
    //     elke.addMembershipYear(1999);
    //     elke.addMembershipYear(1978);
    //     elke.addMembershipYear(3000);
        
    //     //when
    //     int numberOfMembershipIn2000 = elke.getNumberOfMembershipYearsIn2000();
    
    //     //then
    //     assertEquals(0, numberOfMembershipIn2000);
    // }

    // //isPasswordCorrect
    // //happy case
    // // @Test
    // void givenValidUser_whenCheckingPasswordWithCorrectPassword_thenTrueIsReturned (){
    //     //given
    //     User elke = new User(validNameElke, validAgeElke, validEmailElke, validPasswordElke);

    //     //when
    //     boolean correctPassword = elke.isPasswordCorrect("ikgahetnietvertellenhoor");

    //     //then
    //     assertTrue(correctPassword);
    // }

    // //isPasswordCorrect
    // //unhappy case
    // @Test
    // void givenValidUser_whenCheckingPasswordWithIncorrectPassword_thenFalseIsReturned (){
    //     //given
    //     User elke = new User(validNameElke, validAgeElke, validEmailElke, validPasswordElke);
    
    //     //when
    //     boolean correctPassword = elke.isPasswordCorrect("rararaaikgahet");
    
    //     //then
    //     assertFalse(correctPassword);
    // }

}