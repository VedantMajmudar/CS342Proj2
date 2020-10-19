import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HowToPlay {

public static void PlayPrompt() {
		
		Stage RuleWindow = new Stage();
		RuleWindow.initModality(Modality.APPLICATION_MODAL);
		RuleWindow.setTitle("How to Play / Prompt");
		RuleWindow.setMinWidth(250);

		
		Label RulesData = new Label();
		RulesData.setStyle("-fx-background-color: BLACK");
		RulesData.setTextFill(Color.LIME); 
		RulesData.setText("\n\n"
				+ " HOW TO PLAY Window by Window \n\n"
				+ ">> Welcome Window << \n"	
				+ "	#The game will start with the welcome window. \n"
				+ " #Click on the 'Play Kino' button and game will take you to the Spot choosing window.\n\n" 
				
				+ ">> Spot choosing window <<\n"
				+ " #Click on the number of spots you want to pick \n"
				+ " #You can change the number if you want too\n"
				+ " #Once you are sure click on the 'continue the game' button, and game will take you to the rounds choosing window\n\n"
				
				+ ">> Round Choosing window <<\n"
				+ " #Click on the number of Round you want to pick \n"
				+ " #You can change the number if you want too\n"
				+ " #Once you are sure click on the 'continue the game' button, and game will take you to the game window\n\n"
				
				+ ">> Game Window <<\n"
				+ " #pick the number you want on the grid, OR click on random button so system will pick number for you\n"
				+ " #Youn can reselect all of it using clear button."
				+ " #Now hit the draw button 20 times. so computer will generate the numbers  \n"
				+ " #You can see the number in the game gride \n"
				+ " #Now you see the score you made in the game\n"
				+ " #Now Click the next round button and go to the ext round \n"
				+ " #Repeat it untill the game overs \n"
				+ " #Now the new game button is enabled so hit to play again or exit form the meun \n\n\n\n"
);
	
		VBox layout = new VBox(10);
		layout.getChildren().addAll(RulesData);
		layout.setAlignment(Pos.TOP_CENTER);
		
		Scene scene = new Scene(layout, Color.BLACK);
		RuleWindow.setScene(scene);
		RuleWindow.showAndWait();
	}
	
	
	
}
