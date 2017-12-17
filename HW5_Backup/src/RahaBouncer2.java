import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author David Mawazo
 *
 * Andrew ID: dmawazo
 *
 * On my honor, as a Carnegie-Mellon Africa student, 
 * I have neither given nor received unauthorized assistance on this work.
 */


public class RahaBouncer2 extends IceCreamConePG implements Bouncer
{

	
	public void move()
	{
		setMyLocation(getStartX() +35, getStartY() + 30);
	}
	
	@Override
	public void setX(int x)
	{
		setStartX(x);
	}

	
	@Override
	public void setY(int y)
	{
		setStartY(y);
	}

	
	@Override
	public void setXAndY(int x, int y)
	{
		setStartXStartY(x, y);
	}

	
	@Override
	public void setColor(Color c)
	{
		setConeColor(c);

	}


	@Override
	public void setColor(String c)
	{
		setConeColor(c);

	}

	

}
