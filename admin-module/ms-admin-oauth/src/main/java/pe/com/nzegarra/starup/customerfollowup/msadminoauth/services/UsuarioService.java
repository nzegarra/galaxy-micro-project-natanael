package pe.com.nzegarra.starup.customerfollowup.msadminoauth.services;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import pe.com.nzegarra.starup.customerfollowup.msadminoauth.clients.UsuarioFeignClient;
import pe.com.nzegarra.starup.customerfollowup.msadminoauth.model.Usuario;

@Service
public class UsuarioService implements UserDetailsService {

	private static final Logger log = org.slf4j.LoggerFactory.getLogger(UsuarioService.class);
//	@Autowired
//	private UsuarioFeignClient client;
	private RestTemplate restTemplate;
//	
	public UsuarioService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Usuario usuario = client.findByUsername(username);
//		RestTemplate restTemplate = new RestTemplate();
		Usuario usuario = restTemplate.getForObject("http://app-service-admin-gateway.galaxy-dev.svc.cluster.local:80/api/usuarios/usuarios/search/findByUsername?username="+username, Usuario.class);
		if(Objects.isNull(usuario)) {
			throw new UsernameNotFoundException("No existe el usuario: " + username);
		}
		List<GrantedAuthority> authorities = usuario.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getNombre()))
				.peek(authority -> log.info("Role : " + authority.getAuthority()))
				.collect(Collectors.toList());
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled().equalsIgnoreCase("1"), true, true, true, authorities);
	}
	

}
