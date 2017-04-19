.class public c
.super java/lang/Object

.method public <init>()V
  aload_0
  invokespecial java/lang/Object/<init>()V
  return
.end method

.method public main()V
  .limit stack 100
  .limit locals 100
  aload_0
  ldc_string "out "
  aload_0
  ldc 1.0
  ldc 20.0
  invokespecial Namespace
  invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String;
  invokespecial Namespace
  ldc 0.0
  fstore 1
  goto L0
L1:
  aload_0
  invokespecial Namespace
  store 2
  aload_0
  ldc 1200.0
  invokespecial Namespace
  aload_0
  aload_0
  invokespecial Namespace
  aload_0
  ldc -2.0
  ldc 15.0
  invokespecial Namespace
  fadd
  invokespecial Namespace
  aload_0
  load 2
  invokespecial Namespace
  aload_0
  ldc 5000.0
  invokespecial Namespace
  fload 1
  ldc 1.0
  fadd
  fstore 1
L0:
  fload 1
  ldc 50.0
  if_icmplt L1
  iconst_0
  goto L2L1:
  iconst_1
L2:
  nop
  ifne L3
.end method

