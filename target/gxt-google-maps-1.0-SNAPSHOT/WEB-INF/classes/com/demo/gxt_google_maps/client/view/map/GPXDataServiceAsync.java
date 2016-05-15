package com.demo.gxt_google_maps.client.view.map;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GPXDataServiceAsync
{
	//String getMyName(String username, AsyncCallback<Void> async);


	String getMyName(String username, AsyncCallback<String> async);
}
