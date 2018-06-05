import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import parcs.*;

public class JG implements AM{
	public static void main(String[] args) {
		task curtask = new task();
        curtask.addJarFile("JG.jar");
        (new JG()).run(new AMInfo(curtask, (channel)null));
        curtask.end();
	}
	
	public void run(AMInfo info) {
	      int N;
	      double[][] A;
	      double[] B;
	      Matrix mat = null;
	      try {
	          /*byte[] buf = new byte[200];
	          System.out.print("Enter n: ");
	          System.in.read(buf);
	          n=new Long(new String(buf).trim()).longValue();*/
	    	  mat = new Matrix();
	    	  File file = new File(info.curtask.findFile("input"));
	    	  Scanner sc = new Scanner(file);
	    	  N = sc.nextInt();
	    	  
	    	  A = new double[N][N];
	    	  mat.rows = new Row[N];
	    	  for(int i = 0; i < N; ++i) { 
	    		  mat.rows[i] = new Row();
	    		  mat.rows[i].A = new double[N];
	    		  for(int j = 0; j < N; ++j) {
	    			 double x = sc.nextDouble();
	    			 A[i][j] = x;
	    			 mat.rows[i].A[j] = x;
	    		  }
	    	  }
	    	  
	    	  B = new double[N];
	    	  for(int i = 0; i < N; ++i) {
	    		  double x = sc.nextDouble();
	    	  	  B[i] = x;
	    	  	  mat.rows[i].B = x;
	    	  }
	    	  
	    	  
	    	  mat.N = N;
	    	  mat.A = A;
	    	  mat.B = B;
	    	  mat.current = 1;
  
	      } catch (IOException e) {e.printStackTrace(); return;}

	      point p1 = info.createPoint();
	      channel c1 = p1.createChannel();
	      p1.execute("Part");
	      c1.write(mat);
	      c1.write(1);

	      System.out.println("Waiting for result...");
	      Matrix r = (Matrix)c1.readObject();
	      
	      double[] res = new double[N];
	      res[N - 1] = r.B[N - 1] / r.A[N - 1][N - 1];
	      for(int i = N - 2; i >= 0; i--) {
	    	  double sum = 0.0;
	    	  for(int j = i + 1; j < N; ++j) {
	    		  sum += r.A[i][j] * res[j];
	    	  }
	    	  res[i] = (r.B[i] - sum) / r.A[i][i];
	      }
	      System.out.println("RES");
	      for(int i = 0; i < N; ++i) {
	    	  System.out.print(res[i] + " ");
	      }
	    }
}
