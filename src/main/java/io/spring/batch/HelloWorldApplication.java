package io.spring.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableBatchProcessing
public class HelloWorldApplication {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    public HelloWorldApplication(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean
    public Job job() {
        System.out.println("job 실행됨");
        return this.jobBuilderFactory.get("job")
                .start(step1())
                .build();
    }

    @Bean
    public Step step1() {
        System.out.println("step1 실행됨");
        return this.stepBuilderFactory.get("step1")

                .tasklet((stepContribution, chunkContext) -> {
                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                    System.out.println("Hello world");
                    return RepeatStatus.FINISHED;

                }).build();
    }


    public static void main(String[] args) {
        System.setProperty("spring.profiles.default", "local");
        SpringApplication.run(HelloWorldApplication.class, args);
    }

}
