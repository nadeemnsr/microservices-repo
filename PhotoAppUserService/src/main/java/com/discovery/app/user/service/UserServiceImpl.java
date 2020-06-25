package com.discovery.app.user.service;

import java.util.ArrayList;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.discovery.app.user.data.entity.UserEntity;
import com.discovery.app.user.repository.UsersRepositoty;
import com.discovery.app.user.ui.model.UserDto;

@Service
public class UserServiceImpl implements UserService {

	UsersRepositoty usersRepositoty;
	BCryptPasswordEncoder bCryptPasswordEncoder;
	RestTemplate restTemplate;
	Environment environment;
	// AlbumServiceClient albumServiceClient;

	org.slf4j.Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	public UserServiceImpl(UsersRepositoty usersRepositoty, BCryptPasswordEncoder bCryptPasswordEncoder,
			RestTemplate restTemplate, Environment environment/* , AlbumServiceClient albumServiceClient */) {
		this.usersRepositoty = usersRepositoty;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.restTemplate = restTemplate;
		this.environment = environment;
		/* this.albumServiceClient = albumServiceClient; */ }

	@Override
	public UserDto createUser(UserDto userDetails) {

		userDetails.setUserId(UUID.randomUUID().toString());
		userDetails.setEncryptedPass(bCryptPasswordEncoder.encode(userDetails.getPassword()));
		ModelMapper model = new ModelMapper();
		model.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userEntity = model.map(userDetails, UserEntity.class);
		usersRepositoty.save(userEntity);

		UserDto dto = model.map(userEntity, UserDto.class);
		return dto;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity entity = usersRepositoty.findByEmail(username);

		if (entity == null)
			throw new UsernameNotFoundException(username);

		return new User(entity.getEmail(), entity.getEncryptedPass(), true, true, true, true, new ArrayList<>());
	}

	@Override
	public UserDto getUserDetailByEmail(String username) {
		UserEntity entity = usersRepositoty.findByEmail(username);

		if (entity == null)
			throw new UsernameNotFoundException(username);

		return new ModelMapper().map(entity, UserDto.class);
	}

	/*
	 * * @Override public UserDto getUserByUserId(String userId) {
	 * 
	 * UserEntity userEntity = usersRepositoty.findByUserId(userId); if (userEntity
	 * == null) throw new UsernameNotFoundException("User not found"); UserDto dto =
	 * new ModelMapper().map(userEntity, UserDto.class);
	 * 
	 * String albumUrl = String.format(environment.getProperty("album.url"),
	 * userId);
	 * 
	 * ResponseEntity<List<AlbumResponseModel>> albumListResponse =
	 * albumServiceClient.exchange(albumUrl, HttpMethod.GET, null, new
	 * ParameterizedTypeReference<List<AlbumResponseModel>>() { });
	 * List<AlbumResponseModel> albumList = albumListResponse.getBody();
	 * 
	 * logger.info("Before calling albums Microservices"); List<AlbumResponseModel>
	 * albumList = null; try { albumList = albumServiceClient.getAlbum(userId); }
	 * catch (FeignException e) { logger.error(e.getLocalizedMessage()); }
	 * logger.info("After calling albums Microservices"); dto.setModel(albumList);
	 * return dto; }
	 */
}
