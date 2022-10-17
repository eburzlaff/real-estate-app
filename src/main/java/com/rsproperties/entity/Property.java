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
     */
    public Property(String address, int price, String description) {
        this.address = address;
        this.price = price;
        this.description = description;
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

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
