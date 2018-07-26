package com.capgemini.springTask1.houres;

public class HouresDTO {

	private int playerId;
	private String day;
	private int start;
	private int end;

	public HouresDTO(int playerId, String day, int start, int end) {
		super();
		this.playerId = playerId;
		this.day = day;
		this.start = start;
		this.end = end;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

}
