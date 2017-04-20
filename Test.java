import java.util.*;
import com.educode.runtime.*;

public class Test extends com.educode.runtime.ScriptBase
{
public void main()
{
System.out.println(testNum());
System.out.println(testIf());
System.out.println(testLoop());
System.out.println(testAssign());
bla();
return;
}
public Float testAssign()
{
Float a;
Float b;
Float c;
Float d = 10.000000F;
if(d == 10.000000F)
{
a = b = c = d;
}
else
{
a = 15.000000F;
}

return a;
}
public Float testNum()
{
Float testNum = 5.000000F;
return testNum;
}
public boolean testIf()
{
if(true == true)
{
return true;
}
else
{
return false;
}

}
public Float testLoop()
{
Float a = 5.000000F;
Float b = 0.000000F;
while (a > 0.000000F)
{
b = (b + 1.000000F);
a = (a - 1.000000F);
}

return b;
}
public void bla()
{
Float a = 1.000000F;
Float b = 2.000000F;
Float result = add(10.000000F, 10.000000F);
if(result == 20.000000F)
{
System.out.println("Math checks out");
}
else
{
System.out.println("Math does not check out");
}

boolean foo = true;
boolean bar = false;
boolean andRes = foo && bar;
if(andRes == false)
{
System.out.println("And seems to work");
}
else
{
System.out.println("And not working as intended");
}

Float increment = 0.000000F;
while (increment < 100.000000F)
{
System.out.println("Repeating..");
increment = (increment + 1.000000F);
}

return;
}
public Float add(Float a,Float b)
{
return (a + b);
}
}