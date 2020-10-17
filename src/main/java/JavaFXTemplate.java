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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
		
		
		public int TScore = 0; //Attribute to store the Score per Round 
		public int GameScore = 0;//Attribute to store the Score in total in all the Round. 
		
		public ArrayList<Integer> UserList; // ArrayList to store number picked by the user.
		public ArrayList<Integer> CompList; // ArrayList to store numbers picked by the Computer.
		
		public ArrayList<Integer> RandomUserList; // ArrayList to store number picked by the user.
		
		GridPane grid = new GridPane();
		int button_num = 1;


		
		public Button globalButton;
		int val = 0;
		int randCount = 0;
		 
		
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
		
			primaryStage.setTitle("Keno Game Welcome !!!");//Setting the title of the Welcome Window.

		
		//================== Creating Menu and setting is Actions=================		
		
			BAR = new MenuBar(); //A menu bar takes menus as children

			Menu mOne = new Menu("Menu"); //a menu goes inside a menu bar and with all the windows 
		
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
	
		      Welcome = new Text();     //Setting Text for the welcome window. 
		      Welcome.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 50)); // Making Text Fancy 
		      Welcome.setFill(Color.ROYALBLUE); // Adding color to the text 
		      Welcome.setStrokeWidth(2); // Setting the Size of the Fonts 
		      Welcome.setText("Welcome to the Game\n");	// Setting text. 
			
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
		        RoundContinue.setOnAction(e -> primaryStage.setScene(sceneMap.get("game")));
		       
				
		      
	      //==================END  Initializing and setting action needed for the Rounds Window=================
		      
		      
	      //================== Initializing and setting action needed for the Spot Window=================
		        
		        
				EventHandler<ActionEvent> SpotVal1Event = new EventHandler<ActionEvent>() {
		
					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
						
						Spot = 1;	
						SpotCount = Spot;
						System.out.print("Value of Spot == " + Spot);
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
				
				SpotContinue.setOnAction(e -> primaryStage.setScene(sceneMap.get("rounds")));
					
		//================== END Initializing and setting action needed for the Spot Window=================	
				
				
		//================== Initializing and setting action needed for the Welcome Window=================		
				
				start = new Button("PLAY KENO");
				start.setTextAlignment(TextAlignment.CENTER);
				start.setOnAction(e-> primaryStage.setScene(sceneMap.get("spots")));
				
		//================== END Initializing and setting action needed for the Spot Window=================			
				
				
		//================== Adding the Scenes in the HashMap================
				
				sceneMap.put("scene", welcomeScene());
				sceneMap.put("spots", spotScene());
				sceneMap.put("rounds", roundsScene());
				sceneMap.put("game", GameSecne());
				
		//================== END Adding the Scenes in the HashMap================
				
		
		//================== Setting up Primary Stage.================		
			
				//new scene with root node
				primaryStage.setScene(sceneMap.get("scene")); //set the scene in the stage
				primaryStage.show(); //make visible to the user
				
		//================== ENDSetting up Primary Stage.================	
				
				
								
				
		
	}
		
		

//+++++++++++++++++++++++++++++++++++++++++++ END Start ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

		

	
	/*
	 * method to populate a GridPane with buttons and attach a handler to each button
	 */
	
	
	
	public Scene welcomeScene() {
		
		BorderPane Pane = new BorderPane();
		Pane.setPadding(new Insets(70));
		
		VBox paneCenter = new VBox(30,BAR, Welcome, start);
		
		Pane.setCenter(paneCenter);
		
		return new Scene(Pane, 600, 450);
		
	}
	
	public Scene spotScene() {
		
		Text textMessage = new Text("Select your spot");
		textMessage.setTextAlignment(TextAlignment.CENTER);
		textMessage.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 50));
		textMessage.setFill(Color.ROYALBLUE);
		textMessage.setStrokeWidth(2);
	      
		
		
		//Menu spotMenu = new Menu("menu");
		
		BorderPane Pane = new BorderPane();
		//Pane.setPadding(new Insets(70));
		
		HBox buttons = new HBox(30, BAR ,SpotVal1 , SpotVal4, SpotVal8, SpotVal10, SpotContinue);
		buttons.setAlignment(Pos.BOTTOM_CENTER);
		
		VBox paneCenter = new VBox(30,BAR);
		
		textMessage.setX(100);
		textMessage.setY(100);
		//paneCenter.getChildren().add(BAR);
		paneCenter.getChildren().add(textMessage);
		paneCenter.getChildren().add(buttons);
		
		Pane.setCenter(paneCenter);
		
		return new Scene(Pane, 600, 450);
		
		
		
	}
	
	
	public Scene roundsScene() {
		
		Text textMessage = new Text("Select Your Rounds");
		
		BorderPane Pane = new BorderPane();
		HBox buttons = new HBox(30,BAR ,RoundVal1 , RoundVal2, RoundVal3, RoundVal4, RoundContinue);
		VBox paneCenter = new VBox(30,BAR,textMessage);
		paneCenter.getChildren().add(buttons);
		Pane.setCenter(paneCenter);
		return new Scene(Pane, 600, 450);
		
 
		
	}
	
	public Scene GameSecne() {
		
	
		
	//====================The Grid ======================
	
		
	grid = new GridPane();
	grid.setHgap(10);
	grid.setVgap(10);
	grid.setAlignment(Pos.CENTER);
	
	 button_num = 1;
	 int counter = 0;

	 

     for(int x = 0; x < 8; x++) {
         for(int i = 0; i < 10; i++) {

             Button b1 = new Button(Integer.toString(button_num));
             button_num++;

             
             b1.setStyle("-fx-pref-height: 100px");
             b1.setStyle("-fx-pref-width: 100px");

             b1.setOnAction(new EventHandler<ActionEvent>() {
            	 //if(spotCont!=0) 
             
                 @Override
                 public void handle(ActionEvent e) {
                	
                	 
                	// System.out.println(" \n SpotCount " + SpotCount);
                	 if (SpotCount > 0) {
                     // TODO Auto-generated method stub
                     System.out.println(" \n button pressed: " + ((Button)e.getSource()).getText());
                     
                     
                     String s = ((Button)e.getSource()).getText();		 
                     UserList.add(Integer.valueOf(s));
                     
                     Button b1 = (Button)e.getSource();
                     b1.setDisable(true);
                     

//                     for (Integer e1 :UserList  ) {
//                    	 System.out.println(" " + e1);}
                     
                     SpotCount--;
                     
                 }
               }
             });
             grid.add(b1, i, x);

         }

     }
	
 	//====================The Grid END======================
   //====================The Score Borad======================
     
     
     //+++++++++++++++++++ ALL buttons, text , textfield setups+++++++++++++++;

     Text Score = new Text(" Score :");
     Text drawing = new Text("Drawing left:");
     Text Round = new Text("Rounds Left ");
     Text NumPick = new Text("Numbers picked by game:");
     Text TotalGameScore = new Text("The Score of the total Game are :");
     
     TextField TotalGameScoreData = new TextField();
     TotalGameScoreData.setEditable(false);
     TotalGameScoreData.setMouseTransparent(true);
     TotalGameScoreData.setFocusTraversable(false);
     TotalGameScoreData.setText(" 0 ");

     
     TextField Picks = new TextField();
     Picks.setEditable(false);
     Picks.setMouseTransparent(true);
     Picks.setFocusTraversable(false);
     Picks.setPrefWidth(450);
     
     
     TextField ScoreData = new TextField();
     ScoreData.setEditable(false);
     ScoreData.setMouseTransparent(true);
     ScoreData.setFocusTraversable(false);
     ScoreData.setText(" 0 ");
     
     
     TextField drawsLeft = new TextField();
     drawsLeft.setEditable(false);
     drawsLeft.setMouseTransparent(true);
     drawsLeft.setFocusTraversable(false);
     drawsLeft.setText(" 20 ");
     
     
     TextField RoundsLeft = new TextField();
     RoundsLeft.setEditable(false);
     RoundsLeft.setMouseTransparent(true);
     RoundsLeft.setFocusTraversable(false);
    
     
     Button Drow = new Button(" Drow ");
     Button Clear = new Button("Clear");
     Button Random = new Button("Random");

    
     Button NextRound =  new Button ("NextRound");
     NextRound.setDisable(true);
     
   //+++++++++++++++++++ END ALL buttons, text , textfield setups+++++++++++++++;   
     
     
     
     NextRound.setOnAction(new EventHandler<ActionEvent>()
	 {
		@Override
		public void handle(ActionEvent event) {
			
			
			if(RoundCount!=0)
			{
			//GameScore = GameScore + TScore;
			
			TScore = 0; 
			UserList.clear();
			CompList.clear();
			RandomUserList.clear();
			SpotCount = Spot;
			drowCount = 20;
			MatchNums = 0;
			Picks.setText("  ");

			ScoreData.setText(" 0 ");
			
			 drawsLeft.setText(" 20 ");
			
		
			
			for(Node child: grid.getChildren()) {	
				child.setDisable(false);
			}	
			Clear.setDisable(false);
			Drow.setDisable(false);
			Random.setDisable(false);
			
			NextRound.setDisable(true);
			
			}
		}
		});
     
     
   
     
     Drow.setOnAction(new EventHandler<ActionEvent>()
	 {

		@Override
		public void handle(ActionEvent event) {
		
			System.out.println("Spot Count: " + SpotCount);
			System.out.println("Spot Count: " + Spot);
			System.out.println("Drow Count: " + drowCount);
			
			for(Integer e: UserList) {
				System.out.println(e);
			}
			
			for(Integer e: RandomUserList) {
				System.out.println(e);
			}
			
		if(SpotCount == 0 && drowCount != 0 ){
			
			
			Clear.setDisable(true);
			
			drowCount--;
			
			if(drowCount == 0) {
				RoundCount--;
			}
			
			String p = String.valueOf(drowCount); 
			drawsLeft.setText( p );
			
			
			int num = GetRandomNumber();
			while(CompList.contains(num)) {
				num = GetRandomNumber();
			}
			CompList.add(num);
			
			
			
			if(UserList.contains(num)) {
				MatchNums++;
				
			}

			
			TScore = ScoreCal(MatchNums);
			p = String.valueOf(TScore);
			ScoreData.setText( p );
			
			
			Data = "";
		    for (Integer e1 :CompList  ) {
		    	 	Data = String.valueOf(e1)+ ", " +Data;
		    }

		    
		    Picks.setText(Data);
		    RoundsLeft.setText(String.valueOf(RoundCount));
		    
		
		}
		else if (RoundCount > 0 && drowCount == 0){
			
			NextRound.setDisable(false);
			RoundsLeft.setText(String.valueOf(RoundCount));
			Drow.setDisable(true);
			GameScore = GameScore + TScore;
			TotalGameScoreData.setText(String.valueOf(GameScore));
			
		}
		
		else if(RoundCount == 0 && drowCount == 0) {
			
			GameScore = GameScore + TScore;
			TotalGameScoreData.setText(String.valueOf(GameScore));
			RoundsLeft.setText(" GAME OVER ");
			ScoreData.setText(" GAME OVER ");
			drawsLeft.setText(" GAME OVER ");
			Picks.setText(" GAME OVER ");
			
			
		}
		}
	});


     
     Clear.setOnAction(new EventHandler<ActionEvent>()
    		 {

				@Override
				public void handle(ActionEvent event) {
				
					SpotCount = Spot;
					UserList.clear();
					RandomUserList.clear();
					Random.setDisable(false);
					
					for(Node child: grid.getChildren()) {	
						child.setDisable(false);
					}	
				}
     });
     
     Random.setOnAction(new EventHandler<ActionEvent>(){

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			
			
			for(Node Child: grid.getChildren()) {
				Child.setDisable(false);
			}
			UserList.clear();
			
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
							disbaleRandomButton(val, Child);
							count = 1;
							break;
						}
					}
					
				}
			
			Random.setDisable(true);
			
			}
    	 
     });
     
     
     HBox TheGRID = new HBox(50, grid);
     HBox ScoreDataBox = new HBox(50 ,Score, ScoreData , Clear, NextRound);
     HBox DrowDataBox = new HBox (50, Drow, drawing, drawsLeft, Random);
     HBox CompDataBox = new HBox(50, NumPick,Picks);
     HBox RoundDataBox = new HBox(50, Round, RoundsLeft ); 
     HBox TotalScoreBox = new HBox(50, TotalGameScore, TotalGameScoreData ); 
     
     
   //====================The Score Borad END======================
	return new Scene( new VBox  (40 , BAR, TheGRID , ScoreDataBox, DrowDataBox, CompDataBox, RoundDataBox, TotalScoreBox), 900, 700);
	}
	
	

	
	public int ScoreCal(int num) {
		
		
	if (num == 1) {
			return 1;
		}
		else if(num == 2 ) {
			return 11; 
		}
		else if(num == 3) {
			return 27;  
		}
		else if(num == 4) {
			return 75;
		}
		else if(num == 5) {
			return  420;
		}
		else if(num == 6) {
			return  1100;
		}
		else if(num == 7) {
			return  4500;
		}
		else if(num == 8) {
			return  10000;
		}
		
		else if(num == 9) {
			return  30000;
		}
		else if(num == 10) {
			return  100000;
		}

		return 0;
	}
	
	public int GetRandomNumber() {
		
		Random rand = new Random();
		return (1 + rand.nextInt(80));
	}
	
	public void disbaleRandomButton(int val, Node Child) {
		
		UserList.clear();
		
		Child.setDisable(true);
		RandomUserList.add(val);
				
		for(Integer e: RandomUserList) {
			UserList.add(e);
		}
		
		
	}
	
	
	
	
	
}
