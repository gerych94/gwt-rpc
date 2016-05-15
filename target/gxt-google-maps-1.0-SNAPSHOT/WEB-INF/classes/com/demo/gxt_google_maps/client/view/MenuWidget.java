package com.demo.gxt_google_maps.client.view;

import com.demo.gxt_google_maps.client.rpc.GWTService;
import com.demo.gxt_google_maps.client.rpc.StoreUtil;
import com.demo.gxt_google_maps.shared.TitleTransit;
import com.demo.gxt_google_maps.shared.Transit;
import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.sencha.gxt.cell.core.client.TextButtonCell;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.Dialog;
import com.sencha.gxt.widget.core.client.box.MessageBox;
import com.sencha.gxt.widget.core.client.event.HideEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;

import java.util.ArrayList;
import java.util.List;

public class MenuWidget extends Grid<Transit> {

    private static final GWTService service = GWT.create(GWTService.class);

    public static final DateTimeFormat                       df = DateTimeFormat.getFormat("yyyy-MM-dd HH:mm:ss");
    private static ColumnConfig<Transit, Boolean>       viewCol = new ColumnConfig<Transit, Boolean>(service.checked1(), 30, SafeHtmlUtils.fromSafeConstant("<img alt='View' src='img/view.png' width='14' style='margin-left:-1px;'/>"));
    private static ColumnConfig<Transit, Boolean>      foundCol = new ColumnConfig<Transit, Boolean>(service.checked2(), 30, SafeHtmlUtils.fromSafeConstant("<img alt='Found' src='img/found.png' width='14' style='margin-left:-1px;'/>"));
    private static ColumnConfig<Transit, TitleTransit> objectCol = new ColumnConfig<Transit, TitleTransit>(service.title(), 233, SafeHtmlUtils.fromSafeConstant("<center>Объект</center>"));
    private static ColumnConfig<Transit, Integer>      phoneCol = new ColumnConfig<Transit, Integer>(service.speed(), 40, "км/ч");
    private static ColumnConfig<Transit, Boolean>       wifiCol = new ColumnConfig<Transit,Boolean>(service.wifi(),30, SafeHtmlUtils.fromSafeConstant("<img alt='Wi-Fi' src='img/wifi.png' width='14' style='margin-left:-1px;'/>"));
    private static ColumnConfig<Transit, String>       stateCol = new ColumnConfig<Transit, String>(service.state(), 37, "");

    public MenuWidget() {
        super(loadData(), createColumns());

        this.setAllowTextSelection(true);
        this.getView().setStripeRows(true);
        this.getView().setColumnLines(true);
        this.getView().setAutoExpandColumn(objectCol);
        this.setBorders(false);
        this.setColumnReordering(true);
        this.setStateful(false);
    }

    private static ListStore<Transit> loadData(){
        ListStore<Transit> store = new ListStore<Transit>(service.key());
        store.addAll(StoreUtil.getData());

        return store;
    }

    private static ColumnModel<Transit> createColumns(){
        viewCol.setCell(new AbstractCell<Boolean>() {
            @Override
            public void render(Context context, Boolean value, SafeHtmlBuilder sb) {
                if(value){
                    sb.appendHtmlConstant("<input name='checked1' id='checked1' type='checkbox' checked></input>");
                } else {
                    sb.appendHtmlConstant("<input name='checked1' id='checked1' type='checkbox'></input>");
                }
            }
        });
        foundCol.setCell(new AbstractCell<Boolean>() {
            @Override
            public void render(Context context, Boolean value, SafeHtmlBuilder sb) {
                if(value){
                    sb.appendHtmlConstant("<input name='checked2' id='checked2' type='checkbox' checked></input>");
                } else {
                    sb.appendHtmlConstant("<input name='checked2' id='checked2' type='checkbox'></input>");
                }
            }
        });
        objectCol.setCell(new AbstractCell<TitleTransit>() {
            @Override
            public void render(Context context, TitleTransit title, SafeHtmlBuilder sb) {
                sb.appendHtmlConstant("<table cellspacing='3' cellpadding='0' border='0'>");
                sb.appendHtmlConstant("<tr><td rowspan='2'><img alt='"+title.getVehicleType()+"' src='img/"+title.getVehicleType()+".png' width='30'/></td><td><font color='blue'><b>"+title.getNameVehicleType()+"</b></font></td></tr>");
                sb.appendHtmlConstant("<tr><td>"+df.format(title.getTime())+"</td></tr>");
                sb.appendHtmlConstant("</table>");
            }
        });
        wifiCol.setCell(new AbstractCell<Boolean>() {
            @Override
            public void render(Context context, Boolean value, SafeHtmlBuilder sb) {
                if(value){
                    sb.appendHtmlConstant("<img src='img/wifi-enable.png'>");
                } else {
                    sb.appendHtmlConstant("<img src='img/wifi-disable.png'>");
                }
            }
        });
        TextButtonCell stateButton = new TextButtonCell();
        stateButton.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                //Cell.Context c = event.getContext();
                //int row = c.getIndex();
                Transit transit = MenuWidget.loadData().get(event.getContext().getIndex());
                MessageBox box = new MessageBox("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Состояние", "");
                box.setWidth(800);
                box.setHeight(450);
                box.setPredefinedButtons(Dialog.PredefinedButton.YES, Dialog.PredefinedButton.CANCEL);
                box.setMessage("<style>table.mydialog{padding:10px;border-radius:10px;border-color:#000;background:#adb3c5;}table.mydialogin{padding:10px;}table.mydialogin th,td{border-bottom:1px solid #fff;}</style>"
                        + "<center><table class='mydialog' border='1' width='760' cellpadding='15' cellspacing='0'><tr><td>"
                        + "<table class='mydialogin' border='0' width='100%' cellspacing='0'>"
                        + "<tr><td><br>Водитель</td><td><br><input type='text' name='name' size='25' value='"+transit.getFirstName()+" "+transit.getLastName()+"' maxlength='50'></td></tr>"
                        + "<tr><td><br>Время (позиция)</td><td><br><input type='text' name='name' size='25' value='"+MenuWidget.df.format(transit.getTimePosition())+"' maxlength='50'></td></tr>"
                        + "<tr><td><br>Время (сервер)</td> <td><br><input type='text' name='name' size='25' value='"+MenuWidget.df.format(transit.getTimeServer())+"' maxlength='50'></td></tr>"
                        + "<tr><td><br>Высота</td> <td><br><input type='text' name='name' size='25' value='"+transit.getHeight()+"' maxlength='50'></td></tr>"
                        + "<tr><td><br>Модель</td> <td><br><input type='text' name='name' size='25' value='"+transit.getModel()+"' maxlength='50'></td></tr>"
                        + "<tr><td><br>Номер</td> <td><br><input type='text' name='name' size='25' value='"+transit.getNumber()+"' maxlength='50'></td></tr>"
                        + "<tr><td><br>Одометр</td> <td><br><input type='text' name='name' size='25' value='"+transit.getDistance()+"' maxlength='50'></td></tr>"
                        + "<tr><td><br>Позиция</td> <td><br><a href='https://www.google.com.ua/maps/@"+transit.getPosition().getLatitude()+","+transit.getPosition().getLongitude()+",8.75z' target='_blank' title='Показать на карте'>" +transit.getPosition().getLatitude()+"', "+transit.getPosition().getLongitude()+"</td></tr>"
                        + "<tr><td><br>Угол</td> <td><br><input type='text' name='name' size='25' value='"+transit.getDegree()+"'' maxlength='50'></td></tr>"
                        + "</table>"
                        + "<br>"
                        + "</td></tr></table></center>");
                box.addHideHandler(new HideEvent.HideHandler() {
                    @Override
                    public void onHide(HideEvent event) {}
                });
                box.show();
            }
        });
        stateButton.setHTML(SafeHtmlUtils.fromSafeConstant("<img alt='gear' src='img/gear.png'/>"));
        stateCol.setCell(stateButton);

        List<ColumnConfig<Transit, ?>> columns = new ArrayList<ColumnConfig<Transit, ?>>();
        viewCol.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        foundCol.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        phoneCol.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        wifiCol.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

        columns.add(viewCol);
        columns.add(foundCol);
        columns.add(objectCol);
        columns.add(phoneCol);
        columns.add(wifiCol);
        columns.add(stateCol);
        return new ColumnModel<Transit>(columns);
    }

//    static class ExpanderBuilder extends TabPanel {
//        public ExpanderBuilder(Transit transit){
//            StringBuilder expanderStringBuilder = new StringBuilder();
//            expanderStringBuilder.append("<table class='underline'>");
//            expanderStringBuilder.append("<tr><td>Водитель:</td> <td><font color='blue'>"+transit.getFirstName()+" "+transit.getLastName()+"</font></td></tr>");
//            expanderStringBuilder.append("<tr><td>Время (позиция):</td> <td>"+df.format(transit.getTimePosition())+"</td></tr>");
//            expanderStringBuilder.append("<tr><td>Время (сервер):</td> <td>"+df.format(transit.getTimeServer())+"</td></tr>");
//            expanderStringBuilder.append("<tr><td>Высота:</td> <td>"+transit.getHeight()+" м</td></tr>");
//            expanderStringBuilder.append("<tr><td>Модель:</td> <td>"+transit.getModel()+"</td></tr>");
//            expanderStringBuilder.append("<tr><td>Номер:</td> <td>"+transit.getNumber()+"</td></tr>");
//            expanderStringBuilder.append("<tr><td>Одометр:</td> <td>"+transit.getDistance()+"</td></tr>");
//            expanderStringBuilder.append("<tr><td>Позиция:</td> <td><a href='https://www.google.com.ua/maps/@"+transit.getPosition().getLatitude()+","+transit.getPosition().getLongitude()+",8.75z' target='_blank' title='Показать на карте'>" +transit.getPosition().getLatitude()+"', "+transit.getPosition().getLongitude() +"'</a></td></tr>");
//            expanderStringBuilder.append("<tr><td>Угол:</td> <td>"+transit.getDegree()+"'</td></tr>");
//            expanderStringBuilder.append("</table>");
//
//            ContentPanel currentPanel = new ContentPanel();
//            ContentPanel routesPanel = new ContentPanel();
//            ContentPanel notificationsPanel = new ContentPanel();
//            currentPanel.add(new HTML(expanderStringBuilder.toString()));
//            routesPanel.add(new HTML("none"));
//            notificationsPanel.add(new HTML("none"));
//            currentPanel.setHeaderVisible(false); routesPanel.setHeaderVisible(false); notificationsPanel.setHeaderVisible(false);
//
//            add(currentPanel, "Сейчас");
//            add(routesPanel, "Маршруты");
//            add(notificationsPanel, "Оповещения");
//            setAutoSelect(true);
//        }
//    }
}
