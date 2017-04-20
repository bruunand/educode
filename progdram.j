.class public progdram
.super java/lang/Object

.method public <init>()V
  aload_0
  invokespecial java/lang/Object/<init>()V
  return
.end method

.method public static main([Ljava/lang/String;)V
  .limit stack 100
  .limit locals 100
  new classname
  dup
  astore 2
  invokevirtual classname/<init>()V
  aload 2
  ldc 5.0
  ldc 10.0
  invokespecial classname/range(TODO)TODO
  dup
  store 1
  pop
  ldc 1234.0
  dup
  fstore -1
  dup
  fstore 3
  pop
  ldc 1337.0
  dup
  fstore -1
  dup
  fstore -1
  new classname
  dup
  astore 4
  invokevirtual classname/<init>()V
  aload 4
  ldc_string "out:"
  fload 3
  invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String;
  invokespecial classname/debug(TODO)TODO
  new classname
  dup
  astore 5
  invokevirtual classname/<init>()V
  aload 5
  ldc 500.0
  invokespecial classname/rangeTest.addItem(TODO)TODO
  ldc 5.0
  ldc 3.5
  dmul
  dup
  fstore 6
  pop
  aload 4
  ldc_string "res:"
  fload 6
  invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String;
  invokespecial classname/debug(TODO)TODO
  ldc_string "test"
  dup
  astore 7
  pop
NOT IMPLEMENTED:com.educode.nodes.referencing.StructReferencingNode  dup
  astore 7
  ldc_string "test"
  aload 7
  if_icmpeq L1
  iconst_0
  goto L2
L1:
  iconst_1
L2:
  nop
  ifeq L3
  aload 4
  ldc_string "it works"
  invokespecial classname/debug(TODO)TODO
  goto L0
L3:
  nop
L0:
  nop
NOT IMPLEMENTED:com.educode.nodes.statement.ForEachNodeNOT IMPLEMENTED:com.educode.nodes.referencing.StructReferencingNode  dup
  fstore 8
  pop
  new classname
  dup
  astore 9
  invokevirtual classname/<init>()V
  aload 9
  ldc_string "out "
  new classname
  dup
  astore 10
  invokevirtual classname/<init>()V
  aload 10
  ldc 1.0
  ldc 20.0
  invokespecial classname/random(TODO)TODO
  invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String;
  invokespecial classname/robot.say(TODO)TODO
  ldc 0.0
  dup
  fstore 11
  pop
  ldc 2.0
  dup
  fstore 12
  dup
  fstore 11
  goto L4
L5:
  new classname
  dup
  astore 14
  invokevirtual classname/<init>()V
  aload 14
  invokespecial classname/robot.getCoordinates(TODO)TODO
  dup
  store 13
  pop
  new classname
  dup
  astore 15
  invokevirtual classname/<init>()V
  aload 15
  ldc 1200.0
  invokespecial classname/robot.setWorldTime(TODO)TODO
  new classname
  dup
  astore 16
  invokevirtual classname/<init>()V
  aload 16
  new classname
  dup
  astore 17
  invokevirtual classname/<init>()V
  aload 17
  invokespecial classname/coords.getX(TODO)TODO
  aload 10
  ldc -2.0
  ldc 15.0
  invokespecial classname/random(TODO)TODO
  fadd
  invokespecial classname/coords.setX(TODO)TODO
  new classname
  dup
  astore 18
  invokevirtual classname/<init>()V
  aload 18
  load 13
  invokespecial classname/robot.walkTo(TODO)TODO
  new classname
  dup
  astore 19
  invokevirtual classname/<init>()V
  aload 19
  ldc 5000.0
  invokespecial classname/wait(TODO)TODO
  fload 11
  ldc 1.0
  fadd
  dup
  fstore 11
  pop
  pop
L4:
  fload 11
  ldc 50.0
  dup2
  fcmpg
  iflt L5
  iconst_0
  goto L6L5:
  iconst_1
L6:
  nop
  ifne L7
.end method

