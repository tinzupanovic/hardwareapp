package hr.tvz.zupanovic.hardwareapp.quartz;

import hr.tvz.zupanovic.hardwareapp.hardware.Hardware;
import hr.tvz.zupanovic.hardwareapp.hardware.HardwareRepository;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

public class LabosJob extends QuartzJobBean {

    @Autowired
    private HardwareRepository hardwareRepository;

    private static final Logger log = LoggerFactory.getLogger(LabosJob.class);

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        List<Hardware> hardwares = hardwareRepository.findAll();
        log.info("Ovo su trenutno dostupni hardveri");
        log.info("---------------------------------");
        hardwares.stream()
                .filter(hardware -> hardware.getStock() != 0)
                .forEach(hardware -> log.info(hardware.getName() + " - " + hardware.getStock()));
        log.info("---------------------------------");
    }
}
