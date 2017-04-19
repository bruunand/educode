import java.util.*;
import com.educode.runtime.*;

public class Test extends com.educode.runtime.ScriptBase
{
public void main()
{
ExtendedCollection<Float> rangeTest = range(5.000000F, 10.000000F);
rangeTest.addItem(500.000000F);
for (Float c : rangeTest)
{
System.out.println(("val:" + c));
}

Float x = robot.getOwner().getCoordinates().getX();
String s = "test";
s = s.toString().toString().toString().toString().toString().toString();
if("test".equals(s))
{
System.out.println("it works");
}

robot.say(("out " + random(1.000000F, 20.000000F)));
Float num = 0.000000F;
Float test;;
num = test = 2.000000F;
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
}