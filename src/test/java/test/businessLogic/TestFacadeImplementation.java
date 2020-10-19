package test.businessLogic;


import java.util.Date;

import configuration.ConfigXML;
import domain.Event;
import domain.Pertsona;
import domain.PertsonaErregistratua;
import test.dataAccess.TestDataAccess;

public class TestFacadeImplementation {
	TestDataAccess dbManagerTest;
 	
    
	   public TestFacadeImplementation()  {
			
			System.out.println("Creating TestFacadeImplementation instance");
			ConfigXML c=ConfigXML.getInstance();
			dbManagerTest=new TestDataAccess(); 
			dbManagerTest.close();
		}
		
		 
		public boolean removeEvent(Event ev) {
			dbManagerTest.open();
			boolean b=dbManagerTest.removeEvent(ev);
			dbManagerTest.close();
			return b;

		}
		
		public Event addEvent(String desc, Date d) {
			dbManagerTest.open();
			Event o=dbManagerTest.addEvent(desc,d);
			dbManagerTest.close();
			return o;

		}
		
		public boolean removeUser(Pertsona u) {
			dbManagerTest.open();
			boolean b=dbManagerTest.removeUser(u);
			dbManagerTest.close();
			return b;

		}
		
		public Pertsona addUser(String iz, String ab1, String ab2, String email, int nZ, String nL, String pasahitz) {
			dbManagerTest.open();
			Pertsona o=dbManagerTest.addUser(iz, ab1, ab2, email, nZ, nL, pasahitz);
			dbManagerTest.close();
			return o;

		}

}
