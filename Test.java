import java.util.*;
import com.educode.runtime.*;
import com.educode.runtime.types.*;
import com.educode.helper.*;

public class Test extends ScriptBase
{
public void main() throws InterruptedException
{
testAllBoolExpr();
testAllBoolLitExpr();
testRepeatWhile();
test((floor(20.500000F) == 20.000000F), true);
test((getArea(4.000000F, 3.000000F) == 12.000000F), true);
test(false, true);
}
public void test(Boolean val,Boolean expected) throws InterruptedException
{
if(val.equals(expected))
{
System.out.println("Expected");
}
else
{
System.out.println("Unexpected");
}

}
public void testAllBoolExpr() throws InterruptedException
{
Boolean True = true;
Boolean False = false;
Float one = 1.000000F;
Float zero = 0.000000F;
test(!(True), false);
test(!(False), true);
test((True && True), true);
test((True && False), false);
test((False && True), false);
test((False && False), false);
test((True || True), true);
test((True || False), true);
test((False || True), true);
test((False || False), false);
test(True.equals(True), true);
test(True.equals(False), false);
test(False.equals(True), false);
test(False.equals(False), true);
test(one.equals(one), true);
test(one.equals(zero), false);
test(zero.equals(one), false);
test((one > one), false);
test((one > zero), true);
test((zero > one), false);
test((one < zero), false);
test((one < zero), false);
test((zero < one), true);
test((one >= one), true);
test((one >= zero), true);
test((zero >= one), false);
test((one <= one), true);
test((one <= zero), false);
test((zero <= one), true);
}
public void testAllBoolLitExpr() throws InterruptedException
{
test(!(true), false);
test(!(false), true);
test(!(!(true)), true);
test(true, true);
test(false, false);
test(false, false);
test(false, false);
test(true, true);
test(true, true);
test(true, true);
test(false, false);
test(true, true);
test(false, false);
test(false, false);
test(true, true);
test(true, true);
test(false, false);
test(false, false);
test((1.000000F > 1.000000F), false);
test((1.000000F > 0.000000F), true);
test((0.000000F > 1.000000F), false);
test((1.000000F < 1.000000F), false);
test((1.000000F < 0.000000F), false);
test((0.000000F < 1.000000F), true);
test((1.000000F >= 1.000000F), true);
test((1.000000F >= 0.000000F), true);
test((0.000000F >= 1.000000F), false);
test((1.000000F <= 1.000000F), true);
test((1.000000F <= 0.000000F), false);
test((0.000000F <= 1.000000F), true);
}
public void testRepeatWhile() throws InterruptedException
{
Float num = 10.000000F;
Float counter = 0.000000F;
while ((num > 0.000000F))
{
counter = (counter + 1.000000F);
num = (num - 1.000000F);
}

test((counter == 10.000000F), true);
}
public Float floor(Float num) throws InterruptedException
{
Float result = 0.000000F;
if((num > 0.000000F))
{
while ((num >= 1.000000F))
{
result = (result + 1.000000F);
num = (num - 1.000000F);
}

}
else if((num < 0.000000F))
{
while ((num <= -1.000000F))
{
result = (result - 1.000000F);
num = (num + 1.000000F);
}

}

return result;
}
public Float getArea(Float width,Float length) throws InterruptedException
{
if(((width <= 0.000000F) || (length <= 0.000000F)))
{
return 0.000000F;
}
else
{
return (width * length);
}

}
}