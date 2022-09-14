package com.health.board;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
	BoardEntity findByBoardtitle(String boardtitle);
	BoardEntity findByBoardtitleAndBoardcontent(String boardtitle, String boardcontent);
    List<BoardEntity> findByBoardtitleLike(String boardtitle);
    Page<BoardEntity> findAll(Pageable pageable);
}
