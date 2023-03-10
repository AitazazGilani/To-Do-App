package com.example.app.Controller;


import com.example.app.App;
import com.example.app.UI.GraphicalCalendar;
import com.example.app.database.ManageDB;
import com.example.app.database.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class CalendarController{

    public Menu accountMenu;
    public MenuItem logOutMenuItem;
    //TODO Minor: Future reference, the ListView may not be of the Task Object, confirm this in the future.

    @FXML
    protected ListView<String> selectedDateTaskListView;

    @FXML
    protected AnchorPane centerAnchorPane;

    @FXML
    protected Button tasksTabBtn, calendarTabBtn, contactsTabBtn, newTaskBtn, lockBtn;

    @FXML
    protected Label selectedDateLabel, numberOfTasksLabel;

    protected ManageDB database = new ManageDB();

    protected GraphicalCalendar calendar = new GraphicalCalendar();

    /**
     * This initializes the CalendarView with information on startup.
     */
    @FXML
    private void initialize(){
        //create new calendar graphic

        //set the scenes center pane to the calendar
        centerAnchorPane.getChildren().setAll(calendar);

        //for every cell of buttons in the calendar, create an onAction event handler to handle date selects
        setButtonHandlers();
    }

    /**
     * Sets an event handler for each button in the calendar grid.
     */
    private void setButtonHandlers() {
        calendar.nextBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                calendar.next();
                setButtonHandlers();
            }
        });
        calendar.prevBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                calendar.previous();
                setButtonHandlers();
            }
        });
        for(Button tempButton : calendar.calendarButtonList)
        {
            tempButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    //when a cell is selected update the details on the right of the scene with the right data.
                    ArrayList<Task> currentTasks = database.queryTasks(ManageDB.TaskQuery.DATE, tempButton.getId());

                    numberOfTasksLabel.setText("(# of) Task(s): " + currentTasks.size());

                    ArrayList<String> taskNames = new ArrayList<>();

                    for(Task task : currentTasks){
                        taskNames.add(task.getName());
                    }

                    selectedDateTaskListView.getItems().setAll(taskNames);

                    selectedDateLabel.setText(tempButton.getId());

                }
            });
        }
    }


    /**
     * Move and display the Calendar Tab
     */
    @FXML
    private void clickCalendarTab() {
        //TODO Minor: CalendarTab Button refresh

        //initialize();

        //note, there used to be a param for: ActionEvent actionEvent
        //I removed it as it doesn't seem necessary at the moment, just keep it in mind.

        //Just refresh the calendar page
        //refresh by:
        // 1. clearing the page
        // 2. re-initialize.

        // or for now, just leave it blank I suppose.

    }

    /**
     * Move and display the Tasks Tab
     */
    @FXML
    private void clickTasksTab() throws IOException {
        //loads the TaskView into fxmlLoader.
        Parent fxmlLoader = FXMLLoader.load(Objects.requireNonNull(App.class.getResource("TasksView.fxml")));
        //gets the current stage.
        Stage stage = (Stage)calendarTabBtn.getScene().getWindow();
        //sets the current stage to the new scene.
        stage.getScene().setRoot(fxmlLoader);

    }

    /**
     * Move and display the Contacts Tab
     */
    @FXML
    private void clickContactsTab() throws IOException {
        //loads the TaskView into fxmlLoader.
        Parent fxmlLoader = FXMLLoader.load(Objects.requireNonNull(App.class.getResource("ContactsView.fxml")));
        //gets the current stage.
        Stage stage = (Stage)calendarTabBtn.getScene().getWindow();
        //sets the current stage to the new scene.
        stage.getScene().setRoot(fxmlLoader);
    }

    /**
     * Move and display the TaskForm Tab
     */
    @FXML
    private void clickNewTask() throws IOException {
        //Load the Task form view into the loader
        Parent fxmlLoader = FXMLLoader.load(Objects.requireNonNull(App.class.getResource("TaskFormView.fxml")));
        //create a new window for the new task
        Stage newTaskWindow = new Stage();
        newTaskWindow.setTitle("New Task");
        newTaskWindow.setScene(new Scene(fxmlLoader, 900, 700));
        //open the window
        newTaskWindow.show();
    }

    /**
     * 'Locks' the application by hiding everything with a blank screen
     */
    @FXML
    private void clickLockButton() throws IOException {
        //Load the locked screen view into the loader
        Parent fxmlLoader = FXMLLoader.load(Objects.requireNonNull(App.class.getResource("LockedView.fxml")));
        //create a new window for the locked screen
        Stage newTaskWindow = new Stage();
        newTaskWindow.setTitle("Screen Locked");
        newTaskWindow.setScene(new Scene(fxmlLoader, 1200, 700));
        //open the window
        newTaskWindow.show();

        //Gets current stage (calendar view)
        Stage cur = (Stage) lockBtn.getScene().getWindow();
        //Close the window
        cur.close();
    }

    /**
     * Logs the current user out of the application, returning them to the returning user login page.
     */
    @FXML
    public void ClickLogOut() throws IOException {
        //Load the returning user login view into the loader
        Parent fxmlLoader = FXMLLoader.load(Objects.requireNonNull(App.class.getResource("ReturningLoginView.fxml")));
        //create a new window for the returning user login view
        Stage newTaskWindow = new Stage();
        newTaskWindow.setTitle("TODO Application");
        newTaskWindow.setScene(new Scene(fxmlLoader, 1200, 700));
        //open the window
        newTaskWindow.show();


        //Gets current stage (Calendar view)
        Stage cur = (Stage) lockBtn.getScene().getWindow();
        //Close the window
        cur.close();
    }
}
