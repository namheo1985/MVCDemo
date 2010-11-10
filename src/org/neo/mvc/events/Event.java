package org.neo.mvc.events;

public class Event {	
	public String name;
	public Object data;
	public Dispatcher target;	
	public Event(String nameEvent, Object dataEvent) {
		this.name = nameEvent;
		this.data = dataEvent;
	}
}
