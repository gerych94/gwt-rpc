package com.demo.gxt_google_maps.client.view.map;

import org.discotools.gwt.leaflet.client.Options;
import org.discotools.gwt.leaflet.client.jsobject.JSObject;
import org.discotools.gwt.leaflet.client.layers.others.GeoJSON;
import org.discotools.gwt.leaflet.client.layers.others.GeoJSONFeatures;
import org.discotools.gwt.leaflet.client.layers.others.GeoJSONOptions;
import org.discotools.gwt.leaflet.client.map.Map;
import org.discotools.gwt.leaflet.client.marker.Marker;
import org.discotools.gwt.leaflet.client.types.LatLng;

/**
 * Created by algernon on 15.03.2016.
 */
public class GeoJsonHelper
{
	public static void createJsonSamples(Map map) {
		String freeBus       = GeoJsonSampleFactory.getInstance().createFreeBus();
		String lightRailStop = GeoJsonSampleFactory.getInstance().createLightRailStop();
		String bicycleRental = GeoJsonSampleFactory.getInstance().createBicycleRental();
		String campus        = GeoJsonSampleFactory.getInstance().createCampus();
		String coorsField    = GeoJsonSampleFactory.getInstance().createCoorsField();

		GeoJSONFeatures features1 = new GeoJSONFeatures() {

			@Override
			public JSObject style(JSObject self) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public JSObject pointToLayer(JSObject feature, JSObject latlng) {
				return new Marker(new LatLng(latlng), new Options()).getJSObject();
			}

			@Override
			public JSObject onEachFeature(JSObject feature, JSObject layer) {
				return myOnEachFeature(feature, layer);
			}

			@Override
			public boolean filter(JSObject self, JSObject layer) {
				return myFilter(self, layer);
			}
		};

		GeoJSONFeatures features2 = new GeoJSONFeatures() {

			@Override
			public JSObject style(JSObject self) {
				return null;

			}

			@Override
			public JSObject pointToLayer(JSObject feature, JSObject latlng) {
				return new Marker(new LatLng(latlng), new Options()).getJSObject();
			}

			@Override
			public JSObject onEachFeature(JSObject feature, JSObject layer) {
				return myOnEachFeature2(feature, layer);
			}

			@Override
			public boolean filter(JSObject self, JSObject layer) {
				return myFilter(self, layer);
			}
		};

		GeoJSONFeatures features3 = new GeoJSONFeatures() {

			@Override
			public JSObject style(JSObject feature) {
				return myStyle(feature);

			}

			@Override
			public JSObject pointToLayer(JSObject feature, JSObject latlng) {
				return myPointToLayer(feature, latlng);
			}

			@Override
			public JSObject onEachFeature(JSObject feature, JSObject layer) {
				return myOnEachFeature2(feature, layer);
			}

			@Override
			public boolean filter(JSObject self, JSObject layer) {
				return myFilter(self, layer);
			}
		};

		GeoJSONOptions coorsOptions         = new GeoJSONOptions(features1);
		GeoJSONOptions freeBusOptions       = new GeoJSONOptions(features2);
		GeoJSONOptions bicycleRentalOptions = new GeoJSONOptions(features3);

		GeoJSON geojson_lightRailStop = new GeoJSON(lightRailStop , freeBusOptions);
		GeoJSON geojson_bicycleRental = new GeoJSON(bicycleRental , bicycleRentalOptions);
		GeoJSON geojson_campus        = new GeoJSON(campus        , bicycleRentalOptions);
		GeoJSON geojson_coorsField    = new GeoJSON(coorsField    , coorsOptions);
		GeoJSON geojson_freeBus       = new GeoJSON(freeBus       , freeBusOptions);

		geojson_freeBus      .addTo(map);
		geojson_lightRailStop.addTo(map);
		geojson_bicycleRental.addTo(map);
		geojson_campus       .addTo(map);
		geojson_coorsField   .addTo(map);
	}


	public static native JSObject myOnEachFeature(JSObject feature, JSObject layer) /*-{
        var popupContent = "<p> <b>myOnEachFeature</b> " +
            feature.geometry.type + ", but now I'm a Leaflet vector!</p>";

        if (feature.properties && feature.properties.popupContent) {
            popupContent += feature.properties.popupContent;
        }

        layer.bindPopup(popupContent);
        return layer;
    }-*/;


	public static native JSObject myOnEachFeature2(JSObject feature, JSObject layer) /*-{
        var popupContent = "<p> <b>myOnEachFeature2</b> "
            + feature.geometry.type + ", but now I'm a Leaflet vector!</p>";

        if (feature.properties && feature.properties.popupContent) {
            popupContent += feature.properties.popupContent;
        }

        layer.bindPopup(popupContent);
        return layer;
    }-*/;


	public static native JSObject myStyle(JSObject feature) /*-{
        return feature.properties && feature.properties.style;
    }-*/;

	public static native boolean myFilter(JSObject feature, JSObject layer) /*-{
        if (feature.properties) {
            // If the property "underConstruction" exists and is true, return false (don't render features under construction)
            return feature.properties.underConstruction !== undefined ? !feature.properties.underConstruction
                : true;
        }
        return false;
    }-*/;

	public static native JSObject myPointToLayer(JSObject feature, JSObject latlng) /*-{
        return $wnd.L.circleMarker(latlng, {
            radius : 8,
            fillColor : "#ff7800",
            color : "#000",
            weight : 1,
            opacity : 1,
            fillOpacity : 0.8
        });
    }-*/;
}
