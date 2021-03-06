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

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;

/**
 * A Neutron network
 *
 */
public class Network {

   private String id;
   private NetworkStatus status;
   private ImmutableSet<String> subnets;

   private String name;
   @Named("admin_state_up")
   private Boolean adminStateUp;
   private Boolean shared;
   @Named("tenant_id")
   private String tenantId;

   @Named("provider:network_type")
   private NetworkType networkType;

   @ConstructorProperties(
         { "id", "status", "subnets", "name", "admin_state_up", "shared", "tenant_id", "provider:network_type" })
   private Network(String id, NetworkStatus status, ImmutableSet<String> subnets, String name, Boolean adminStateUp,
         Boolean shared, String tenantId, NetworkType networkType) {
      // No checkNotNulls. With Neutron, any of these properties can be left null when used in an update.
      this.id = id;
      this.status = status;
      this.subnets = subnets;
      this.name = name;
      this.adminStateUp = adminStateUp;
      this.shared = shared;
      this.tenantId = tenantId;
      this.networkType = networkType;
   }

   /**
    * Default constructor.
    */
   private Network() {
   }

   /**
    * Copy constructor
    *
    * @param network
    */
   private Network(Network network) {
      this(network.id,
            network.status,
            network.subnets,
            network.name,
            network.adminStateUp,
            network.shared,
            network.tenantId,
            network.networkType);
   }

   /**
    * @return the id of the Network
    */
   @Nullable
   public String getId() {
      return id;
   }

   /**
    * @return the status of the Network
    */
   @Nullable
   public NetworkStatus getStatus() {
      return status;
   }

   /**
    * @return the subnets of the Network
    */
   @Nullable
   public ImmutableSet<String> getSubnets() {
      return subnets;
   }

   /**
    * @return the name of the Network
    */
   @Nullable
   public String getName() {
      return name;
   }

   /**
    * @return the adminStateUp of the Network
    */
   @Nullable
   public Boolean isAdminStateUp() {
      return adminStateUp;
   }

   /**
    * The shared attribute can be used to create a public network, i.e.: a network which is shared with all other tenants.
    * Control of the shared attribute could be reserved to particular users only, such as administrators.
    * In this case, regular users trying to create a shared network will receive a 403 - Forbidden error.
    *
    * @return true if the network resource can be accessed by any tenant or not, false if not
    */
   @Nullable
   public Boolean isShared() {
      return shared;
   }

   /**
    * @return the tenantId of the Network
    */
   @Nullable
   public String getTenantId() {
      return tenantId;
   }

   /**
    * @return the networkType of the Network
    */
   @Nullable
   public NetworkType getNetworkType() {
      return networkType;
   }

   @Override
   public int hashCode() {
      return Objects.hashCode(id, status, subnets, name, adminStateUp, shared, tenantId, networkType);
   }

   /*
    * Methods to get the Create and Update builders follow
    */

   @Override
   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      }
      if (obj == null || getClass() != obj.getClass()) {
         return false;
      }
      Network that = Network.class.cast(obj);
      return Objects.equal(this.id, that.id)
            && Objects.equal(this.status, that.status)
            && Objects.equal(this.subnets, that.subnets)
            && Objects.equal(this.name, that.name)
            && Objects.equal(this.adminStateUp, that.adminStateUp)
            && Objects.equal(this.shared, that.shared)
            && Objects.equal(this.tenantId, that.tenantId)
            && Objects.equal(this.networkType, that.networkType);
   }

   @Override
   public String toString() {
      return MoreObjects.toStringHelper(this)
            .add("id", id)
            .add("status", status)
            .add("subnets", subnets)
            .add("name", name)
            .add("adminStateUp", adminStateUp)
            .add("shared", shared)
            .add("tenantId", tenantId)
            .add("networkType", networkType)
            .toString();
   }

   /*
    * Methods to get the Create and Update builders follow
    */

   /**
    * @return the Builder for creating a new Router
    */
   public static CreateBuilder createBuilder(String name) {
      return new CreateBuilder(name);
   }

   /**
    * @return the Builder for updating a Router
    */
   public static UpdateBuilder updateBuilder() {
      return new UpdateBuilder();
   }

   private abstract static class Builder<ParameterizedBuilderType> {
      protected Network network;

      /**
       * No-parameters constructor used when updating.
       */
      private Builder() {
         network = new Network();
      }

      protected abstract ParameterizedBuilderType self();

      /**
       * Provide the name to the Network's Builder.
       *
       * @return the Builder.
       * @see Network#getName()
       */
      public ParameterizedBuilderType name(String name) {
         network.name = name;
         return self();
      }

      /**
       * Provide the adminStateUp to the Network's Builder.
       *
       * @return the Builder.
       * @see Network#isAdminStateUp()
       */
      public ParameterizedBuilderType adminStateUp(Boolean adminStateUp) {
         network.adminStateUp = adminStateUp;
         return self();
      }

      /**
       * Provide the shared to the Network's Builder.
       *
       * @return the Builder.
       * @see Network#isShared()
       */
      public ParameterizedBuilderType shared(Boolean shared) {
         network.shared = shared;
         return self();
      }

      /**
       * Provide the tenantId to the Network's Builder.
       *
       * @return the Builder.
       * @see Network#getTenantId()
       */
      public ParameterizedBuilderType tenantId(String tenantId) {
         network.tenantId = tenantId;
         return self();
      }

      /**
       * Provide the networkType to the Network's Builder.
       *
       * @return the Builder.
       * @see Network#getNetworkType()
       */
      public ParameterizedBuilderType networkType(NetworkType networkType) {
         network.networkType = networkType;
         return self();
      }
   }
   /**
    * Create and Update builders (inheriting from Builder)
    */
   public static class CreateBuilder extends Builder<CreateBuilder> {
      /**
       * Supply required properties for creating a Builder
       */
      private CreateBuilder(String name) {
         network.name = name;
      }

      /**
       * @return a CreateNetwork constructed with this Builder.
       */
      public CreateNetwork build() {
         return new CreateNetwork(network);
      }

      protected CreateBuilder self() {
         return this;
      }
   }

   /**
    * Create and Update builders (inheriting from Builder)
    */
   public static class UpdateBuilder extends Builder<UpdateBuilder> {
      /**
       * Supply required properties for updating a Builder
       */
      private UpdateBuilder() {
      }

      /**
       * @return a UpdateNetwork constructed with this Builder.
       */
      public UpdateNetwork build() {
         return new UpdateNetwork(network);
      }

      protected UpdateBuilder self() {
         return this;
      }
   }

   /**
    * Create and Update options - extend the domain class, passed to API update and create calls.
    * Essentially the same as the domain class. Ensure validation and safe typing.
    */
   public static class CreateNetwork extends Network {
      /**
       * Copy constructor
       */
      private CreateNetwork(Network network) {
         super(network);
         checkNotNull(network.name, "name should not be null");
      }
   }

   /**
    * Create and Update options - extend the domain class, passed to API update and create calls.
    * Essentially the same as the domain class. Ensure validation and safe typing.
    */
   public static class UpdateNetwork extends Network  {
      /**
       * Copy constructor
       */
      private UpdateNetwork(Network network) {
         super(network);
      }
   }
}
