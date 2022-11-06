package org.ms.authentificationservice.repositories;

import org.ms.authentificationservice.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    @RestResource(path="/byRoleName")
    AppRole findByRoleName(@Param("mc") String roleName);
}
