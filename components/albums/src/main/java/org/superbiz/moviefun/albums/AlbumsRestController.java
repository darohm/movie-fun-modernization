package org.superbiz.moviefun.albums;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumsRestController {
    private AlbumsRepository albumsRepository;

    public AlbumsRestController(AlbumsRepository albumsRepository) {
        this.albumsRepository = albumsRepository;
    }

    @PostMapping("/addAlbum")
    public void addAlbum(@RequestBody Album album){
        albumsRepository.addAlbum(album);
    }

    @GetMapping("/getAlbums")
    public List<Album> getAlbums(){
        return albumsRepository.getAlbums();
    }

    @GetMapping("/find/{albumId}")
    public Album find(@PathVariable long albumId){
        System.out.println("WE ARE CALLING OUR RESTCONTROLER FIND");
        return albumsRepository.find(albumId);
    }
}
