package hr.tvz.zupanovic.hardwareapp.hardware;

import hr.tvz.zupanovic.hardwareapp.hardware.Hardware;

import java.util.List;
import java.util.Optional;

public interface HardwareRepository {

    List<Hardware> findAll();

    Optional<Hardware> findByCode(String code);

    Optional<Hardware> save(Hardware hardware);

    Optional<Hardware> update(String code, Hardware updateHardware);

    void deleteByCode(String code);
}
