package com.fluytcloud.api.transport.request;

import java.util.Set;

public record GroupRequest(Integer id, String name, GroupRequest group, Set<GroupRequest> subgroups) {
}
