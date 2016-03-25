package com.demo.gxt_google_maps.client.view.map;

import org.discotools.gwt.leaflet.client.layers.vector.Polyline;
import org.discotools.gwt.leaflet.client.layers.vector.PolylineOptions;
import org.discotools.gwt.leaflet.client.map.Map;
import org.discotools.gwt.leaflet.client.types.LatLng;

/**
 * Created by algernon on 15.03.2016.
 */
public class PolylineHelper
{
	public static void draw(Map map, LatLng[] latlngs)
	{
		/*
		LatLng latlngLine1 = new LatLng(59.915, 10.759);
		LatLng latlngLine2 = new LatLng(59.900, 10.800);
		LatLng latlngLine3 = new LatLng(59.990, 10.800);
		latlngs = new LatLng[] {latlngLine1, latlngLine2, latlngLine3};
		*/

		//GWT.log("size   :" + latlngs.length);
		for(LatLng l : latlngs) {
			//GWT.log("string :" + l.toString());
		}
		//GWT.log("Polyline");
		Polyline poly = new Polyline(latlngs, new PolylineOptions());
		poly.addTo(map);
	}
}
