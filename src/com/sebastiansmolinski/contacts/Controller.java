package com.sebastiansmolinski.contacts;

import com.sebastiansmolinski.contacts.datamodel.Contact;
import com.sebastiansmolinski.contacts.datamodel.ContactData;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class Controller {

    @FXML
    private BorderPane mainPanel;
    @FXML
    private TableView<Contact> contactsTableView;
    @FXML
    private MenuItem editContact;
    @FXML
    private Button themeButton;
    @FXML
    private Button editButton;
    @FXML
    private Button deleteButton;
    @FXML
    private MenuItem deleteContact;
    @FXML
    private TextField nameField;
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
    @FXML
    private ComboBox choiceTheme;
    @FXML
    private String urlBlackTheme = getClass().getResource("blackTheme.css").toExternalForm();
    @FXML
    private String urlWhiteTheme = getClass().getResource("whiteTheme.css").toExternalForm();


    private ContactData data;


    public void initialize() {
        data = new ContactData();
        data.loadContacts();
        contactsTableView.setItems(data.getContacts());
        contactsTableView.getSelectionModel().selectFirst();
        handleTableViewMouseClick();


    }

    @FXML
    public void editContact() {
        Contact editingContact = contactsTableView.getSelectionModel().getSelectedItem();
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainPanel.getScene().getWindow());
        dialog.setTitle("Edit Contact");
        dialog.setHeaderText("Use this dialog to edit contact");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("contactDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        ContactController contactController = fxmlLoader.getController();
        contactController.setFields(editingContact);
        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            contactController.modifyContact(editingContact);
            contactsTableView.refresh();
            data.saveContacts();
        }
    }

    @FXML
    public void deleteContact() {
        Contact selectedContact = contactsTableView.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Contact");
        alert.setHeaderText("Delete contact: " + selectedContact.getFirstName() + " " + selectedContact.getLastName());
        alert.setContentText("Are you sure? Press OK to confirm, or cancel to Back out.");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && (result.get() == ButtonType.OK)) {
            data.deleteContact(selectedContact);
            data.saveContacts();
        }

    }

    @FXML
    public void addContact() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainPanel.getScene().getWindow());
        dialog.setTitle("Add New Contact");
        dialog.setHeaderText("Use this dialog to create a new contact");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("contactDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);


        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            ContactController contactController = fxmlLoader.getController();
            Contact newContact = contactController.getNewContact();
            data.addContact(newContact);
            data.saveContacts();
        }
    }

    @FXML
    public void handleTableViewMouseClick() {
        Contact contact = contactsTableView.getSelectionModel().getSelectedItem();
        if (contact != null) {
            editContact.setDisable(false);
            deleteContact.setDisable(false);
            editButton.setDisable(false);
            deleteButton.setDisable(false);
            this.titleField.setText(contact.getTitle());
            this.nameField.setText(contact.getFirstName() + " " + contact.getLastName());
            this.companyNameField.setText(contact.getCompanyName());
            this.jobTitleField.setText(contact.getJobTitle());
            this.phoneNumberField.setText(contact.getPhoneNumber());
            this.mobileNumberField.setText(contact.getMobileNumber());
            this.webSiteField.setText(contact.getWebSiteAddress());
            this.mailField.setText(contact.getMailAddress());
            this.chooseImage.setImage(new Image(contact.getPhoto()));
        } else {
            editContact.setDisable(true);
            deleteContact.setDisable(true);
            editButton.setDisable(true);
            deleteButton.setDisable(true);
        }
    }



    public void handleThemeClick() {
        int index = choiceTheme.getSelectionModel().getSelectedIndex();
        Main.stage.getScene().getStylesheets().clear();
        Main.stage.getScene().setUserAgentStylesheet(null);
        if (index == 0) {
            Main.stage.getScene().getStylesheets().add(urlBlackTheme);
        } else {
            Main.stage.getScene().getStylesheets().add(urlWhiteTheme);
        }
    }

    public void handleExit() {
        Platform.exit();
    }
}
