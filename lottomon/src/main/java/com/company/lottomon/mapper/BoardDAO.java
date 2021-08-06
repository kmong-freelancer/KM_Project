package com.company.lottomon.mapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.company.lottomon.model.Board;

@Repository
public class BoardDAO {

	@Autowired 
	private SqlSessionTemplate sqlSession;

	/**
     * 게시물 개수 가져오기
     * @param board 게시물 Count
     * @return
     */
    public int selectListCount(Board board) {
    	return sqlSession.selectOne("board.selectListCount", board);
	}
	/**
     * 게시물 리스트 가져오기
     * @param board	추가 할 게시물 정보
     * @return
     */
    public List<Board> selectList(Board board) {
    	return sqlSession.selectList("board.selectList", board);
	}
	/**
     * 게시물 내용 가져오기
     * @param board	추가 할 게시물 정보
     * @return
     */
    public List<Board> selectPostBoard(Board board) {
    	return sqlSession.selectList("board.selectPostBoard", board);
	}
	/**
     * 게시물의 댓글 가져오기
     * @param board	추가 할 게시물 정보
     * @return
     */
    public List<Board> selectPostBoardDetail(Board board) {
    	return sqlSession.selectList("board.selectPostBoardDetail", board);
	}
	/**
     * 게시물 Insert
     * @param board Insert 할 게시물 정보
     * @return
     */
    public int insertBoardContent(Board board) {
    	return sqlSession.insert("board.insertBoardContent", board);
	}
    
}
