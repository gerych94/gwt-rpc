package com.demo.gxt_google_maps.client.view.map;

import org.discotools.gwt.leaflet.client.crs.epsg.EPSG3857;
import org.discotools.gwt.leaflet.client.map.MapOptions;
import org.discotools.gwt.leaflet.client.types.LatLng;

/**
 * Created by algernon on 16.03.2016.
 */
public class MapHelper
{

	public static MapOptions getMapOptions()
	{
		//создаем набор опций карты
		MapOptions loptions = new MapOptions();
		//опция Центр карты
		LatLng centerLatlng = new LatLng(50.420710000, 30.640718000);
		loptions.setCenter(centerLatlng);
		//опция Увеличение
		loptions.setZoom(14);

		// Required version: origin/master
		//EPSG3395 vCRS_EPSG3395 = new EPSG3395();
		//EPSG4326 vCRS_EPSG4326 = new EPSG4326();
		EPSG3857 vCRS_EPSG3857 = new EPSG3857();
		loptions.setProperty("crs", vCRS_EPSG3857);

		return loptions;
	}


}
