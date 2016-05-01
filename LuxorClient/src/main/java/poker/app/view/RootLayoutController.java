package poker.app.view;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.stage.FileChooser;
import poker.app.MainApp;
import pokerBase.Card;
import pokerEnums.eBet;
import pokerEnums.eGame;
import pokerEnums.eRank;
import pokerEnums.eSuit;


/**
 * The controller for the root layout. The root layout provides the basic
 * application layout containing a menu bar and space where other JavaFX
 * elements can be placed.
 * 
 * @author Marco Jakob
 */
public class RootLayoutController implements Initializable {

	// Reference to the main application
	private MainApp mainApp;

	@FXML
	private MenuBar mb;

	@FXML
	private Menu mnuGame;
	
	@FXML
	private Menu mnuRule;


	public String getRuleName()
	{	
		String strRuleID = null;
		for (Menu m: mb.getMenus())
		{
			if (m.getText() == "Pick Game")
			{
				for (MenuItem mi: m.getItems())
				{
					if (mi.getClass().equals(RadioMenuItem.class))
					{
						RadioMenuItem rmi = (RadioMenuItem)mi;
						if (rmi.isSelected() == true)
						{
							strRuleID = rmi.getId();
							break;
						}
					}
				}
			}
		}
		
		return strRuleID;
	}
	
	public void initialize(URL location, ResourceBundle resources) {

		BuildMenus();
	}
	
	public void BuildMenus()
	{

		Menu mnuGame = new Menu();
		mnuGame.setText("Pick Game");
		mb.getMenus().add(0,mnuGame);
				
		ToggleGroup tglGrpGame = new ToggleGroup();
		
		for (eGame eGame : eGame.values()) {
			RadioMenuItem rmi = new RadioMenuItem(eGame.toString());
			rmi.setId("PokerGame" + String.valueOf(eGame.getGame()));
			rmi.setToggleGroup(tglGrpGame);
			if (eGame.getDefault())
			{
				rmi.setSelected(true);
			}
			mnuGame.getItems().add(rmi);
		}
		
		Menu mnuRule = new Menu();
		mnuRule.setText("Betting Rules");
		mb.getMenus().add(0,mnuRule);
				
		ToggleGroup tglGrpBet = new ToggleGroup();
		
		for (eBet eBet : eBet.values()) {
			RadioMenuItem rmi = new RadioMenuItem(eBet.toString());
			rmi.setId("BettingRules" + String.valueOf(eBet.getRule()));
			rmi.setToggleGroup(tglGrpBet);
			if (eBet.getDefault())
			{
				rmi.setSelected(true);
			}
			mnuRule.getItems().add(rmi);
		}
	}
    
	public String getBetName()
	{	
		String strBetID = null;
		for (Menu m: mb.getMenus())
		{
			if (m.getText() == "Betting Rules")
			{
				for (MenuItem mi: m.getItems())
				{
					if (mi.getClass().equals(RadioMenuItem.class))
					{
						RadioMenuItem rmi = (RadioMenuItem)mi;
						if (rmi.isSelected() == true)
						{
							strBetID = rmi.getId();
							break;
						}
					}
				}
			}
		}
		
		return strBetID;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}


	@FXML
	private void handleAbout() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("AddressApp");
		alert.setHeaderText("About");
		alert.setContentText("Author: Bert Gibbons");

		alert.showAndWait();
	}

	/**
	 * Closes the application.
	 */
	@FXML
	private void handleExit() {
		System.exit(0);
	}



	

}