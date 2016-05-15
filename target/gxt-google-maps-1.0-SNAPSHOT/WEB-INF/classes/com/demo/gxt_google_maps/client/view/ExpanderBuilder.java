package com.demo.gxt_google_maps.client.view;

import com.demo.gxt_google_maps.shared.Transit;

/**
 * Created by Саша on 23.03.2016.
 */
public class ExpanderBuilder {
    private Transit transit;

    public ExpanderBuilder(Transit transit){
        this.transit = transit;
    }

    public String getBuilder(){
        StringBuilder expanderStringBuilder = new StringBuilder();
        expanderStringBuilder.append("<style type='text/css'>"+"ul.pixel-tabs{list-style-type:none;margin:0;padding:0;height:300px;overflow:visible;}ul.pixel-tabs li{display:inline-block;line-height:25px;}ul.pixel-tabs li a.tab{border-bottom:1px solid #eee;height:29px;}ul.pixel-tabs li a{color:#666;text-decoration:none;display:inline-block;padding:0px 12px;white-space:nowrap;}ul.pixel-tabs li a:hover{border-bottom:none;}ul.pixel-tabs li a.active-tab{background:linear-gradient(#fff,#a2becd);border-left:1px solid #eee;border-right:1px solid #eee;border-top:1px solid #eee;border-radius:8px 8px 0 0;}.content-tab{border-top:1px solid #eee;margin:-5px 0 0 0;padding:0;}div.tabs{height:300px;overflow:hidden;font-size:11px;}"+"table.underline{border-spacing:0;width:330px;}table.underline th{background:linear-gradient(#fff,#ddd);height:23px;}table.underline td{height:20px;}table.underline th:first-child{border-right:1px solid #bbb;}table.underline th:first-child,table.underline td:first-child{width:170px;padding-left:7px;}table.underline th:last-child,table.underline td:last-child{width:240px;}table.underline th,table.underline td{border-bottom:1px solid #ddd;}table.underline tr:last-child th,table.underline tr:last-child td{border-bottom:none;}"+"</style>");

        expanderStringBuilder.append("<div class='tabs'>");
        expanderStringBuilder.append("<ul class='pixel-tabs' id='one-tab"+transit.getId()+"'>");
        expanderStringBuilder.append("<li><a href='#one-tab"+transit.getId()+"' class='active-tab'>Сейчас</a></li><li><a href='#two-tab"+transit.getId()+"' class='tab'>Топливо</a></li><li><a href='#three-tab"+transit.getId()+"' class='tab'>Другое</a></li>");
        expanderStringBuilder.append("<div class='content-tab'>");
        expanderStringBuilder.append("<table class='underline'>");
        expanderStringBuilder.append("<tr><th><center><b>Данные</b></center></th> <th><center><b>Значение</b></center></th></tr>");
        expanderStringBuilder.append("<tr><td>Водитель:</td> <td><font color='blue'>"+transit.getFirstName()+" "+transit.getLastName()+"</font></td></tr>");
        expanderStringBuilder.append("<tr><td>Время (позиция):</td> <td>"+MenuWidget.df.format(transit.getTimePosition())+"</td></tr>");
        expanderStringBuilder.append("<tr><td>Время (сервер):</td> <td>"+MenuWidget.df.format(transit.getTimeServer())+"</td></tr>");
        expanderStringBuilder.append("<tr><td>Высота:</td> <td>"+transit.getHeight()+"</td></tr>");
        expanderStringBuilder.append("<tr><td>Модель:</td> <td>"+transit.getModel()+"</td></tr>");
        expanderStringBuilder.append("<tr><td>Номер:</td> <td>"+transit.getNumber()+"</td></tr>");
        expanderStringBuilder.append("<tr><td>Одометр:</td> <td>"+transit.getDistance()+"</td></tr>");
        expanderStringBuilder.append("<tr><td>Позиция:</td> <td><a href='https://www.google.com.ua/maps/@"+transit.getPosition().getLatitude()+","+transit.getPosition().getLongitude()+",8.75z' target='_blank' title='Показать на карте'>" +transit.getPosition().getLatitude()+"', "+transit.getPosition().getLongitude()+"'</a></td></tr>");
        expanderStringBuilder.append("<tr><td>Угол:</td> <td>"+transit.getDegree()+"'</td></tr>");
        expanderStringBuilder.append("</table>");
        expanderStringBuilder.append("</div>");
        expanderStringBuilder.append("</ul>");

        expanderStringBuilder.append("<ul class='pixel-tabs' id='two-tab"+transit.getId()+"'>");
        expanderStringBuilder.append("<li><a href='#one-tab"+transit.getId()+"' class='tab'>Сейчас</a></li><li><a href='#two-tab"+transit.getId()+"' class='active-tab'>Топливо</a></li><li><a href='#three-tab"+transit.getId()+"' class='tab'>Другое</a></li>");
        expanderStringBuilder.append("<div class='content-tab'>");
        expanderStringBuilder.append("<table class='underline'>");
        expanderStringBuilder.append("<tr><th><center><b>Данные</b></center></th> <th><center><b>Значение</b></center></th></tr>");
        expanderStringBuilder.append("<tr><td>Бак №1</td> <td>130л</td></tr>");
        expanderStringBuilder.append("<tr><td>Бак №2</td> <td>82л</td></tr>");
        expanderStringBuilder.append("<tr><td><a href='#' target='_blank'>график топлива</a></td> <td></td></tr>");
        expanderStringBuilder.append("</table>");
        expanderStringBuilder.append("</div>");
        expanderStringBuilder.append("</ul>");

        expanderStringBuilder.append("<ul class='pixel-tabs' id='three-tab"+transit.getId()+"'>");
        expanderStringBuilder.append("<li><a href='#one-tab"+transit.getId()+"' class='tab'>Сейчас</a></li><li><a href='#two-tab"+transit.getId()+"' class='tab'>Топливо</a></li><li><a href='#three-tab"+transit.getId()+"' class='active-tab'>Другое</a></li>");
        expanderStringBuilder.append("<div class='content-tab'>");
        expanderStringBuilder.append("<table class='underline'>");
        expanderStringBuilder.append("<tr><th><center><b>Данные</b></center></th> <th><center><b>Значение</b></center></th></tr>");
        expanderStringBuilder.append("<tr><td>Напряжение батареи (В)</td> <td>0</td></tr>");
        expanderStringBuilder.append("<tr><td>GPS заблокирован</td> <td>Нет</td></tr>");
        expanderStringBuilder.append("<tr><td>Статус GPS</td> <td>Включено</td></tr>");
        expanderStringBuilder.append("<tr><td>Зажигание</td> <td>Выключен</td></tr>");
        expanderStringBuilder.append("<tr><td>Оператор</td> <td>Estonian Mobile Telephone</td></tr>");
        expanderStringBuilder.append("<tr><td>Питание</td> <td>Выключен</td></tr>");
        expanderStringBuilder.append("<tr><td>Напряжение питания (В)</td> <td>0</td></tr>");
        expanderStringBuilder.append("</table>");
        expanderStringBuilder.append("</div>");
        expanderStringBuilder.append("</ul>");
        expanderStringBuilder.append("</div>");

        return expanderStringBuilder.toString();
    }
}
