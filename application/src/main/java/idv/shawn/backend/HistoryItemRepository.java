package idv.shawn.backend;

import org.springframework.data.jpa.repository.JpaRepository;

import idv.shawn.backend.data.entity.HistoryItem;

public interface HistoryItemRepository extends JpaRepository<HistoryItem, Long> {
}
