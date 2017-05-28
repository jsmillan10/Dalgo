package Problemas;

import java.util.Scanner;

public class ProblemaA {

	public void rotateDer(int[] A, int p, int q, int k)
	{
		reverse(A, q-(k%(q-p)), q-1);
		reverse(A, p, q-1-(k%(q-p)));
		reverse(A, p, q-1);
	}

	public void rotateIzq(int[] A, int p, int q, int k)
	{
		reverse(A, p, p+ (k%(q-p)-1));
		reverse(A, p+ (k%(q-p)), q-1);
		reverse(A, p, q-1);
	}

	// La funcion del reverse es:

	public void reverse(int[] A, int i, int j)
	{
		if (i == j)
			return;
		while (i < j) {
			int temp = A[i];
			A[i] = A[j];
			A[j] = temp;
			i++;
			j--;
		}
	}

	public static void main(String[] args) {
		
		ProblemaA pa = new ProblemaA();
		Scanner in = new Scanner(System.in);
		boolean acabe = false;
		while(!acabe)
		{
			System.out.println("Escriba el tamaño del arreglo");
			int n = in.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i]=i+1;
			}
			System.out.println("Escriba el número de rotaciones");
			int r = in.nextInt();
			try{
				while(r!=0)
				{
					System.out.println("Escriba la rotación que desea hacer separada por comas");
					String rot = in.next();
					String[] result = rot.split(",");
					int p = Integer.parseInt(result[0]);			
					int q = Integer.parseInt(result[1]);
					int k = Integer.parseInt(result[2]);
					if(k<0)
						pa.rotateIzq(a, p, q, -k);	    
					else
						pa.rotateDer(a, p, q, k);
					r--;
				}
				System.out.println("Resultado:");
				for (int i = 0; i < a.length; i++) {				
					System.out.print(a[i] + " ");
				}
			}
			catch (Exception e) {
				System.out.println("Resultado:");
				for (int i = 0; i < a.length; i++) {				
					System.out.print(a[i] + " ");
				}
			}
			System.out.println();
			System.out.println();
		}
	}
}
