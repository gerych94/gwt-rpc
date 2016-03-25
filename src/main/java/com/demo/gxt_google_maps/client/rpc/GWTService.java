package com.demo.gxt_google_maps.client.rpc;

import com.demo.gxt_google_maps.shared.PositionTransit;
import com.demo.gxt_google_maps.shared.TitleTransit;
import com.demo.gxt_google_maps.shared.Transit;
import com.demo.gxt_google_maps.shared.VehicleTypeTransit;
import com.google.gwt.editor.client.Editor.Path;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

import java.util.Date;

public interface GWTService extends PropertyAccess<Transit> {
	@Path("id")
	ModelKeyProvider<Transit> key();

    ValueProvider<Transit, String> firstName();
    ValueProvider<Transit, String> lastName();
    ValueProvider<Transit, Date> time();
    ValueProvider<Transit, Date> timePosition();
    ValueProvider<Transit, Date> timeServer();
    ValueProvider<Transit, Integer> speed();
    ValueProvider<Transit, Integer> height();
    ValueProvider<Transit, String> model();
    ValueProvider<Transit, String> number();
    ValueProvider<Transit, Integer> distance();
    ValueProvider<Transit, PositionTransit> position();
    ValueProvider<Transit, Integer> degree();
    ValueProvider<Transit, VehicleTypeTransit> vehicleType();
    ValueProvider<Transit, Boolean> wifi();
    ValueProvider<Transit, Boolean> checked1();
    ValueProvider<Transit, Boolean> checked2();
    ValueProvider<Transit, TitleTransit> title();
    ValueProvider<Transit, String> state();
}
