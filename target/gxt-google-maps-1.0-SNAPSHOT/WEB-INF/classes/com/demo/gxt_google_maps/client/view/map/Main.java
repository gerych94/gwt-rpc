package com.demo.gxt_google_maps.client.view.map;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.thirdparty.javascript.rhino.head.BaseFunction;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.RootPanel;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.Viewport;
import org.discotools.gwt.leaflet.client.events.MouseEvent;
import org.discotools.gwt.leaflet.client.events.handler.EventHandler;
import org.discotools.gwt.leaflet.client.events.handler.EventHandlerManager;
import org.discotools.gwt.leaflet.client.jsobject.JSObject;
import org.discotools.gwt.leaflet.client.layers.raster.TileLayer;
import org.discotools.gwt.leaflet.client.layers.vector.*;
import org.discotools.gwt.leaflet.client.map.Map;
import org.discotools.gwt.leaflet.client.map.MapOptions;
import org.discotools.gwt.leaflet.client.marker.Marker;
import org.discotools.gwt.leaflet.client.marker.MarkerWithLabel;
import org.discotools.gwt.leaflet.client.types.LatLng;
import org.discotools.gwt.leaflet.client.widget.MapWidget;

import java.util.ArrayList;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Main
{
	//переменная для хранения HTML-идентификатора контейнера
	//в этом контейнере будет храниться карта
	private static final String MAP_ID = "map";
	private static final LatLng centerLatlng = new LatLng(50.420710000, 30.640718000);



	public static void setMap(ContentPanel contentPanel)
	{

		//создаем компонент для заполнения всего доступного пространства
		//Viewport viewport = new Viewport();

		//создаем контент-панель
		//ContentPanel contentPanel = new ContentPanel();

		//отключаем видимость заголовка контент-панели
		contentPanel.setHeaderVisible(false);

		//ширину или высоту контент панели устанавливать не нужно
		//contentPanel.setWidth("10%");
		//contentPanel.setHeight("20%");

		//добавляем контент панель во вьюпорт
		//viewport.add(contentPanel, new MarginData(0));

		//добавляем вьюпорт к корневой панели
		//RootPanel.get().add(viewport);


		//добавляем новый виджет для отображения карты
		MapWidget mapWidget = new MapWidget(MAP_ID);

		//ширину и высоту виджета устанавливать не нужно
		//mapWidget.setHeight("100%");
		//mapWidget.setWidth("60%");

		//добавляем к контент панели виджет
		contentPanel.add(mapWidget);

		//запускаем в следующем event loop Javascript команду по добавлению карты
		//если добавлять карту сразу же после создания виджета,
		//то не она не занимает все положенное ей пространство,
		//а в данном случае сначала будет создан и займет положенное место виджет
		//а потом в него будет помещена и заполнит его полностью наша карта

		Scheduler.get().scheduleDeferred(new Command()
		{
			@Override
			public void execute()
			{
				//создаем карту
				createMap(MAP_ID);
			}
		});



		/*
		//Нужно ли обновлять карту при изменении размеров контент-панели?
		// Update map size
		contentPanel.addResizeHandler(new ResizeHandler()
		{
			@Override
			public void onResize(ResizeEvent event)
			{
			}
		});
		*/

	}


	/**
	 * <p>Создаем экземпляр карты</p>
	 * <p>по заданному идентификатору контейнера в который будет помещена карта;
	 * @param mapId
	 * @return void
	 */
	public static void createMap(String mapId)
	{
		/*

		GPXDataServiceAsync gpxDataServiceAsync =
				(GPXDataServiceAsync) GWT.create(GPXDataService.class);
		AsyncCallback callback = new AsyncCallback() {
			@Override
			public void onFailure(Throwable caught)
			{
				AlertMessageBox d = new AlertMessageBox("sfvs", "sfv sfdvddd");
				d.setIcon(MessageBox.ICONS.info());
				d.show();
			}

			@Override
			public void onSuccess(Object result)
			{
				GWT.log((String) result.toString());
				AlertMessageBox d = new AlertMessageBox("ура", "все харашо");
				d.setIcon(MessageBox.ICONS.info());
				d.show();
			}
		};

		String result = gpxDataServiceAsync.getMyName("4fvsfd", callback);

		AlertMessageBox d = new AlertMessageBox(result, result);
		d.setIcon(MessageBox.ICONS.info());
		d.show();

		*/

		//получаем опции карты
		MapOptions mapOptions = MapHelper.getMapOptions();

		//создаем карту с указанным id контейнера и с настройками mapOptions
		final org.discotools.gwt.leaflet.client.map.Map map = new org.discotools.gwt.leaflet.client.map.Map(mapId, mapOptions);

		//получаем коллекцию слоев используемых нами в картах
		final ArrayList<TileLayer> tileLayers = LayerHelper.getTileLayers();

		//добавляем один из слоев к карте
		map.addLayer(tileLayers.get(6));

		//Добавляем контрол для переключения между слоями карты
		BaseMapFunction.addLayerCheckboxControl(map, tileLayers);

		//Добавить на карту маркер с меткой
		final MarkerWithLabel markerWithLabel = BaseMapFunction.createMarkerWithLabel(map);

		//Добавляем на карту маркет со всплывающим попапом
		final Marker markerWithPopup = BaseMapFunction.createMarkerWithPopup(map);


		//получаем коллекцию объектов-координат нашего Тест-маршрута
		final ArrayList<LatLng> route = ExamplesRoute.getCoordinates();

		//запускаем таймер который будет эмулировать
		//перемещение маркера по маршруту с течение времени
		//и отрисовывать маршрут

		int delay = 30;
		BaseMapFunction.runMarker(map, markerWithPopup, route, delay);


		//Рисуем эллипс
		Ellipse ellipse = EllipseHelper.draw(map);
		//добавляем к эллипсу возможность кликнуть по нему
		//и изменить его размеры
		addClickToEdit(ellipse.getJSObject());


		//рисуем окружность
		Circle circle = CircleHelper.draw(map, centerLatlng);

		//Редактируем окружность
		final LeafletCircleEditor circleEditor = new LeafletCircleEditor(circle);
		EventHandlerManager.addEventHandler(
				circle,
				EventHandler.Events.click,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(
							MouseEvent event ) {
						circleEditor.enable(map);
					}
				});


		//CoordinatesHelper.draw(map);
		//CrosshairControlHelper.draw(map);


		//подключение контрола на карту позволяющего включать выключать определенные группы маркеров
		MarkerHelper.createGroupMarker(map);


		//рисуем прямоугольник
		RectangleHelper.draw(map);



		BaseMapFunction.setMarketToScreenCenter(map);

		//GWT.debugger();
		//BaseFunction.setMarketToScreenCenter(map);
		//BaseFunction.addDrawControl(map);




		/*
		MeasureHelper.draw(map);

		//GeoJsonHelper.createJsonSamples(map);
		*/


	}



	public static native void addClickToEdit(JSObject layer) /*-{
        layer
            .on({
                click : function(e) {
                    layer.editing.enable();
                }
            });
    }-*/;

}
