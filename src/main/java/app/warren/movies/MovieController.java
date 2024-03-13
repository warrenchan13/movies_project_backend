package app.warren.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController // used to create RESTful web services using Spring MVC.
//@RequestMapping("/api/movies")
public class MovieController {
    @Autowired // it allows Spring to automatically wire the required beans (dependencies) into your classes, eliminating the need for manual configuration.
    private MovieService movieService;
    @GetMapping("/api/movies")
    public ResponseEntity<List<Movie>> getMovies() {
        return new ResponseEntity<List<Movie>>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/api/movie/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId) {
        return new ResponseEntity<Optional<Movie>>(movieService.getSingleMovie(imdbId), HttpStatus.OK);
    }

}
