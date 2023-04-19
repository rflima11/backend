package com.fluytcloud.kubernetes.transport.http;

import com.fluytcloud.kubernetes.entities.Filter;
import com.fluytcloud.kubernetes.interactors.ClusterService;
import com.fluytcloud.kubernetes.interactors.PodService;
import com.fluytcloud.kubernetes.transport.response.PodResponse;
import io.quarkus.security.Authenticated;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/v1/kubernetes/pod")
@Authenticated
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PodResource {

    private final PodService podService;
    private final ClusterService clusterService;

    public PodResource(PodService podService, ClusterService clusterService) {
        this.podService = podService;
        this.clusterService = clusterService;
    }

    @GET
    public List<PodResponse> getAllPods(Integer clusterId) {
        var cluster = clusterService.findById(clusterId).get();
        return podService.list(new Filter(cluster, null, null, null, null, null))
                .stream()
                .map(it -> new PodResponse(it.getMetadata().getNamespace(), it.getMetadata().getName()))
                .toList();
    }

}
