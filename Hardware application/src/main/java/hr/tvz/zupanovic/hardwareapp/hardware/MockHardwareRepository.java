package hr.tvz.zupanovic.hardwareapp.hardware;

import hr.tvz.zupanovic.hardwareapp.hardware.Hardware;
import hr.tvz.zupanovic.hardwareapp.hardware.HardwareRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MockHardwareRepository implements HardwareRepository {

    private final List<Hardware> MOCKED_HARDWARE = new ArrayList<>() {
        {
            add(new Hardware(1, "Asus TUF RTX 3080", "1", 1599.0, "GPU", 2));
            add(new Hardware(2, "EVGA XC3 RTX 3070 Ti", "2", 1299.0, "GPU", 3));
            add(new Hardware(3, "AMD Ryzen 5950X", "3", 899.0, "CPU", 2));
            add(new Hardware(4, "Samsung 980 PRO SSD 1TB", "4", 299.0, "STORAGE", 10));
            add(new Hardware(5, "Kingston FURY Beast DDR5 32GB", "5", 699.0, "RAM", 7));
        }
    };


    @Override
    public List<Hardware> findAll() {
        return MOCKED_HARDWARE;
    }

    @Override
    public Optional<Hardware> findByCode(final String code) {
        return MOCKED_HARDWARE.stream()
                .filter(o -> Objects.equals(o.getCode(), code))
                .findAny();
    }

    @Override
    public Optional<Hardware> save(final Hardware hardware) {
        boolean exists = false;
        for (Hardware checkingHardware : MOCKED_HARDWARE) {
            if (checkingHardware.getCode().equals(hardware.getCode())) {
                exists = true;
                break;
            }
        }
        if(!exists) {
            MOCKED_HARDWARE.add(hardware);
            return Optional.of(hardware);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Hardware> update(final String code, final Hardware updateHardware) {
        boolean exists = MOCKED_HARDWARE.removeIf(
                o -> Objects.equals(o.getCode(), code) && Objects.equals(o.getCode(), updateHardware.getCode())
        );
        if(exists) {
            MOCKED_HARDWARE.add(updateHardware);
            return Optional.of(updateHardware);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void deleteByCode(final String code) {
        MOCKED_HARDWARE.removeIf(o -> Objects.equals(o.getCode(), code));
    }
}
/*
    private List<Hardware> MOCKED_HARDWARE = Arrays.asList(
            new Hardware("Asus TUF RTX 3080", "1", 1599.0, "GPU", 2),
            new Hardware("EVGA XC3 RTX 3070 Ti", "2", 1299.0, "GPU", 3),
            new Hardware("AMD Ryzen 5950X", "3", 899.0, "CPU", 2),
            new Hardware("Samsung 980 PRO SSD 1TB", "4", 299.0, "STORAGE", 10),
            new Hardware("Kingston FURY Beast DDR5 32GB", "5", 699.0, "RAM", 7)
    );*/
