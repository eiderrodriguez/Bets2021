package businessLogic;

import java.util.Vector;
import java.util.Collection;
import java.util.Date;
import java.util.List;

//import domain.Booking;
import domain.Question;
import domain.QuestionContainer;
import domain.ApustuContainer;
import domain.Apustua;
import domain.DiruMugimendua;
import domain.Event;
import domain.Kuota;
import domain.KuotaContainer;
import domain.Pertsona;
import domain.PertsonaErregistratua;
import exceptions.EventFinished;
import exceptions.QuestionAlreadyExist;
import iterator.ExtendedIterator;
import iterator.ExtendedIteratorEvents;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Interface that specifies the business logic.
 */
@WebService
public interface BLFacade  {
	

	/**
	 * This method creates a question for an event, with a question text and the minimum bet
	 * 
	 * @param event to which question is added
	 * @param question text of the question
	 * @param betMinimum minimum quantity of the bet
	 * @return the created question, or null, or an exception
	 * @throws EventFinished if current data is after data of the event
 	 * @throws QuestionAlreadyExist if the same question already exists for the event
	 */
	@WebMethod Question createQuestion(Event event, String question, float betMinimum) throws EventFinished, QuestionAlreadyExist;
	
	
	/**
	 * This method retrieves the events of a given date 
	 * 
	 * @param date in which events are retrieved
	 * @return collection of events
	 */
	//@WebMethod public Vector<Event> getEvents(Date date);
	@WebMethod public ExtendedIterator<Event> getEvents(Date date);
	/**
	 * This method retrieves from the database the dates a month for which there are events
	 * 
	 * @param date of the month for which days with events want to be retrieved 
	 * @return collection of dates
	 */
	@WebMethod public Vector<Date> getEventsMonth(Date date);
	
	/**
	 * This method calls the data access to initialize the database with some events and questions.
	 * It is invoked only when the option "initialize" is declared in the tag dataBaseOpenMode of resources/config.xml file
	 */	
	@WebMethod public void initializeBD();
	
	/////GUK EGINDAKOAK/////
	@WebMethod	public Pertsona getUserByNan(int nan);
	@WebMethod	public PertsonaErregistratua getErregistratuaByNan(int nan);
	@WebMethod	public boolean pertsonaErregistratu(String iz, String ab1, String ab2, String email, float dirua, Date jaioD, int nZ, String nL, String pasahitz, String pasahitz2);
	@WebMethod	public void gertaeraSortu(int gZenb, String gDeskr, Date gData);
	@WebMethod	public Event getEventByNumber(int gZenb);
	@WebMethod	public boolean login(int nan, String pasahitza);
	@WebMethod	public Collection<Event> getEventList();
	@WebMethod	public boolean kuotaGorde(String pronostikoa, float irabaziak, Question galdera);
	@WebMethod	public float updateDirua(int nan, float dirua);
	@WebMethod	public List<DiruMugimendua> getDiruMugimenduakByNan(int nan);
	@WebMethod	public boolean apustuaEgin(Date apustuData, float zenbatDiru, Kuota kuota, int nan);
	@WebMethod	public List<Apustua> getApustuakByNan(int nan);
	@WebMethod	public void apustuaEzabatu(Apustua a, int nan);
	@WebMethod	public void erantzunaGorde(Question g, Kuota k);
	@WebMethod	public void gertaeraKantzelatu(Event ev);
	@WebMethod  public List<Apustua> getApustuakByEvent(Event ev);
	@WebMethod	public List<PertsonaErregistratua> getUsers();
	@WebMethod	public void ordaindu(int nan, float i);
	//Containerrak
	@WebMethod  public List<ApustuContainer> getListApustuContainer();
	@WebMethod  public List<KuotaContainer> getListKuotaContainer();
	@WebMethod  public List<QuestionContainer> getListQuestionContainer();
	@WebMethod  public Kuota getKuota(Apustua a);
	@WebMethod  public Question getGaldera(Kuota k);
	@WebMethod  public Event getEvent(Question q);
	///////////////////////
}
