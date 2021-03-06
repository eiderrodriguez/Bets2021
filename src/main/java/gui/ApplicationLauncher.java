package gui;

import java.awt.Color;
import java.net.URL;
import java.util.Locale;

import javax.swing.UIManager;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import configuration.ConfigXML;
import dataAccess.DataAccess;
import factory.BusinessLogicFactory;
import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;

public class ApplicationLauncher {
	
	public static void main(String[] args){
		ConfigXML c = ConfigXML.getInstance();
		System.out.println(c.getLocale());		
		Locale.setDefault(new Locale(c.getLocale()));
		System.out.println("Locale: "+Locale.getDefault());
		Login a=new Login();

		try {
			
			BLFacade appFacadeInterface;
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			
			appFacadeInterface = BusinessLogicFactory.createBusinessLogic(c.isBusinessLogicLocal());
			MainGUI.setBussinessLogic(appFacadeInterface);
			a.setVisible(true);
		
		}catch (Exception e) {
			//a.jLabelSelectOption.setText("Error: "+e.toString());
			//a.jLabelSelectOption.setForeground(Color.RED);		
			
			System.out.println("Error in ApplicationLauncher: "+e.toString());
		}
	}

}
