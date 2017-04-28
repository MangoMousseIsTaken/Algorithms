package fundament;

import java.util.Random;
import java.util.Scanner;

import sun.net.www.content.audio.aiff;

public class quick_sort {
	public static void main(String[] args){
		Scanner scanner= new Scanner(System.in);
		while(scanner.hasNextLine()){
			String string=scanner.nextLine();
			String[] sa= string.split("\\s+");
			int[] ia= new int[sa.length];
			int[] ia2= new int[sa.length];
			for(int i=0; i<sa.length; i++){
				char[] ca=sa[i].toCharArray();
				int temp=0;
				int a=1;
				for(int j=ca.length-1; j>=0; j--){
					temp+=(ca[j]-'0')*a;
					a*=10;
				}
				ia[i]=temp;
				ia2[i]=temp;
			}
			
		/*	int[] ia= new int[1000];
			int[] ia2=new int[1000];
			for(int i=0; i<1000; i++){
				ia[i]=1000-i;
				ia2[i]=1000-i;
			}
		*/	
			long startTime=System.nanoTime();   //获取开始时间
			quicksort(ia,0,ia.length-1);
			long endTime=System.nanoTime(); //获取结束时间
			System.out.println("quicksort程序运行时间： "+(endTime-startTime)+"ns");			
			for(int i=0; i<ia.length; i++){
				System.out.print(ia[i]+" ");
			}
			System.out.println();
			
			
			long startTime2=System.nanoTime();   //获取开始时间
			random_quicksort(ia2,0,ia2.length-1);
			long endTime2=System.nanoTime(); //获取结束时间
			System.out.println("randomquicksort程序运行时间： "+(endTime2-startTime2)+"ns");			
			for(int i=0; i<ia2.length; i++){
				System.out.print(ia2[i]+" ");
			}
			System.out.println();
		}
	}

	private static void random_quicksort(int[] ia, int from, int to) {
		// TODO Auto-generated method stub
		Random random= new Random();
		int x=random.nextInt(to)%(to-from+1)+from;
		int temp=ia[to];
		ia[to]=ia[x];
		ia[x]= temp;
		quicksort(ia, from, to);
	}

	private static void quicksort(int[] ia, int from, int to) {
		// TODO Auto-generated method stub
		if(from>= to)
			return;
		
		int x=ia[to];
		int i= from-1;
		for(int j=from; j<to; j++){
			if(ia[j]<=x){
				i++;
				int temp=ia[j];
				ia[j]=ia[i];
				ia[i]= temp;
			}
		}
		i++;
		int temp=ia[to];
		ia[to]=ia[i];
		ia[i]= temp;
		quicksort(ia, from, i-1);
		quicksort(ia, i+1, to);
		
	}
}
