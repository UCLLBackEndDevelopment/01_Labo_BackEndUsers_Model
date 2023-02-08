package model;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class UserTest {

    //given
    private String validNameElke = "Elke";
    private int validAgeElke = 44;
    private double validLengthElke = 1.66;
    private String validEmailElke = "elke.steegmans@ucll.be";

    @Test
    void givenValidNameAgeEmailAndLength_whenCreatingUser_thenUserIsCreatedWithThatNameAgeEmailAndLength() {
        //when
        User elke = new User(validNameElke, validAgeElke, validEmailElke, validLengthElke);

        //then
        assertNotNull(elke);
        assertEquals(validNameElke, elke.getName());
        assertEquals(validAgeElke, elke.getAge());
        assertEquals(validEmailElke, elke.getEmail());
        assertEquals(validLengthElke, elke.getLength());
    }

    @Test
    void givenValidNameEmailAndLengthAndInvalidNegativeAge_whenCreatingUser_thenUserIsCreatedWithThatNameEmailAndLengthAndAge0() {
        //when
        User elke = new User(validNameElke, -5, validEmailElke, validLengthElke);

        //then
        assertNotNull(elke);
        assertEquals(validNameElke, elke.getName());
        assertEquals(0, elke.getAge());
        assertEquals(validEmailElke, elke.getEmail());
        assertEquals(validLengthElke, elke.getLength());
    }

    @Test
    void givenValidNameEmailAndAgeAndInvalidNegativeLength_whenCreatingUser_thenUserIsCreatedWithThatNameEmailAndAgeAndLength31cm() {
        //when
        User elke = new User(validNameElke, validAgeElke, validEmailElke, -0.50);

        //then
        assertNotNull(elke);
        assertEquals(validNameElke, elke.getName());
        assertEquals(validAgeElke, elke.getAge());
        assertEquals(validEmailElke, elke.getEmail());
        assertEquals(0.31, elke.getLength());
    }

    @Test
    void givenValidNameEmailAndAgeAndInvalidLength30cm_whenCreatingUser_thenUserIsCreatedWithThatNameEmailAndAgeAndLength31cm() {
        //when
        User elke = new User(validNameElke, validAgeElke, validEmailElke, 0.30);

        //then
        assertNotNull(elke);
        assertEquals(validNameElke, elke.getName());
        assertEquals(validAgeElke, elke.getAge());
        assertEquals(validEmailElke, elke.getEmail());
        assertEquals(0.31, elke.getLength());
    }

    @Test
    void givenValidAgeEmailAndLengthAndInvalidEmptyName_whenCreatingUser_thenUserIsCreatedWithThatAgeEmailAndLengthAndNameAnonymous() {
        //when
        User elke = new User("", validAgeElke, validEmailElke, validLengthElke);

        //then
        assertNotNull(elke);
        assertEquals("anonymous", elke.getName());
        assertEquals(validAgeElke, elke.getAge());
        assertEquals(validEmailElke, elke.getEmail());
        assertEquals(validLengthElke, elke.getLength());
    }

    @Test
    void givenValidAgeEmailAndLengthAndInvalidNameNullValue_whenCreatingUser_thenUserIsCreatedWithThatAgeEmailAndLengthAndNameAnonymous() {
        //when
        User elke = new User(null, validAgeElke, validEmailElke, validLengthElke);

        //then
        assertNotNull(elke);
        assertEquals("anonymous", elke.getName());
        assertEquals(validAgeElke, elke.getAge());
        assertEquals(validEmailElke, elke.getEmail());
        assertEquals(validLengthElke, elke.getLength());
    }

    @Test
    void givenValidNameAgeAndLengthAndInvalidEmptyEmail_whenCreatingUser_thenUserIsCreatedWithThatNameAgeAndLengthAndDefaultEmail() {
        //when
        User elke = new User(validNameElke, validAgeElke, "", validLengthElke);

        //then
        assertNotNull(elke);
        assertEquals(validNameElke, elke.getName());
        assertEquals(validAgeElke, elke.getAge());
        assertEquals("support@ucll.be", elke.getEmail());
        assertEquals(validLengthElke, elke.getLength());
    }

    @Test
    void givenValidNameAgeAndLengthAndInvalidEmailNullValue_whenCreatingUser_thenUserIsCreatedWithThatNameAgeAndLengthAndDefaultEmail() {
        //when
        User elke = new User(validNameElke, validAgeElke, null, validLengthElke);

        //then
        assertNotNull(elke);
        assertEquals(validNameElke, elke.getName());
        assertEquals(validAgeElke, elke.getAge());
        assertEquals("support@ucll.be", elke.getEmail());
        assertEquals(validLengthElke, elke.getLength());
    }

    @Test
    void givenValidUser_whenChangingAgeToNewValidAge_thenAgeOfThisUserIsChangedToNewAge() {
        //given
        User elke = new User(validNameElke, validAgeElke, validEmailElke, validLengthElke);

        //when
        elke.setAge(6);

        //then
        assertEquals(validNameElke, elke.getName());
        assertEquals(6, elke.getAge());
        assertEquals(validEmailElke, elke.getEmail());
        assertEquals(validLengthElke, elke.getLength());
    }

    @Test
    void givenValidUser_whenChangingAgeToInvalidNegativeAge_thenAgeOfThisUserIsNotChanged() {
        //given
        User elke = new User(validNameElke, validAgeElke, validEmailElke, validLengthElke);

        //when
        elke.setAge(-9);

        //then
        assertEquals(validNameElke, elke.getName());
        assertEquals(validAgeElke, elke.getAge());
        assertEquals(validEmailElke, elke.getEmail());
        assertEquals(validLengthElke, elke.getLength());
    }

    @Test
    void givenValidUser_whenChangingAgeToAge0_thenAgeOfThisUserIsChangedTo0() {
        //given
        User elke = new User(validNameElke, validAgeElke, validEmailElke, validLengthElke);

        //when
        elke.setAge(0);

        //then
        assertEquals(validNameElke, elke.getName());
        assertEquals(0, elke.getAge());
        assertEquals(validEmailElke, elke.getEmail());
        assertEquals(validLengthElke, elke.getLength());
    }

    @Test
    void givenValidUser_whenChangingLengthToNewValidLength_thenAgeOfThisUserIsChangedToNewLength() {
        //given
        User elke = new User(validNameElke, validAgeElke, validEmailElke, validLengthElke);

        //when
        elke.setLength(1.70);

        //then
        assertEquals(validNameElke, elke.getName());
        assertEquals(validAgeElke, elke.getAge());
        assertEquals(validEmailElke, elke.getEmail());
        assertEquals(1.70, elke.getLength());
    }

    @Test
    void givenValidUser_whenChangingAgeToInvalidNegativeLength_thenLengthOfThisUserIsNotChanged() {
        //given
        User elke = new User(validNameElke, validAgeElke, validEmailElke, validLengthElke);

        //when
        elke.setLength(-1.65);;

        //then
        assertEquals(validNameElke, elke.getName());
        assertEquals(validAgeElke, elke.getAge());
        assertEquals(validEmailElke, elke.getEmail());
        assertEquals(validLengthElke, elke.getLength());
    }

    @Test
    void givenValidUser_whenChangingLengthToLength31cm_thenLengthOfThisUserIsChangedTo0() {
        //given
        User elke = new User(validNameElke, validAgeElke, validEmailElke, validLengthElke);

        //when
        elke.setLength(0.31);

        //then
        assertEquals(validNameElke, elke.getName());
        assertEquals(validAgeElke, elke.getAge());
        assertEquals(validEmailElke, elke.getEmail());
        assertEquals(0.31, elke.getLength());
    }

    @Test
    void givenValidUser_whenChangingAgeToInvalidLength30cm_thenLengthOfThisUserIsNotChanged() {
        //given
        User elke = new User(validNameElke, validAgeElke, validEmailElke, validLengthElke);

        //when
        elke.setLength(0.30);;

        //then
        assertEquals(validNameElke, elke.getName());
        assertEquals(validAgeElke, elke.getAge());
        assertEquals(validEmailElke, elke.getEmail());
        assertEquals(validLengthElke, elke.getLength());
    }

    @Test
    void givenValidUser_whenChangingNameToNewValidName_thenNameOfThisUserIsChangedToNewName() {
        //given
        User elke = new User(validNameElke, validAgeElke, validEmailElke, validLengthElke);

        //when
        elke.setName("Els");

        //then
        assertEquals("Els", elke.getName());
        assertEquals(validAgeElke, elke.getAge());
        assertEquals(validEmailElke, elke.getEmail());
        assertEquals(validLengthElke, elke.getLength());
    }

    @Test
    void givenValidUser_whenChangingNameToInvalidNameEmptyString_thenNameOfThisUserIsNotChanged() {
        //given
        User elke = new User(validNameElke, validAgeElke, validEmailElke, validLengthElke);

        //when
        elke.setName("   ");

        //then
        assertEquals(validNameElke, elke.getName());
        assertEquals(validAgeElke, elke.getAge());
        assertEquals(validEmailElke, elke.getEmail());
        assertEquals(validLengthElke, elke.getLength());
    }

    @Test
    void givenValidUser_whenChangingNameToInvalidNameNullValue_thenNameOfThisUserIsNotChanged() {
        //given
        User elke = new User(validNameElke, validAgeElke, validEmailElke, validLengthElke);

        //when
        elke.setName(null);

        //then
        assertEquals(validNameElke, elke.getName());
        assertEquals(validAgeElke, elke.getAge());
        assertEquals(validEmailElke, elke.getEmail());
        assertEquals(validLengthElke, elke.getLength());
    }

    @Test
    void givenValidUser_whenChangingEmailToNewValidEmail_thenNameOfThisUserIsChangedToNewEmail() {
        //given
        User elke = new User(validNameElke, validAgeElke, validEmailElke, validLengthElke);

        //when
        elke.setEmail("elke@ucll.be");

        //then
        assertEquals(validNameElke, elke.getName());
        assertEquals(validAgeElke, elke.getAge());
        assertEquals("elke@ucll.be", elke.getEmail());
        assertEquals(validLengthElke, elke.getLength());
    }

    @Test
    void givenValidUser_whenChangingEmailToInvalidEmailEmptyString_thenEmailOfThisUserIsNotChanged() {
        //given
        User elke = new User(validNameElke, validAgeElke, validEmailElke, validLengthElke);

        //when
        elke.setEmail("  ");

        //then
        assertEquals(validNameElke, elke.getName());
        assertEquals(validAgeElke, elke.getAge());
        assertEquals(validEmailElke, elke.getEmail());
        assertEquals(validLengthElke, elke.getLength());
    }

    @Test
    void givenValidUser_whenChangingEmailToInvalidemailNullValue_thenEmailOfThisUserIsNotChanged() {
        //given
        User elke = new User(validNameElke, validAgeElke, validEmailElke, validLengthElke);

        //when
        elke.setEmail(null);

        //then
        assertEquals(validNameElke, elke.getName());
        assertEquals(validAgeElke, elke.getAge());
        assertEquals(validEmailElke, elke.getEmail());
        assertEquals(validLengthElke, elke.getLength());
    }

    @Test
    void givenValidUser_whenToString_thenNameAndAgeIsGivenInStringRepresentation() {
        //given
        User elke = new User(validNameElke, validAgeElke, validEmailElke, validLengthElke);

        //when
        String result = elke.toString();

        //then
        assertEquals(result, "Elke is 44 years old");
    }

    @Test
    void givenValidUser_whenGrowWithPositiveCentimeters_thenUserHasNewLength() {
        //given
        User elke = new User(validNameElke, validAgeElke, validEmailElke, validLengthElke);

        //when
        double result = elke.grow(2);

        //then
        assertEquals(1.68, result);
        assertEquals(1.68, elke.getLength());
        assertEquals(validNameElke, elke.getName());
        assertEquals(validAgeElke, elke.getAge());
        assertEquals(validEmailElke, elke.getEmail());
    }

    @Test
    void givenValidUser_whenGrowWithNegativeCentimeters_thenUserHasSameLength() {
        //given
        User elke = new User(validNameElke, validAgeElke, validEmailElke, validLengthElke);

        //when
        double result = elke.grow(-2);

        //then
        assertEquals(1.66, result);
        assertEquals(validNameElke, elke.getName());
        assertEquals(validAgeElke, elke.getAge());
        assertEquals(validEmailElke, elke.getEmail());
        assertEquals(validLengthElke, elke.getLength());
    }
}