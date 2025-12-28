package bitbalance;

public class InnerCircle {

	public InnerCircle() {
		double a,b,c;

		a = 1.0;
		b = 0.7;
		c = Math.PI - a - b;
		a = Math.sin(a);
		b = Math.sin(b);
		c = Math.sin(c);
		doInnerCircle(a, b, c);
		doOuterCircle(a, b, c);

		a = 1.2;
		b = 0.7;
		c = Math.PI - a - b;
		a = Math.sin(a);
		b = Math.sin(b);
		c = Math.sin(c);
		doInnerCircle(a, b, c);
		doOuterCircle(a, b, c);

		a = 0.8;
		b = 0.7;
		c = Math.PI - a - b;
		a = Math.sin(a);
		b = Math.sin(b);
		c = Math.sin(c);
		doInnerCircle(a, b, c);
		doOuterCircle(a, b, c);
	}

	public void doInnerCircle(double a, double b, double c) {
//		a = Math.sin(a);
//		b = Math.sin(b);
//		c = Math.sin(c);
		double s = 0.5 * (a + b + c);
		double h;
		h = Math.sqrt((s - a) * (s - b) * (s - c) / s);
		System.out.println("Inner Circle radius: " + h);
	}

	public void doOuterCircle(double a, double b, double c) {
		double s = 0.5 * (a + b + c);
		double h;
		h = Math.sqrt((s - a) * (s - b) * (s - c) * s);
		h = a*b*c*.25 /h;
		System.out.println("Outer Circle radius: " + h);
	}
	public static void main(String[] args) {
		new InnerCircle();
	}
}
