package com.demo.gxt_google_maps.client.view.map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import org.discotools.gwt.leaflet.client.Options;
import org.discotools.gwt.leaflet.client.layers.vector.Circle;
import org.discotools.gwt.leaflet.client.map.Map;
import org.discotools.gwt.leaflet.client.types.LatLng;

/**
 * Created by algernon on 15.03.2016.
 */
public class CircleHelper
{
	public static Circle draw(Map map, LatLng latlng)
	{
		final double radiusStart = 1000;
		//Circle
		GWT.log("Circle");
		Options circleOptions = new Options();
		circleOptions.setProperty("color", "red");
		circleOptions.setProperty("fillColor", "yellow");
		circleOptions.setProperty("stroke", true);
		circleOptions.setProperty("fillOpacity", 0.3);
		final Circle circle = new Circle(latlng, radiusStart, circleOptions);

		circle.addTo(map);

		Timer timer = new Timer()
		{
			double radius = radiusStart;
			public void run()
			{
				circle.setRadius(radius);
				radius = radius - 1;
				if (radius < 100)
				{
					radius = radiusStart;
				}
			}
		};
		//timer.scheduleRepeating(10);
		return circle;


	}
}
