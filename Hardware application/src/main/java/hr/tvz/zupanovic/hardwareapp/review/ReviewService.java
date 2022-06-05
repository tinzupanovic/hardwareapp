package hr.tvz.zupanovic.hardwareapp.review;

import java.util.List;

public interface ReviewService {
    List<ReviewDTO> findAll();

    List<ReviewDTO> findByhardware(int id);
}
