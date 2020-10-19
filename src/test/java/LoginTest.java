import static org.junit.Assert.*;

import javax.swing.JOptionPane;

import org.junit.BeforeClass;
import org.junit.Test;

import businessLogic.BLFacadeImplementation;
import configuration.ConfigXML;
import dataAccess.DataAccess;
import domain.Pertsona;
import test.businessLogic.TestFacadeImplementation;

public class LoginTest {

	static BLFacadeImplementation sut;
	static TestFacadeImplementation testBL;

	private Pertsona per;

	@BeforeClass
	public static void setUpClass() {
		//sut= new BLFacadeImplementation();
		// you can parametrize the DataAccess used by BLFacadeImplementation
		DataAccess da= new DataAccess(ConfigXML.getInstance().getDataBaseOpenMode().equals("initialize"));
		sut=new BLFacadeImplementation(da);
		testBL= new TestFacadeImplementation();
	}
	@Test
	//Pertsona datu basean dago, TRUE
	public void test1() {
		try {
			int nan = 98765432;
			String pasahitza = "proba";
			per = testBL.addUser("Eider", "Rodriguez", "Martinez", "erodriguez086@ikasle.ehu.eus", 98765432, "D", "proba");
			boolean login = sut.login(nan, pasahitza);
			assertTrue(true);
		}catch(Exception e){
			fail();
		}finally {
			boolean b = testBL.removeUser(per);
			System.out.println("Finally "+b);
		}
	}
	@Test
	//Pertsona ez dago datu basean, FALSE
	public void test2() {
		try {
			int nan = 12345678;
			String pasahitza = "aaaa";
			per = testBL.addUser("Eider", "Rodriguez", "Martinez", "erodriguez086@ikasle.ehu.eus", 98765432, "D", "proba");
			boolean login = sut.login(nan, pasahitza);
			assertEquals(login, false);
		}catch(Exception e){
			fail();
		}finally {
			boolean b = testBL.removeUser(per);
			System.out.println("Finally "+b);
		}
	}
	@Test
	//Pasahitza null, FALSE
	public void test3() {
		try {
			int nan = 98765432;
			String pasahitza = null;
			per = testBL.addUser("Eider", "Rodriguez", "Martinez", "erodriguez086@ikasle.ehu.eus", 98765432, "D", "proba");
			boolean login = sut.login(nan, pasahitza);
			assertEquals(login, false);
		}catch(Exception e){
			fail();
		}finally {
			boolean b = testBL.removeUser(per);
			System.out.println("Finally "+b);
		}
	}
	@Test
	//Pasahitza okerra, FALSE
	public void test4() {
		try {
			int nan = 98765432;
			String pasahitza = "proba1";
			per = testBL.addUser("Eider", "Rodriguez", "Martinez", "erodriguez086@ikasle.ehu.eus", 98765432, "D", "proba");
			boolean login = sut.login(nan, pasahitza);
			assertEquals(login, false);
		}catch(Exception e){
			fail();
		}finally {
			boolean b = testBL.removeUser(per);
			System.out.println("Finally "+b);
		}
	}
}
