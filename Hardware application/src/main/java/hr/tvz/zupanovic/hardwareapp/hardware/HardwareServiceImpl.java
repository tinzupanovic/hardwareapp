package hr.tvz.zupanovic.hardwareapp.hardware;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HardwareServiceImpl implements HardwareService {

    private final HardwareRepository hardwareRepository;

    public HardwareServiceImpl(HardwareRepository hardwareRepository) {
        this.hardwareRepository = hardwareRepository;
    }

    @Override
    public List<HardwareDTO> findAll() {
        return hardwareRepository.findAll().stream()
                .map(this::mapHardwareToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<HardwareDTO> findByCode(final String code) {
        return hardwareRepository.findByCode(code).map(this::mapHardwareToDTO);
    }

    @Override
    public Optional<HardwareDTO> save(HardwareCommand hardwareCommand) {
        return hardwareRepository.save(mapCommandToHardware(hardwareCommand)).map(this::mapHardwareToDTO);
    }

    @Override
    public Optional<HardwareDTO> update(String code, HardwareCommand updateHardwareCommand) {
        return hardwareRepository.update(code, mapCommandToHardware(updateHardwareCommand)).map(this::mapHardwareToDTO);
    }

    @Override
    public void deleteByCode(String code) {
        hardwareRepository.deleteByCode(code);
    }

    private HardwareDTO mapHardwareToDTO(final Hardware hardware) {
        return new HardwareDTO(hardware.getName(), hardware.getCode(), hardware.getPrice());
    }

    private Hardware mapCommandToHardware(final HardwareCommand hardwareCommand) {
        return new Hardware(hardwareCommand.getId(), hardwareCommand.getName(), hardwareCommand.getCode(), hardwareCommand.getPrice(), hardwareCommand.getType(), hardwareCommand.getStock());
    }
}
