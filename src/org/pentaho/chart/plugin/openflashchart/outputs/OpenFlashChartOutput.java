/*
 * Copyright 2007 Pentaho Corporation.  All rights reserved. 
 * This software was developed by Pentaho Corporation and is provided under the terms 
 * of the Mozilla Public License, Version 1.1, or any later version. You may not use 
 * this file except in compliance with the license. If you need a copy of the license, 
 * please go to http://www.mozilla.org/MPL/MPL-1.1.txt. The Original Code is the Pentaho 
 * BI Platform.  The Initial Developer is Pentaho Corporation.
 *
 * Software distributed under the Mozilla Public License is distributed on an "AS IS" 
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or  implied. Please refer to 
 * the license for the specific language governing your rights and limitations.
 *
 * @created Mar 4, 2008 
 * @author wseyler
 */


package org.pentaho.chart.plugin.openflashchart.outputs;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Writer;

import ofc4j.model.Chart;

import org.jfree.chart.ChartRenderingInfo;
import org.pentaho.chart.plugin.api.IOutput;
import org.pentaho.chart.plugin.api.PersistenceException;



/**
 * @author arodriguez
 *
 */
public class OpenFlashChartOutput implements IOutput {

  private Chart chart;
  private ChartRenderingInfo info;
  private static final String OPEN_FLASHCHART_JSON = "{\"bg_colour\":\"#FFFFFF\",\"inner_bg_colour\":\"#EEEEEE\",\"title\":{\"text\":\"Bar Chart\",\"style\":\"font-family: Arial; font-size: 14px; font-weight: bold; font-style: normal;\"},\"y_legend\":{\"text\":\"Sales\",\"style\":\"font-family: Arial; font-size: 12px; font-weight: normal; font-style: normal;\"},\"x_legend\":{\"text\":\"Years\",\"style\":\"font-family: Arial; font-size: 12px; font-weight: normal; font-style: normal;\"},\"y_axis\":{\"min\":0,\"steps\":204252,\"stroke\":1,\"grid-colour\":\"#aaaaaa\",\"colour\":\"#000000\",\"max\":2246772},\"x_axis\":{\"stroke\":1,\"grid-colour\":\"#aaaaaa\",\"colour\":\"#000000\",\"labels\":{\"labels\":[\"2003\",\"2004\",\"2005\"]},\"offset\":1},\"elements\":[{\"text\":\"Classic Cars\",\"type\":\"bar\",\"values\":[{\"top\":1514407.42},{\"top\":1838274.85},{\"top\":738737.6}],\"colour\":\"#387179\"},{\"text\":\"Vintage Cars\",\"type\":\"bar\",\"values\":[{\"top\":679948.55},{\"top\":997559.65},{\"top\":388718.19}],\"colour\":\"#626638\"},{\"text\":\"Trucks and Buses\",\"type\":\"bar\",\"values\":[{\"top\":420429.93},{\"top\":531975.89},{\"top\":201874.75}],\"colour\":\"#A8979A\"},{\"text\":\"Motorcycles\",\"type\":\"bar\",\"values\":[{\"top\":397219.71},{\"top\":590580.25},{\"top\":286325.23}],\"colour\":\"#B09A6B\"},{\"text\":\"Planes\",\"type\":\"bar\",\"values\":[{\"top\":347755.01},{\"top\":528927.94},{\"top\":200074.17}],\"colour\":\"#772200\"},{\"text\":\"Ships\",\"type\":\"bar\",\"values\":[{\"top\":244821.09},{\"top\":375671.69},{\"top\":128178.07}],\"colour\":\"#C52F0D\"},{\"text\":\"Trains\",\"type\":\"bar\",\"values\":[{\"top\":72802.29},{\"top\":124749.57},{\"top\":36917.33}],\"colour\":\"#123D82\"}]}";
  public OpenFlashChartOutput(Chart chart)
  {
    this.chart = chart;
  }

  public OutputStream persistChart(OutputStream outputStream, IOutput.OutputTypes fileType, int width, int height) throws PersistenceException {
    if (outputStream == null) {
      outputStream = new ByteArrayOutputStream();
    }
    try {
      outputStream.flush();
    } catch (IOException e1) {
      throw new PersistenceException(e1);
    }
    PrintStream printStream = new PrintStream(outputStream, true);
    printStream.print(chart.toString());
//    printStream.print(OPEN_FLASHCHART_JSON);
    return outputStream;
  }

  public Writer persistMap(Writer outputStream, String mapName) throws PersistenceException {
    throw new UnsupportedOperationException();
  }

  private String getMap(String mapName) {
    throw new UnsupportedOperationException();
  }

  public Object getDrawable()
  {
    return chart;
  }
}
