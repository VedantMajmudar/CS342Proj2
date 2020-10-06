import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class OddsWinWindow {
	
public static void Odds() {
		
		Stage OddsWindow = new Stage();
		OddsWindow.initModality(Modality.APPLICATION_MODAL);
		OddsWindow.setTitle("Odds of Winning");
		OddsWindow.setMinWidth(250);
		
		Label OddsData = new Label();
		OddsData.setText("15\n" + 
				"14 == 1 in 428,010,179,098.40\n" + 
				"13 == 1 in 2,853,401,193.99\n" + 
				"12 == 1 in 1,539,397.31\n" +
				"11 == 1 in 81,020.91\n" + 
				"10 == 1 in 789.16\n" + 
				"9  == 1 in 136.40\n" +
				"8  == 1 in 33.46\n" + 
				"7  == 1 in 11.58\n" + 
				"6  == 1 in 5.68\n" + 
				"5  == 1 in 4.00\n" +
				"4  == 1 in 4.16\n" + 
				"3  == 1 in 6.76\n" + 
				"2  == 1 in 19.13 \n" + 
				"1  == 1 in 124.75 \n" );
				
	

		VBox layout = new VBox(10);
		layout.getChildren().addAll(OddsData);
		layout.setAlignment(Pos.TOP_CENTER);
		
		Scene scene = new Scene(layout);
		OddsWindow.setScene(scene);
		OddsWindow.showAndWait();

}
}