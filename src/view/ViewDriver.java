package view;

import javax.swing.UIManager;

import view.mainjframe.MainJFrame;
import view.mainjframe.MainJFrameController;

public class ViewDriver {

	/**
	 * This is the starting point/constructor that will create the maninFrame and
	 * controller so that the first view will start
	 */
	public ViewDriver() {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		MainJFrame mainJFrame = new MainJFrame();

	
		MainJFrameController mainJFrameController = new MainJFrameController(mainJFrame);

	}

	/**
	 * This is the main method for the whole application
	 */
	public static void main(String[] args) {
		new ViewDriver();
	}

}