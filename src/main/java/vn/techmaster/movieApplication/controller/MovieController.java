package vn.techmaster.movieApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import vn.techmaster.movieApplication.entity.Movie;
import vn.techmaster.movieApplication.service.MovieService;

@Controller
public class MovieController {
    @Autowired
    private MovieService movieService;

    // Trang chủ
    @GetMapping("/")
    public String getHome(Model model) {
        model.addAttribute("hotMovies", movieService.findHotMovies());
        model.addAttribute("phimChieuRapMovies", movieService.findPhimChieuRapMovies());
        model.addAttribute("phimLeMovies", movieService.findPhimLeMovies());
        model.addAttribute("phimBoMovies", movieService.findPhimBoMovies());
        return "web/index";
    }

    // Danh sách phim chiếu rạp
    @GetMapping("/phim-chieu-rap")
    public String getPhimChieuRap(Model model) {
        model.addAttribute("phimChieuRapMovies", movieService.findPhimChieuRapMovies());
        return "web/phim-chieu-rap";
    }

    // Danh sách phim lẻ
    @GetMapping("/phim-le")
    public String getPhimLe(Model model) {
        model.addAttribute("phimLeMovies", movieService.findPhimLeMovies());
        return "web/phim-le";
    }

    // Danh sách phim bộ
    @GetMapping("/phim-bo")
    public String getPhimBo(Model model) {
        model.addAttribute("phimBoMovies", movieService.findPhimBoMovies());
        return "web/phim-bo";
    }

    // Chi tiết phim
    @GetMapping("/phim/{id}/{slug}")
    public String getChiTietPhim(@PathVariable Integer id, @PathVariable String slug, Model model) {
        Movie movie = movieService.findMovieById(id);
        model.addAttribute("movie", movie);
        model.addAttribute("hotMovies", movieService.findHotMovies());
        return "web/chi-tiet-phim";
    }
}
