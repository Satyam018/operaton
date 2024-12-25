/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. Camunda licenses this file to you under the Apache License,
 * Version 2.0; you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.operaton.bpm.engine.test.bpmn.event.compensate.helper;

import org.operaton.bpm.engine.delegate.DelegateExecution;
import org.operaton.bpm.engine.delegate.Expression;
import org.operaton.bpm.engine.delegate.JavaDelegate;


/**
 * @author Daniel Meyer
 */
public class UndoService implements JavaDelegate {
  
  private Expression counterName;

  @Override
  public void execute(DelegateExecution execution) throws Exception {
    String variableName = (String) counterName.getValue(execution);
    Object variable = execution.getVariable(variableName);
    if(variable == null) {
      execution.setVariable(variableName, 1);
    }
    else  {
      execution.setVariable(variableName, ((Integer)variable)+1);
    }
  }

}
