package com.techm.transport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.transport.entity.BoardingPoint;
import com.techm.transport.repository.BoardingPointRepository;

@Service
public class BoardingPointService{	

	@Autowired
	BoardingPointRepository boardingPointRepository;

	public BoardingPoint getBoardingPointById(Integer id) {
		BoardingPoint boardingPoint = boardingPointRepository.findById(id);
		return boardingPoint;
	}
	
	public BoardingPoint getBoardingPointByName(String boardPointName) {
		BoardingPoint boardingPoint = boardingPointRepository.findByName(boardPointName);
		return boardingPoint;
	}

}
