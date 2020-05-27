package com.discovery.app.user.ui.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import feign.Response;
import feign.codec.ErrorDecoder;

@Component
public class FeignErrorDecoder implements ErrorDecoder {

	Environment env;

	@Autowired
	public FeignErrorDecoder(Environment env) {
		super();
		this.env = env;
	}

	@Override
	public Exception decode(String methodKey, Response response) {

		switch (response.status()) {
		case 400:
			break;
//return new BadRequestException();
		case 404: {
			if (methodKey.contains("getAlbum")) {
				return new ResponseStatusException(HttpStatus.valueOf(response.status()),
						env.getProperty("albums.exception.album-not-found"));
			}
			break;
		}
		default:
			return new Exception();

		}
		return null;
	}

}
