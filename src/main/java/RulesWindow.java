import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;



public class RulesWindow {

	public static void Rules() {
		
		Stage RuleWindow = new Stage();
		RuleWindow.initModality(Modality.APPLICATION_MODAL);
		RuleWindow.setTitle("Rules");
		RuleWindow.setMinWidth(250);
		
		Label RulesData = new Label();
		RulesData.setStyle("-fx-background-color: BLACK");
		RulesData.setTextFill(Color.LIME); 
		RulesData.setText("1. Decide how much to play per draw. Each play costs $1. Play for $2 to double your prize; play for $3 to triple your "
				+ "prize and so on up to $10 per play.\n" + 
				"2. Select how many consecutive draws to play. Pick up to 20. Drawings happen every 4 minutes.\n" + 
				"3. Select how many numbers to match from 1 to 10. In Keno, these are called Spots. The number of Spots you choose and the amount"
				+ " you play per draw will determine the amount you could win. See the prize chart to determine the amount you could win with a $1 "
				+ "play.\n" + 
				"4. Pick as many numbers as you did Spots. You can select numbers from 1 to 80 or choose Quick Pick and let the computer terminal "
				+ "randomly pick some or all of these numbers for you.\n" + 
				"5. Add Multiplier to increase all prizes up to 10X. Multiplier doubles base ticket cost.\n");
	
		VBox layout = new VBox(10);
		layout.getChildren().addAll(RulesData);
		layout.setAlignment(Pos.TOP_CENTER);
		
		Scene scene = new Scene(layout, Color.BLACK);
		RuleWindow.setScene(scene);
		RuleWindow.showAndWait();
	}
}
