package hr.tvz.zupanovic.hardwareapp.hardware;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("hardware")
@CrossOrigin(origins = "http://localhost:4200")
public class HardwareController {

    private final HardwareService hardwareService;

    public HardwareController(HardwareService hardwareService) {
        this.hardwareService = hardwareService;
    }

    @GetMapping
    public List<HardwareDTO> getAllHardware() {
        return hardwareService.findAll();
    }

    @GetMapping("/{code}")
    public ResponseEntity<HardwareDTO> getHardwareByCode(@PathVariable final String code) {
        return hardwareService.findByCode(code)
                .map(ResponseEntity::ok)
                .orElseGet(
                        () -> ResponseEntity.notFound().build()
                );
    }

    @PostMapping
    @Secured("ROLE_ADMIN")
    public ResponseEntity<HardwareDTO> save(@Valid @RequestBody final HardwareCommand hardwareCommand) {
        return hardwareService.save(hardwareCommand)
                .map(
                    hardwareDTO -> ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body(hardwareDTO)
                )
                .orElseGet(
                    () -> ResponseEntity
                            .status(HttpStatus.CONFLICT)
                            .build()
                );

    }

    @PutMapping("/{code}")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<HardwareDTO> update(@PathVariable String code, @Valid @RequestBody final HardwareCommand updateHardwareCommand) {
        return hardwareService.update(code, updateHardwareCommand)
                .map(ResponseEntity::ok)
                .orElseGet(
                        () -> ResponseEntity.notFound().build()
                );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{code}")
    @Secured("ROLE_ADMIN")
    public void delete(@PathVariable String code) {
        hardwareService.deleteByCode(code);
    }
}
