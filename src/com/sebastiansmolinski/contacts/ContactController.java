package com.sebastiansmolinski.contacts;

import com.sebastiansmolinski.contacts.datamodel.Contact;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.MalformedURLException;

public class ContactController {

    private String imagePath;

    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private TextField mobileNumberField;
    @FXML
    private TextField titleField;
    @FXML
    private TextField companyNameField;
    @FXML
    private TextField webSiteField;
    @FXML
    private TextField jobTitleField;
    @FXML
    private TextField mailField;
    @FXML
    private ImageView chooseImage;

    public Contact getNewContact() {
        String title = titleField.getText();
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String companyName = companyNameField.getText();
        String jobTitle = jobTitleField.getText();
        String phoneNumber = phoneNumberField.getText();
        String mobileNumber = mobileNumberField.getText();
        String mailAddress = mailField.getText();
        String webSiteAddress = webSiteField.getText();
        Image photo = (chooseImage != null ? chooseImage.getImage() : new Image("765-default-avatar.png"));

        return new Contact(firstName, lastName, title, companyName, jobTitle,
                phoneNumber, mobileNumber, mailAddress, webSiteAddress, photo);
    }

    public void modifyContact(Contact contact) {
        contact.setFirstName(this.firstNameField.getText());
        contact.setLastName(this.lastNameField.getText());
        contact.setPhoneNumber(this.phoneNumberField.getText());
        contact.setPhoto((imagePath != null) ? new Image(imagePath) : chooseImage.getImage());
        contact.setMobileNumber(this.mobileNumberField.getText());
        contact.setCompanyName(this.companyNameField.getText());
        contact.setJobTitle(this.jobTitleField.getText());
        contact.setTitle(this.titleField.getText());
        contact.setWebSiteAddress(this.webSiteField.getText());
        contact.setMailAddress(this.mailField.getText());
    }

    public void setFields(Contact contact) {
        this.titleField.setText(contact.getTitle());
        this.firstNameField.setText(contact.getFirstName());
        this.lastNameField.setText(contact.getLastName());
        this.companyNameField.setText(contact.getCompanyName());
        this.jobTitleField.setText(contact.getJobTitle());
        this.phoneNumberField.setText(contact.getPhoneNumber());
        this.mobileNumberField.setText(contact.getMobileNumber());
        this.webSiteField.setText(contact.getWebSiteAddress());
        this.mailField.setText(contact.getMailAddress());
        this.chooseImage.setImage(new Image(contact.getPhoto()));
    }

    public void loadImage() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Load user image");
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Images Files", "*.gif", "*.jpg", "*.png"));

        File file = chooser.showOpenDialog(chooseImage.getScene().getWindow());

        imagePath = file.toURI().toString();

        chooseImage.setImage(new Image(imagePath));
    }
}
