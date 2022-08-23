package com.fluytcloud.auth.repositories;

public interface GroupRepository {

    boolean create(String group, String... subGroups);

}
