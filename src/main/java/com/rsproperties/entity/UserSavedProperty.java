//package com.rsproperties.entity;
//
//import javax.persistence.*;
//import java.io.Serializable;
//
//@Entity(name = "UserSavedProperty")
//@Table(name = "user_savedProperty")
//public class UserSavedProperty implements Serializable {
//
//    @Id
//    @ManyToOne
//    @JoinColumn(name = "user_saved_id", referencedColumnName = "id")
//    private User user;
//
//    @Id
//    @ManyToOne
//    @JoinColumn(name = "property_id", referencedColumnName = "id")
//    private SavedProperty savedProperty;
//
//    public UserSavedProperty() {
//    }
//
//    public UserSavedProperty(User user, SavedProperty savedProperty) {
//        this.user = user;
//        this.savedProperty = savedProperty;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public SavedProperty getSavedProperty() {
//        return savedProperty;
//    }
//
//    public void setSavedProperty(SavedProperty savedProperty) {
//        this.savedProperty = savedProperty;
//    }
//
//    @Override
//    public String toString() {
//        return "UserSavedProperty{" +
//                "user=" + user +
//                ", savedProperty=" + savedProperty +
//                '}';
//    }
//}
