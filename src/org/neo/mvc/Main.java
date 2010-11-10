package org.neo.mvc;

import org.neo.mvc.events.Dispatcher;
import org.neo.mvc.events.Event;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class Main extends Activity {
    /** Called when the activity is first created. */
	public String namheo = "namheo";
    @Override  
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Dispatcher target = new Dispatcher();        
        target.addEventListener("namheo", this, "namheoHandler");
        target.addEventListener("namheo1", this, "namheoHandler");
        target.dispatch(new Event("namheo", "data"));
    }
    public void namheoHandler(Event e) {
    	Log.i("namheo: ", e.name);
    }  
}