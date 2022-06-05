package hr.tvz.zupanovic.hardwareapp.quartz;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchedulerConfig {
    @Bean
    public JobDetail labosJobDetail() {
        return
                JobBuilder.newJob(LabosJob.class).withIdentity("labosJob").storeDurably().build();
    }
    @Bean
    public Trigger labosJobTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(10).repeatForever();
        return TriggerBuilder.newTrigger().forJob(labosJobDetail())
                .withIdentity("labosTrigger").withSchedule(scheduleBuilder).build();
    }
}
