package org.superbiz.moviefun.moviesapi;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestOperations;

import java.util.List;

public class AlbumsClient {
    private String albumsUrl;
    private RestOperations restOperations;

    public AlbumsClient(String albumsUrl, RestOperations restOperations) {
        this.albumsUrl = albumsUrl;
        this.restOperations = restOperations;
    }

    private static ParameterizedTypeReference<List<AlbumInfo>> albumListType = new ParameterizedTypeReference<List<AlbumInfo>>() {
    };

    public void addAlbumInfo(AlbumInfo albumInfo){
        restOperations.postForEntity(albumsUrl + "/addAlbum", albumInfo, AlbumInfo.class);
    }

    public List<AlbumInfo> getAlbumInfos(){
        return restOperations.exchange(albumsUrl + "/getAlbums", HttpMethod.GET, null, albumListType).getBody();
    }

    public AlbumInfo findInfo(long albumId){
        return restOperations.getForObject(albumsUrl + "/find/" + albumId, AlbumInfo.class);
    }
}
