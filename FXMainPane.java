package lab5;




import javafx.application.Platform;	
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {
	
	
	//Button hello, howdy, Chinese, clear, exit;
	Label feedback; 
	TextField textField;
	//student Task #2:
	//  declare five buttons, a label, and a textfield
	//  declare two HBoxes
	//HBox hbox = new HBox();
	HBox hbox1;
	HBox hbox2;
	
	
	//student Task #4:
	//  declare an instance of DataManager
	
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		//  instantiate the HBoxes
		HBbox hbox1= new HBox();
	    HBbox hbox2= new HBox();
	    
	    Button hello= new Button();
	    hello.setText("Hello");
	    Button howdy = new Button("Howdy");
	    Button Chinese = new Button("Chinese");
	    Button clear = new Button("Clear");
	    Button exit = new Button("Exit");
	    
	   
	    

		
		//student Task #4:
		//  instantiate the DataManager instance
		//  set margins and set alignment of the components
	    dataManager = new DataManager();
	    // set margins and set alignment of the components
	    HBox.setMargin(hello, new Insets(10));
	    HBox.setMargin(howdy, new Insets(10));
	    HBox.setMargin(Chinese, new Insets(10));
	    HBox.setMargin(clear, new Insets(10));
	    HBox.setMargin(exit, new Insets(10));
	    
	    hbox1.setAlignment(Pos.CENTER);
	    hbox2.setAlignment(Pos.CENTER);
	     
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		//  add the buttons to the other HBox
		//  add the HBoxes to this FXMainPanel (a VBox)
	    feedback = new Label("Feedback");
	    textField = new TextField();
	    
	    hbox1.getChildren().addAll(hello, howdy, Chinese, clear, exit);
	    hbox2.getChildren().addAll(feedback, textField);
	    getChildren().addAll(hbox1,hbox2);
	      
	      
	    hello.setOnAction(new ButtonHandler());
	    howdy.setOnAction(new ButtonHandler());
	    Chinese.setOnAction(new ButtonHandler());
	    clear.setOnAction(new ButtonHandler());
	    exit.setOnAction(new ButtonHandler());
	    
	    
		
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	class ButtonHandler implements EventHandler<ActionEvent>{
	      
		@Override
		   public void handle(ActionEvent event) {
		       if (event.getTarget()==hello) {
		           textField.setText(dataManager.getHello());
		       }
		       else if (event.getTarget()==howdy) {
		           textField.setText(dataManager.getHowdy());
		       }
		       else if (event.getTarget()==Chinese) {
		           textField.setText(dataManager.getChinese());
		       }
		       else if (event.getTarget()==clear) {
		           textField.setText("");
		       }
		       else if (event.getTarget()==exit) {
		           Platform.exit();
		           System.exit(0);
		       }
		   }
	}
	
}

	
	