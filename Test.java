import java.util.*;
import com.educode.runtime.*;

public class Test extends ScriptBase
{
public void main()
{
Coordinates c = new Coordinates(5.000000F, 10.000000F, 5.000000F);
c.x = (x + 1.000000F);
Float a = 5.000000F;
a = 123.000000F;
System.out.println(("T:" + a));
List<Float> test = Arrays.asList(a, 5.000000F, 10.000000F);
for (Float c : test)
{
System.out.println(("T:" + c));
robot.say(("Value:" + c));
}

robot.wait(500.000000F);
robot.say("hej");
}
}