.class public Test
.super java/lang/Object

.method public <init>()V
  aload_0
  invokespecial java/lang/Object/<init>()V
  return
.end method

.method public static main([Ljava/lang/String;)V
  .limit stack 100
  .limit locals 100
  iconst_1
  istore 1
  iconst_0
  istore 2
  iload 2
  iconst_0
  if_icmpeq L1
  ldc 0
  goto L2
L1:
  ldc 1
L2:
  nop
  ifeq L3
  iload 2
  istore 1
  goto L0
L3:
  iload 1
  ifeq L5
  iload 1
  ifeq L4
  iconst_1
L4:
  nop
  istore 2
  goto L0
L5:
  nop
L0:
  nop
  return
.end method

