package com.demo.gxt_google_maps.client.view.map;

import com.google.gwt.core.client.GWT;
import org.discotools.gwt.leaflet.client.controls.ControlOptions;
import org.discotools.gwt.leaflet.client.controls.Position;
import org.discotools.gwt.leaflet.client.controls.coordinates.CoordinatesButton;
import org.discotools.gwt.leaflet.client.controls.coordinates.CoordinatesButtonOptions;
import org.discotools.gwt.leaflet.client.map.Map;

/**
 * Created by algernon on 15.03.2016.
 */
public class CoordinatesHelper
{
	public static void draw(Map map)
	{
		// Add Coordinates Control
		GWT.log("Coordinates Control");
		ControlOptions coordinatesOptions = new ControlOptions(Position.BOTTOM_LEFT);
		CoordinatesButtonOptions coordinatesButtonOptions = new CoordinatesButtonOptions();
		coordinatesButtonOptions.setPosition(Position.TOP_RIGHT);
		coordinatesButtonOptions.setText("Cursor");
		coordinatesButtonOptions.setCoordinatesOptions(coordinatesOptions);

		CoordinatesButton coordinates = new CoordinatesButton(coordinatesButtonOptions);
		map.addControl(coordinates);
	}
}
