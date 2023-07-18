import java.io.IOException;
import java.util.function.LongSupplier;
import java.util.stream.LongStream;

/**
 * Ref: https://www.liaoxuefeng.com/wiki/1252599548343744/1322655160467490
 * 
 * Compile: javac Fibonacci2.java -encoding "UTF-8"
 */
public class Fibonacci2 {
    public static void main(String[] args) throws IOException {
        LongStream fib = LongStream.generate(new FibSupplier());
        // 打印Fibonacci数列：1, 1, 2, 3, 5, 8, 13, 21...
        fib.limit(10).forEach(System.out::println);
    }
}

class FibSupplier implements LongSupplier {
    private long i = 1, j = 1;

    public long getAsLong() {
        long r = i;
        long k = i + j;
        i = j;
        j = k;
        return r;
    }
}
