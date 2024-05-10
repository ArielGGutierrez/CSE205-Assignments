package application;
// Assignment 6: ASU - CSE 205
//         Name: Ariel Gael Gutierrez
//    StudentID: 1218982505
//      Lecture: TTH 1:30PM-2:45 PM
//  Description: SelectPane displays a list of available department
//               from which a user can select and compute total number 
//               of faculties in multiple departments.

import java.util.ArrayList;

import javafx.event.ActionEvent; //**Need to import
import javafx.event.EventHandler; //**Need to import

// import all other necessary JavaFX classes here
import javafx.scene.layout.BorderPane;

/* Stuff needed */
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.CheckBox;

/**
* SelectPane displays a list of available departments from which a user
* can select and compute total number of faculties for selected departments.
*/
public class SelectPane extends BorderPane {

	/* ------------------ */
    /* Instance variables */
    /* ------------------ */
	
	/* Instance Variables specified in constructor */
    private ArrayList<Department> departList; // List of all departments
    private int                 facultyCount; // Counts the total number of faculty selected
    
    /* JavaFX component instance variables */
    private VBox           checkboxContainer; // Vertical box that holds all the check boxes
    private Label                   topLabel; // Top label that prompts the user to select some departments
    private ScrollPane            scrollPane; // Scroll pane that holds the checkboxContainer
    private Label                bottomLabel; // Bottom label that tells the user how much faculty they selected
    
    /**
     * SelectPane constructor
     * 
     * @param list the list of departments
     */
    public SelectPane(ArrayList<Department> list)
    {
    	/* Instantiates the department list and sets the faculty count to zero */
    	this.departList = list;
        facultyCount    = 0;
        
        /* Instantiates the checkboxContainer and the scrollPane that holds it */
        checkboxContainer = new VBox();
        scrollPane        = new ScrollPane();
        
        /* Instantiates and sets the default values for the top and bottom labels */
        topLabel    = new Label("Select Department(s)");
        bottomLabel = new Label("The total number of faculty for the selected department(s): " + facultyCount);
        
        // Wrap checkboxContainer in ScrollPane so formatting is
        // correct when many departments are added
        scrollPane.setContent(checkboxContainer);
        
        //SelectPane is a BorderPane - add the components here
        this.setTop(topLabel);
        this.setCenter(scrollPane);
        this.setBottom(bottomLabel);
        
    } // end of SelectPane constructor

    // This method uses the newly added parameter Department object
    // to create a CheckBox and add it to a pane created in the constructor
    // Such check box needs to be linked to its handler class
    public void updateDepartList(Department newdep)
    {
        // Create checkbox for new department with appropriate text
    	CheckBox myCheckBox = new CheckBox(newdep.toString());
    	
        // Bind checkbox toggle action to event handler
        // Passes the number of faculties in each department to the handler. When the checkbox is
        // toggled,this number will be added/subtracted from the total number of selected faculties
    	myCheckBox.setOnAction(new SelectionHandler(newdep.getNumberOfMembers()));

        // Add new checkbox to checkbox container
    	checkboxContainer.getChildren().add(myCheckBox);
    	
    } // end of updateDepartList method

    /**
     * SelectionHandler This class handles a checkbox toggle event. When the
     * checkbox is toggled, this number will be added/subtracted from the total
     * number of selected faculties.
     */
    private class SelectionHandler implements EventHandler<ActionEvent>
    {
        // Instance variable for number of faculties associated with a given department/checkbox
        private int faculties;
        
        public SelectionHandler(int members)
        {
        	this.faculties = members; // Set instance variable
        } // end of SelectionHandler constructor

        //over-ride the abstract method handle
        public void handle(ActionEvent event)
        {
            // Get the object that triggered the event, and cast it to a checkbox, since
            // only a department checkbox
            // can trigger the SelectionHandler event. The cast is necessary to have access
            // to the isSelected() method
        	if (((CheckBox) event.getSource()).isSelected())
        	{
        		facultyCount += faculties;
        	}
        	
        	else
        	{
        		facultyCount -= faculties;
        	}
        	
        	// Update the selected Faculties label with the new number of selected faculties
        	bottomLabel.setText("The total number of faculty for the selected department(s): " + facultyCount);
        	
        } // end handle method
    } // end of SelectHandler class
} // end of SelectPane class
