package com.gmail.christopher.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gmail.christopher.backend.data.entity.HistoryItem;

public interface HistoryItemRepository extends JpaRepository<HistoryItem, Long> {
}
