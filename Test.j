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
  iconst_0 ; 1
  istore 1 ; 0
  iconst_1 ; 1
  istore 2 ; 0
  iload 2  ; 1
  iconst_0 ; 2
  if_icmpeq L1 ; 1
  ldc 0    ; 2
  goto L2  ; 2
L1:
  ldc 1    ; 2
L2:
  nop      ; 2
  ifeq L3  ; 1
  iload 2  ; 2
  istore 1 ; 1
  goto L0  ; 1
L3:
  iload 2  ; 2
  ifeq L5  ; 1
  iload 2  ; 2
  dup      ; 3
  ifeq L4  ; 2
  pop      ; 1
  iconst_1 ; 2
L4:
  nop      ; 2
  istore 1 ; 1
  goto L0  ; 1
L5:
  nop
L0:
  nop
  getstatic java/lang/System/out Ljava/io/PrintStream;
  iload 1
  invokevirtual java/io/PrintStream/println(I)V
  return
.end method

