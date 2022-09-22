package com.fluytcloud.api.transport.response;

import java.util.Objects;
import java.util.Set;

public record GroupResponse(Integer id,
                            String name,
                            Set<GroupResponse> subgroups) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupResponse that = (GroupResponse) o;

        if (!Objects.equals(id, that.id)) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

}
