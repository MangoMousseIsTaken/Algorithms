package test;

import java.util.Scanner;

public class pkg {
	public static void main(String[] args){
		Scanner scanner= new Scanner(System.in);
		while(scanner.hasNextLine()){
			System.out.println("输入背包容量");
			int W= scanner.nextInt();
			//scanner.nextLine();
			
			System.out.println("输入物品数量");
			int n= scanner.nextInt();
			//scanner.nextLine();
			
			System.out.println("输入物品重量");
			int[] w=new int[n+1];
			for(int i=1; i<n+1; i++){
				w[i]=scanner.nextInt();
			}
			//scanner.nextLine();
			
			System.out.println("输入物品价值");
			int[] v=new int[n+1];
			for(int i=1; i<n+1; i++){
				v[i]=scanner.nextInt();
			}
			scanner.nextLine();
			
			System.out.println("1.01背包动态规划");
			System.out.println("2.部分背包贪心算法");
			System.out.println("3.部分背包动态规划");
			System.out.println("输入选择方法");
			int a=scanner.nextInt();
			scanner.nextLine();
			
			switch (a) {
			case 1:
				a(W,n,w,v);
				break;
            case 2:
            	b(W,n,w,v);
				break;	
            case 3:
            	c(W,n,w,v);
				break;
			default:
				
				break;
			}
		}		
	}

	

	

	private static void a(int W, int n, int[] w, int[] v) {
		// TODO Auto-generated method stub
		int[][] a=new int[n+1][W+1];
		int from=W;
		for(int i=1; i<n+1; i++){
			from-=w[i];
		}
		for(int i=1; i<n+1; i++){
			for(int j=(from>0?from:0); j<W+1; j++){
				if(j<w[i])
					a[i][j]=a[i-1][j];
				else
					a[i][j]=Math.max(a[i-1][j], a[i-1][j-w[i]]+v[i]);
			}
		}
		System.out.println("结果为"+a[n][W]);
	}
	private static void b(int W, int n, int[] w, int[] v) {
		// TODO Auto-generated method stub
		double[] p=new double[n+1];
		for(int i=1; i<n+1; i++){
			p[i]=v[i]/w[i];
		}
		quicksort(p,v,w,0,n);
		
		int sum=0;
		int from=n;
		while(W>0){
			if(W>=w[from]){
				W-=w[from];
				sum+=v[from];
			}
			else{				
				sum+=W*p[from];
				W=0;
			}
			from--;
		}
		System.out.println("结果为"+sum);
	}
	private static void quicksort(double[] p, int[] v, int[] w, int from, int to) {
		if(from>= to)
			return;
		
		double x=p[to];
		int i= from-1;
		for(int j=from; j<to; j++){
			if(p[j]<=x){
				i++;
				double temp=p[j];
				p[j]=p[i];
				p[i]= temp;
				
				int temp2=v[j];
				v[j]=v[i];
				v[i]= temp2;
				
				int temp3=w[j];
				w[j]=w[i];
				w[i]= temp3;
			}
		}
		i++;
		double temp=p[to];
		p[to]=p[i];
		p[i]= temp;
		
		int temp2=v[to];
		v[to]=v[i];
		v[i]= temp2;
		
		int temp3=w[to];
		w[to]=w[i];
		w[i]= temp3;
		quicksort(p,v,w, from, i-1);
		quicksort(p, v,w,i+1, to);
		
	}





	private static void c(int W, int n, int[] w, int[] v) {
		// TODO Auto-generated method stub
		
	}
}
