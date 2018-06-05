import java.io.Serializable;

public class Matrix implements Serializable {
	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;

	public Matrix() {} 
	
	public Row[] rows;
	
	public int N;
        public  double[][] A;
        public  double[] B;
    
        public int getN() {
		return N;
	}

	public void setN(int n) {
		N = n;
	}

	public double[][] getA() {
		return A;
	}

	public void setA(double[][] a) {
		A = a;
	}

	public double[] getB() {
		return B;
	}

	public void setB(double[] b) {
		B = b;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}
	int current = 0;
}
