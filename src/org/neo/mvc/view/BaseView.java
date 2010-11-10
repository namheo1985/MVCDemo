package org.neo.mvc.view;

import org.neo.mvc.control.BaseControl;
import org.neo.mvc.events.Dispatcher;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.glandore.fda.view.ContextMenu;

public class BaseView extends Dispatcher{
	protected BaseControl controller;
	public BaseView(BaseControl control) {
		this.controller = control;
		this.init();
	}
	/***********************************************INIT****************************************************/
	public void init() {}
	public void initLayout(int idLayout) {
		controller.setContentView(idLayout);
	}	
	public View getView(int id) {
		return controller.findViewById(id);
	}
	public void onClick(View view) {
		// TODO Auto-generated method stub
	}
	public void excute(String action, Object data) {
		if(action.equals(ContextMenu.CREATE_MENU)) {	
			menu = new ContextMenu(context);
			menu.create((Menu)data);
			return;
		}
		if(action.equals(ContextMenu.CLICK_MENU)) {	
			menu.clickMenuItemHandler((MenuItem)data);
			return;
		}
	}
	public String getString(int id) {
		return context.getString(id);
	}
}
