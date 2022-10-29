package com.rsproperties.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Represents a property in the real state application
 *
 * @eburzlaff
 */
@Entity(name = "Property")
@Table(name = "property")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "address")
    private String address;

    @Column(name = "price")
    private int price;

    @Column(name = "description")
    private String description;

    @Column(name = "property_type")
    private String propertyType;

    @Column(name = "availability_type")
    private String availabilityType;

    @Column(name = "bedroom_number")
    private int bedroomNumber;

    @Column(name = "bathroom_number")
    private int bathroomNumber;

    @ManyToOne
    private User user;

    /**
     * Instantiates a new Property.
     */
    public Property() {
    }

    /**
     * Instantiates a new Property.
     *
     * @param address     the address
     * @param price       the price
     * @param description the description
     * @param user        the user
     */
    public Property(String address, int price, String description, User user) {
        this.address = address;
        this.price = price;
        this.description = description;
        this.user = user;
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
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets property type.
     *
     * @return the property type
     */
    public String getPropertyType() {
        return propertyType;
    }

    /**
     * Sets property type.
     *
     * @param propertyType the property type
     */
    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    /**
     * Gets availability type.
     *
     * @return the availability type
     */
    public String getAvailabilityType() {
        return availabilityType;
    }

    /**
     * Sets availability type.
     *
     * @param availabilityType the availability type
     */
    public void setAvailabilityType(String availabilityType) {
        this.availabilityType = availabilityType;
    }

    /**
     * Gets bedroom number.
     *
     * @return the bedroom number
     */
    public int getBedroomNumber() {
        return bedroomNumber;
    }

    /**
     * Sets bedroom number.
     *
     * @param bedroomNumber the bedroom number
     */
    public void setBedroomNumber(int bedroomNumber) {
        this.bedroomNumber = bedroomNumber;
    }

    /**
     * Gets bathroom number.
     *
     * @return the bathroom number
     */
    public int getBathroomNumber() {
        return bathroomNumber;
    }

    /**
     * Sets bathroom number.
     *
     * @param bathroomNumber the bathroom number
     */
    public void setBathroomNumber(int bathroomNumber) {
        this.bathroomNumber = bathroomNumber;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", propertyType='" + propertyType + '\'' +
                ", availabilityType='" + availabilityType + '\'' +
                ", bedroomNumber=" + bedroomNumber +
                ", bathroomNumber='" + bathroomNumber + '\'' +
                ", user=" + user +
                '}';
    }
}
