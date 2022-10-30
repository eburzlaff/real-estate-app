package com.rsproperties.persistence;

import com.rsproperties.entity.User;
import com.rsproperties.util.DatabaseUtility;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by paulawaite and adapted by Eduardo Burzlaff
 */
public class UserTest {

    /**
     * The Dao.
     */
    GenericDao dao;
    /**
     * The Database utility.
     */
    DatabaseUtility databaseUtility;
    /**
     * The Users.
     */
    List<User> users;

    /**
     * Sets up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        dao = new GenericDao(User.class);
        databaseUtility = new DatabaseUtility();
        databaseUtility.runSQL("cleandb.sql");
        databaseUtility.runSQL("createTestData.sql");
        users = dao.getAll();
    }


    /**
     * Test get all users.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetAllUsers() throws Exception {
        assertTrue(users.size() > 0);
        assertFalse(users.get(0).getFirstName().equals(""));
    }

    /**
     * Test update user.
     *
     * @throws Exception the exception
     */
    @Test
    public void testUpdateUser() throws Exception {
        User user = users.get(0);
        int id = user.getId();
        String updateValue = LocalDate.now().toString();
        String emailBeforeUpdate = user.getEmail();
        // it would be a good idea to test each value like this

        user.setEmail(user.getEmail() + updateValue);

        dao.saveOrUpdate(user);

        User updatedUser = (User) dao.getById(id);

        assertEquals(user, updatedUser);

    }

    /**
     * Test delete user.
     *
     * @throws Exception the exception
     */
    @Test
    public void testDeleteUser() throws Exception {
        int sizeBeforeDelete = users.size();
        User userToDelete = users.get(0);
        int id = userToDelete.getId();
        dao.delete(userToDelete);
        int sizeAfterDelete = dao.getAll().size();

        User deletedUser = (User) dao.getById(id);

        assertEquals(sizeBeforeDelete - 1, sizeAfterDelete);
        assertNull(deletedUser);

    }


    /**
     * Test add user.
     *
     * @throws Exception the exception
     */
    @Test
    public void testAddUser() throws Exception {

        int insertedUserId = 0;

        User user = new User();
        user.setFirstName("Unit");
        user.setLastName("Test");
        user.setUserName("UnitTesterB");
        user.setEmail("UserDaoTesterB@gmail.com");
        user.setPassword("supersecret");
        insertedUserId = dao.insert(user);
        User retrievedUser = (User) dao.getById(insertedUserId);

        assertTrue(insertedUserId > 0);
        assertEquals(user, retrievedUser);
    }

    /**
     * Test get all users with last name exact.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetAllUsersWithLastNameExact() throws Exception {
        users = dao.findByPropertyEqual("lastName", "Coyne");
        assertTrue(users.size() > 0);
        assertTrue(users.get(0).getFirstName().equals("Joe"));
    }

}