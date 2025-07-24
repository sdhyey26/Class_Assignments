
public class PlayerManager {
	private String currentPlayer;

    public PlayerManager() {
        currentPlayer = "X";
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayer() {
        currentPlayer = currentPlayer.equals("X") ? "O" : "X";
    }

    public void reset() {
        currentPlayer = "X";
}
