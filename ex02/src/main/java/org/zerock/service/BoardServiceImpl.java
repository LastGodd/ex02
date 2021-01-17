package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@RequiredArgsConstructor
@ToString
public class BoardServiceImpl implements BoardService {

	private final BoardMapper mapper;

	@Override
	public Long register(BoardVO board) {
		log.info("register...............");
		mapper.insertSelectKey(board);
		return board.getBno();
	}

	@Override
	public BoardVO get(Long bno) {
		log.info("get...............");
		return mapper.read(bno);
	}

	@Override
	public int modify(BoardVO board) {
		log.info("modify...............");
		return mapper.update(board);
	}

	@Override
	public int remove(Long bno) {
		log.info("remove...............");
		return mapper.delete(bno);
	}

	@Override
	public List<BoardVO> getList() {
		log.info("List...............");
		return mapper.getList();
	}
	
}
