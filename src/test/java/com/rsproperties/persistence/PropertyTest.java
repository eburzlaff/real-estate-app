package com.rsproperties.persistence;

import com.rsproperties.entity.Property;
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
public class PropertyTest {

    /**
     * The Dao.
     */
    GenericDao dao;
    /**
     * The Database utility.
     */
    DatabaseUtility databaseUtility;
    /**
     * The Properties.
     */
    List<Property> properties;

    /**
     * Sets up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        dao = new GenericDao(Property.class);
        databaseUtility = new DatabaseUtility();
        databaseUtility.runSQL("cleandb.sql");
        databaseUtility.runSQL("createTestData.sql");
        properties = dao.getAll();
    }


    /**
     * Test get all properties.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetAllProperties() throws Exception {
        assertTrue(properties.size() > 0);
        assertFalse(properties.get(0).getId() == 123456789);
    }

    /**
     * Test update property.
     *
     * @throws Exception the exception
     */
    @Test
    public void testUpdateProperty() throws Exception {
        Property property = properties.get(0);
        int id = property.getId();
        String updateValue = "Sale100";
        String availabilityTypeBeforeUpdate = property.getAvailabilityType();
        // it would be a good idea to test each value like this

        property.setAvailabilityType(property.getAvailabilityType() + updateValue);

        dao.saveOrUpdate(property);

        Property updatedProperty = (Property) dao.getById(id);

        assertEquals(property, updatedProperty);

    }

    /**
     * Test delete property.
     *
     * @throws Exception the exception
     */
    @Test
    public void testDeleteProperty() throws Exception {
        int sizeBeforeDelete = properties.size();
        Property propertyToDelete = properties.get(0);
        int id = propertyToDelete.getId();
        dao.delete(propertyToDelete);
        int sizeAfterDelete = dao.getAll().size();

        Property deletedProperty = (Property) dao.getById(id);

        assertEquals(sizeBeforeDelete - 1, sizeAfterDelete);
        assertNull(deletedProperty);

    }


    /**
     * Test add property.
     *
     * @throws Exception the exception
     */
    @Test
    public void testAddProperty() throws Exception {

        int insertedPropertyId = 0;

//        User user = dao.getById(1);
//        User user = new User("Eduardo", "Burzlaff", "eburzlaff", "123", "eblrb@test.com");
        Property property = new Property();
//        property.setUser(user);
        property.setAddress("Test");
        property.setPrice(2000);
        property.setDescription("DescriptionTest");
        property.setPropertyType("House");
        property.setAvailabilityType("Rent");
        property.setBedroomNumber(3);
        property.setBathroomNumber(2);
//        user.addProperty(property);

        insertedPropertyId = dao.insert(property);
        Property retrievedProperty = (Property) dao.getById(insertedPropertyId);

        assertTrue(insertedPropertyId > 0);
        assertEquals(property, retrievedProperty);
    }

}