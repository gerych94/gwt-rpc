package com.demo.gxt_google_maps.client.rpc;

import com.demo.gxt_google_maps.shared.PositionTransit;
import com.demo.gxt_google_maps.shared.TitleTransit;
import com.demo.gxt_google_maps.shared.Transit;
import com.demo.gxt_google_maps.shared.VehicleTypeTransit;
import com.google.gwt.i18n.client.DateTimeFormat;

import java.util.ArrayList;
import java.util.List;

public class StoreUtil {
    private static List<Transit> lData = null;

	public static List<Transit> getData(){
		if(lData == null) {
            lData = new ArrayList<Transit>();
            lData.add(new Transit(1, "Alexandra", "Zagorovskaya", DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss").parse("2016-02-10 11:50:23"), DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss").parse("2016-02-20 11:49:11"), DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss").parse("2016-02-20 11:47:44"), 45, 107, "Honda NSX", "NSX123", 423511, new PositionTransit(50.3551709, 30.3359953), 148, true, true, false, VehicleTypeTransit.BUS, "<img alt='gear' src='img/gear.png' style='margin-top:4px; margin-left:-1px;'/>"));
            lData.add(new Transit(2, "Alex", "Gusev", DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss").parse("2015-11-20 11:50:23"), DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss").parse("2016-02-20 11:49:11"), DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss").parse("2016-02-20 11:47:44"), 45, 101, "Hundai", "NSX123", 123456, new PositionTransit(53.587648, -2.558620), 48, true, true, false, VehicleTypeTransit.BUS, "<img alt='gear' src='img/gear.png' style='margin-top:4px; margin-left:-1px;'/>"));
            lData.add(new Transit(3, "Alina", "Bokovtseva", DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss").parse("2014-12-22 11:50:23"), DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss").parse("2016-02-20 11:49:11"), DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss").parse("2016-02-20 11:47:44"), 100, 77, "Mazda", "NSX123", 654321, new PositionTransit(50.3551709, 30.3359953), 18, false, true, true, VehicleTypeTransit.CAR, "<img alt='gear' src='img/gear.png' style='margin-top:4px; margin-left:-1px;'/>"));
            lData.add(new Transit(4, "Anastasia", "Kuzmintsova", DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss").parse("2016-01-01 11:50:23"), DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss").parse("2016-02-20 11:49:11"), DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss").parse("2016-02-20 11:47:44"), 45, 12, "Chevrole", "NSX123", 3245, new PositionTransit(53.587648, -2.558620), 180, true, true, false, VehicleTypeTransit.BUS, "<img alt='gear' src='img/gear.png' style='margin-top:4px; margin-left:-1px;'/>"));
            lData.add(new Transit(5, "Andrew", "Kurkin", DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss").parse("2014-08-25 11:50:23"), DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss").parse("2016-02-20 11:49:11"), DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss").parse("2016-02-20 11:47:44"), 45, 87, "Volga 2000", "NSX123", 678, new PositionTransit(50.3551709, 30.3359953), 50, true, true, false, VehicleTypeTransit.BUS, "<img alt='gear' src='img/gear.png' style='margin-top:4px; margin-left:-1px;'/>"));
            lData.add(new Transit(6, "Angela", "Alayeva", DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss").parse("2015-07-28 11:50:23"), DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss").parse("2016-02-20 11:49:11"), DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss").parse("2016-02-20 11:47:44"), 45, 63, "Moskvith 123", "NSX123", 999, new PositionTransit(50.3551709, 30.3359953), 60, true, true, false, VehicleTypeTransit.BUS, "<img alt='gear' src='img/gear.png' style='margin-top:4px; margin-left:-1px;'/>"));
            lData.add(new Transit(7, "Anna", "Ocherednik", DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss").parse("2015-05-18 11:50:23"), DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss").parse("2016-02-20 11:49:11"), DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss").parse("2016-02-20 11:47:44"), 60, 137, "Mitcbisy", "NSX123", 100000, new PositionTransit(53.587648, -2.558620), 70, false, true, true, VehicleTypeTransit.TRUCK, "<img alt='gear' src='img/gear.png' style='margin-top:4px; margin-left:-1px;'/>"));
            lData.add(new Transit(8, "Artem", "Savotin", DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss").parse("2016-04-05 11:50:23"), DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss").parse("2016-02-20 11:49:11"), DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss").parse("2016-02-20 11:47:44"), 45, 58, "Pagera", "NSX123", 20041, new PositionTransit(50.3551709, 30.3359953), 83, true, true, true, VehicleTypeTransit.BUS, "<img alt='gear' src='img/gear.png' style='margin-top:4px; margin-left:-1px;'/>"));
            lData.add(new Transit(9, "Aviram", "Eisenberg", DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss").parse("2016-02-02 11:50:23"), DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss").parse("2016-02-20 11:49:11"), DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss").parse("2016-02-20 11:47:44"), 65, 99, "Porshe", "NSX123", 42, new PositionTransit(53.587648, -2.558620), 10, false, true, false, VehicleTypeTransit.TRUCK, "<img alt='gear' src='img/gear.png' style='margin-top:4px; margin-left:-1px;'/>"));
        }
		return lData;
	}

    public static List<TitleTransit> getTitleTransits() {
        ArrayList titleTransits = new ArrayList();
        for (Transit transit:StoreUtil.getData()) titleTransits.add(transit.getTitle());
        return titleTransits;
    }
}
