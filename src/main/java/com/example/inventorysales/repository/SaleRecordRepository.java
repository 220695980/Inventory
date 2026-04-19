package com.example.inventorysales.repository;

import com.example.inventorysales.model.SaleRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRecordRepository extends JpaRepository<SaleRecord, Long> {
}
