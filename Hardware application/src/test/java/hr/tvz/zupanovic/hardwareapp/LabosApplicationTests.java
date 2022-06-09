package hr.tvz.zupanovic.hardwareapp;

import hr.tvz.zupanovic.hardwareapp.hardware.HardwareController;
import hr.tvz.zupanovic.hardwareapp.hardware.HardwareRepository;
import hr.tvz.zupanovic.hardwareapp.hardware.HardwareService;
import hr.tvz.zupanovic.hardwareapp.review.JpaReviewRepository;
import hr.tvz.zupanovic.hardwareapp.review.ReviewController;
import hr.tvz.zupanovic.hardwareapp.review.ReviewService;
import hr.tvz.zupanovic.hardwareapp.security.controller.AuthenticationController;
import hr.tvz.zupanovic.hardwareapp.security.service.AuthenticationService;
import hr.tvz.zupanovic.hardwareapp.security.service.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = LabosApplicationTests.class)
class LabosApplicationTests {

    /*@Autowired
    private HardwareController hardwareController;
    @Autowired
    private HardwareService hardwareService;
    @Autowired
    private HardwareRepository hardwareRepository;

    @Autowired
    private ReviewController reviewController;
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private JpaReviewRepository reviewRepository;


    @Autowired
    private AuthenticationController authenticationController;
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private JwtService jwtService;*/

    @Test
    void contextLoads() throws Exception {
        /*assertThat(hardwareController).isNotNull();
        assertThat(hardwareService).isNotNull();
        assertThat(hardwareRepository).isNotNull();
        assertThat(reviewController).isNotNull();
        assertThat(reviewService).isNotNull();
        assertThat(reviewRepository).isNotNull();
        assertThat(authenticationController).isNotNull();
        assertThat(authenticationService).isNotNull();
        assertThat(jwtService).isNotNull();*/
    }

}
