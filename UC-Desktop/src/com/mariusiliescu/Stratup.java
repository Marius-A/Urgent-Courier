package com.mariusiliescu;

import java.awt.EventQueue;

import com.mariusiliescu.swingcontroller.MainController;
import com.mariusiliescu.view.MainInterface;

public class Stratup {
	public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
            	
            	new MainController(new MainInterface(), new Model());
            }
        });
	}
}
