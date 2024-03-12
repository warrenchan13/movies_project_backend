package app.warren.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired // it allows Spring to automatically wire the required beans (dependencies) into your classes, eliminating the need for manual configuration.
    private MovieRepository movieRepository;
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
    public Optional<Movie> getSingleMovie(ObjectId id) {
        return movieRepository.findById(id);

    }
}
