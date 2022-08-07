package com.fluytcloud.jpa;

import io.quarkus.hibernate.orm.PersistenceUnitExtension;
import io.quarkus.hibernate.orm.runtime.tenant.TenantResolver;
import io.vertx.ext.web.RoutingContext;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@PersistenceUnitExtension
@RequestScoped
public class CustomTenantResolver implements TenantResolver {

    @Inject
    RoutingContext context;

    @Override
    public String resolveTenantId() {
        // OIDC TenantResolver has already calculated the tenant id and saved it as a RoutingContext `tenantId` attribute:
        //return context.get("tenantId");
        return "pato";
    }

    @Override
    public String getDefaultTenantId() {
        return "grimpa";
    }

}