package ro.go.mariusiliescu;

import java.awt.EventQueue;

import ro.go.mariusiliescu.swingcontroller.MainController;
import ro.go.mariusiliescu.view.MainInterface;

public class Stratup {
	public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
            	
            	new MainController(new MainInterface(), new Model());
            }
        });
	}
}
