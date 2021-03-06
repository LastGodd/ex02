package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void testGetList() {
		log.info("-------------------");
		boardMapper.getList();
	}
	
	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("テスト題名");
		board.setContent("テストコンテンツ");
		board.setWriter("八神");
		
		boardMapper.insert(board);
		log.info("--------------------------------");
		log.info("after insert " + board.getBno());
	}
	
	@Test
	public void testInsertSelectKey() {
		BoardVO board = new BoardVO();
		board.setTitle("AAAテスト題名");
		board.setContent("AAAテストコンテンツ");
		board.setWriter("AAA八神");
		
		boardMapper.insertSelectKey(board);
		log.info("--------------------------------");
		log.info("after insert selectKey " + board.getBno());
	}
	
	@Test
	public void testRead() {
		BoardVO board = boardMapper.read(7L);
		log.info("--------------------------------");
		log.info(board);
	}
	
	@Test
	public void testDelete() {
		int count = boardMapper.delete(1L);
		log.info("--------------------------------");
		log.info("count : " + count);
	}
	
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		board.setBno(2L);
		board.setTitle("Update Title");
		board.setContent("Update Content");
		board.setWriter("神谷");
		
		log.info("--------------------------------");
		log.info("count : " + boardMapper.update(board));
		
	}
}
