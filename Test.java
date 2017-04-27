import java.util.*;
import com.educode.runtime.*;
import com.educode.runtime.types.*;

public class Test extends ScriptBase
{
Float b;
Float a = 5.000000F;
Float c = 10.000000F;
public void main()
{
setter();
System.out.println(("a:" + a));
return;
}
public void setter()
{
a = 10.000000F;
}
public void onMessageReceived(MinecraftEntity sender,Float message)
{
}
}