package com.demo.gxt_google_maps.client.view.map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import org.discotools.gwt.leaflet.client.Options;
import org.discotools.gwt.leaflet.client.controls.ControlOptions;
import org.discotools.gwt.leaflet.client.controls.Position;
import org.discotools.gwt.leaflet.client.controls.draw.Draw;
import org.discotools.gwt.leaflet.client.controls.draw.DrawControlOptions;
import org.discotools.gwt.leaflet.client.controls.layers.Layers;
import org.discotools.gwt.leaflet.client.draw.edit.EditOptions;
import org.discotools.gwt.leaflet.client.draw.events.DrawCreatedEvent;
import org.discotools.gwt.leaflet.client.draw.events.DrawEditedEvent;
import org.discotools.gwt.leaflet.client.draw.events.handler.DrawEvents;
import org.discotools.gwt.leaflet.client.events.handler.EventHandler;
import org.discotools.gwt.leaflet.client.events.handler.EventHandlerManager;
import org.discotools.gwt.leaflet.client.layers.ILayer;
import org.discotools.gwt.leaflet.client.layers.others.FeatureGroup;
import org.discotools.gwt.leaflet.client.layers.others.LayerGroup;
import org.discotools.gwt.leaflet.client.layers.raster.TileLayer;
import org.discotools.gwt.leaflet.client.map.Map;
import org.discotools.gwt.leaflet.client.map.MapOptions;
import org.discotools.gwt.leaflet.client.marker.Marker;
import org.discotools.gwt.leaflet.client.marker.MarkerWithLabel;
import org.discotools.gwt.leaflet.client.marker.label.LabelOptions;
import org.discotools.gwt.leaflet.client.types.Icon;
import org.discotools.gwt.leaflet.client.types.LatLng;

import java.util.ArrayList;

/**
 * Created by algernon on 15.03.2016.
 */
public class BaseMapFunction
{
	//Добавить на карту маркер с меткой
	public static MarkerWithLabel createMarkerWithLabel(Map map)
	{
		/////////////////////////////////////////////////////
		MapOptions mapOptions = new MapOptions();

		//создаем иконку для маркера
		Icon icon = IconHelper.createIcon(map);

		//TODO Solve iconurl problem
		mapOptions.setProperty("icon", icon);


		//координаты метки
		final LatLng latlngLabel = new  LatLng(50.420710000, 30.640718000);
		//создаем маркер с меткой
		final MarkerWithLabel markerWithLabel = new MarkerWithLabel(latlngLabel, mapOptions);
		//добавляем
		markerWithLabel.addTo(map);

		LabelOptions labelOptions = LabelHelper.createLabelOptions();
		markerWithLabel.bindLabel("<b>Это&nbspмаркер&nbspс&nbspметкой</b>", labelOptions);

		markerWithLabel.showLabel();

		return markerWithLabel;
	}

	//добавить на карту маркер со всплывающим попапом
	public static Marker createMarkerWithPopup(Map map)
	{

		MapOptions mapOptions = new MapOptions();

		//создаем координаты маркера
		final LatLng latlng1 = new LatLng(50.4333, 30.5167);
		//создаем маркер
		//конструктор маркера принимает координаты и опции карты MapOptions
		final Marker marker = new Marker(latlng1, mapOptions);
		//добавляем маркер на карту
		marker.addTo(map);
		//прикрепляем к маркеру попап, параметром выступает HTML (любая строка)
		marker.bindPopup("<b>Ура попап1!<b>");

		return marker;
	}

	//Добавляем контрол для переключения между слоями карты
	public static void addLayerCheckboxControl(Map map, ArrayList<TileLayer> tileLayers)
	{

		//контрол для переключения между слоями карты
		Options bases = new Options();
		for (int i = 0; i < tileLayers.size(); i++)
		{
			bases.setProperty("слой №"+Integer.toString(i+1), tileLayers.get(i));
		}

		Options overlays = new Options();

		ControlOptions controlOptions = new ControlOptions();
		controlOptions.setPosition(Position.TOP_RIGHT);

		//TODO разобрать что значат параметры bases, overlays, controlOptions
		Layers control = new Layers(bases, overlays, controlOptions);
		control.addTo(map);

	}


	public static void runMarker(final Map map,
	                             final Marker marker,
	                             final ArrayList<LatLng> route,
	                             int delay)
	{
		//запускаем таймер который будет эмулировать
		//перемещение маркера по маршруту с течение времени
		//и отрисовывать маршрут
		Timer timer = new Timer()
		{
			//текущая позиция
			LatLng currentPosition = new LatLng(50.420710000, 30.640718000);
			//предыдущая позиция
			LatLng previousPosition = new LatLng(50.420710000, 30.640718000);
			//нужды для рисования отрезков маршрута по мере перемещения маркера

			//номер точки в коллекции координат маршрута
			int pointNumber = 0;

			public void run()
			{
				LatLng latlng;

				if (pointNumber < route.size())
				{
					LatLng currentPosition = route.get(pointNumber);
					marker.setLatLng(currentPosition);
					LatLng[] polylineArray = {previousPosition, currentPosition};

					if (pointNumber < route.size()-1)
					{
						PolylineHelper.draw(map, polylineArray);
					}
					previousPosition = currentPosition;
					pointNumber++;
				}
				else
				{
					pointNumber = 0;
					LatLng currentPosition = route.get(pointNumber);
					previousPosition = currentPosition;
				}
			}
		};
		timer.scheduleRepeating(delay);

	}

	//1) Для какого маркера установить его по центру экрана
	public static void setMarketToScreenCenter(final Map map)
	{
		//GWT.debugger();
		//генерируем много маркеров
		final Marker[] markers = MarkerHelper.generateArrayOfMarkers();
		for (int i = 0; i < markers.length; i++)
		{
			markers[i].addTo(map);
			GWT.log("Маркер добавлен к карте " + Integer.toString(i));
		}
		//каждые 3 секунды перемещаем карту на указанный маркер


		final Timer timer = new Timer()
		{


			int number = 0;
			public void run()
			{
				//GWT.debugger();
				GWT.log(String.valueOf(number));
				if (number > markers.length-1)
				{
					number = 0;

				}
				//GWT.log("");

				LatLng currentLatLng = markers[number].getLatLng();
				GWT.log("Выводим координаты!");
				GWT.log(String.valueOf(currentLatLng.lat()));
				GWT.log(String.valueOf(currentLatLng.lng()));
				GWT.log("закончили вывод координат");
				LatLng newLatLng = new LatLng(currentLatLng.lat(), currentLatLng.lng());

				map.setView(newLatLng, 6, false);
				markers[number].openPopup();

				number = number + 1;

			}

		};
		timer.scheduleRepeating(10000);

		//map.setView(new LatLng(49.00, 32.00), 6, true);

		//GWT.log(String.valueOf());
		//map.setView(new LatLng(51.414139000, 30.604332000), 12, false);

	}
	//2) Отрисовка маршрут
	////отрисовываем маршрут по коллекции точек
	public static void drawRoute()
	{

	}
	//3) Кластеризация ?


	//4) Создание: рисовать полигон, прямоугольник, элипс и круг



	public static void addDrawControl(Map map)
	{
		// Add Draw Control
		GWT.log("Draw Control");
		final FeatureGroup drawnItems = new FeatureGroup();
		map.addLayer(drawnItems);
		DrawControlOptions drawControlOptions = new DrawControlOptions();
		drawControlOptions.setPosition(Position.TOP_LEFT);
		EditOptions editOptions = new EditOptions();
		editOptions.setFeatureGroup(drawnItems);
		drawControlOptions.setEditOptions(editOptions);
		Draw draw = new Draw(drawControlOptions);
		map.addControl(draw);
		EventHandlerManager.addEventHandler(
				map,
				DrawEvents.draw_created,
				new EventHandler<DrawCreatedEvent>()
				{

					@Override
					public void handle(
							DrawCreatedEvent event)
					{
						GWT.log("Added " + event.getLayerType() + " to map.");
						String type = event.getLayerType();
						ILayer layer = event.getLayer();
						if (type == "marker")
						{
							((Marker) layer).bindPopup("A popup!");
						}

						drawnItems.addLayer(layer);
					}
				});
		EventHandlerManager.addEventHandler(
				map,
				DrawEvents.draw_edited,
				new EventHandler<DrawEditedEvent>()
				{

					@Override
					public void handle(
							DrawEditedEvent event)
					{
						LayerGroup layers = event.getLayers();
						MyLayerHandler myLayerHandler = new MyLayerHandler();
						layers.forEachLayer(myLayerHandler);
						//int countOfEditedLayers = layers.getLayers().length;
						GWT.log("Edited " + myLayerHandler.countOfEditedLayers + " layers.");
					}
				});
	}

	//5) Отобразить или скрыть полигоны
	//6) Отобразить скрыть маркеры
	//7) Табличка с данным в попапе
	//8) на геозоне нужно название геозоны, и присвоили ей название.
	//9) линейка
	//10) знать длину маршрута

}
