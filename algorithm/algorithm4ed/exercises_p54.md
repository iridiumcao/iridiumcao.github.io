# Exercises

## 1.1.1 Give the value of each of the following expressions

```text
a. ( 0 + 15 ) / 2
b. 2.0e-6 * 100000000.1
c. true && false || true && true
```

### Answer

```text
a. 7
b. 200.0000002
c. true
```

## 1.1.2 Give the type and value of each of the following expressions

```text
a. (1 + 2.236) / 2
b. 1 + 2 + 3 + 4.0
c. 4.1 >= 4
d. 1 + 2 + "3"
```

### Answer

```text
a. 3.118
b. 10.0
c. true
d. 33
```

## 1.1.3 Write a program that takes three integer command-line arguments and prints **equal** if all three are equal, and **not equal** otherise

### Answer

```java
public static void main(String... args) {
    if (Integer.parseInt(args[0]) == Integer.parseInt(args[1])
            && Integer.parseInt(args[0]) == Integer.parseInt(args[2])) {
        System.out.println("equal");
    } else {
        System.out.println("not equal");
    }
}
```

([Ref](code/1_1_3/ThreeEqual.java))

## 1.1.4 What (if anything) is wrong with each of the following statements?

```text
a. if (a > b) then c = 0;
b. if a > b { c = 0;}
c. if (a > b ) c = 0;
d. if (a > b) c = 0 else b = 0;
```

### Answer

```text
a. Wrong. Syntax error, "then" is not a keyword of Java.
b. Wrong. Syntax error. if must be appended bricks.
c. Correct.
d. Wrong. "c = 0" must be appended ";".
```

## 1.1.5 Write a code fragment that prints **true** if the double variables **x** and **y** are both strictly between 0 and 1 and **false** otherwise.

### Answer

```java
public class Between01 {
    public static void main(String... args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        System.out.println(isBetween01(x, y));
    }

    public static boolean isBetween01(double x, double y) {
        if (x > 0 && x < 1 && y > 0 && y < 1) {
            return true;
        }
        return false;
    }
}
```

([Ref](code/1_1_5/Between01.java))

## 1.1.6 What does the following program print?

```java
int f = 0;
int g = 1;
for (int i = 0; i <=15; i++) {
    StdOut.println(f);
    f = f + g;
    g = f - g;
}
```

Answer

```text
  0 
  1 
  1 
  2 
  3 
  5 
  8 
 13
 21
 34
 55
 89
145
234
379
613
```

The details as following

```text
  f    g   i
  0    1   0
  1    0   1
  1    1   2
  2    1   3
  3    2   4
  5    3   5
  8    5   6
 13    8   7
 21   13   8
 34   21   9
 55   34  10
 89   55  11
145   89  12
234  145  13
379  234  14
613  379  15
```
