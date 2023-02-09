package demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    //given
    UserService serviceWithUsers = new UserService();
    
    User elke = new User("Elke", 44, "elke@ucll.be", 1.66);
    User miyo = new User("Miyo", 15, "miyo@ucll.be", 1.67);
    User eric = new User("Eric", 65, "eric@kuleuven.be", 1.81);
    User yuki = new User("Yuki", 13, "yuki@ucll.be", 1.71);
    User stijn = new User("Stijn", 45, "stijn@ucll.be", 1.80);

    UserService serviceWithoutUsers = new UserService();

    @BeforeEach
    void setUp() {
        //given
        serviceWithUsers.addUser(elke);
        serviceWithUsers.addUser(miyo);
        serviceWithUsers.addUser(eric);
        serviceWithUsers.addUser(yuki);
    }

    @Test
    void given4Users_whenNewUserWithNotAlreadyUsedEmailIsAdded_thenUserIsAdded() {
        //given
        assertEquals(4, serviceWithUsers.getAllUsers().size());

        //when
        boolean added = serviceWithUsers.addUser(stijn);

        //then
        assertTrue(added);
        assertEquals(5, serviceWithUsers.getAllUsers().size());
        assertTrue(serviceWithUsers.getAllUsers().contains(stijn));
        assertTrue(serviceWithUsers.getAllUsers().contains(elke));
    }

    @Test
    void given4Users_whenNewUserWithAlreadyUsedEmailIsAdded_thenUserIsNotAdded() {
        //given
        assertEquals(4, serviceWithUsers.getAllUsers().size());

        //when
        User otherElke = new User("Elke", 20, "Elke@ucll.be", 1.50);
        boolean added = serviceWithUsers.addUser(otherElke);

        //then
        assertFalse(added);
        assertEquals(4, serviceWithUsers.getAllUsers().size());
        assertFalse(serviceWithUsers.getAllUsers().contains(otherElke));
        assertTrue(serviceWithUsers.getAllUsers().contains(elke));
    }

    @Test
    void given4UsersWhere2UsersWithAge44_whenSearchForUsersOlderThan43_then2UsersAreReturned() {
        //when
        List<User> usersAged44 = serviceWithUsers.getUsersWithAgeOlderThen(43);

        //then
        assertEquals(2, usersAged44.size());
        assertTrue(containsUserWithName(usersAged44, "Elke"));
        assertTrue(containsUserWithName(usersAged44, "Eric"));
        assertFalse(containsUserWithName(usersAged44, "Miyo"));
    }

    @Test
    void given4UsersWhere0UsersWithAge80_whenSearchForUsersOlderThan80_thenAnEmpyListIsReturned() {
        //when
        List<User> usersAged81 = serviceWithUsers.getUsersWithAgeOlderThen(80);

        //then
        assertEquals(0, usersAged81.size());
    }

    @Test
    void given4Users_whenSearchForOldestUser_thenOldestUserIsReturned() {
        //when
        User oldestUser = serviceWithUsers.getOldestUser();

        //then
        assertEquals(65, oldestUser.getAge());
        assertEquals("Eric", oldestUser.getName());
    }

    @Test
    void givenNoUsers_whenSearchForOldestUser_thenNullValueIsReturned() {
        //when
        User oldestUser = serviceWithoutUsers.getOldestUser();

        //then
        assertNull(oldestUser);
    }

    @Test
    void given4Users_whenSearchForUserWithExistingEmail_thenUserIsReturned() {
        //when
        User foundUser = serviceWithUsers.getUserWithEmail("miyo@ucll.be");

        //then
        assertEquals(15, foundUser.getAge());
        assertEquals("Miyo", foundUser.getName());
    }

    @Test
    void given4Users_whenSearchForUserWithNonExistingEmail_thenNullIsReturned() {
        //when
        User foundUser = serviceWithUsers.getUserWithEmail("carmen@gmail.be");

        //then
        assertNull(foundUser);
    }

    @Test
    void given4Users_whenRemoveExistingUser_thenUserIsRemovedAndRemovedUserIsReturned() {
        //given
        assertEquals(4, serviceWithUsers.getAllUsers().size());

        //when
        User removedUser = serviceWithUsers.removeUser("yuki@ucll.be");

        //then
        assertEquals(3, serviceWithUsers.getAllUsers().size());
        assertEquals(13, removedUser.getAge());
        assertEquals("Yuki", removedUser.getName());
    }

    @Test
    void given4Users_whenRemoveNonExistingUser_thenUserIsNotRemovedAndNullValueIsReturned() {
        //given
        assertEquals(4, serviceWithUsers.getAllUsers().size());

        //when
        User removedUser = serviceWithUsers.removeUser("stijn@ucll.be");

        //then
        assertEquals(4, serviceWithUsers.getAllUsers().size());
        assertNull(removedUser);
    }

    private boolean containsUserWithName(List<User> users, String name) {
        return users.stream().anyMatch(user -> user.getName().equals(name));
    }
}