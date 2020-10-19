import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import dataAccess.DataAccess;
import domain.Pertsona;

@RunWith(MockitoJUnitRunner.class)
public class LoginMockito { 

	DataAccess dataAccess = Mockito.mock(DataAccess.class);
	Pertsona mockedUser = Mockito.mock(Pertsona.class);

	@InjectMocks
	BLFacade sut = new BLFacadeImplementation(dataAccess);

	@Test
	//TRUE
	public void test1() {
		try {
			int nan = 98765432;
			String pasahitza = "proba";
			//configure Mock
			Mockito.doReturn(true).when(dataAccess).login(Mockito.anyInt(), Mockito.anyString());
			boolean login = sut.login(nan, pasahitza);
			assertEquals(login, true);
		}catch(Exception e){
			fail();
		}
	}

	@Test
	//FALSE
	public void test2() {
		try {
			int nan = 12345678;
			String pasahitza = "aaaa";
			//configure Mock
			Mockito.doReturn(false).when(dataAccess).login(Mockito.anyInt(), Mockito.anyString());
			boolean login = sut.login(nan, pasahitza);
			assertEquals(login, false);
		}catch(Exception e){
			fail();
		}
	}
	@Test
	//FALSE
	public void test3() {
		try {
			int nan = 98765432;
			String pasahitza = null;
			//configure Mock
			Mockito.doReturn(false).when(dataAccess).login(Mockito.anyInt(), Mockito.anyString());
			boolean login = sut.login(nan, pasahitza);
			assertEquals(login, false);
		}catch(Exception e){
			fail();
		}
	}
	@Test
	//FALSE
	public void test4() {
		try {
			int nan = 98765432;
			String pasahitza = "proba1";
			//configure Mock
			Mockito.doReturn(false).when(dataAccess).login(Mockito.anyInt(), Mockito.anyString());
			boolean login = sut.login(nan, pasahitza);
			assertEquals(login, false);
		}catch(Exception e){
			fail();
		}
	}
}
