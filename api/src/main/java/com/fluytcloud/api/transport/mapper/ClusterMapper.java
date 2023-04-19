package com.fluytcloud.api.transport.mapper;

import com.fluytcloud.api.transport.request.ClusterRequest;
import com.fluytcloud.api.transport.response.ClusterResponse;
import com.fluytcloud.api.transport.response.ClusterResponseList;
import com.fluytcloud.kubernetes.entities.Cluster;

public class ClusterMapper {

    public ClusterResponseList mapResponseList(Cluster cluster) {
        return new ClusterResponseList(
                cluster.id(),
                cluster.name()
        );
    }

    public ClusterResponse mapResponse(Cluster cluster) {
        return new ClusterResponse(
                cluster.id(),
                cluster.name(),
                cluster.connectionType(),
                cluster.url(),
                cluster.token(),
                cluster.username(),
                cluster.password(),
                cluster.validateSSL()
        );
    }

    public Cluster map(ClusterRequest request, Integer id) {
        return new Cluster(
                id,
                request.name(),
                request.connectionType(),
                request.url(),
                request.token(),
                request.username(),
                request.password(),
                request.validateSSL()
        );
    }

    public Cluster map(ClusterRequest request) {
        return map(request, null);
    }

}
