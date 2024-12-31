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
package org.operaton.bpm.client.spring.subscription;

import org.operaton.bpm.client.spring.MockedTest;
import org.operaton.bpm.client.spring.exception.NotOpenedException;
import org.operaton.bpm.client.spring.subscription.configuration.NotOpenedExceptionConfiguration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
class NotOpenedExceptionTest {

  @BeforeEach
  void setup() {
    MockedTest.mockClient();
  }

  @AfterEach
  void reset() {
    MockedTest.close();
  }

  @Test
  void shouldThrowException() {
    Class<?> clazz = NotOpenedExceptionConfiguration.class;
    assertThatThrownBy(() -> new AnnotationConfigApplicationContext(clazz))
        .isInstanceOf(NotOpenedException.class)
        .hasMessageContaining("TASK/CLIENT/SPRING-02009 Subscription with topic name " +
            "'topic-name' has yet not  been opened");
  }

}