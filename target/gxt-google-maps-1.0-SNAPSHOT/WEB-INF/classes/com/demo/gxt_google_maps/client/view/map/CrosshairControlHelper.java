package com.demo.gxt_google_maps.client.view.map;

import com.google.gwt.core.client.GWT;
import org.discotools.gwt.leaflet.client.controls.ControlOptions;
import org.discotools.gwt.leaflet.client.controls.Position;
import org.discotools.gwt.leaflet.client.controls.crosshair.CrosshairButton;
import org.discotools.gwt.leaflet.client.controls.crosshair.CrosshairButtonOptions;
import org.discotools.gwt.leaflet.client.map.Map;

/**
 * Created by algernon on 15.03.2016.
 */
public class CrosshairControlHelper
{
	public static void draw(Map map)
	{
		// Add Crosshair Control
		GWT.log("Crosshair Control");
		ControlOptions crosshairOptions = new ControlOptions(Position.BOTTOM_LEFT);
		CrosshairButtonOptions crosshairButtonOptions = new CrosshairButtonOptions();
		crosshairButtonOptions.setPosition(Position.TOP_RIGHT);
		crosshairButtonOptions.setText("Crosshair");
		crosshairButtonOptions.setCrosshairOptions(crosshairOptions);

		CrosshairButton crosshair = new CrosshairButton(crosshairButtonOptions);
		map.addControl(crosshair);
	}
}
