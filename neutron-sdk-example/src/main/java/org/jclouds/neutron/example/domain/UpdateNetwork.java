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

import org.immutables.value.Value;

import com.google.common.collect.ImmutableSet;

/**
 * A Neutron network
 *
 */
@Value.Immutable
public abstract class UpdateNetwork {
   public abstract ImmutableSet<String> subnets();
   public abstract String name();
   public abstract Boolean adminStateUp();
   public abstract Boolean shared();
   public abstract String tenantId();
   public abstract NetworkType networkType();
}
