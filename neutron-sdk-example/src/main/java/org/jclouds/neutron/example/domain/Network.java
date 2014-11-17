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

import static com.google.common.base.Preconditions.checkNotNull;

import java.beans.ConstructorProperties;

import javax.inject.Named;

import org.jclouds.javax.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;
import org.jclouds.json.SerializedNames;

/**
 * A Neutron network
 *
 */
@AutoValue
public abstract class Network {

   public abstract String getId();
   @Nullable public abstract NetworkStatus getStatus();
   public abstract ImmutableSet<String> getSubnets();
   public abstract String getName();
   @Nullable public abstract Boolean getAdminStateUp();
   @Nullable public abstract Boolean getShared();
   @Nullable public abstract String getTenantId();
   @Nullable public abstract NetworkType getNetworkType();

   @SerializedNames({"id", "status", "subnets", "name", "admin_state_up", "shared", "tenant_id", "provider:network_type"})
   public static Network create(String id, NetworkStatus status, ImmutableSet<String> subnets, String name, Boolean adminStateUp,
         Boolean shared, String tenantId, NetworkType networkType) {
      // Validation would be here

      return new AutoValue_Network(id, status, subnets, name, adminStateUp,
            shared, tenantId, networkType);
   }
}
