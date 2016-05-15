package com.demo.gxt_google_maps.client.view.map;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * Created by algernon on 12.03.2016.
 */
@RemoteServiceRelativePath("GPXDataService")
public interface GPXDataService extends RemoteService
{
	String getMyName(String username);


}
