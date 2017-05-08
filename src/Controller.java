import java.util.Iterator;
import java.util.Vector;


// This is just a way to hold Event objects.
class EventSet {
	private Vector events = new Vector();
	public void add(Event e) {
		events.add(e);
	}
	public Event getNext() {
		if(events.isEmpty())
			return null;
		return (Event) events.firstElement();
	}
	public void removeCurrent() {
		events.remove(0);
	}
	public void jumpAdd(Event e){
		events.add(1, e);
	}
	
}
public class Controller {
	protected EventSet es = new EventSet();
	public void addEvent(Event c) { 
		es.add(c); 
	}
	public void run() {
		Event e;
		while((e = es.getNext()) != null) {
			if(e.ready()) {
				e.action();
				System.out.println(e.description());
				es.removeCurrent();
			}
		}
	}
	public void jumpAddEvent(Event c){
		es.jumpAdd(c);
	}
	
	
}