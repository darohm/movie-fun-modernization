package org.superbiz.moviefun.movies;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/movies")
public class MoviesController {

    private MoviesRepository moviesRepository;

    public MoviesController(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    @PostMapping
    public void addMovie(@RequestBody Movie movie){
        moviesRepository.addMovie(movie);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable long id){
        moviesRepository.deleteMovieId(id);
    }

    @GetMapping
    public List<Movie> find(
            @RequestParam(name = "field", required = false) String field,
            @RequestParam(name = "key", required = false) String key,
            @RequestParam(name = "start", required = false) Integer start,
            @RequestParam(name = "pageSize", required = false) Integer pageSize
    ){
        if (field != null && key != null) {
            return moviesRepository.findRange(field, key, start, pageSize);
        } else if (start != null && pageSize != null) {
            return moviesRepository.findAll(start, pageSize);
        } else {
            return moviesRepository.getMovies();
        }
    }

    @GetMapping("/count")
    public int count(
            @RequestParam(name = "field", required = false) String field,
            @RequestParam(name = "key", required = false) String key
    ){
        if(field != null && key != null){
            return moviesRepository.count(field, key);
        }else {
            return moviesRepository.countAll();
        }
    }

}
