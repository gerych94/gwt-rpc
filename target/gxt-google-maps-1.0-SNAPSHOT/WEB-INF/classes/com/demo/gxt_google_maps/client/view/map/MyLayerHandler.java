package com.demo.gxt_google_maps.client.view.map;

import org.discotools.gwt.leaflet.client.layers.ILayer;
import org.discotools.gwt.leaflet.client.layers.others.LayerGroup;

public class MyLayerHandler implements LayerGroup.LayerHandler
{
	public int countOfEditedLayers = 0;
	@Override
	public void handle(
			ILayer layer ) {
		countOfEditedLayers++;
	}
}
