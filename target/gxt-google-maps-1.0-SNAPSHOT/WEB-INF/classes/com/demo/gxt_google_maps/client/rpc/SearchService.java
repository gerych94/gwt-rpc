package com.demo.gxt_google_maps.client.rpc;

import com.demo.gxt_google_maps.shared.Transit;
import com.google.gwt.editor.client.Editor;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface SearchService extends PropertyAccess<Transit> {
    ModelKeyProvider<Transit> firstName();

    LabelProvider<Transit> lastName();

    @Editor.Path("lastName")
    ValueProvider<Transit, String> nameValueProvider();
}
