package GamesHistory;

public class GameDTO {

	int playerId;
	int opponentId;
	int pointsGot;
	int gameNumber;
	
	public GameDTO(int playerId, int opponentId, int pointsGot, int gameNumber) {
		super();
		this.playerId = playerId;
		this.opponentId = opponentId;
		this.pointsGot = pointsGot;
		this.gameNumber = gameNumber;
	}
	
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public int getOpponentId() {
		return opponentId;
	}
	public void setOpponentId(int opponentId) {
		this.opponentId = opponentId;
	}
	public int getPointsGot() {
		return pointsGot;
	}
	public void setPointsGot(int pointsGot) {
		this.pointsGot = pointsGot;
	}
	public int getGameNumber() {
		return gameNumber;
	}
	public void setGameNumber(int gameNumber) {
		this.gameNumber = gameNumber;
	}
}
