import java.util.*;
import com.educode.runtime.*;

public class c extends ScriptBase
{
public void main()
{
robot.say(("out " + random(1.000000F, 20.000000F)));
Float num = 0.000000F;
while (num < 50.000000F)
{
Coordinates coords = robot.getCoordinates();
robot.setWorldTime(1200.000000F);
coords.setX((coords.getX() + random(-2.000000F, 15.000000F)));
robot.walkTo(coords);
robot.wait(5000.000000F);
num = (num + 1.000000F);
}

}