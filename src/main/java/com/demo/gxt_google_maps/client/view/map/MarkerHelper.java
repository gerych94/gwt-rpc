package com.demo.gxt_google_maps.client.view.map;

import com.google.gwt.core.client.GWT;
import org.discotools.gwt.leaflet.client.Options;
import org.discotools.gwt.leaflet.client.controls.ControlOptions;
import org.discotools.gwt.leaflet.client.controls.Position;
import org.discotools.gwt.leaflet.client.controls.layers.Layers;
import org.discotools.gwt.leaflet.client.layers.others.LayerGroup;
import org.discotools.gwt.leaflet.client.map.Map;
import org.discotools.gwt.leaflet.client.marker.Marker;
import org.discotools.gwt.leaflet.client.marker.MarkerOptions;
import org.discotools.gwt.leaflet.client.types.LatLng;

/**
 * Created by algernon on 15.03.2016.
 */
public class MarkerHelper
{
	//
	public static void createGroupMarker(Map map)
	{

		// Параметры для контрола-переключателя слоев: bases, overlays, controlOptions
		Options bases = new Options();

		Options overlays =new Options();

		ControlOptions controlOptions = new ControlOptions();
		controlOptions.setPosition(Position.BOTTOM_RIGHT);


		LatLng glatlng1 = new LatLng(51.414139000, 30.604332000);
		LatLng glatlng2 = new LatLng(50.395635000, 30.578235000);
		LatLng glatlng3 = new LatLng(50.431698000, 30.611180000);
		LatLng glatlng4 = new LatLng(50.423559000, 30.615827000);

		MarkerOptions opt1 = new MarkerOptions();
		opt1.setTitle("marker1");
		MarkerOptions opt2 = new MarkerOptions();
		opt2.setTitle("marker2");
		MarkerOptions opt3 = new MarkerOptions();
		opt3.setTitle("marker3");
		MarkerOptions opt4 = new MarkerOptions();
		opt4.setTitle("marker4");
		Marker marker1 = new Marker(glatlng1,opt1);
		Marker marker2 = new Marker(glatlng2,opt2);
		Marker marker3 = new Marker(glatlng3,opt3);
		Marker marker4 = new Marker(glatlng4,opt4);

		Marker[] markers = new Marker[] {marker1, marker2};
		LayerGroup groupMarkers1 = new LayerGroup(markers);

		Marker[] markers2 = new Marker[] {marker3, marker4};
		LayerGroup groupMarkers2 = new LayerGroup(markers2);
		overlays.setProperty("Group marker 1", groupMarkers1);
		overlays.setProperty("Group marker 2", groupMarkers2);

		// Add layers control to map
		Layers control = new Layers(bases, overlays, controlOptions);
		control.addTo(map);

	}


	public static LatLng getUkraineLatLng()
	{
		/*
		//Крайние точки Украины

		Северная точка — село Гремяч (Черниговская область).
		52°20′04″ с. ш. 33°17′19″ в. д. (G)  (O)
		52.33444444444444 lat северня широта

		Южная точка — Сарыч (Автономная Республика Крым).
		44°23′14″ с. ш. 33°44′17″ в. д. (G)  (O)
		44.38722222222222 lat северная широта


		Западная точка — село Соломоново (Закарпатская область).
		48°25′50″ с. ш. 22°09′50″ в. д. (G)  (O)
		22.163888888888888 восточная долгота lng

		Восточная точка — село Червоная Зирка (Луганская область).
		49°15′33″ с. ш. 40°11′53″ в. д. (G)  (O)
		40.198055555555555 восточная долгота lng

		*/


		/*

		Географический центр Украины
		памятник/монумент, 2005 г.
		Достопримечательность Географический центр Украины, Шпола
		Координаты: 49°1'39''N, 31°28'58''E
		lat = 49.027499999999996;
		lng = 31.482777777777777;

		 */
		//Decimal Degrees = Degrees + minutes/60 + seconds/3600
		//http://andrew.hedges.name/experiments/convert_lat_long/

		double eastLng = 40.198055555555555;
		double westLng = 22.16388888888888;
		double northLat = 52.33444444444444;
		double southLat = 44.38722222222222;

		double lat = northLat + (northLat - southLat) / 2.0;
		double lng = eastLng + (eastLng - westLng) / 2.0;


		lat = 49.027499999999996;
		lng = 31.482777777777777;

		GWT.log("широта и долгота");
		GWT.log(String.valueOf(lat));
		GWT.log(String.valueOf(lng));
		GWT.log("Конец широты и долготы");

		return new LatLng(lat, lng);
	}


	//генерируем массив маркеров
	public static Marker[] generateArrayOfMarkers()
	{


		LatLng glatlng1 = new LatLng(52.414139000, 30.604332000);
		LatLng glatlng2 = new LatLng(51.395635000, 30.578235000);
		LatLng glatlng3 = new LatLng(53.431698000, 30.611180000);
		LatLng glatlng4 = new LatLng(54.423559000, 30.615827000);
		LatLng glatlgnUkraine = getUkraineLatLng();


		MarkerOptions opt1 = new MarkerOptions();
		opt1.setTitle("marker1");

		MarkerOptions opt2 = new MarkerOptions();
		opt2.setTitle("marker2");
		MarkerOptions opt3 = new MarkerOptions();
		opt3.setTitle("marker3");

		MarkerOptions opt4 = new MarkerOptions();
		MarkerOptions optUkraine = new MarkerOptions();

		opt4.setTitle("marker4");
		opt4.setDraggable(true);

		opt4.setProperty("image", "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ef/Cherry_Blossoms_and_Washington_Monument.jpg/320px-Cherry_Blossoms_and_Washington_Monument.jpg");
		opt4.setProperty("url", "https://en.wikipedia.org/wiki/Washington,_D.C.");
		opt4.setProperty("marker-symbol", "star");
		opt4.setProperty("marker-color", "#ff8888");
		opt4.setProperty("marker-size", "large");

		optUkraine.setTitle("Украина!");


		Marker marker1 = new Marker(glatlng1, opt1);
		Marker marker2 = new Marker(glatlng2, opt2);
		Marker marker3 = new Marker(glatlng3, opt3);
		Marker marker4 = new Marker(glatlng4, opt4);
		Marker markerUkraine = new Marker(glatlgnUkraine, optUkraine);

		marker1.bindPopup("Это маркер <b>один</b> для проверки центрирования карты по положению маркера");
		marker2.bindPopup("Это маркер <b>два</b> для проверки центрирования карты по положению маркера");
		marker3.bindPopup("Это маркер <b>три</b> для проверки центрирования карты по положению маркера");
		//marker4.bindPopup("Это маркер <b>четыре</b> для проверки центрирования карты по положению маркера");
		String popup4Content = "<div id='content'>"+
			"<div id='siteNotice'>"+
			"</div>"+
			"<h1 id='firstHeading' class='firstHeading'>Uluru</h1>"+
			"<div id='bodyContent'>"+
			"<p><b>Маркер 4</b>, also referred to as <b>Ayers Rock</b>, is a large " +
			"sandstone rock formation in the southern part of the "+
			"Northern Territory, central Australia. It lies 335&#160;km (208&#160;mi) "+
			"south west of the nearest large town, Alice Springs; 450&#160;km "+
			"(280&#160;mi) by road. Kata Tjuta and Uluru are the two major "+
			"features of the Uluru - Kata Tjuta National Park. Uluru is "+
			"sacred to the Pitjantjatjara and Yankunytjatjara, the "+
			"Aboriginal people of the area. It has many springs, waterholes, "+
			"rock caves and ancient paintings. Uluru is listed as a World "+
			"Heritage Site.</p>"+
			"<p>Attribution: Uluru, <a href='https://en.wikipedia.org/w/index.php?title=Uluru&oldid=297882194'>"+
	"https://en.wikipedia.org/w/index.php?title=Uluru</a> "+
			"(last visited June 22, 2009).</p>"+
			"</div>"+
			"</div>";


		//markerOptions.setProperty("city", "Washington, D.C.");

		marker4.bindPopup(popup4Content);

		markerUkraine.bindPopup("Украина!");

		Marker[] markers = new Marker[] { marker1, marker2, marker3, marker4, markerUkraine };

		return markers;
	}
}
