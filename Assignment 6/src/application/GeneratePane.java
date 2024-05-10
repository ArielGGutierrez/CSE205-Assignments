package application;
// Assignment 6: ASU - CSE 205
//         Name: Ariel Gael Gutierrez
//    StudentID: 1218982505
//      Lecture: TTH 1:30PM-2:45 PM
//  Description: GeneratePane creates a pane where a user can enter
//               department information and create a list of available
//               departments.

/* --------------- */
/* Import Packages */
/* --------------- */
import java.util.ArrayList;

import javafx.event.ActionEvent; //**Need to import
import javafx.event.EventHandler; //**Need to import

// JavaFX classes
//import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * GeneratePane builds a pane where a user can enter a department
 * information and create a list of available departments.
 */
public class GeneratePane extends HBox
{
	/* ------------------ */
    /* Instance variables */
    /* ------------------ */
	
	/* Instance Variables specified in constructor */
	private ArrayList<Department> departList; // List of all departments
    private SelectPane            selectPane; // The relationship between GeneratePane and SelectPane is Aggregation
    
    /* JavaFX component instance variables */
	private Label              feedbackLabel; // Top label to give feedback to user about adding a new department
	private Label              depTitleLabel; // Label prompting user to enter a department title
	private Label            facultyNumLabel; // Label prompting user to enter the number of faculty
	private Label               uniNameLabel; // Label prompting user to enter the university name
	private TextField          depTitleField; // Text field that lets user enter a department title
	private TextField        facultyNumField; // Text field that lets user enter the number of faculty
	private TextField           uniNameField; // Text field that lets user enter the university name
	private Button              addDepButton; // Button to add the new department
	private TextArea                  output; // Output text with all the departments

    /**
     * CreatePane constructor
     *
     * @param list   the list of departments
     * @param sePane the SelectPane instance
     */
    public GeneratePane(ArrayList<Department> list, SelectPane sePane)
    {
        /* Instantiates the department list and the selectPane */
    	this.departList = list;
    	this.selectPane = sePane;
    	
    	/* Instantiates the feedback label and makes its text color red */
    	feedbackLabel = new Label();
    	feedbackLabel.setTextFill(Color.RED);
    	
    	/* Instantiates all the labels, text fields, and button */
    	depTitleLabel   = new Label("Department Title");
    	depTitleField   = new TextField();
    	facultyNumLabel = new Label("Number of Faculty");
    	facultyNumField = new TextField();
    	uniNameLabel    = new Label("Name of University");
    	uniNameField    = new TextField();
    	addDepButton    = new Button("Add a Department");
    	
    	/* Instantiates the output text area, sets its first text and makes it noneditable by the user */
    	output = new TextArea();
    	output.setText("No Department");
    	output.setEditable(false);
    	
    	/* Creates two vertical boxes for to hold the previous elements */
    	VBox leftHalf  = new VBox();
    	VBox rightHalf = new VBox();
    	
		//create a GridPane to hold labels & text fields.
		//you can choose to use .setPadding() or setHgap(), setVgap()
		//to control the spacing and gap, etc.
    	
    	/* Creates a grid pane and sets a gap of 5 pixels between each row */
    	GridPane gridPane = new GridPane();
    	gridPane.setVgap(5);
    	
    	/* Adds the labels and text fields to the grid pane */
    	gridPane.add(depTitleLabel,   0, 0);
    	gridPane.add(depTitleField,   1, 0);
    	gridPane.add(facultyNumLabel, 0, 1);
    	gridPane.add(facultyNumField, 1, 1);
    	gridPane.add(uniNameLabel,    0, 2);
    	gridPane.add(uniNameField,    1, 2);
    	
		// Set both left and right columns to 50% width (half of window)
		ColumnConstraints halfWidth = new ColumnConstraints();
		halfWidth.setPercentWidth(50);
        gridPane.getColumnConstraints().addAll(halfWidth, halfWidth);
        
		/* Creates a horizontal box to hold the button and centers it */
        HBox buttonHolder = new HBox();
        buttonHolder.getChildren().add(addDepButton);
        buttonHolder.setAlignment(Pos.BASELINE_CENTER);
        
		//Set up the layout for the left half of the GeneratePane.
        leftHalf.getChildren().addAll(feedbackLabel, gridPane, buttonHolder);
        leftHalf.setSpacing(5);
        
		//the right half of the GeneratePane is simply a TextArea object
		//Note: a ScrollPane will be added to it automatically when there are no more space
		//Add the left half and right half to the GeneratePane
        rightHalf.getChildren().add(output);
        
        /* Adds the left and right components to the GeneratePane horizontal box */
        this.getChildren().addAll(leftHalf, rightHalf);
        
        /* Formats the layout of the GeneratePane horizontal box */
        HBox.setHgrow(leftHalf, Priority.ALWAYS);  // Ensures that the left half grows when the window increases size
        HBox.setHgrow(rightHalf, Priority.ALWAYS); // Ensures that the right half grows when the window increases size
        
        Insets margin = new Insets(10);    // Adds a margin from the window to the horizontal box
        HBox.setMargin(leftHalf, margin);  // Sets that margin to the left side
        HBox.setMargin(rightHalf, margin); // Sets that margin to the right side
        
		//Note: GeneratePane extends from HBox
		//register/link source object with event handler
        // Bind button click action to event handler
        addDepButton.setOnAction(new ButtonHandler());
        
    } // end of constructor

    /**
     * ButtonHandler ButtonHandler listens to see if the button "Add a department" is pushed
     * or not, When the event occurs, it get a department's Title, number of faculties,
     * and its university information from the relevant text fields, then create a
     * new department and adds it to the departList. Meanwhile it will display the department's
     * information inside the text area. using the toString method of the Department
     * class. It also does error checking in case any of the text fields are empty,
     * or a non-numeric value was entered for number of faculty
     */
    private class ButtonHandler implements EventHandler<ActionEvent>
    {
        /**
         * handle Override the abstract method handle()
         */
        public void handle(ActionEvent event)
        {
        	// Declare local variables
            Department newDepart;    // New department
            int numberOfFaculty = 0; // Integer number of faculty in said department
            
            boolean isEmptyFields = false; // Boolean that checks if any text field is empty
            
            /* Checks if any of the text fields are empty and sets the isEmptyFields flag to true accordingly */
            if(depTitleField.getText().equals("") || 
               facultyNumField.getText().equals("") || 
               uniNameField.getText().equals(""))
            {
            	isEmptyFields = true;
            }
            
            // Display error message if there are empty fields
            if (isEmptyFields)
            {
            	feedbackLabel.setText("Please fill all fields");
            }
            
            else
            {
	            // If all fields are filled, try to add the department
	            try 
	            {
	            	/*
	            	 * Cast faculties Field to an integer, throws NumberFormatException if unsuccessful
	            	 */
	            	numberOfFaculty = Integer.parseInt(facultyNumField.getText());
	            	
	            	// Data is valid, so create new Department object and populate data
	            	newDepart = new Department();
	            	newDepart.setDeptName(depTitleField.getText());
	            	newDepart.setNumberOfMembers(numberOfFaculty);
	            	newDepart.setUniversity(uniNameField.getText());
	            	
	            	// Loop through existing departments to check for duplicates
	            	// do not add it to the list if it exists and display a message
	            	
	            	boolean isDuplicate = false; // Boolean that checks if what was inputed is a duplicate
	            	
	            	/* 
	            	 * Loops through the departments in departList and checks if the department names and university
	            	 * names are the same.  If the names are the same, then the user inputed a duplicate and the
	            	 * isduplicate box is updated accordingly.
	            	 */
	            	for(int i = 0; i < departList.size(); i++)
	            	{
	            		if (newDepart.getDeptName().equals(departList.get(i).getDeptName()) &&
	            			newDepart.getUniversity().equals(departList.get(i).getUniversity()))
	            		{
	            			isDuplicate = true;
	            			feedbackLabel.setText("Department not added - already exist");
	            			break;
	            		}
	            	}
	            	
	            	// department is not a duplicate, so display it and add it to list
	            	if (!isDuplicate)
	            	{
	            		/* Adds the department to the list and gives the user feedback */
	            		departList.add(newDepart);
	            		feedbackLabel.setText("Department added");
	            		
	            		/* Updates the department list in the selecPane class */
	            		selectPane.updateDepartList(newDepart);
	            		
	            		String outputString = ""; // Empty string that gets added to
	            		
	            		/* Fills the outputString with toString versions all the departments in departList */
	            		for(int i = 0; i < departList.size(); i++)
		            	{
		            		outputString += departList.get(i).toString();
		            	}
	            		
	            		/* Sets the output text area to the outputString */
	            		output.setText(outputString);
	            	}
	            	
	            } //end of try
	            
	            catch (NumberFormatException e)
	            {
	            	// If the number of faculties entered was not an integer, display an error
	            	feedbackLabel.setText("Please enter an integer for a number of faculty.");
	            	
	            }
	            catch (Exception e)
	            {
	            	// Catches generic exception and displays message
	            	// Used to display 'Department is not added - already exist' message if department already exist
	            	feedbackLabel.setText("Department not added - already exist");
	            }
            }
        } // end of handle() method
    } // end of ButtonHandler class
} // end of GeneratePane class


