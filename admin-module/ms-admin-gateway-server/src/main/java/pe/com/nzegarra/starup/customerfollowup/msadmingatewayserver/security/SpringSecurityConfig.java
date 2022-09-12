package pe.com.nzegarra.starup.customerfollowup.msadmingatewayserver.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
public class SpringSecurityConfig {

	@Autowired
	private JwtAuthenticationFilter authenticationFilter;
	
	@Bean
	public SecurityWebFilterChain configure(ServerHttpSecurity http) {
		return http.authorizeExchange()
				.pathMatchers("/api/security/oauth/**").permitAll()
				.pathMatchers(HttpMethod.GET, "/api/usuarios/usuarios/**").permitAll()
				.pathMatchers(HttpMethod.POST, "/api/usuarios/usuarios/**").hasAnyRole("ADMIN")
				.pathMatchers(HttpMethod.DELETE, "/api/usuarios/usuarios/**").hasAnyRole("ADMIN")
				.pathMatchers(HttpMethod.GET, "/api/usuarios/usuarios/{id}").hasAnyRole("ADMIN", "USER")
				.pathMatchers(HttpMethod.POST, "/api/treatment-command/v1/treatment-command").permitAll()
				.pathMatchers(HttpMethod.GET, "/api/product/**").hasAnyRole("ADMIN", "USER")
				.pathMatchers(HttpMethod.POST, "/api/product").hasAnyRole("ADMIN")
				.pathMatchers(HttpMethod.GET, "/api/customer").hasAnyRole("ADMIN", "USER")
				.pathMatchers(HttpMethod.POST, "/api/customer").hasAnyRole("ADMIN")
				.pathMatchers(HttpMethod.DELETE, "/api/customer").hasAnyRole("ADMIN")
				.pathMatchers("/api/treatment-query/**").hasAnyRole("ADMIN", "USER")
				.pathMatchers("/api/treatment-producer/**").hasAnyRole("ADMIN", "USER")
				.anyExchange().authenticated()
				.and().addFilterAt(authenticationFilter, SecurityWebFiltersOrder.AUTHENTICATION)
				.csrf().disable()
				.build();
	}
}
