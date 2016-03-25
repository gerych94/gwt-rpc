//package com.demo.gxt_google_maps.client.view;
//
//import com.google.gwt.user.client.ui.IsWidget;
//import com.google.gwt.user.client.ui.Widget;
//import com.sencha.gxt.widget.core.client.Dialog;
//import com.sencha.gxt.widget.core.client.box.MessageBox;
//import com.sencha.gxt.widget.core.client.button.ButtonBar;
//import com.sencha.gxt.widget.core.client.button.TextButton;
//import com.sencha.gxt.widget.core.client.event.HideEvent;
//import com.sencha.gxt.widget.core.client.event.HideEvent.HideHandler;
//import com.sencha.gxt.widget.core.client.event.SelectEvent;
//import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
//
//public class FrameWidget2 implements IsWidget {
//
//    public Widget asWidget() {
//        ButtonBar statusBar = new ButtonBar();
//
//        TextButton statusButton = new TextButton("Ok");
//        statusButton.addSelectHandler(new SelectHandler() {
//            @Override
//            public void onSelect(SelectEvent event) {
//                MessageBox box = new MessageBox("<center>Состояние</center>", "");
//                box.setWidth(600);
//                box.setPredefinedButtons(Dialog.PredefinedButton.OK, Dialog.PredefinedButton.CANCEL);
//                box.setMessage("<center><table border='1' width='100%' cellpadding='10' cellspacing='0'>"
//                        +"<tr><td>Водитель</td><td><i>Ivan Petrov</i></td></tr>"
//                        +"<tr><td>Время (позиция)</td><td><i>2016-02-20 11:49:11</i></td></tr>"
//                        +"<tr><td>Время (сервер)</td> <td><i>2016-02-20 11:47:44</i></td></tr>"
//                        +"<tr><td>Высота</td> <td><i>107 м</i></td></tr>"
//                        +"<tr><td>Модель</td> <td><i>Honda NSX</i></td></tr>"
//                        +"<tr><td>Номер</td> <td><i>NSX123</i></td></tr>"
//                        +"<tr><td>Одометр</td> <td><i>423511</i></td></tr>"
//                        +"<tr><td>Позиция</td> <td><i>53.587648,-2.558620'</i></td></tr>"
//                        +"<tr><td>Угол</td> <td><i>148'</i></td></tr>"
//                        +"</table></center>");
//                box.addHideHandler(new HideHandler() {
//                    @Override
//                    public void onHide(HideEvent event) {
//                        Dialog btn = (Dialog) event.getSource();
////                        String msg = Format.substitute("The '{0}' button was pressed", btn.getHideButton().getText());
////                        Info.display("MessageBox", msg);
//                    }
//                });
//                box.show();
//            }
//        });
//        statusBar.add(statusButton);
//
//        return statusBar;
//    }
//}
