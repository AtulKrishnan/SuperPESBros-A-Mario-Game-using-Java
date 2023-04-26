package PESMario;

public class ObstacleFactory {
	public Obstacle getObstacle(String obstacle, int x, int y, int width, int height)
	{
		if(obstacle.equals(null))
			return null;
		if(obstacle.equalsIgnoreCase("Bouncer"))
		{
			return new Bouncer(x, y, width, height);
		}
		else if(obstacle.equalsIgnoreCase("Wall"))
		{
			return new Wall(x, y, width, height);
		}
		return null;
	}
}
