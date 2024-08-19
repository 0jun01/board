package com.tenco.bank.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Data
public class Board {
	private int id;
	private String title;
	private String content;
	private String author;
	
	
}
