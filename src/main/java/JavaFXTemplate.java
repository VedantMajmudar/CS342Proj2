import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;


//This is vedant commenting the line. 


public class JavaFXTemplate extends Application {

		private MenuBar BAR;
		private Button MenuButton;
		
		public int Spot;
		public int getSpot() {
			return Spot;
		}




		private Button SpotVal1;
		private Button SpotVal4;
		private Button SpotVal8;
		private Button SpotVal10;
		
		 
	
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args); // Set up javafx as an application 
		
		JavaFXTemplate hi = new JavaFXTemplate();
		
		System.out.print("Value of Spot == " + hi.getSpot() );
		
		
	}

	
	
	
	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		primaryStage.setTitle("Keno Main Menu");//Setting the title of the window.
		
		
		
		
		
//==================++++++++++++MENU+++++++++++=================		
		BAR = new MenuBar(); //a menu bar takes menus as children
		MenuButton = new Button("Menu"); //Menu button on the Menu bar 
		
		Menu mOne = new Menu("Menu"); //a menu goes inside a menu bar and with all the windows 
		
		
		
		MenuItem iOne = new MenuItem("Rule"); //MenuItem which will lunch  a new window for Rules.
		MenuItem iTwo = new MenuItem("Odds of winning"); //MenuItem which will lunch  a new window for  Odds of winning.
		MenuItem iThree = new MenuItem("Exit"); // Terminate the ; 
		
		
		
		mOne.getItems().add(iOne); //add menu item to first menu
		mOne.getItems().add(iTwo);
		mOne.getItems().add(iThree);
		
		BAR.getMenus().addAll(mOne); //add our menu to the menus to the menu bar
		
		
		//event handler for menu item
			//Setting Exit Button to terminate the program
			iThree.setOnAction((ActionEvent t) -> {
					System.exit(0);
				}); 
			//
	
			iOne.setOnAction(e -> RulesWindow.Rules());
			iTwo.setOnAction(e -> OddsWinWindow.Odds());
//==================++++++++++++MENU+++++++++++=================
			
			
			
			
	
		      Text Welcome = new Text();      
		      

		      Welcome.setText("Welcome to the Game Please select your Spot"); 
			
			

			
			
	
//==================++++++++++++SPot+++++++++++=================
			
			
			EventHandler<ActionEvent> SpotVal1Event = new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					Spot = 1;	
					System.out.print("Value of Spot == " + Spot);
				} 
	            
	        }; 
	        
	        EventHandler<ActionEvent> SpotVal4Event = new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					Spot = 4;	
					System.out.print("Value of Spot == " + Spot);
				} 
	            
	        }; 
	        EventHandler<ActionEvent> SpotVal8Event = new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					Spot = 8;	
					System.out.print("Value of Spot == " + Spot);
				} 
	            
	        }; EventHandler<ActionEvent> SpotVal10Event = new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					Spot = 10;	
					System.out.print("Value of Spot == " + Spot);
				} 
	            
	        }; 

			SpotVal1 = new Button(" 1 ");
			SpotVal4 = new Button(" 4 ");
			SpotVal8 = new Button(" 8 ");
			SpotVal10 = new Button(" 10 ");

			SpotVal1.setOnAction(SpotVal1Event);
			SpotVal4.setOnAction(SpotVal4Event);
			SpotVal8.setOnAction(SpotVal8Event);
			SpotVal10.setOnAction(SpotVal10Event);
			
			
			
//==================++++++++++++SPot+++++++++++=================
			
			
		//new scene with root node
		Scene scene = new Scene(new VBox(30,BAR, Welcome,SpotVal1, SpotVal4, SpotVal8, SpotVal10),1000,700);
		primaryStage.setScene(scene); //set the scene in the stage
		primaryStage.show(); //make visible to the user
		
	}
	
	/*
	 * method to populate a GridPane with buttons and attach a handler to each button
	 */

}
	
	