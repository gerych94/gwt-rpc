package com.demo.gxt_google_maps.client.view.map;

import com.google.gwt.core.client.GWT;
import org.discotools.gwt.leaflet.client.layers.vector.PathOptions;
import org.discotools.gwt.leaflet.client.layers.vector.Rectangle;
import org.discotools.gwt.leaflet.client.map.Map;
import org.discotools.gwt.leaflet.client.types.LatLng;
import org.discotools.gwt.leaflet.client.types.LatLngBounds;

/**

 */
public class RectangleHelper
{
	public static void draw(Map map)
	{
		// Рисуем прямоугольник
		GWT.log("Rectangle");
		LatLng rec1 = new LatLng(50.40, 30.6);
		LatLng rec2 = new LatLng(50.41, 30.55);
		LatLng[] recs = new LatLng[] {rec1, rec2};
		LatLngBounds bounds = new LatLngBounds(recs);
		Rectangle rec = new Rectangle(bounds, new PathOptions());
		rec.addTo(map);
	}
}
