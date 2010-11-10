package org.neo.mvc.control;

import org.neo.mvc.events.Event;
import org.neo.mvc.model.BaseModel;
import org.neo.mvc.utils.FDADialog;
import org.neo.mvc.view.BaseView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class BaseControl extends Activity implements Runnable{	
	protected BaseView view;
	protected BaseModel model;
	public Thread thread;
	
	/***********************************************INIT****************************************************/
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        runThread();
	}		
	public void init() {		
		view = new BaseView(this);
		model = new BaseModel(this);
		this.initEvent();
	}	
	/***********************************************INIT EVENT****************************************************/
	public void initEvent() {}
	public void eventHandler(Event e) {}
	
	/***********************************************ACTIVITY TRANSITION****************************************************/
	public void startNext(Class<?> activityClass, Bundle transferedData, Boolean isShowLoading) {
		if(isShowLoading) FDADialog.showLoading(this, "Please wait for loading...");
		Intent intent = new Intent(this, activityClass);
		if(transferedData != null) intent.putExtras(transferedData);
		this.startActivity(intent);
	}
	
	/***********************************************DATA IN ACTIVITY TRANSITION****************************************************/
	public Object getTransferedData(String name) {
		return this.getIntent().getExtras().get(name);
	}
	public Bundle getTransferedData() {
		return this.getIntent().getExtras();
	}	
	
	/***********************************************THREAD****************************************************/
	public void startThread() {
		thread = new Thread(this);
		thread.start();
	}
	public void runThread() {
		thread = new Thread(this);
		thread.run();
	}
	public void run() {
		// TODO Auto-generated method stub
        init();
		handler.sendEmptyMessage(0);
	}
	public Handler handler = new Handler() {
		//TODO HANDLE THREAD 
		@Override
		public void handleMessage(Message msg) {
			if(BaseControl.this.thread != null) {
				BaseControl.this.thread.stop();
			}			
			FDADialog.close();
	    }	
	};
}