package com.demo.gxt_google_maps.client;

import com.google.gwt.junit.client.GWTTestCase;

public class CompileGwtTest extends GWTTestCase {
  
    @Override
    public String getModuleName() {
        return "com.map.gxt_google_maps.App";
    }

    public void testApp() {
        assertTrue(true);
    }
  
}
