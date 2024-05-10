// Assignment 7: ASU - CSE 205
//         Name: Ariel Gael Gutierrez
//    StudentID: 1218982505
//      Lecture: TTH 1:30PM-2:45 PM
//  Description: CirclePane class creates a pane where we can use
//               mouse key to drag on canvas and there will be some color following
//               the mouse. We can also use combo boxes to change its colors and stroke widths

import javafx.geometry.Insets;
import javafx.scene.layout.*;

import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.paint.Color;

import javafx.scene.control.Label;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class CirclePane extends BorderPane
{
    private ComboBox<String> primaryColorCombo; // Combo box that allows the user to change the primary color
    private ComboBox<String>      bgColorCombo; // Combo box that allows the user to change the background color
    private ComboBox<String>        widthCombo; // Combo box that allows the user to change the stroke width
    private Color                 primaryColor; // Color that the selected circle will show as
    private Color               secondaryColor; // Color that adjacent circles to the selected circle will show as
    private Color                      bgColor; // Color of the circles that aren't selected nor adjacent to the other circles
    private int                    selectWidth; // Stroke width of the circles
    private Circle[][]             circleArray; // Array that holds all of the circles

    private final int NUM_COL = 6, NUM_ROW = 6, RADIUS = 40;
    private GridPane canvas;	//this is where circles are drawn

    /**
     * Default constructor of the CirclePane class
     */
    public CirclePane()
    {
    	/* Initializes the combo box with primary color options */
    	primaryColorCombo = new ComboBox<String>();
    	primaryColorCombo.getItems().addAll("Black",  "Red", "Green", "Blue");
    	primaryColorCombo.setValue("Black");
    	
    	/* Initializes the combo box with background color options */
    	bgColorCombo = new ComboBox<String>();
    	bgColorCombo.getItems().addAll("White",  "Beige", "Alice Blue", "Gold");
    	bgColorCombo.setValue("White");
    	
    	/* Initializes the combo box with stroke width options */
    	widthCombo = new ComboBox<String>();
    	widthCombo.getItems().addAll("1",  "3", "5", "7");
    	widthCombo.setValue("1");
    	
    	/* Sets default colors and width */
    	primaryColor = Color.BLACK;
    	secondaryColor = Color.GRAY;
    	bgColor = Color.WHITE;
    	selectWidth = 1;
    	
    	/* Initializes three labels for user feedback */
    	Label primaryColorLabel = new Label("PrimaryColor");
    	Label bgColorLabel = new Label("BackgroundColor");
    	Label widthLabel = new Label("StrokeWidth");
    	
    	/* Instantiates a 2D array with 6 row and 6 columns for 36 total items */
    	circleArray = new Circle[NUM_ROW][NUM_COL];
    	
    	/* Instantiates a grid pane to hold the array elements */
        canvas = new GridPane();
        canvas.setPrefWidth(2*RADIUS * NUM_COL);
        canvas.setPrefHeight(2*RADIUS * NUM_ROW);
        
        /* Fills the circle array with circles and adds them to the gridpane */
    	for(int row = 0; row < circleArray.length; row++)
    	{
    		for (int column = 0; column < circleArray[row].length; column++)
    		{
    			/* Creates and sets properties for the circles in the array */
    			circleArray[row][column] = new Circle(RADIUS/2, RADIUS/2, RADIUS);
    			circleArray[row][column].setFill(bgColor);
    			circleArray[row][column].setStroke(Color.BLACK);
    			circleArray[row][column].setStrokeWidth(selectWidth);
    			
    			/* Adds the element in the array to the grid pane */
    			canvas.add(circleArray[row][column], column, row);
    		}
    	}
    	
        /* Creates and formats a VBox for the left side to hold the labels and combo boxes */
    	VBox leftPane = new VBox();
        leftPane.setSpacing(20);
        leftPane.setPadding(new Insets(10, 10, 10, 10));
        leftPane.setStyle("-fx-border-color: black");
        
        /* Adds the labels and combo boxes to the left pane */
        leftPane.getChildren().addAll(primaryColorLabel, primaryColorCombo, bgColorLabel, bgColorCombo, widthLabel, widthCombo);
        
        /* Adds the left and right panes to this border pane class */
        this.setLeft(leftPane);
        this.setCenter(canvas);
        
        /* Registers source nodes with their respective handler objects */
        primaryColorCombo.setOnAction(new PrimaryColorHandler());
        bgColorCombo.setOnAction(new BackgroundColorHandler());
        widthCombo.setOnAction(new WidthHandler());
        canvas.setOnMouseDragged(new MouseHandler());
    }

    /** MouseHandler handles mouse interaction  */
    private class MouseHandler implements EventHandler<MouseEvent>
    {
        public void handle(MouseEvent event)
        {
        	/*
        	 * While the mouse is dragged, find the circle that is being selected and set its color to
        	 * the primary color.
        	 * Next, fill every other circle with the background color.
        	 * Lastly, fill the circles surroundimg the main circle with the secondary color.
        	 */
        	if(event.getEventType()== MouseEvent.MOUSE_DRAGGED)
        	{
        		int selectedColumn = (int) event.getX()/(RADIUS*2); // Corresponding column based on mouse location
        		int selectedRow    = (int) event.getY()/(RADIUS*2); // Corresponding row based on mouse location
        		
        		/* If the mouse gets off the screen, there'll be an IndexOutOfBounds exception.  In that case, don't stop the program */
        		try
        		{
        			/* Run through the 2D array of circles */
        			for(int row = 0; row < circleArray.length; row++)
                	{
                		for (int column = 0; column < circleArray[row].length; column++)
                		{
                			/* If the current circle is the one selected, set its color to the primaryColor */
                			if (row == selectedRow && column == selectedColumn)
                			{
                        		circleArray[row][column].setFill(primaryColor);
                			}
                			
                			/* 
                			 * This section only runs if the circle selected is within the circle array.
                			 * It ensures that if the mouse isn't selecting any circle, then no changes will
                			 * be made.
                			 */
                			else if ((selectedRow < NUM_ROW && selectedRow >= 0) &&
                				(selectedColumn < NUM_COL && selectedColumn >= 0))
                			{
                				/* If the current circle is adjacent to the selected circle, fill it with the secondaryColor */
                				if((column - 1 == selectedColumn && row == selectedRow) ||
                				   (column + 1 == selectedColumn && row == selectedRow) ||
                				   (row - 1 == selectedRow && column == selectedColumn) ||
                				   (row + 1 == selectedRow && column == selectedColumn))
                    			{
                    				circleArray[row][column].setFill(secondaryColor);
                    			}
                				/* If the current circle isn't the one selected, fill it with the bgColor */
                    			else
                    			{
                    				circleArray[row][column].setFill(bgColor);
                    			}
                			}
                		}
                	}
        		}
        		
        		catch (ArrayIndexOutOfBoundsException exception)
        		{
        			// Don't stop the program, but do nothing
        		}
        		
        	}
        }
    }//end MouseHandler

	/** primaryColorHandler handles the primaryColor combo box */
    private class PrimaryColorHandler implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent event)
        {
			/* Checks to see which option is selected and chooses the color appropriately */
    		switch (primaryColorCombo.getValue())
    		{
    			case "Black":
    				primaryColor = Color.BLACK;
    				secondaryColor = Color.GRAY;
    				break;
    			case "Red":
    				primaryColor = Color.RED;
    				secondaryColor = Color.PINK;
    				break;
    			case "Green":
    				primaryColor = Color.GREEN;
    				secondaryColor = Color.LIGHTGREEN;
    				break;
    			case "Blue":
    				primaryColor = Color.BLUE;
    				secondaryColor = Color.POWDERBLUE;
    				break;
    			default:
    				primaryColor = Color.BLACK;
    				secondaryColor = Color.GRAY;
    				break;
    		}
        	
		}
    }//end PrimaryColorHandler

    /** BackgroundColorHandler handles the background color combo box*/
    private class BackgroundColorHandler implements EventHandler<ActionEvent>
    {
    	public void handle(ActionEvent event)
    	{
    		/* Checks to see which option is selected and chooses the color appropriately */
    		switch (bgColorCombo.getValue())
    		{
    			case "White":
    				bgColor = Color.WHITE;
    				break;
    			case "Beige":
    				bgColor = Color.BEIGE;
    				break;
    			case "Alice Blue":
    				bgColor = Color.ALICEBLUE;
    				break;
    			case "Gold":
    				bgColor = Color.GOLD;
    				break;
    			default:
    				bgColor = Color.WHITE;
    				break;
    		}
        	
    		/* If a new color is selected, set all the circles to the new bgColor */
        	for(int row = 0; row < circleArray.length; row++)
        	{
        		for (int column = 0; column < circleArray[row].length; column++)
        		{
        			circleArray[row][column].setFill(bgColor);
        		}
        	}
    	}
    }

    /** WidthHandler handles the stroke width combo box*/
    private class WidthHandler implements EventHandler<ActionEvent>
    {
    	public void handle(ActionEvent event)
        {
    		/* Checks to see which option is selected and chooses the stroke width appropriately */
    		switch (widthCombo.getValue())
    		{
    			case "1":
    				selectWidth = 1;
    				break;
    			case "3":
    				selectWidth = 3;
    				break;
    			case "5":
    				selectWidth = 5;
    				break;
    			case "7":
    				selectWidth = 7;
    				break;
    			default:
    				selectWidth = 1;
    				break;
    		}
        	
    		/* If a new stroke width is selected, set all the circles to the new stroke width */
        	for(int row = 0; row < circleArray.length; row++)
        	{
        		for (int column = 0; column < circleArray[row].length; column++)
        		{
        			circleArray[row][column].setStrokeWidth(selectWidth);
        		}
        	}

		}
    }//end of WidthHandler

} //end of CirclePane