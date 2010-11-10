package org.neo.mvc.events;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

public class Dispatcher {
	protected HashMap<String, String> eventList;
	protected Object scoper;
	@SuppressWarnings("unchecked")
	public Dispatcher() {
		eventList = new HashMap();
	}
	public void dispatch(Event e) {
		try {
			this.send(e);
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchMethodException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	protected void send(Event e) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		e.target = this;
		Set set = eventList.entrySet();
	    Iterator i = set.iterator();
	    while(i.hasNext()){
	      Entry<String, String> item = (Entry<String, String>)i.next();
	      if(item.getKey().equals(e.name)) {
	    	String functionName = item.getValue();
	    	Method method = scoper.getClass().getMethod(functionName, Event.class);				
			if(method != null) method.invoke(scoper, e);
	      }
	    }		
	}
	public void removeEventListener(String eventName) {
		eventList.remove(eventName);
	}
	public void addEventListener(String eventName, Object scope, String functionName) {		
		eventList.put(eventName, functionName);
		scoper = scope;		
	}
}
