package Logic;

public interface IGameLogicLevel {
	
	public boolean update(char direction);
	public boolean heroCanMoveTo(int x, int y);
}
