package hr.tvz.zupanovic.hardwareapp.review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findAll();

    @Query("from Review r where r.hardware.id = :id")
    List<Review> findByHardwareId(@Param("id") int id);
}
