import java.util.*;
import com.educode.runtime.*;
import com.educode.runtime.types.*;
import com.educode.helper.*;

public class Test extends ScriptBase
{
public void main() throws InterruptedException
{
<<<<<<< Updated upstream
testAllBoolExpr();
testAllBoolLitExpr();
testRepeatWhile();
test((floor(20.500000) == 20.000000), true);
test((getArea(4.000000, 3.000000) == 12.000000), true);
=======
null;
null;
null;
null;
null;
>>>>>>> Stashed changes
}
public void test(Boolean val,Boolean expected) throws InterruptedException
{
if(val.equals(expected))
{
null;
}
else
{
null;
}

}
public void testAllBoolExpr() throws InterruptedException
{
Boolean True = true;
Boolean False = false;
<<<<<<< Updated upstream
Double one = 1.000000;
Double zero = 0.000000;
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
test((true && true), true);
test((true && false), false);
test((false && true), false);
test((false && false), false);
test((true || true), true);
test((true || false), true);
test((false || true), true);
test((false || false), false);
test((true == true), true);
test((true == false), false);
test((false == true), false);
test((false == false), true);
test((1.000000 == 1.000000), true);
test((1.000000 == 0.000000), false);
test((0.000000 == 1.000000), false);
test((1.000000 > 1.000000), false);
test((1.000000 > 0.000000), true);
test((0.000000 > 1.000000), false);
test((1.000000 < 1.000000), false);
test((1.000000 < 0.000000), false);
test((0.000000 < 1.000000), true);
test((1.000000 >= 1.000000), true);
test((1.000000 >= 0.000000), true);
test((0.000000 >= 1.000000), false);
test((1.000000 <= 1.000000), true);
test((1.000000 <= 0.000000), false);
test((0.000000 <= 1.000000), true);
=======
Float one = 1.000000F;
Float zero = 0.000000F;
null;
null;
null;
null;
null;
null;
null;
null;
null;
null;
null;
null;
null;
null;
null;
null;
null;
null;
null;
null;
null;
null;
null;
null;
null;
null;
null;
null;
null;
}
public void testAllBoolLitExpr() throws InterruptedException
{
null;
null;
null;
null;
null;
null;
null;
null;
null;
null;
null;
null;
null;
null;
null;
null;
null;
null;
null;
null;
null;
null;
null;
null;
null;
null;
null;
null;
null;
>>>>>>> Stashed changes
}
public void testRepeatWhile() throws InterruptedException
{
Double num = 10.000000;
Double counter = 0.000000;
while ((num > 0.000000))
{
counter = (counter + 1.000000);
num = (num - 1.000000);
}

<<<<<<< Updated upstream
test((counter == 10.000000), true);
=======
null;
>>>>>>> Stashed changes
}
public Double floor(Double num) throws InterruptedException
{
Double result = 0.000000;
if((num > 0.000000))
{
while ((num >= 1.000000))
{
result = (result + 1.000000);
num = (num - 1.000000);
}

}
else if((num < 0.000000))
{
while ((num <= -1.000000))
{
result = (result - 1.000000);
num = (num + 1.000000);
}

}

return result;
}
public Double getArea(Double width,Double length) throws InterruptedException
{
if(((width <= 0.000000) || (length <= 0.000000)))
{
return 0.000000;
}
else
{
return (width * length);
}

}
}