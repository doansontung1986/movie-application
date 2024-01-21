package vn.techmaster.movieApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.techmaster.movieApplication.entity.Movie;
import vn.techmaster.movieApplication.model.enums.MovieType;
import vn.techmaster.movieApplication.repository.MovieRepository;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> findHotMovies() {
        return movieRepository.findByRatingBetween(6.0, 10.0);
    }

    public List<Movie> findPhimLeMovies() {
        Pageable pageable = PageRequest.of(0, 6, Sort.by("publishedAt").descending());
        Page<Movie> pageData = movieRepository.findByTypeAndStatus(MovieType.PHIM_LE, true, pageable);
        return pageData.getContent();
    }

    public List<Movie> findPhimBoMovies() {
        Pageable pageable = PageRequest.of(0, 6, Sort.by("publishedAt").descending());
        Page<Movie> pageData = movieRepository.findByTypeAndStatus(MovieType.PHIM_BO, true, pageable);
        return pageData.getContent();
    }

    public List<Movie> findPhimChieuRapMovies() {
        Pageable pageable = PageRequest.of(0, 6, Sort.by("publishedAt").descending());
        Page<Movie> pageData = movieRepository.findByTypeAndStatus(MovieType.PHIM_CHIEU_RAP, true, pageable);
        return pageData.getContent();
    }

    public Movie findMovieById(int id) {
        return movieRepository.findAll().stream().filter(movie -> movie.getId() == id && movie.getStatus()).findFirst().orElse(null);
    }
}
