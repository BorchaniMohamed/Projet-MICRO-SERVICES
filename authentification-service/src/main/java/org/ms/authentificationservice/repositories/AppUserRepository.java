package org.ms.authentificationservice.repositories;

import org.ms.authentificationservice.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    @RestResource(path="/byUsername")
    AppUser findByUsername(@Param("mc") String name);
}
