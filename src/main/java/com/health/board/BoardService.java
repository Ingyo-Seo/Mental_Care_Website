package com.health.board;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.health.DataNotFoundException;
import com.health.user.UserEntity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public List<BoardEntity> getList() {
        return this.boardRepository.findAll();
    }

    public BoardEntity getBoardEntity(Integer boardserial) {  
        Optional<BoardEntity> boardentity = this.boardRepository.findById(boardserial);
        if (boardentity.isPresent()) {
            return boardentity.get();
        } else {
            throw new DataNotFoundException("board not found");
        }
    }
    
    public Page<BoardEntity> getList(int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return this.boardRepository.findAll(pageable);
    }
    
    public void createBoard(String boardtitle, String boardcontent, String boardtype, UserEntity userEntity) {
    	BoardEntity boardentity = new BoardEntity();
    	boardentity.setBoardtitle(boardtitle);
    	boardentity.setBoardcontent(boardcontent);
    	boardentity.setBoarddate(LocalDateTime.now());
    	boardentity.setBoardtype(boardtype);
    	boardentity.setBoardauthor(userEntity);
        this.boardRepository.save(boardentity);
    }
}
