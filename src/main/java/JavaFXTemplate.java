import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.MotionBlur;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;


public class JavaFXTemplate extends Application {

		
		
	//++++++++++++++++ Creating Attributes keep trace of thing going in the game. +++++++++++++
		
		//stores scenes
		HashMap<String, Scene> sceneMap;
		
		private MenuBar BAR;//private Button MenuButton, for all the use in all the Screens ;
		
		
		public int Spot;//Attribute to store the number of spot chosen by the user
		public int Round;//Attribute to store the number of Rounds chosen by the user
		public int SpotCount;//Attribute to  keep running count of Spot
		public int RoundCount;//Attribute to  keep running count of Rounds
		public int drowCount = 20;//Attribute to  keep running count of Draws in every round
		public int MatchNums = 0; //Attribute to  keep running count of numbers matched in every round;
		public  String Data;//Attributer to display the score in the game 
		public Stage me;
		
		
		public int TScore = 0; //Attribute to store the Score per Round 
		public int GameScore = 0;//Attribute to store the Score in total in all the Round. 
		
		public ArrayList<Integer> UserList; // ArrayList to store number picked by the user.
		public ArrayList<Integer> CompList; // ArrayList to store numbers picked by the Computer.
		public ArrayList<Integer> MatchList; // ArrayList to store numbers picked by the Computer.
		
		public ArrayList<Integer> RandomUserList; // ArrayList to store number picked by the user.
		
		GridPane grid = new GridPane();
		int button_num = 1;


		
		public Button globalButton;
		int val = 0; 
		int randCount = 0; //Random Value counter 
		boolean changeBackground = false;
		Menu mOne;
		 
		
		public int getSpot() {
			return Spot; // ???????????????????
		}
		
		//++++++++++++++++ END // Attributes keep trace of thing going in the game. +++++++++++++
		

		//++++++++++++++++ Creating buttons for the Welcome Screen.+++++++++++++++++++
		private Button start;
		Text Welcome;
		
		//++++++++++++++++ END // buttons for the Welcome Screen.+++++++++++++++++++
		


		//++++++++++++++++Creating buttons for the Spot Choosing Screen.+++++++++++++++++++

		private ToggleButton SpotVal1; 
		private ToggleButton SpotVal4;
		private ToggleButton SpotVal8;
		private ToggleButton SpotVal10;
		private Button SpotContinue;
				
		
		
		//++++++++++++++++ END // buttons for the Spot Choosing Screen.+++++++++++++++++++
		
		
		//++++++++++++++++Creating buttons for the Rounds Choosing Screen.+++++++++++++++++++
		
		private ToggleButton RoundVal1;
		private ToggleButton RoundVal2;
		private ToggleButton RoundVal3;
		private ToggleButton RoundVal4;
		private Button RoundContinue;
		
		//++++++++++++++++ END // buttons for the Rounds Choosing Screen.+++++++++++++++++++
		
	
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			launch(args); // Set up javafx as an application 
			
			JavaFXTemplate hi = new JavaFXTemplate();
			
			System.out.print("Value of Spot == " + hi.getSpot() );
			
			
		}

//+++++++++++++++++++++++++++++++++++++++++++ Starting ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		// Starting the game and Initializing  all the thing we need, during the game. 
		@Override
		public void start(Stage primaryStage) throws Exception {
			
			// TODO Auto-generated method stub
			
			sceneMap = new HashMap<String,Scene>(); // Initializing scenes storing H ashMap
			UserList = new ArrayList<Integer>();	// Initializing the array list for the User picks 
			CompList = new ArrayList<Integer>();	// Initializing the array list for the computer picks
			RandomUserList = new ArrayList<Integer>();
			MatchList = new ArrayList<Integer>();
		
			primaryStage.setTitle("Keno Game Welcome !!!");//Setting the title of the Welcome Window.

		
		//================== Creating Menu and setting is Actions=================		
		
			BAR = new MenuBar(); //A menu bar takes menus as children

			mOne = new Menu("Menu"); //a menu goes inside a menu bar and with all the windows 
		
			MenuItem iOne = new MenuItem("Rule"); //MenuItem which will lunch  a new window for Rules.
			MenuItem iTwo = new MenuItem("Odds of winning"); //MenuItem which will lunch  a new window for  Odds of winning.
			MenuItem iThree = new MenuItem("Exit"); // Terminate the Game; 
			MenuItem iFour = new MenuItem("How to Play"); ///MenuItem which will lunch  a new window for giving ore information on how to play the game.
		
		
			mOne.getItems().add(iOne); // Adding button for the rules in the menu bar
			mOne.getItems().add(iTwo); // Adding the button for the odd of winning data window in the menu bar
			mOne.getItems().add(iFour);	// Adding the button for the "How to Play" Data window in the menu bar
			mOne.getItems().add(iThree); // Adding Exit Button in 
			
			BAR.getMenus().addAll(mOne); //Add our menu to the menus to the menu bar
		
		
			
			iThree.setOnAction((ActionEvent t) -> {System.exit(0);});//Setting Action for Exit Button to terminate the program
			iOne.setOnAction(e -> RulesWindow.Rules());// Setting Action for Rules Button
			iTwo.setOnAction(e -> OddsWinWindow.Odds());//Setting Actions for Odds Button 
			iFour.setOnAction(e -> HowToPlay.PlayPrompt());// Setting Action for "How to Play" Button.
			
		//================== END Menu and setting is Actions=================	
			
		
			
		//================== Initializing and setting action needed for the Welcome Window=================	
	
		     
			
	    //================== END Initializing and setting action needed for the Welcome Window=================	
			
			
        //================== Initializing and setting action needed for the Rounds Window=================
		      
		      
				//Action for toggle button 1
				EventHandler<ActionEvent> RoundVal1Event = new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
						
						Round = 1;	// Setting round and Round Count to 1
						RoundCount = Round; // Setting round and Round Count to 1
						//System.out.print("Value of Round == " + Round);
						RoundContinue.setDisable(false); //Making Continue button available. 			
					} 
		            
		        }; 
		      //Action for toggle button 2
		        EventHandler<ActionEvent> RoundVal2Event = new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
						
						Round = 2;	// Setting round and Round Count to 2
						RoundCount = Round;// Setting round and Round Count to 2
						//System.out.print("Value of Round == " + Round);
						RoundContinue.setDisable(false);//Making Continue button available. 
						
					} 
		            
		        }; 
		      //Action for toggle button 3
		        EventHandler<ActionEvent> RoundVal3Event = new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
						
						Round = 3;	// Setting round and Round Count to 3
						RoundCount = Round; // Setting round and Round Count to 3
						//System.out.print("Value of Round == " + Round);
						RoundContinue.setDisable(false);//Making Continue button available. 
						 
					} 
		            
		        }; 
		      //Action for toggle button 4
		        EventHandler<ActionEvent> RoundVal4Event = new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
						Round = 4;	// Setting round and Round Count to 4
						RoundCount = Round;// Setting round and Round Count to 4
						//System.out.print("Value of Round == " + Round);
						RoundContinue.setDisable(false);//Making Continue button available. 			
					} 
		            
		        }; 
		       
		     //Action for the continue Button.    
			EventHandler<ActionEvent> RoundC = new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
						sceneMap.put("game", GameSecne());//Creating the seen for game window 
						primaryStage.setScene(sceneMap.get("game"));//Calling the game scene and going back to the game scene. 
					} 
		            
		        }; 
		        
		        
		        //Setting up four Toggle Button to chose number of rounds the player wants to play.
		        RoundVal1 = new ToggleButton(" 1 "); 
		        RoundVal2 = new ToggleButton(" 2 ");
		        RoundVal3 = new ToggleButton(" 3 ");
		        RoundVal4 = new ToggleButton(" 4 ");
		        
		        //Setting up the toggle group. 
		        ToggleGroup RoundGroup = new ToggleGroup();
		       
		        RoundVal1.setToggleGroup(RoundGroup);
		        RoundVal2.setToggleGroup(RoundGroup);
		        RoundVal3.setToggleGroup(RoundGroup);
		        RoundVal4.setToggleGroup(RoundGroup);
		        
		        //Setting Up Continue button to Continue playing the game. 
		        RoundContinue = new Button(" Continue the Game ");
		        RoundContinue.setDisable(true);

		        //Setting up Action for all the toggle and Continue button. 
		        RoundVal1.setOnAction(RoundVal1Event);
		        RoundVal2.setOnAction(RoundVal2Event);
		        RoundVal3.setOnAction(RoundVal3Event);
		        RoundVal4.setOnAction(RoundVal4Event);
		        RoundContinue.setOnAction(RoundC);
		       
				
		      
	      //==================END  Initializing and setting action needed for the Rounds Window=================
		      
		      
	      //================== Initializing and setting action needed for the Spot Window=================
		        
		        
				EventHandler<ActionEvent> SpotVal1Event = new EventHandler<ActionEvent>() {
		
					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
						
						Spot = 1;	// Setting spot and spot Count to 1
						SpotCount = Spot;	// Setting spot and spot Count to 1
						//System.out.print("Value of Spot == " + Spot);
						SpotContinue.setDisable(false);//Making Continue button available. 			
						
					} 
		            
		        }; 
		        
		        EventHandler<ActionEvent> SpotVal4Event = new EventHandler<ActionEvent>() {
		
					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
						Spot = 4; // Setting spot and spot Count to 4
						SpotCount = Spot; // Setting spot and spot Count to 4
						//System.out.print("Value of Spot == " + Spot);
						SpotContinue.setDisable(false);//Making Continue button available. 			
						
					} 
		            
		        }; 
		        EventHandler<ActionEvent> SpotVal8Event = new EventHandler<ActionEvent>() {
		
					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
						Spot = 8;	// Setting spot and spot Count to 8
						SpotCount = Spot; // Setting spot and spot Count to 8
						//System.out.print("Value of Spot == " + Spot);
						SpotContinue.setDisable(false);//Making Continue button available. 			
						
					} 
		            
		        }; EventHandler<ActionEvent> SpotVal10Event = new EventHandler<ActionEvent>() {
		
					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
						Spot = 10;	// Setting spot and spot Count to 10
						SpotCount = Spot; // Setting spot and spot Count to 10
						//System.out.print("Value of Spot == " + Spot);
						SpotContinue.setDisable(false);//Making Continue button available. 			
					} 
		            
		        }; 
		
			
			EventHandler<ActionEvent> SpotC = new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
						sceneMap.put("rounds", roundsScene()); // Creating the round selection Scene
						primaryStage.setScene(sceneMap.get("rounds")); //Calling the round selecting Scene 
					} 
		            
		        }; 
		        //Setting up four Toggle Button to chose number of Spot the player wants to play.
				SpotVal1 = new ToggleButton(" 1 ");
				SpotVal4 = new ToggleButton(" 4 ");
				SpotVal8 = new ToggleButton(" 8 ");
				SpotVal10 = new ToggleButton(" 10 ");
				
				//Setting up the toggle group. 
				ToggleGroup SpotGroup = new ToggleGroup();
			       
				SpotVal1.setToggleGroup(SpotGroup);
				SpotVal4.setToggleGroup(SpotGroup);
				SpotVal8.setToggleGroup(SpotGroup);
				SpotVal10.setToggleGroup(SpotGroup);
				
				//Setting Up Continue button to Continue playing the game. 
				SpotContinue = new Button(" Continue the Game ");
				SpotContinue.setDisable(true);
				
				//Setting up Action for all the toggle and Continue button. 
				SpotVal1.setOnAction(SpotVal1Event);
				SpotVal4.setOnAction(SpotVal4Event);
				SpotVal8.setOnAction(SpotVal8Event);
				SpotVal10.setOnAction(SpotVal10Event);
				SpotContinue.setOnAction(SpotC);
					
		//================== END Initializing and setting action needed for the Spot Window=================	
				
				
		//================== Initializing and setting action needed for the Welcome Window=================		
				
				EventHandler<ActionEvent> Start = new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {
							sceneMap.put("spots", spotScene()); //Setting up the screen for the spot selection 
							primaryStage.setScene(sceneMap.get("spots")); //Calling the scene for spot selection 
						} 

				}; 
				
				//Creating and setting action to the play Keno button 
				start = new Button("PLAY KENO");
				start.setTextAlignment(TextAlignment.CENTER);
				start.setOnAction(Start);
				
		//================== END Initializing and setting action needed for the Spot Window=================			
				
				
		//================== Adding the Scenes in the HashMap================
				
				sceneMap.put("scene", welcomeScene());
// 				sceneMap.put("spots", spotScene());
// 				sceneMap.put("rounds", roundsScene());
// 				sceneMap.put("game", GameSecne());
				
		//================== END Adding the Scenes in the HashMap================
				
		
		//================== Setting up Primary Stage.================		
			
				//new scene with root node
				me = primaryStage;
				primaryStage.setScene(sceneMap.get("scene")); //set the scene in the stage
				primaryStage.show(); //make visible to the user
				
		//================== ENDSetting up Primary Stage.================	
				
				
								
				
		
	}
		
		

//+++++++++++++++++++++++++++++++++++++++++++ END Start ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

		

	
	
	
	//All the things that are set on the welcome Scene. 
	
	public Scene welcomeScene() {
		
		
		BorderPane Pane = new BorderPane();//Setting up border pane
		Welcome = new Text();     //Setting text for welcome screen
	    Welcome.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 55)); // Making Text Fancy 
	    Welcome.setFill(Color.YELLOW); //Setting color to yellow 
	    Welcome.setStrokeWidth(2);  // Setting the text size
	    Welcome.setText("Welcome to the Game\n"); // Assing the text 
	    Welcome.setStyle("-fx-border-color: black;"+ "-fx-border-size: 20px"); //Making the text border
		
		VBox vbox1 = new VBox(70, BAR); //Setting Vertical box with a BAR
		VBox paneCenter = new VBox(30, Welcome, start); //Adding welcome text and start box 
		
		Pane.setCenter(paneCenter); 
		Pane.setTop(vbox1); //Setting menu bar at the top.
		if(changeBackground == false) {
			Pane.setStyle("-fx-background-image: url(welcome1.jpeg)");
		}
		else {
			Pane.setStyle("-fx-background-image: url(WelcomeSpace.jpg)");
		}
		//Pane.setStyle("-fx-background-image: url(welcome1.jpeg)"); //Makeing the frame fancy 
		start.setPrefSize(140, 70);
		start.setTranslateY(85);
		start.setTranslateX(65);
		
		
		//Setting the style for the start button. 
		start.setStyle("-fx-background-color: #090a0c," + 
						"linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%)," +
						"linear-gradient(#20262b, #191d22)," +
						"radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));" +
						"-fx-background-radius: 5,4,3,5;" +
						"-fx-background-insets: 0,1,2,0;" +
						"-fx-text-fill: white;" +
						"-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );" +
						"-fx-font-family: Arial;" +
						"-fx-text-fill: linear-gradient(white, #d0d0d0);" +
						"-fx-font-size: 12px;");
		
		
		MotionBlur mb = new MotionBlur(); 
		mb.setRadius(6.0f);
		mb.setAngle(40.0f);
		Welcome.setTranslateY(125);
		Welcome.setEffect(mb);
		
		//Returning the Scene on Welcome. 
		return new Scene(Pane, 900, 600);
		
	}
	
	public Scene spotScene() { //Creating the spot selecting window. 
		
		
		//Creating the text to display text for the screen. 
		Text textMessage = new Text("Select your spot");
  
		BorderPane Pane = new BorderPane();//Setting up borderPane
		
		//Adding all the buttons on in an HBox to Display.
		HBox buttons = new HBox(45,SpotVal1 , SpotVal4, SpotVal8, SpotVal10);
		buttons.setAlignment(Pos.BOTTOM_CENTER);

		//Adding the text to display in an HBox
		HBox text = new HBox(30, textMessage);
		text.setAlignment(Pos.BOTTOM_CENTER);
		text.setPadding(new Insets(50));
		
		//Adding the continue button in an HBox
		HBox cont = new HBox(50, SpotContinue);
		cont.setAlignment(Pos.BOTTOM_RIGHT);
		cont.setPadding(new Insets(95));

		//Creating a VBox on the, with the BAR at the top.
		VBox paneCenter = new VBox(30,BAR);

		//Adding text, sopt option buttons and then continue button on the scree. 
		paneCenter.getChildren().addAll(text,buttons,cont);
		Pane.setCenter(paneCenter);
		
		//Making text fancy. 
		textMessage.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 65));
		textMessage.setFill(Color.YELLOW);
		//Pane.setStyle("-fx-background-image: url(spots.jpg)");
		if(changeBackground == false) {
			Pane.setStyle("-fx-background-image: url(spots.jpg)");
		}
		else {
			Pane.setStyle("-fx-background-image: url(SpotBackground.jpeg)");
		}
		//Setting the size of the button. 
		SpotVal1.setPrefSize(70, 70);
		SpotVal4.setPrefSize(70, 70);
		SpotVal8.setPrefSize(70, 70);
		SpotVal10.setPrefSize(70, 70);
		
		MotionBlur mb = new MotionBlur();
		mb.setRadius(6.0f);
		mb.setAngle(40.0f);
		
		text.setEffect(mb);
		
		//Defining a design to the button 
		buttonDesign(SpotVal1);
		buttonDesign(SpotVal4);
		buttonDesign(SpotVal8);
		buttonDesign(SpotVal10);
		
		//Making text Facny 
		cont.setStyle("-fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;" +
				  " -fx-background-radius: 8;" + 
				  "-fx-background-color:clinear-gradient(from 0% 93% to 0% 100%, #a34313 50%, #903b12 100%), #9d4024,#d86e3a," +
				  "radial-gradient(center 50% 50%, radius 100%, #d86e3a, #c54e2c);" +
				  "-fx-effect: dropshadow( gaussian , rgba(0,0,0,1) , 4,0,0,0 );"+
			      "-fx-font-family: Arial;" +
				  "-fx-font-weight: bold;" + 
				  "-fx-font-size: 2.3em");


		//Returning the screen. 
		return new Scene(Pane, 1000, 600);		
	}
	
	
	public Scene roundsScene() {
		
		//Setting text for the spot windows 
		Text text = new Text("Select Your Rounds");
		
		//Setting text.
		text.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 65));
		text.setFill(Color.ORANGERED);
		MotionBlur mb = new MotionBlur();
		mb.setRadius(6.0f);
		mb.setAngle(40.0f);
		
		//Making text fancy 
		text.setEffect(mb);
		
		//Setting up borderPane
		BorderPane Pane = new BorderPane();
		
		//Creating a hbox to keep the text at the top 
		HBox hbox = new HBox(30, text);
		hbox.setAlignment(Pos.BOTTOM_CENTER);
		hbox.setPadding(new Insets(50));
		
		//Creating a hbox to add all the nmber buttons 
		HBox buttons = new HBox(45, RoundVal1 , RoundVal2, RoundVal3, RoundVal4);
		buttons.setAlignment(Pos.BOTTOM_CENTER);

		//Creating another hbox to add continue button. 
		HBox cont = new HBox(45, RoundContinue);
		cont.setAlignment(Pos.BOTTOM_RIGHT);
		cont.setPadding(new Insets(95));
		
		
		//Make a vbox to add the menu bar at the top.
		VBox paneCenter = new VBox(30,BAR);
		//Pane.setStyle("-fx-background-image: url(rounds2.jpg)");
		
		if(changeBackground == false) {
			Pane.setStyle("-fx-background-image: url(rounds2.jpg)");
		}
		else {
			Pane.setStyle("-fx-background-image: url(RoundBackground.jpg)");
		}

		//Adjusting sizes of the button 
		RoundVal1.setPrefSize(70, 70);
		RoundVal2.setPrefSize(70, 70);
		RoundVal3.setPrefSize(70, 70);
		RoundVal4.setPrefSize(70, 70);
		
		//Adding text, round option buttons and then continue button on the scree. 	
		paneCenter.getChildren().addAll(hbox,buttons,cont);

		Pane.setCenter(paneCenter);
		
		//Defining a design to the button 
		buttonDesign(RoundVal1);
		buttonDesign(RoundVal2);
		buttonDesign(RoundVal3);
		buttonDesign(RoundVal4);
		
		//Making text Facny 
		cont.setStyle("-fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;" +
				  " -fx-background-radius: 8;" + 
				  "-fx-background-color:clinear-gradient(from 0% 93% to 0% 100%, #a34313 50%, #903b12 100%), #9d4024,#d86e3a," +
				  "radial-gradient(center 50% 50%, radius 100%, #d86e3a, #c54e2c);" +
				  "-fx-effect: dropshadow( gaussian , rgba(0,0,0,1) , 4,0,0,0 );"+
			      "-fx-font-family: Arial;" +
				  "-fx-font-weight: bold;" + 
				  "-fx-font-size: 2.3em");
		
		//returning the scene. 
		return new Scene(Pane, 1000, 600);	
	}
	
	
	
	public Scene GameSecne() {	
	//====================The Grid ======================
		/*
		 * method to populate a GridPane with buttons and attach a handler to each button
		 */
	
		
	grid = new GridPane();//creating an instance of  grid 
	//Setting padding and alignment of the grid
	grid.setHgap(10);
	grid.setVgap(10);
	grid.setAlignment(Pos.CENTER);
	
	
	
	button_num = 1; // Veriabe to asign the numbers to the button on the grid 

	 
	//Creating two for loops for x and y axis, to place buttons on..
     for(int x = 0; x < 8; x++) {
         for(int i = 0; i < 10; i++) {

        	 //Creating a button 
             Button b1 = new Button(Integer.toString(button_num));
             button_num++;//increaidng the button number 
             b1.setPrefSize(50,50);// Setting the size of the button 
             //Settin the action to the button 
             b1.setOnAction(new EventHandler<ActionEvent>() {
             
                 @Override
                 public void handle(ActionEvent e) {
 
                	// System.out.println(" \n SpotCount " + SpotCount);
                	 if (SpotCount > 0) {
                     
                	 // TODO Auto-generated method stub
                     //System.out.println(" \n button pressed: " + ((Button)e.getSource()).getText());
                     String s = ((Button)e.getSource()).getText();		// picking the button  
                     UserList.add(Integer.valueOf(s));	// Adding button number to the UserList for matching later 
                     Button b1 = (Button)e.getSource();	
                     b1.setStyle("-fx-background-color: red;"); //Making picked button fancy 
                     b1.setDisable(true); // Setting picked button to disable so no one pick it up again.
//                     for (Integer e1 :UserList  ) {
//                    	 System.out.println(" " + e1);}
                     SpotCount--; // reduciing the spot count.
                     
                 }
               }
             });
             grid.add(b1, i, x); //Setting x and y axis of the button. 
         }
     }
     grid.setTranslateX(190);
	
 	//====================The Grid END======================
     
    //====================The Score Borad======================
     
     //+++++++++++++++++++ ALL buttons, text , textfield setups+++++++++++++++;

     //Setting all the text that are in the game window.
     Text Score = new Text(" Score: ");
     Text drawing = new Text("Drawing left: ");
     Text RoundText = new Text("Rounds Left: ");
     Text NumPick = new Text("Numbers picked by game:");
     Text TotalGameScore = new Text("The Score of the total Game are :");
     
     //Making the text fancy and, to a particular size. 
     Score.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 30)); // Making Text Fancy 
     Score.setFill(Color.YELLOW); 
     Score.setStrokeWidth(2); 
     Score.setTranslateX(5);
     Score.setTranslateY(2);
     
     ////Making the text fancy and, to a particular size. 
     drawing.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 30)); // Making Text Fancy 
     drawing.setFill(Color.YELLOW); 
     drawing.setStrokeWidth(2); 
     drawing.setTranslateX(10);
     drawing.setTranslateY(5);
     
     //Making the text fancy and, to a particular size. 
     RoundText.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 30)); // Making Text Fancy 
     RoundText.setFill(Color.YELLOW); 
     RoundText.setStrokeWidth(2); 
     RoundText.setTranslateX(10);
     RoundText.setTranslateY(7);
     
     //Making the text fancy and, to a particular size. 
     NumPick.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 30)); // Making Text Fancy 
     NumPick.setFill(Color.YELLOW); 
     NumPick.setStrokeWidth(2); 
     NumPick.setTranslateX(10);
     NumPick.setTranslateY(10);
     
    //Making the text fancy and, to a particular size. 
     TotalGameScore.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 30)); // Making Text Fancy 
     TotalGameScore.setFill(Color.YELLOW); 
     TotalGameScore.setStrokeWidth(2); 
     TotalGameScore.setTranslateX(10);
     
     
     //Making the text fancy and, to a particular size. 
     Text MatchText = new Text("Numbers Matched in the List: ");
     MatchText.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 30)); // Making Text Fancy 
     MatchText.setFill(Color.YELLOW); 
     MatchText.setStrokeWidth(2); 

     
     
     //Setting up uneditable text box to display number matched 
     TextField MatchData = new TextField();
     MatchData.setEditable(false);
     MatchData.setMouseTransparent(true);
     MatchData.setFocusTraversable(false);
     MatchData.setText(" NaN ");
     MatchData.setTranslateX(-20);
     MatchData.setTranslateY(10);
     
   //Setting up uneditable text box to display Total Game Score Data 
     TextField TotalGameScoreData = new TextField();
     TotalGameScoreData.setEditable(false);
     TotalGameScoreData.setMouseTransparent(true);
     TotalGameScoreData.setFocusTraversable(false);
     TotalGameScoreData.setText(" 0 ");
     TotalGameScoreData.setTranslateY(5);

     //Setting up uneditable text box to display Picks
     TextField Picks = new TextField();
     Picks.setEditable(false);
     Picks.setMouseTransparent(true);
     Picks.setFocusTraversable(false);
     Picks.setPrefWidth(450);
     Picks.setTranslateY(10);
     
     //Setting up uneditable text box to display current game score Data 
     TextField ScoreData = new TextField();
     ScoreData.setEditable(false);
     ScoreData.setMouseTransparent(true);
     ScoreData.setFocusTraversable(false);
     ScoreData.setText(" 0 ");
     ScoreData.setTranslateY(9);
     //ScoreData.setTranslateX(-5);
     
     //Setting up uneditable text box to display number od draw left 
     TextField drawsLeft = new TextField();
     drawsLeft.setEditable(false);
     drawsLeft.setMouseTransparent(true);
     drawsLeft.setFocusTraversable(false);
     drawsLeft.setText(" 20 ");
     drawsLeft.setTranslateY(10);
     
   //Setting up uneditable text box to display number of rounds left 
     TextField RoundsLeft = new TextField();
     RoundsLeft.setEditable(false);
     RoundsLeft.setMouseTransparent(true);
     RoundsLeft.setFocusTraversable(false);
     RoundsLeft.setTranslateY(10);
     RoundsLeft.setTranslateX(-10);
    
     //Creating buttons needed to play game. 
     Button Drow = new Button(" Drow ");
     Button Clear = new Button("Clear");
     Button Random = new Button("Random");
     Button NewGame = new Button ("Play_Again");
     Button NextRound =  new Button ("NextRound");
     
     //Setting all the buttons to a set design 
     buttonDesign(NextRound);
     buttonDesign(Drow);
     buttonDesign(Clear);
     buttonDesign(Random);
     buttonDesign(NewGame);
     //Setting needed buttons to disable, to avoid cheating 
     NewGame.setDisable(true);
     NextRound.setDisable(true);
     
   //+++++++++++++++++++ END ALL buttons, text , textfield setups+++++++++++++++;   
     
     
     // Adding action to the next round button click 
     NextRound.setOnAction(new EventHandler<ActionEvent>()
	 {
		@Override
		public void handle(ActionEvent event) {
			if(RoundCount!=0)
			{
			//resetting all the attributes that are needed to play next round 
			TScore = 0; 
			UserList.clear();
			CompList.clear();
			RandomUserList.clear();
			MatchData.setText("NaN");
			SpotCount = Spot;
			drowCount = 20;
			MatchNums = 0;
			//Resetting all the text field to defalt
			Picks.setText("  ");
			ScoreData.setText(" 0 ");
			drawsLeft.setText(" 20 ");
			
		
			//Resetting all the grid buttons to default
			for(Node child: grid.getChildren()) {	
				child.setDisable(false);
				//child.setStyle("-fx-border-color: black");
				child.setStyle(null);
			}	
			
			//Making needed buttons available to play 
			Clear.setDisable(false);
			Drow.setDisable(false);
			Random.setDisable(false);
			MatchList.clear(); // Clearing the match list
			//Making next round button unavailable until needed.  
			NextRound.setDisable(true);
			
			}
		}
		});
     
     

     //Setting Actions for the Draw button
     Drow.setOnAction(new EventHandler<ActionEvent>()
	 {

		@Override
		public void handle(ActionEvent event) {
		
//			System.out.println("Spot Count: " + SpotCount);
//			System.out.println("Spot Count: " + Spot);
//			System.out.println("Drow Count: " + drowCount);

			//setting random button disable so player can't pick other numbers. 
			Random.setDisable(true);
			
			
//			for(Integer e: UserList) {
//				System.out.println(e);
//			}
//			
//			for(Integer e: RandomUserList) {
//				System.out.println(e);
//			}

		//Checking if the condition for the draw is correct or not
		if(SpotCount == 0 && drowCount != 0 ){
			
			//Setting the clear button to disable.
			Clear.setDisable(true);
			drowCount--;//Reducing the draw count 
			
			//Reducing the round count if the player is  
			if(drowCount == 0) {
				RoundCount--;
			}
			
			//Resetting the draw counts ever time user draws a number 
			String p = String.valueOf(drowCount); 
			drawsLeft.setText( p );
			
			//getting a random number fore the drawing. 
			int num = GetRandomNumber();
			while(CompList.contains(num)) {//Making sure random number is not repeated.
				num = GetRandomNumber();
			}
			
			//adding unique random number to the computer generated list.
			CompList.add(num);
			
			//changing the gui affects of the random number.
			int counter2 = num;
			for(Node Child: grid.getChildren()) {
				if(counter2 == 1) {
					Child.setStyle("-fx-background-color: blue");
					Child.setDisable(true);
				}
				counter2--;
			}
			
			////changing the gui affects of the random number if it matches with the user picked numbers. 
			if(UserList.contains(num)) {
				MatchNums++;
				
				int counter = num;
				for(Node Child: grid.getChildren()) {
					if(counter == 1) {
						Child.setStyle("-fx-background-color: lightgreen");
					}
					counter--;
				}
				
				//adding the number to the match list id it matches and changing the data in the match list.
				MatchList.add(num);
				String MatchD = " ";
				for(Integer a :MatchList) {
					MatchD =  String.valueOf(a)+ ", " + MatchD;
				}
				MatchData.setText(MatchD);
				
			}

			//if the number matches updating the score. 
			TScore = ScoreCal(MatchNums);
			p = String.valueOf(TScore);
			ScoreData.setText( p );
			
			//updating the picked list wich displays the computer generated numbers. 
			Data = "";
		    for (Integer e1 :CompList  ) {
		    	 	Data = String.valueOf(e1)+ ", " +Data;
		    }
		    Picks.setText(Data);
		    
		    //updating the numbers of the rounds left. 
		    RoundsLeft.setText(String.valueOf(RoundCount));
		    
		
		}
		else if (RoundCount > 0 && drowCount == 0){//checking the condition if the user is done with the current round n need to go to the next round.
			
			NextRound.setDisable(false);//making next round button avaliabe 
			RoundsLeft.setText(String.valueOf(RoundCount));//resetting next round text field.
			Drow.setDisable(true);//making draw button unavailabe 
			GameScore = GameScore + TScore;//Adding current game score to the total game. 
			TotalGameScoreData.setText(String.valueOf(GameScore));//updating the totle score text box
			
		}
		
		else if(RoundCount == 0 && drowCount == 0) {//checking the condition if game is over and user need to exit or restart. 
			
			GameScore = GameScore + TScore;// Adding the current game score to the total score.
			TotalGameScoreData.setText(String.valueOf(GameScore));//displaying the total score in the totle score tect box
			//resetting all the other text box data to game over. 
			RoundsLeft.setText(" GAME OVER ");
			ScoreData.setText(" GAME OVER ");
			drawsLeft.setText(" GAME OVER ");
			Picks.setText(" GAME OVER ");
			MatchData.setText("GAME OVER");
			//Making all the other text button unavailabe 
			Drow.setDisable(true);
			Clear.setDisable(true);
			Random.setDisable(true);
			NextRound.setDisable(true);
			//Making the new game button availabe.
			NewGame.setDisable(false);
			
		}
		}
	});


     //Setting actions for the clear button. 
     Clear.setOnAction(new EventHandler<ActionEvent>()
    		 {

				@Override
				public void handle(ActionEvent event) {
					
					SpotCount = Spot;//updating the spot count for the game
					UserList.clear();//Clearing the user and the random list 
					RandomUserList.clear();//Clearing the user and the random list 
					Random.setDisable(false);//Making the random button unavailabe
					
					//Resetting all the affects in the grid.
					for(Node child: grid.getChildren()) {	
						child.setDisable(false);
						//child.setStyle("-fx-border-color: black");
						child.setStyle(null);
					}	
				}
     });
     
     //Setting actions for the random button.
     Random.setOnAction(new EventHandler<ActionEvent>(){

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			
			SpotCount = Spot;//updating the spot count for the game
			UserList.clear();//clearing the user list
			
			//Resetting all the affects in the grid.
			for(Node Child: grid.getChildren()) {
				Child.setDisable(false);
				Child.setStyle(null);
			}
			UserList.clear();//clearing the user list
			
			//Generating unique random numbers applying affects to thoes and also adding it to the random numbers list. 
			for(int i = 0; i < Spot; i++) {	
				val = GetRandomNumber();
				while(UserList.contains(val)) {
					val = GetRandomNumber();
				}
				int count = 1;
				for(Node Child: grid.getChildren()) {		
					if(val!= count) {
						count++;
					}
					else {
						SpotCount--;
	                     Child.setStyle("-fx-background-color: red;");
						disbaleRandomButton(val, Child);
						count = 1;
						break;
					}
				}
					
			}
			//Disabeling the random number button
			Random.setDisable(true);
			}
    	 
     });
     
     
     // Setting actions for the new game button 
     NewGame.setOnAction(new EventHandler<ActionEvent>()
	 {
		@Override
		public void handle(ActionEvent event) {
			
			
			//Clearinga all the list. 
			UserList.clear();
			CompList.clear();
			RandomUserList.clear();
			MatchList.clear();
			//Resetting all the attribute to the default values. 
			TScore = 0;  
			SpotCount = Spot;
			drowCount = 20;
			MatchNums = 0;
			Spot = 0;
			Round = 0;
			SpotCount = 0;
			RoundCount = 0;
			drowCount = 20;
			MatchNums = 0; 
			Data = " ";
			TScore = 0; 
			GameScore = 0;
			//Making all the buttons availabe to play game which are needed.
			RoundContinue.setDisable(true);
			SpotContinue.setDisable(true);
			//Resetting all the text in the text box.
			drawsLeft.setText(" 20 ");
			ScoreData.setText(" 0 ");
			TotalGameScoreData.setText(" 0 ");
			Picks.setText(" ");
			MatchData.setText(" NaN ");
			RoundsLeft.setText("  ");
			me.setScene(sceneMap.get("scene"));
		}
	});
     
     
     //Setting up the game window. 
     HBox TheGRID = new HBox(50, grid);//adding gid
     TheGRID.setStyle("-fx-background-image: url(grid.jpg);");
     HBox ScoreDataBox = new HBox(50 ,Score, ScoreData , Clear, NextRound, NewGame);//Adding button, text and text box in the screen 
     HBox DrowDataBox = new HBox (50, drawing, drawsLeft, Drow, Random);//Adding button, text and text box in the screen 
     HBox CompDataBox = new HBox(50, NumPick,Picks);//Adding button, text and text box in the screen 
     HBox RoundDataBox = new HBox(50, RoundText, RoundsLeft, MatchText, MatchData ); //Adding button, text and text box in the screen 
     HBox TotalScoreBox = new HBox(50, TotalGameScore, TotalGameScoreData ); //Adding button, text and text box in the screen 
     VBox barGrid = new VBox(50, BAR, TheGRID);//Adding button, text and text box in the screen 
     VBox group = new VBox  (40 ,ScoreDataBox, DrowDataBox, CompDataBox, RoundDataBox, TotalScoreBox);//Adding all the thinkgs in one box.

     //making the backgroundy fancy 
     barGrid.getChildren().add(group);
     //barGrid.setStyle("-fx-background-image: url(background.jpg);");
		
	MenuItem iFive = new MenuItem("Change Look"); 
	mOne.getItems().add(iFive);

	iFive.setOnAction((ActionEvent t) -> {changeBackground = true;
						barGrid.setStyle("-fx-background-image: url(SpaceBackground.jpeg)");
						TheGRID.setStyle("-fx-background-image: none;");});		
     
	if(changeBackground == false) {
		barGrid.setStyle("-fx-background-image: url(background.jpg)");
		TheGRID.setStyle("-fx-background-image: url(grid.jpg);");
	}
	else {
		barGrid.setStyle("-fx-background-image: url(SpaceBackground.jpeg)");
	}
     //====================The Score Borad END======================
	
     return new Scene(barGrid, 1000, 1000);
	}
	
	

	//Method that calculate the score and returns an int 
	public int ScoreCal(int num) {
		
		if (num == 1) {
			return 1; //if 1 number matches score == 1
		}
		else if(num == 2 ) {
			return 11;// if 2 number matches score == 11
		}
		else if(num == 3) {
			return 27; // if 3 number matches score == 27
		}
		else if(num == 4) {
			return 75; // if 4 number matches score == 75
		}
		else if(num == 5) {
			return  420;// if 5 number matches score == 420
		}
		else if(num == 6) {
			return  1100;// if 6 number matches score == 1100
		}
		else if(num == 7) {
			return  4500;// if 7 number matches score == 4500
		}
		else if(num == 8) {
			return  10000;// if 8 number matches score == 10000
		}
		
		else if(num == 9) {
			return  30000;// if 9 number matches score == 30000
		}
		else if(num == 10) {
			return  100000;// if 10 number matches score == 100000
		}

		return 0;
	}
	
	
	//Method that generats random number form 1 to 80
	public int GetRandomNumber() {
		
		Random rand = new Random();
		return (1 + rand.nextInt(80));
	}
	
	
	//Method to diable the random number selection button.
	public void disbaleRandomButton(int val, Node Child) {
		UserList.clear();
		Child.setDisable(true);
		RandomUserList.add(val);
		for(Integer e: RandomUserList) {
			UserList.add(e);
		}

	}
	
	//Method to add affects to the buttons. >>http://fxexperience.com/2011/12/styling-fx-buttons-with-css/
	public void buttonDesign(ToggleButton spotVal12) {
		spotVal12.setStyle("-fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;" +
				  " -fx-background-radius: 8;" + 
				  "-fx-background-color:clinear-gradient(from 0% 93% to 0% 100%, #a34313 50%, #903b12 100%), #9d4024,#d86e3a," +
			      "-fx-font-family: Arial;" +
				  "-fx-font-weight: bold;" + 
				  "radial-gradient(center 50% 50%, radius 100%, #d86e3a, #c54e2c);" +
				  "-fx-effect: dropshadow( gaussian , rgba(0,0,0,1) , 4,0,0,0 );"+
				  "-fx-font-size: 2.3em");
	}
	
	//Method to add affects to the buttons. >>http://fxexperience.com/2011/12/styling-fx-buttons-with-css/
	public void buttonDesign(Button spotVal12) {
		spotVal12.setStyle("-fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;" +
				  " -fx-background-radius: 8;" + 
				  "-fx-background-color:clinear-gradient(from 0% 93% to 0% 100%, #a34313 50%, #903b12 100%), #9d4024,#d86e3a," +
				  "-fx-font-family: Arial;" +
				  "-fx-font-weight: bold;" + 
				  "radial-gradient(center 50% 50%, radius 100%, #d86e3a, #c54e2c);" +
				  "-fx-effect: dropshadow( gaussian , rgba(0,0,0,1) , 4,0,0,0 );"+
				  "-fx-font-size: 2.3em");
	}
	
	
	
	
	
}
