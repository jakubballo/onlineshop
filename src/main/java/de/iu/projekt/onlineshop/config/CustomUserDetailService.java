package de.iu.projekt.onlineshop.config;

import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import de.iu.projekt.onlineshop.model.Nutzer;
import de.iu.projekt.onlineshop.repository.NutzerRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {
	
	private final NutzerRepository nutzerRepository;
	
	public CustomUserDetailService(NutzerRepository nutzerRepository) {
		this.nutzerRepository = nutzerRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Nutzer> nutzer = nutzerRepository.findByEmail(username);
		Nutzer gefundenerNutzer = nutzer.orElseThrow(() -> new UsernameNotFoundException("Benutzer nicht gefunden" + username));
		
		return User.builder()
				.username(gefundenerNutzer.getEmail())
				.password(gefundenerNutzer.getPasswort())
				.roles(gefundenerNutzer.getRolle().name())
				.build();	
	}
}
