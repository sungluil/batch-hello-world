package io.spring.batch.batch;

import io.spring.batch.model.UserBatch;
import io.spring.batch.repository.UserBatchRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<UserBatch> {

    private final UserBatchRepository userBatchRepository;

    public DBWriter(UserBatchRepository userBatchRepository) {
        this.userBatchRepository = userBatchRepository;
    }


    @Override
    public void write(List<? extends UserBatch> users) throws Exception {

        System.out.println("Data Saved for Users : "+users);
        userBatchRepository.saveAll(users);
    }
}
