package com.discovery.app.user.data;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.discovery.app.user.ui.model.AlbumResponseModel;

import feign.FeignException;
import feign.hystrix.FallbackFactory;

//@FeignClient(name = "album-ws" ,fallback=AlbumsFallback.class)
@FeignClient(name = "album-ws", fallbackFactory = AlbumsFallbackFactory.class)
public interface AlbumServiceClient {

	@GetMapping("/users/{id}/albums")
	public List<AlbumResponseModel> getAlbum(@PathVariable String id);

}

@Component
class AlbumsFallbackFactory implements FallbackFactory<AlbumServiceClient> {

	@Override
	public AlbumServiceClient create(Throwable cause) {
		return new AlbumServiceClientFallback(cause);
	}
}

class AlbumServiceClientFallback implements AlbumServiceClient {
	Logger logger = LoggerFactory.getLogger(AlbumServiceClientFallback.class);

	private final Throwable cause;

	AlbumServiceClientFallback(Throwable cause) {
		this.cause = cause;
	}

	@Override
	public List<AlbumResponseModel> getAlbum(String id) {

		if (cause instanceof FeignException && ((FeignException) cause).status() == 404) {
			logger.error("404 error can took place when getAlbum was called with userId:" + id + ", Error message: "
					+ cause.getLocalizedMessage());
		} else {
			logger.error("Othre error took place :" + cause.getLocalizedMessage());
		}
		return new ArrayList<>();
	}
}