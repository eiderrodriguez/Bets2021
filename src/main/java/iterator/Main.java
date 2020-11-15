package iterator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import businessLogic.BLFacade;
import domain.Event;
import factory.BusinessLogicFactory;

public class Main {
	public static void main(String[] args) {
		boolean isLocal=true;
		//Facade objektua lortu lehendabiziko ariketa erabiliz 
		BLFacade facadeInterface = (new BusinessLogicFactory()).createBusinessLogic(isLocal);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date;
		
		try {
			date = sdf.parse("17/12/2020");
			ExtendedIterator<Event> i = facadeInterface.getEvents(date); 
			Event ev;
			System.out.println("________");
			System.out.println("Atzetik aurrera");
			i.goLast();
			while (i.hasPrevious()){
				ev=i.previous();
				System.out.println(ev.toString());
			}
			System.out.println();
			System.out.println("________");
			System.out.println("Aurretik atzera");
			i.goFirst();
			while (i.hasNext()){
				ev=i.next();
				System.out.println(ev.toString()); 
			}
		}catch (ParseException e1){
			System.out.println("Problems");
		}

	}
}
