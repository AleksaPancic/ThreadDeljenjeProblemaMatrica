package aleksa;

public class Worker implements Runnable {
	
	private int a[][];
	private int n;
	private int l,r;
	public static volatile Boolean Condition = true;
	
	public Worker(int[][] a, int n, int l, int r) {
		super();
		this.a = a;
		this.n = n;
		this.l = l;
		this.r = r;
	}


	@Override
	public void run() {
		int brojac = 0;
		for(int i = l; i <= r && Condition; i++) {
			for(int j = 0; j < n; j++) {
				if(a[i][j] % 2 == 0) {
					brojac++;
				}
			}
			if(brojac % 2 == 0 || brojac == 0) {
				Condition = false;
			}
			brojac = 0;
		}
	}

}
