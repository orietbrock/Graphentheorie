/*
 * Diese Utilities fuer Graphen und Stochastik
 * @author Oliver Rietbrock
 */
public class Util {
	public static int calcFibonacci(int exp) {
		double wfuenf = Math.sqrt(5);
		double ergebnis = 1
				/ wfuenf
				* (Math.pow(((1 + wfuenf) / 2), exp) - Math.pow(
						((1 - wfuenf) / 2), exp));
		return (int) ergebnis;
	}

	public static boolean istFibonacci(int wert) {
		int exp = 0;
		int fib = 0;
		boolean istFib = false;
		while (fib <= wert) {
			fib = calcFibonacci(exp);
			exp++;
			if (wert == fib) {
				istFib = true;
			}
		}
		return istFib;
	}
	public static int[][] adjazenzMatrixMulti(int[][] a, int[][] b) {
		int[][] c = new int[a.length][b[0].length];
		for(int i = 0; i<a.length; i++) {
			for(int j = 0; j<b[i].length; j++){
				int sum = 0;
				for(int k = 0; k<a[i].length; k++) {
					sum += a[i][k] * b[k][j];
				}
				c[i][j] = sum;
			}
		}
		return c;
	}
	public static int[][] adjazenzMatrixAdd(int[][] a, int[][] b) {
		int[][] c = new int[a.length][b[0].length];
		for(int i = 0; i<a.length; i++) {
			for(int j = 0; j<b[i].length; j++){
				
				c[i][j] = a[i][j] + b[i][j];
			}
		}
		return c;
	}
	public static int[][] adjazenzPotenz(int[][] a, int n) {
		int[][] an = Util.adjazenzMatrixMulti(a, a);
		for(int i = 2; i < n ; i++) {
			an = Util.adjazenzMatrixMulti(a, an);
		}
		return an;
	}
	public static int[][] kantenRechnung(int[][] a, int n) {
		int[][] k = a;
		for(int i = 2; i <=n ; i++){
			k = Util.adjazenzMatrixAdd(k, Util.adjazenzPotenz(a, i));
		}
		return k;
	}
	public static void anzeigenMatrix(int[][] a) {
		for(int i = 0; i<a.length; i++) {
			System.out.print("{");
			for(int j = 0; j<a[i].length; j++){
				System.out.print(a[i][j]);
				if(j!=a[i].length-1)
					System.out.print(", ");
			}
			System.out.print("} ,\n");
		}
	}
}
