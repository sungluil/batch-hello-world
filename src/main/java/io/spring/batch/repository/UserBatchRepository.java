package io.spring.batch.repository;

import io.spring.batch.model.UserBatch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserBatchRepository extends JpaRepository<UserBatch, Long> {

    List<UserBatch> findAll();
}
