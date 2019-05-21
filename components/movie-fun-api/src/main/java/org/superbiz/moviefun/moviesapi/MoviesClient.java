package org.superbiz.moviefun.moviesapi;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestOperations;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

public class MoviesClient {
    private String moviesUrl;
    private RestOperations restOperations;

    public MoviesClient(String moviesUrl, RestOperations restOperations){
        this.moviesUrl = moviesUrl;
        this.restOperations = restOperations;
    }

    private static ParameterizedTypeReference<List<MovieInfo>> movieListType = new ParameterizedTypeReference<List<MovieInfo>>() {
    };
    //
    public void addMovieInfo(MovieInfo movieInfo) {
        restOperations.postForEntity(moviesUrl, movieInfo, MovieInfo.class);
    }
    //
    public void deleteMovieInfo(Long movieId) {
        restOperations.delete(moviesUrl + "/" + movieId);
    }
    //
    public List<MovieInfo> getMovieInfos() {
        return restOperations.exchange(moviesUrl, HttpMethod.GET, null, movieListType).getBody();
    }

    public List<MovieInfo> findAll(int start, int pageSize) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(moviesUrl)
                .queryParam("start", start)
                .queryParam("pageSize", pageSize);
        return restOperations.exchange(builder.toUriString(), HttpMethod.GET, null, movieListType).getBody();
    }

    public int countAll() {
        return restOperations.getForObject(moviesUrl + "/count", Integer.class);
    }

    public int count(String field, String key) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(moviesUrl + "/count")
                .queryParam("field", field)
                .queryParam("key", key);

        return restOperations.getForObject(builder.toUriString(), Integer.class);
    }

    public List<MovieInfo> findRange(String field, String key, int start, int pageSize) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(moviesUrl)
                .queryParam("field", field)
                .queryParam("key", key)
                .queryParam("start", start)
                .queryParam("pageSize", pageSize);

        return restOperations.exchange(builder.toUriString(), HttpMethod.GET, null, movieListType).getBody();
    }
}
