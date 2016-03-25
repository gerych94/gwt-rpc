//package com.demo.gxt_google_maps.client.view;
//
//import com.google.gwt.cell.client.AbstractCell;
//import com.google.gwt.core.client.GWT;
//import com.google.gwt.editor.client.Editor;
//import com.google.gwt.event.logical.shared.BeforeSelectionEvent;
//import com.google.gwt.event.logical.shared.BeforeSelectionHandler;
//import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
//import com.google.gwt.user.client.Window;
//import com.google.gwt.user.client.ui.HTML;
//import com.google.gwt.user.client.ui.IsWidget;
//import com.google.gwt.user.client.ui.Widget;
//import com.google.web.bindery.autobean.shared.AutoBean;
//import com.google.web.bindery.autobean.shared.AutoBeanFactory;
//import com.sencha.gxt.cell.core.client.form.ComboBoxCell;
//import com.sencha.gxt.core.client.IdentityValueProvider;
//import com.sencha.gxt.core.client.ValueProvider;
//import com.sencha.gxt.data.client.loader.JsoReader;
//import com.sencha.gxt.data.client.loader.ScriptTagProxy;
//import com.sencha.gxt.data.client.writer.UrlEncodingWriter;
//import com.sencha.gxt.data.shared.LabelProvider;
//import com.sencha.gxt.data.shared.ListStore;
//import com.sencha.gxt.data.shared.ModelKeyProvider;
//import com.sencha.gxt.data.shared.PropertyAccess;
//import com.sencha.gxt.data.shared.loader.*;
//import com.sencha.gxt.examples.resources.client.TestData;
//import com.sencha.gxt.examples.resources.client.model.State;
//import com.sencha.gxt.widget.core.client.ContentPanel;
//import com.sencha.gxt.widget.core.client.ListView;
//import com.sencha.gxt.widget.core.client.container.CssFloatLayoutContainer;
//import com.sencha.gxt.widget.core.client.container.MarginData;
//import com.sencha.gxt.widget.core.client.form.ComboBox;
//
//import java.util.Date;
//import java.util.List;
//
//public class SearchBlockWidget implements IsWidget {
//
//    private ContentPanel panel;
//    private ComboBox<Forum> combo2;
//
//    @Override
//    public Widget asWidget() {
//        if (panel == null) {
//            CarService properties = GWT.create(CarService.class);
//
//            ListStore<State> states = new ListStore<State>(properties.abbr());
//            states.addAll(TestData.getStates());
//
//            ListView<State, String> listView = new ListView<State, String>(states, properties.nameValueProvider());
//
//            ComboBox<State> combo1 = new ComboBox<State>(states, properties.name(), listView);
//            combo1.setEmptyText("Все (114)");
//            combo1.setTypeAhead(true);
//            combo1.setTriggerAction(ComboBoxCell.TriggerAction.ALL);
//            combo1.setWidth(160);
//
//            CssFloatLayoutContainer container = new CssFloatLayoutContainer();
//            container.add(combo1);
//
//            String url = "http://www.sencha.com/forum/topics-remote.php";
//
//            ScriptTagProxy<ForumLoadConfig> proxy = new ScriptTagProxy<ForumLoadConfig>(url);
//            proxy.setWriter(new UrlEncodingWriter<ForumLoadConfig>(TestAutoBeanFactory.instance, ForumLoadConfig.class));
//
//            JsoReader<ForumListLoadResult, ForumCollection> reader = new JsoReader<ForumListLoadResult, ForumCollection>(TestAutoBeanFactory.instance, ForumCollection.class) {
//                @Override
//                protected ForumListLoadResult createReturnData(Object loadConfig, ForumCollection records) {
//                    PagingLoadConfig cfg = (PagingLoadConfig) loadConfig;
//                    ForumListLoadResult result = TestAutoBeanFactory.instance.dataLoadResult().as();
//                    result.setData(records.getTopics());
//                    result.setOffset(cfg.getOffset());
//                    result.setTotalLength(Integer.parseInt(records.getTotalCount()));
//
//                    return result;
//                }
//            };
//
//            PagingLoader<ForumLoadConfig, ForumListLoadResult> loader = new PagingLoader<ForumLoadConfig, ForumListLoadResult>(proxy, reader);
//            loader.useLoadConfig(TestAutoBeanFactory.instance.loadConfig().as());
//            loader.addBeforeLoadHandler(new BeforeLoadEvent.BeforeLoadHandler<ForumLoadConfig>() {
//                @Override
//                public void onBeforeLoad(BeforeLoadEvent<ForumLoadConfig> event) {
//                    String query = combo2.getText();
//                    if (query != null && !query.equals("")) {
//                        event.getLoadConfig().setQuery(query);
//                    }
//                }
//            });
//
//            ForumProperties properties2 = GWT.create(ForumProperties.class);
//
//            ListStore<Forum> store2 = new ListStore<Forum>(properties2.topicId());
//
//            loader.addLoadHandler(new LoadResultListStoreBinding<ForumLoadConfig, Forum, ForumListLoadResult>(store2));
//
//            ListView<Forum, Forum> listView2 = new ListView<Forum, Forum>(store2, new IdentityValueProvider<Forum>());
//            listView2.setCell(new AbstractCell<Forum>() {
//                @Override
//                public void render(com.google.gwt.cell.client.Cell.Context context, Forum value, SafeHtmlBuilder sb) {
//                    //TODO
//                }
//            });
//
//            ComboBoxCell<Forum> comboCell = new ComboBoxCell<Forum>(store2, properties2.title(), listView2);
//
//            combo2 = new ComboBox<Forum>(comboCell);
//            combo2.setLoader(loader);
//            combo2.setHideTrigger(true);
//            combo2.setPageSize(10);
//            combo2.setWidth(130);
//            combo2.addBeforeSelectionHandler(new BeforeSelectionHandler<Forum>() {
//                @Override
//                public void onBeforeSelection(BeforeSelectionEvent<Forum> event) {
//                    event.cancel();
//                    Forum forum = combo2.getListView().getSelectionModel().getSelectedItem();
//                    String url = "http://sencha.com/forum/showthread.php?t=" + forum.getTopicId() + "&p=" + forum.getPostId();
//                    Window.open(url, null, "resizable=yes");
//                }
//            });
//
//            container.add(new HTML("&nbsp;&nbsp;"));
//            container.add(combo2);
//            container.add(new HTML("&nbsp;&nbsp;<a href='#'><img alt='settings' src='img/settings-head.png' width='23' style='margin-bottom:0; margin-left:-1px;'/></a>"));
//
//            panel = new ContentPanel();
//            panel.setHeaderVisible(false);
//            panel.add(container, new MarginData(5));
//        }
//        return panel;
//    }
//
//    interface CarService extends PropertyAccess<State> {
//        ModelKeyProvider<State> abbr();
//
//        LabelProvider<State> name();
//
//        @Editor.Path("name")
//        ValueProvider<State, String> nameValueProvider();
//    }
//
//    interface TestAutoBeanFactory extends AutoBeanFactory {
//        static TestAutoBeanFactory instance = GWT.create(TestAutoBeanFactory.class);
//
//        AutoBean<ForumCollection> dataCollection();
//        AutoBean<ForumListLoadResult> dataLoadResult();
//        AutoBean<ForumLoadConfig> loadConfig();
//    }
//
//    public interface Forum {
//        @AutoBean.PropertyName("topic_title")
//        public String getTitle();
//
//        @AutoBean.PropertyName("topic_id")
//        public String getTopicId();
//
//        public String getAuthor();
//
//        @AutoBean.PropertyName("forumid")
//        public String getForumId();
//
//        @AutoBean.PropertyName("post_text")
//        public String getExcerpt();
//
//        @AutoBean.PropertyName("post_id")
//        public String getPostId();
//
//        @AutoBean.PropertyName("post_time")
//        public Date getDate();
//    }
//
//    interface ForumCollection {
//        String getTotalCount();
//        List<Forum> getTopics();
//    }
//
//    interface ForumLoadConfig extends PagingLoadConfig {
//        String getQuery();
//
//        void setQuery(String query);
//
//        @Override
//        @AutoBean.PropertyName("start")
//        public int getOffset();
//
//        @Override
//        @AutoBean.PropertyName("start")
//        public void setOffset(int offset);
//    }
//
//    interface ForumListLoadResult extends PagingLoadResult<Forum> {
//        void setData(List<Forum> data);
//
//        @Override
//        @AutoBean.PropertyName("start")
//        public int getOffset();
//
//        @Override
//        @AutoBean.PropertyName("start")
//        public void setOffset(int offset);
//    }
//
//    interface ForumProperties extends PropertyAccess<Forum> {
//        ModelKeyProvider<Forum> topicId();
//        LabelProvider<Forum> title();
//    }
//}
