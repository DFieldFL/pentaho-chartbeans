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
 * Created 5/15/2008 
 * @author William Seyler
 */
package org.pentaho.experimental.chart.css.styles;

import org.pentaho.reporting.libraries.css.values.CSSConstant;

/**
 * Defines the only valid values for the <code>-x-pentaho-chart-line-visible</code> style
 *
 * @author William Seyler
 */
public class ChartLineVisibleType {
  public static final CSSConstant NO = new CSSConstant("no"); //$NON-NLS-1$
  public static final CSSConstant YES = new CSSConstant("yes"); //$NON-NLS-1$

  private ChartLineVisibleType() {
  }
}
