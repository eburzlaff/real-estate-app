package com.rsproperties.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/**
 * A class to represent a user.
 *
 * @author pwaite
 */
@Entity(name = "User")
@Table(name = "user")
public class User {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @ManyToMany(fetch = FetchType.EAGER, cascade =
            {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.PERSIST
            },
            targetEntity = SavedProperty.class)
    @JoinTable(name = "user_savedProperty",
            joinColumns = {@JoinColumn(name = "user_saved_id") },
            inverseJoinColumns = {@JoinColumn(name = "property_id") })
    private Set<SavedProperty> savedProperties = new HashSet<>();

//    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
//    private Set<UserSavedProperty> savedProperties = new HashSet<UserSavedProperty>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Property> properties = new HashSet<>();

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param userName  the user name
     * @param password  the password
     * @param email     the email
     */
    public User(String firstName, String lastName, String userName, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }



//    public User(Set<UserSavedProperty> savedProperties) {
//        this.savedProperties = savedProperties;
//    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name.
     *
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets properties.
     *
     * @return the properties
     */
    public Set<Property> getProperties() {
        return properties;
    }

    /**
     * Sets properties.
     *
     * @param properties the properties
     */
    public void setProperties(Set<Property> properties) {
        this.properties = properties;
    }

    public Set<SavedProperty> getSavedProperties() {
        return savedProperties;
    }

    public void setSavedProperties(Set<SavedProperty> savedProperties) {
        this.savedProperties = savedProperties;
    }

    //    public Set<UserSavedProperty> getSavedProperties() {
//        return savedProperties;
//    }
//
//    public void setSavedProperties(Set<UserSavedProperty> savedProperties) {
//        this.savedProperties = savedProperties;
//    }

    /**
     * Add property.
     *
     * @param property the property
     */
    public void addProperty(Property property) {
        properties.add(property);
        property.setUser(this);
    }

    /**
     * Remove property.
     *
     * @param property the property
     */
    public void removeProperty(Property property) {
        properties.remove(property);
        property.setUser(null);
    }

//    /**
//     * Add saved property.
//     *
//     * @param savedProperty the property
//     */
//    public void addSavedProperty(SavedProperty savedProperty) {
//        UserSavedProperty userSavedProperty = new UserSavedProperty(this, savedProperty);
//        savedProperties.add(userSavedProperty);
//        savedProperty.getUsers().add(userSavedProperty);
//    }
//
//    /**
//     * Remove property.
//     *
//     * @param savedProperty the property
//     */
//    public void removeSavedProperty(SavedProperty savedProperty) {
//        for (Iterator<UserSavedProperty> iterator = savedProperties.iterator();
//            iterator.hasNext(); ) {
//            UserSavedProperty userSavedProperty = iterator.next();
//
//            if (userSavedProperty.getSavedProperty().equals(this) &&
//                    userSavedProperty.getUser().equals(savedProperty)) {
//                iterator.remove();
//                userSavedProperty.getSavedProperty().getUsers().remove(userSavedProperty);
//                userSavedProperty.setSavedProperty(null);
//                userSavedProperty.setUser(null);
//
//            }
//
//        }
//    }



    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                ", properties=" + properties +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(userName, user.userName) && Objects.equals(password, user.password) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, userName, password, email, id);
    }
}
