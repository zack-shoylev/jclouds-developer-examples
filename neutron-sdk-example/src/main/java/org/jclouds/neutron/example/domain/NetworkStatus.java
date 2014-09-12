/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jclouds.neutron.example.domain;

/**
 * Enumerates Network Status.
 */
public enum NetworkStatus {
   ACTIVE("active"),
   DOWN("down"),
   BUILD("build"),
   ERROR("error"),
   /**
    * Used by jclouds when the service returns an unknown value other than null.
    */
   UNRECOGNIZED("unrecognized");

   private final String name;

   private NetworkStatus(String name) {
      this.name = name;
   }

   /*
    * This provides GSON enum support in jclouds.
    * This implementation supports returning NULL and UNRECOGNIZED
    * This is also case-insensitive.
    * jclouds supports the fromValue method for enums in the jclouds GSON implementation
    *
    * @param name The string representation of this enum value.
    * @return The corresponding enum value.
    */
   public static NetworkStatus fromValue(String name) {
      if (name != null) {
         for (NetworkStatus value : NetworkStatus.values()) {
            if (name.equalsIgnoreCase(value.name)) {
               return value;
            }
         }
         return UNRECOGNIZED;
      }
      return null;
   }

   @Override
   public String toString() {
      return name();
   }
}