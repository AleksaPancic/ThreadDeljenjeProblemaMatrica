package aleksa;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainClass {
	public static int generateMatrix(int n, int a[][], int max) {
		Random random = new Random();
		a = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				a[i][j] = random.nextInt(max) + 1;
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}		
		return a[n][n];
	}
	static int a[][];
	public static void F(int a[][],int n, int t) {
		Worker[] workers = new Worker[t];
		int d = n/t;
		ExecutorService executor = Executors.newFixedThreadPool(t);
		for(int i = 0; i < t; i++) {
			workers[i] = new Worker(a, n, i*d, (i == t - 1 ? n - 1 : (i + 1) * d - 1));
		}
		for(int i = 0; i < t; i++) {
			executor.submit(workers[i]);
		}
		
		executor.shutdown();
		try {
			executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(Worker.Condition ? "true" : "false");
	}
	public static void main(String[] args) {
		int n = 3;
		int t = 1;
		int[][] b = new int[n][n];
		b[0][0] = 4;
		b[0][1] = 8;
		b[0][2] = 8;
		b[1][0] = 4;
		b[1][1] = 6;
		b[1][2] = 8;
		b[2][0] = 4;
		b[2][1] = 6;
		b[2][2] = 8;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(b[i][j]);
			}
			System.out.println();
		}
		F(b, n, t);
	}

}
