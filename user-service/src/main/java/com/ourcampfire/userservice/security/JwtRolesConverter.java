package com.ourcampfire.userservice.security;

import org.jspecify.annotations.NonNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Jwt roles convertor for Keycloak
 */
public class JwtRolesConverter implements Converter<Jwt, Collection<GrantedAuthority>> {
    private static final String REALM_ACCESS = "realm_access";
    private static final String ROLES = "roles";
    private static final String ROLE_PREFIX= "ROLE_";

    @Override
    @SuppressWarnings("unchecked")
    public Collection<GrantedAuthority> convert(@NonNull final Jwt source) {
        Collection<String> keycloakRoles = new ArrayList<>();

        if (source.hasClaim(REALM_ACCESS)) {
            Map<String, Object> realmAccess = source.getClaimAsMap(REALM_ACCESS);
            assert realmAccess != null;
            if (realmAccess.containsKey(ROLES)) {
                keycloakRoles.addAll((Collection<String>) realmAccess.get(ROLES));
            }
        }

        return keycloakRoles.stream()
                .map(role -> ROLE_PREFIX + role.toUpperCase())
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
    }
}
