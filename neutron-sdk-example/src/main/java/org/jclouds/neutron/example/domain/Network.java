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

import java.beans.ConstructorProperties;

import javax.inject.Named;

import com.google.common.collect.ImmutableSet;

/**
 * A Neutron network
 *
 * @see <a
 * href="http://docs.openstack.org/api/openstack-network/2.0/content/Networks.html">api
 * doc</a>
 */
public class Network {

   private String id;
   private NetworkStatus status;
   private ImmutableSet<String> subnets;

   private String name;
   // GSON uses @Named when serializing
   @Named("admin_state_up")
   private Boolean adminStateUp;
   private Boolean shared;
   @Named("tenant_id")
   private String tenantId;

   @Named("provider:network_type")
   private NetworkType networkType;

   // GSON uses @ConstructorProperties and the constructor when deserializing
   @ConstructorProperties(
         { "id", "status", "subnets", "name", "admin_state_up", "shared", "tenant_id", "provider:network_type" })
   private Network(String id, NetworkStatus status, ImmutableSet<String> subnets, String name, Boolean adminStateUp,
         Boolean shared, String tenantId, NetworkType networkType) {
      this.id = id;
      this.status = status;
      this.subnets = subnets;
      this.name = name;
      this.adminStateUp = adminStateUp;
      this.shared = shared;
      this.tenantId = tenantId;
      this.networkType = networkType;
   }

}
