package com.tenco.bank.dto;

import com.tenco.bank.model.Board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class BoardDTO {
	private String title;
	private String content;
	private String author;
	
	
	public Board toBoard() {
		return Board.builder()
				.title(this.getTitle())
				.content(this.getContent())
				.author(this.getAuthor())
				.build();
	}
}
