package com.demo.gxt_google_maps.client.view.map;

import org.discotools.gwt.leaflet.client.Options;
import org.discotools.gwt.leaflet.client.layers.raster.TileLayer;

import java.util.ArrayList;

/**
 * Created by algernon on 16.03.2016.
 */
public class LayerHelper
{

	private static String[] urls = {
			"https://api.mapbox.com/v4/mapbox.streets/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoicGFtcHVzaGtvIiwiYSI6ImNpbDg0aWFvajAwMXd3NGtyZThrMm83aHQifQ.4V4UOkBoW5ijyvLdjqKJdw",

			"http://a.tile.openstreetmap.org/{z}/{x}/{y}.png",

			"https://stamen-tiles-{s}.a.ssl.fastly.net/toner/{z}/{x}/{y}.png",

			"https://api.mapbox.com/v4/mapbox.light/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoicGFtcHVzaGtvIiwiYSI6ImNpbDg0aWFvajAwMXd3NGtyZThrMm83aHQifQ.4V4UOkBoW5ijyvLdjqKJdw",

			"https://api.mapbox.com/v4/mapbox.outdoors/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoicGFtcHVzaGtvIiwiYSI6ImNpbDg0aWFvajAwMXd3NGtyZThrMm83aHQifQ.4V4UOkBoW5ijyvLdjqKJdw",

			"https://api.mapbox.com/v4/mapbox.dark/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoicGFtcHVzaGtvIiwiYSI6ImNpbDg0aWFvajAwMXd3NGtyZThrMm83aHQifQ.4V4UOkBoW5ijyvLdjqKJdw",

			"https://api.mapbox.com/v4/examples.map-h61e8o8e/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoicGFtcHVzaGtvIiwiYSI6ImNpbDg0aWFvajAwMXd3NGtyZThrMm83aHQifQ.4V4UOkBoW5ijyvLdjqKJdw",

			"http://mt0.google.com/vt/lyrs=y&hl=ru&x={x}&y={y}&z={z}&s=Ga",
			"http://mt0.google.com/vt/lyrs=m&x={x}&y={y}&z={z}",
			"http://mt0.google.com/vt/lyrs=m&x={x}&y={y}&z={z}",
			"http://mt0.google.com/vt/lyrs=s,h&x={x}&y={y}&z={z}",
			"http://mt0.google.com/vt/lyrs=s&x={x}&y={y}&z={z}",
			"http://mt0.google.com/vt/lyrs=p&x={x}&y={y}&z={z}"








	};




	//получаем массив опций всех наших слоев
	public static ArrayList<Options> getTileLayersOptions()
	{
		//создание переменных для хранения опций соответствующих слоев
		ArrayList<Options> arrayTileLayerOptions = new ArrayList<Options>();


		for (int i = 0; i < urls.length; i++)
		{
			//Create mutable TileLayer options
			//создание изменяемых параметров Слоев
			Options options = new Options();
			options.setProperty("attribution", "Карта №" + Integer.toString(i+1));
			arrayTileLayerOptions.add(options);

		}
		return arrayTileLayerOptions;
	}


	//получаем массив всех наших слоев с добавленными к ним опциями
	public static ArrayList<TileLayer>getTileLayers()
	{
		ArrayList<TileLayer> tileLayers = new ArrayList<TileLayer>();
		//получение массива слоев карт
		ArrayList<Options> arrayTileLayerOptions = getTileLayersOptions();

		for (int i = 0; i < urls.length; i++)
		{
			TileLayer tileLayer = new TileLayer(urls[i], arrayTileLayerOptions.get(i));
			tileLayers.add(tileLayer);
		}

		return tileLayers;
	}
}
