package com.example.app.Controller;

import com.example.app.App;
import com.example.app.database.Contact;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ContactsController {

    @FXML
    protected Button calendarTabBtn, tasksTabBtn, contactsTabBtn, editContactBtn, deleteContactBtn,
            newContactBtn, newCategoryBtn;

    @FXML
    protected VBox selectedContactInfoBox;

    @FXML
    protected Label contactNameLabel, contactEmailLabel, contactCategoryLabel, selectedTimerLabel;

    @FXML
    protected HBox timerBtnBox;

    @FXML
    protected Button startBtn, pauseBtn, finishBtn, timerSummaryBtn;

    @FXML
    protected ListView<Contact> contactsListView;

    //Timer needs an object, don't really have much experience with timers yet so im not sure what to set the object as
    // yet.
    @FXML
    protected ListView currentTimersListView;

    //Also figure out what object this should be.
    @FXML
    protected ChoiceBox sortByChoiceBox;

    /**
     * This initializes the Contacts Tab with the appropriate information on startup.
     */
    @FXML
    private void initialize(){
        //TODO ContactTab Initializer

        //Init the contact tab with every contact based on their information, would have to figure out the whole timer
        // thing, but it should be fairly straight forward.
    }

    /**
     * Move to Contacts Tab on Click
     */
    @FXML
    private void onContactsTabClick() {
        //TODO ContactTab refresh

        //note, there used to be a param for: ActionEvent actionEvent
        //I removed it as it doesn't seem necessary at the moment, just keep it in mind.

        //Just refresh the calendar page
        //refresh by:
        // 1. clearing the page
        // 2. re-initialize.

        // or for now, just leave it blank I suppose.
    }

    /**
     * Move to Calendar Tab on click
     */
    @FXML
    private void onCalendarTabClick() throws IOException {
        //note, there used to be a param for: ActionEvent actionEvent
        //I removed it as it doesn't seem necessary at the moment, just keep it in mind.

        //loads the TaskView into fxmlLoader.
        Parent fxmlLoader = FXMLLoader.load(Objects.requireNonNull(App.class.getResource("CalendarView.fxml")));
        //gets the current stage.
        Stage stage = (Stage)contactsTabBtn.getScene().getWindow();
        //sets the current stage to the new scene.
        stage.getScene().setRoot(fxmlLoader);
    }

    /**
     * Move to Tasks Tab on click
     */
    @FXML
    private void onTasksTabClick() throws IOException {
        //note, there used to be a param for: ActionEvent actionEvent
        //I removed it as it doesn't seem necessary at the moment, just keep it in mind.

        //loads the TaskView into fxmlLoader.
        Parent fxmlLoader = FXMLLoader.load(Objects.requireNonNull(App.class.getResource("TasksView.fxml")));
        //gets the current stage.
        Stage stage = (Stage)contactsTabBtn.getScene().getWindow();
        //sets the current stage to the new scene.
        stage.getScene().setRoot(fxmlLoader);
    }

    //TODO Duplicate the NewContactView and create an EditContactView, for the edit button. delete will just delete the currently selected item.

    /**
     * Open ContactForm on click with current contacts information and id etc
     */
    @FXML
    private void onEditContactClick() {
        //TODO ContactTab Edit Button

        //note, there used to be a param for: ActionEvent actionEvent
        //I removed it as it doesn't seem necessary at the moment, just keep it in mind.
    }

    /**
     * Delete Currently selected Contact
     */
    @FXML
    private void onDeleteContactClick() {
        //TODO ContactTab Delete Button

        //note, there used to be a param for: ActionEvent actionEvent
        //I removed it as it doesn't seem necessary at the moment, just keep it in mind.
    }

    /**
     * Open blank ContactForm with no information
     */
    @FXML
    private void onNewContactClick() throws IOException {
        //note, there used to be a param for: ActionEvent actionEvent
        //I removed it as it doesn't seem necessary at the moment, just keep it in mind.

        //TODO Check if the window is already open, as to not create 300 tabs.

        //Load the Task form view into the loader
        Parent fxmlLoader = FXMLLoader.load(Objects.requireNonNull(App.class.getResource("ContactFormView.fxml")));
        //create a new window for the new task
        Stage newContactWindow = new Stage();
        newContactWindow.setTitle("New Task");
        newContactWindow.setScene(new Scene(fxmlLoader, 900, 600));
        //open the window
        newContactWindow.show();
    }

    /**
     * ? Display Timer summary page, there doesn't seem to be a fxml file for it yet
     * so ignore for now
     */
    @FXML
    private void onTimerSummaryClick() {
        //TODO ContactTab Timer Button

        //note, there used to be a param for: ActionEvent actionEvent
        //I removed it as it doesn't seem necessary at the moment, just keep it in mind.
    }

    /**
     * ? new Category, again figure out the Category. is it a new Object?
     */
    @FXML
    private void onNewCategoryClick() {
        //TODO ContactTab New Category Button

        //note, there used to be a param for: ActionEvent actionEvent
        //I removed it as it doesn't seem necessary at the moment, just keep it in mind.

        //Currently, there isn't a form for the button to connect to, Lexi is doing that
    }
}