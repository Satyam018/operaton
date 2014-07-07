/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.spin;

import java.util.HashSet;
import java.util.Set;

import org.camunda.spin.impl.xml.dom.XmlDomDataFormat;
import org.camunda.spin.json.SpinJsonNode;
import org.camunda.spin.json.tree.JsonTreeDataFormat;
import org.camunda.spin.spi.DataFormat;
import org.camunda.spin.xml.tree.SpinXmlTreeElement;

/**
 * Provides access to all builtin data formats.
 *
 * @author Sebastian Menski
 * @author Daniel Meyer
 */
public class DataFormats {
  
  public static final Set<DataFormat<? extends Spin<?>>> AVAILABLE_FORMATS;
  
  static {
    AVAILABLE_FORMATS = new HashSet<DataFormat<? extends Spin<?>>>();
    AVAILABLE_FORMATS.add(xmlDom());
    AVAILABLE_FORMATS.add(jsonTree());
  }

  public static DataFormat<SpinXmlTreeElement> xmlDom() {
    return XmlDomDataFormat.INSTANCE;
  }
  
  public static DataFormat<SpinJsonNode> jsonTree() {
    return JsonTreeDataFormat.INSTANCE;
  }

}
