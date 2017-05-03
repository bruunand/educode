import java.util.*;
import com.educode.runtime.*;
import com.educode.runtime.types.*;
import com.educode.helper.*;

public class Test extends ScriptBase
{
public void main() throws InterruptedException
{
Boolean a = true;
Boolean b = false;
Boolean c;
c = true;
if(c)
{
System.out.println("Should happen");
}
else
{
System.out.println("else");
}

while (a)
{
a = false;
System.out.println("Loop");
}

}
}