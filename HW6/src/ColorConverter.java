import java.awt.*;

public enum ColorConverter
{
    BLACK(Color.BLACK), 
    BLUE(Color.BLUE),
    RED(Color.RED), 
    YELLOW(Color.YELLOW), 
    GREEN(Color.GREEN),
    PINK(new Color(255,105,180));

    private Color color;

    ColorConverter (Color c) { color = c; }
    
    public static Color getColor(String colorString) 
    {
        for (ColorConverter option : ColorConverter.values())
        {
            if (option.toString().equalsIgnoreCase(colorString))
                return option.color;
        }
        return Color.BLACK;
    }
}
