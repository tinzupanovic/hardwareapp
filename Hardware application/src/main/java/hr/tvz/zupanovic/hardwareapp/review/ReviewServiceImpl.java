package hr.tvz.zupanovic.hardwareapp.review;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final hr.tvz.zupanovic.hardwareapp.review.JpaReviewRepository JpaReviewRepository;

    public ReviewServiceImpl(JpaReviewRepository jpaReviewRepository) {
        JpaReviewRepository = jpaReviewRepository;
    }

    @Override
    public List<ReviewDTO> findAll() {
        return JpaReviewRepository.findAll().stream()
                .map(this::mapReviewToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReviewDTO> findByhardware(int id) {
        return JpaReviewRepository.findByHardwareId(id).stream()
                .map(this::mapReviewToDTO)
                .collect(Collectors.toList());
    }

    private ReviewDTO mapReviewToDTO(final Review review) {
        return new ReviewDTO(review.getHeadline(), review.getText(), review.getMark());
    }
}
