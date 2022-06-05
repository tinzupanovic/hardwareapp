package hr.tvz.zupanovic.hardwareapp.review;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("review")
@CrossOrigin(origins = "http://localhost:4200")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<ReviewDTO> getAllReviews() {
        return reviewService.findAll();
    }

    @GetMapping("/{id}")
    public List<ReviewDTO> getReviewsByHardwareId(@PathVariable final int id) {
        return reviewService.findByhardware(id);
    }
}
