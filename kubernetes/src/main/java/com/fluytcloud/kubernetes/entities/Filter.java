package com.fluytcloud.kubernetes.entities;

import io.kubernetes.client.proto.Meta;

import java.util.List;
import java.util.Map;

public record Filter(
        Cluster cluster,
        List<String> namespaces,
        String search,
        OwnerReference ownerReference,
        Integer limit,
        Map<String, String> selector) {
}
