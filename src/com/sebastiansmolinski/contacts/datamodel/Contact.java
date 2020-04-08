package com.sebastiansmolinski.contacts.datamodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;

public class Contact {
    private SimpleStringProperty firstName = new SimpleStringProperty();
    private SimpleStringProperty lastName = new SimpleStringProperty();
    private SimpleStringProperty title = new SimpleStringProperty();
    private SimpleStringProperty companyName = new SimpleStringProperty();
    private SimpleStringProperty jobTitle = new SimpleStringProperty();
    private SimpleStringProperty phoneNumber = new SimpleStringProperty();
    private SimpleStringProperty mobileNumber = new SimpleStringProperty();
    private SimpleStringProperty mailAddress = new SimpleStringProperty();
    private SimpleStringProperty webSiteAddress = new SimpleStringProperty();
    private Image photo;

    public Contact() {
    }

    public Contact(String firstName, String lastName, String title, String companyName, String jobTitle,
                   String phoneNumber, String mobileNumber, String mailAddress, String webSiteAddress, Image photo) {
        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.phoneNumber.set(phoneNumber);
        this.title.set(title);
        this.companyName.set(companyName);
        this.jobTitle.set(jobTitle);
        this.phoneNumber.set(phoneNumber);
        this.mobileNumber.set(mobileNumber);
        this.mailAddress.set(mailAddress);
        this.webSiteAddress.set(webSiteAddress);
        this.photo = photo;
    }

    public String getPhoto() {
        return photo.getUrl();
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
    }

    public String getTitle() {
        return title.get();
    }

    public SimpleStringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getCompanyName() {
        return companyName.get();
    }

    public SimpleStringProperty companyNameProperty() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName.set(companyName);
    }

    public String getJobTitle() {
        return jobTitle.get();
    }

    public SimpleStringProperty jobTitleProperty() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle.set(jobTitle);
    }

    public String getMobileNumber() {
        return mobileNumber.get();
    }

    public SimpleStringProperty mobileNumberProperty() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber.set(mobileNumber);
    }

    public String getMailAddress() {
        return mailAddress.get();
    }

    public SimpleStringProperty mailAddressProperty() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress.set(mailAddress);
    }

    public String getWebSiteAddress() {
        return webSiteAddress.get();
    }

    public SimpleStringProperty webSiteAddressProperty() {
        return webSiteAddress;
    }

    public void setWebSiteAddress(String webSiteAddress) {
        this.webSiteAddress.set(webSiteAddress);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public SimpleStringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }


}
