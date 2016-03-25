package com.demo.gxt_google_maps.client.view;

import com.demo.gxt_google_maps.client.rpc.StoreUtil;
import com.demo.gxt_google_maps.client.rpc.SearchService;
import com.demo.gxt_google_maps.shared.Transit;
import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.Dialog;
import com.sencha.gxt.widget.core.client.ListView;
import com.sencha.gxt.widget.core.client.box.MessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.CssFloatLayoutContainer;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.event.HideEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.ComboBox;

public class SearchWidget implements IsWidget {
    private ContentPanel panel;

    @Override
    public Widget asWidget() {
        if (panel == null) {
            SearchService service = GWT.create(SearchService.class);
            ListStore<Transit> store = new ListStore<Transit>(service.firstName());
            store.addAll(StoreUtil.getData());
            ListView<Transit, String> listView = new ListView<Transit, String>(store, service.nameValueProvider());

            ComboBox<Transit> combo1 = new ComboBox<Transit>(store, service.lastName(), listView);
            combo1.setEmptyText("Search");
            combo1.setTypeAhead(true);
            combo1.setTriggerAction(ComboBoxCell.TriggerAction.ALL);
            combo1.setWidth(270);

            CssFloatLayoutContainer container = new CssFloatLayoutContainer();
            container.add(combo1);

            TextButton addButton = new TextButton("add");
            addButton.setHTML(SafeHtmlUtils.fromSafeConstant("<img alt='gear' src='img/add.png'/>"));
            addButton.addSelectHandler(new SelectEvent.SelectHandler() {
                @Override
                public void onSelect(SelectEvent event) {
                    MessageBox box = new MessageBox("&nbsp;&nbsp;&nbsp;Добавить", "");
                    box.setWidth(300);
                    box.setPredefinedButtons(Dialog.PredefinedButton.YES, Dialog.PredefinedButton.CANCEL);
                    box.setMessage("<center><form name='add'> <table border='0' cellspacing='5' cellpadding='5'><tr><td align='right' valign='top'>Имя</td><td><input type='text' name='name' size='25'></td></tr><tr><td align='right' valign='top'>ИМЕИ</td><td><input type='text' name='imey' size='25'></td></tr></table> </form></center>");
                    box.addHideHandler(new HideEvent.HideHandler() {
                        @Override
                        public void onHide(HideEvent event) {}
                    });
                    box.show();
                }
            });

            container.add(new HTML("&nbsp;"));
            container.add(addButton);

            panel = new ContentPanel();
            panel.setHeaderVisible(false);
            panel.add(container, new MarginData(5));
        }
        return panel;
    }
}
