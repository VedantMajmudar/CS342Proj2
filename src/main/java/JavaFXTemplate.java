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

		private MenuBar BAR;
		private Button MenuButton;
		
		public  String Data;
		
		//stores scenes
		HashMap<String, Scene> sceneMap;
		

		public int Spot;
		public int SpotCount;
		public int Round;
		public int RoundCount;
		public int drowCount = 20;
		public int MatchNums = 0; 
		
		
		
		public int TScore = 0; 
		public int GameScore = 0;
		
		public ArrayList<Integer> UserList;
		public ArrayList<Integer> CompList;
		 
		public int getSpot() {
			return Spot;
		}




		private Button SpotVal1;
		private Button SpotVal4;
		private Button SpotVal8;
		private Button SpotVal10;
		private Button start;
		
		Text Welcome;
		
		
		private Button RoundVal1;
		private Button RoundVal2;
		private Button RoundVal3;
		private Button RoundVal4;
		
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
		
		sceneMap = new HashMap<String,Scene>();
		UserList = new ArrayList<Integer>();
		CompList = new ArrayList<Integer>();


		primaryStage.setTitle("Keno Main Menu");//Setting the title of the window.

		
		
//==================++++++++++++MENU+++++++++++=================		
		
		BAR = new MenuBar(); //a menu bar takes menus as children
		//MenuButton = new Button("Menu"); //Menu button on the Menu bar 
		
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
			
			
			
			
	
		      Welcome = new Text();     
		      Welcome.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 50));
		      Welcome.setFill(Color.ROYALBLUE);
		      Welcome.setStrokeWidth(2);
		      Welcome.setText("Welcome to the Game\n");		
			

			
			
	
//==================++++++++++++Rounds+++++++++++=================
		      
		      
				
				EventHandler<ActionEvent> RoundVal1Event = new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
						Round = 1;	
						System.out.print("Value of Round == " + Round);
						primaryStage.setScene(sceneMap.get("game"));
						RoundCount = Round;
						
					} 
		            
		        }; 
		        
		        EventHandler<ActionEvent> RoundVal2Event = new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
						Round = 2;	
						System.out.print("Value of Round == " + Round);
						primaryStage.setScene(sceneMap.get("game"));
						RoundCount = Round;
					} 
		            
		        }; 
		        EventHandler<ActionEvent> RoundVal3Event = new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
						Round = 3;	
						System.out.print("Value of Round == " + Round);
						primaryStage.setScene(sceneMap.get("game"));
						RoundCount = Round;
					} 
		            
		        }; EventHandler<ActionEvent> RoundVal4Event = new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
						Round = 4;	
						System.out.print("Value of Round == " + Round);
						primaryStage.setScene(sceneMap.get("game"));
						RoundCount = Round;
						
					} 
		            
		        }; 

		        RoundVal1 = new Button(" 1 ");
		        RoundVal2 = new Button(" 2 ");
		        RoundVal3 = new Button(" 3 ");
		        RoundVal4 = new Button(" 4 ");

		        RoundVal1.setOnAction(RoundVal1Event);
		        RoundVal2.setOnAction(RoundVal2Event);
		        RoundVal3.setOnAction(RoundVal3Event);
		        RoundVal4.setOnAction(RoundVal4Event);
				
		      
//==================++++++++++++Rounds End+++++++++++=================
		      
		      
//==================++++++++++++SPot+++++++++++=================
			
			
			EventHandler<ActionEvent> SpotVal1Event = new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					Spot = 1;	
					 SpotCount = Spot;
					System.out.print("Value of Spot == " + Spot);
					primaryStage.setScene(sceneMap.get("rounds"));
					
				} 
	            
	        }; 
	        
	        EventHandler<ActionEvent> SpotVal4Event = new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					Spot = 4;
					 SpotCount = Spot;
					System.out.print("Value of Spot == " + Spot);
					primaryStage.setScene(sceneMap.get("rounds"));
					
					
				} 
	            
	        }; 
	        EventHandler<ActionEvent> SpotVal8Event = new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					Spot = 8;	
					 SpotCount = Spot;
					System.out.print("Value of Spot == " + Spot);
					primaryStage.setScene(sceneMap.get("rounds"));
				} 
	            
	        }; EventHandler<ActionEvent> SpotVal10Event = new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					Spot = 10;	
					 SpotCount = Spot;
					System.out.print("Value of Spot == " + Spot);
					primaryStage.setScene(sceneMap.get("rounds"));
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
			
			
			
			start = new Button("PLAY KENO");
			start.setTextAlignment(TextAlignment.CENTER);
			
			start.setOnAction(e-> primaryStage.setScene(sceneMap.get("spots")));
			
			
			
//==================++++++++++++SPot+++++++++++=================		
			
		sceneMap.put("scene", welcomeScene());
		sceneMap.put("spots", spotScene());
		sceneMap.put("rounds", roundsScene());
		sceneMap.put("game", GameSecne());
		
			
		//new scene with root node
		primaryStage.setScene(sceneMap.get("scene")); //set the scene in the stage
		primaryStage.show(); //make visible to the user
		
		
		
	}
	
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
	      
		Menu spotMenu = new Menu("menu");
		
		BorderPane Pane = new BorderPane();
		//Pane.setPadding(new Insets(70));
		
		HBox buttons = new HBox(30, BAR ,SpotVal1 , SpotVal4, SpotVal8, SpotVal10);
		buttons.setAlignment(Pos.BOTTOM_CENTER);
		
		VBox paneCenter = new VBox(30,BAR);
		textMessage.setX(100);
		textMessage.setY(100);
		
		paneCenter.getChildren().add(textMessage);
		paneCenter.getChildren().add(buttons);
		
		Pane.setCenter(paneCenter);
		
		return new Scene(Pane, 600, 450);
		
	}
	
	
	public Scene roundsScene() {
		
		Text textMessage = new Text("Select Your Rounds");
		
		BorderPane Pane = new BorderPane();
		HBox buttons = new HBox(30,BAR ,RoundVal1 , RoundVal2, RoundVal3, RoundVal4);
		VBox paneCenter = new VBox(30,BAR,textMessage);
		paneCenter.getChildren().add(buttons);
		Pane.setCenter(paneCenter);
		return new Scene(Pane, 600, 450);
		
	}
	
	public Scene GameSecne() {
		
	
		
	//====================The Grid ======================
	
		
	GridPane grid = new GridPane();
	grid.setHgap(10);
	grid.setVgap(10);
	grid.setAlignment(Pos.CENTER);
	
	 int button_num = 1;


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
			}
		}
		});
     
     
   
     
     Drow.setOnAction(new EventHandler<ActionEvent>()
	 {

		@Override
		public void handle(ActionEvent event) {
		if(SpotCount == 0 && drowCount != 0 ){
			
			
			Clear.setDisable(true);
			
			drowCount--;
			
			if(drowCount == 0) {
				RoundCount--;
			}
			
			String p = String.valueOf(drowCount); 
			drawsLeft.setText( p );
			
			
			Random rand = new Random();
			int num = 1 + rand.nextInt(80);
			while(CompList.contains(num)) {
				num = 1 + rand.nextInt(80);
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
		    	 	Data = String.valueOf(e1)+ ", " +Data   ;
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
					
					for(Node child: grid.getChildren()) {	
						child.setDisable(false);
					}	
				}
     });
     
     
     HBox TheGRID = new HBox(50, grid);
     HBox ScoreDataBox = new HBox(50 ,Score, ScoreData , Clear, NextRound);
     HBox DrowDataBox = new HBox (50, Drow, drawing, drawsLeft);
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
	
	
	
}
