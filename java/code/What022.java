/**
 * 
 * link: http://www.onjava.com/pub/a/onjava/2005/04/20/javaIAN5.html
 * 
 * @author iridiumcao@gmail.com
 * @version 1.0
 */
public class What022 {

	public static void main(String[] args) {
		double x = 0Xap0; // 10 * 2^0 = 10.0
		double y = 0XfP2D; // 15 * 2^2 = 60.0
		float z = 0Xf.aP1F; // (15 + 10/16ths) * 2^1 = 31.25f
		// Print in decimal
		System.out.printf("%f %f %f%n", x, y, z);
		// Print in hex
		System.out.printf("%a %a %a%n", x, y, z);
	}

}

/*
 * output
 * 10.000000 60.000000 31.250000
 * 0x1.4p3 0x1.ep5 0x1.f4p4
 * 
 */