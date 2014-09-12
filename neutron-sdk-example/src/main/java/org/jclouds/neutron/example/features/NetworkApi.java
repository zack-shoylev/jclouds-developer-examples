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
package org.jclouds.neutron.example.features;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jclouds.openstack.keystone.v2_0.filters.AuthenticateRequest;
import org.jclouds.rest.annotations.RequestFilters;

import com.google.common.annotations.Beta;

/**
 * Provides access to Network operations for the OpenStack Networking (Neutron) v2 API.
 * <p/>
 * Each tenant can define one or more networks. A network is a virtual isolated layer-2 broadcast domain reserved to the
 * tenant. A tenant can create several ports for a network, and plug virtual interfaces into these ports.
 *
 * @see <a href=
 * "http://docs.openstack.org/api/openstack-network/2.0/content/Networks.html">api doc</a>
 */
@Beta
@Path("/networks")
@RequestFilters(AuthenticateRequest.class)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface NetworkApi {

}
