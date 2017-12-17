import java.awt.*;

public interface Bouncer
{
    void move();
    void paint(Graphics g);
    void setX(int x);
    void setY(int y);
    void setXAndY(int x, int y);
    void setColor(Color c);
    void setColor(String c);
    Point getBottomRightPoint();
}
