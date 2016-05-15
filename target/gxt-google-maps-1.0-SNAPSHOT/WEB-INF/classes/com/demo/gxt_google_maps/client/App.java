package com.demo.gxt_google_maps.client;

import com.demo.gxt_google_maps.client.view.FrameWidget;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.sencha.gxt.widget.core.client.container.Viewport;

public class App implements EntryPoint {

    @Override
    public void onModuleLoad() {
        Viewport viewport = new Viewport();
        FrameWidget widget = new FrameWidget();
        viewport.add(widget);
        RootPanel.get().add(viewport);
    }

}