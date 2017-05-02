import java.util.*;
import com.educode.runtime.*;
import com.educode.runtime.types.*;
import com.educode.helper.*;

public class Test extends ScriptBase
{
Float b;
Float a = 5.000000F;
Float c = 10.000000F;
public void main() throws InterruptedException
{
ExtendedCollection<Float> test = new ExtendedCollection<Float>(1.000000F, 2.000000F, 3.000000F);
ExtendedCollection<Float> test2 = new ExtendedCollection<Float>(1.000000F, 2.000000F, 3.000000F, 4.000000F);
Boolean res = test.equals(test2);
String str = "hej jeg hedder anders, hej hvad hedder du";
ExtendedCollection<String> tet = StringHelper.splitString(str, " ");
ExtendedCollection<ExtendedCollection<String>> doubly = new ExtendedCollection<ExtendedCollection<String>>();
for (String theis : tet)
{
doubly.addItem(new ExtendedCollection<String>(random(-5.000000F, 5.000000F).toString()));
doubly.addItem(StringHelper.splitString(theis.toUpperCase(), "E"));
}

System.out.println(("doubly:" + doubly));
tet.setItemAt(0.000000F, tet.getItemAt(0.000000F).toUpperCase());
System.out.println(("res:" + tet.getItemAt(0.000000F)));
System.out.println(("res:" + tet));
System.out.println(("res:" + test.equals(test2)));
System.out.println(("res:" + test2.equals(test2)));
System.out.println(("res:" + test.equals(test)));
setter();
System.out.println(("rand:" + random(-5.000000F, 5.000000F)));
System.out.println(("a:" + a));
return;
}
public void setter() throws InterruptedException
{
a = 10.000000F;
}
public void onMessageReceived(MinecraftEntity sender,String message) throws InterruptedException
{
}
}