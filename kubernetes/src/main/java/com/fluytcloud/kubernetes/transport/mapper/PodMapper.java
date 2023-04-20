package com.fluytcloud.kubernetes.transport.mapper;

import com.fluytcloud.kubernetes.transport.response.PodResponseList;
import io.kubernetes.client.openapi.models.V1Pod;

import java.util.List;

public class PodMapper {

    public PodResponseList mapResponseList(V1Pod pod) {
        return new PodResponseList(
                pod.getMetadata().getNamespace(),
                pod.getMetadata().getName()
        );
    }

    public List<PodResponseList> mapResponseList(List<V1Pod> pods) {
        return pods.stream()
                .map(this::mapResponseList)
                .toList();
    }

}
