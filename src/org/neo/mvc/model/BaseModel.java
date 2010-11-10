package org.neo.mvc.model;

import org.neo.mvc.control.BaseControl;
import org.neo.mvc.events.Dispatcher;
public class BaseModel extends Dispatcher{
	protected BaseControl controller;
	public BaseModel(BaseControl control) {
		this.controller = control;
	}
}
