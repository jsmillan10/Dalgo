package Problemas;

import java.util.Scanner;

public class ProblemaB {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		while(true)
		{
			int nSocios = in.nextInt();
			int[] porSoc = new int [nSocios];

			for (int i = 0; i < porSoc.length; i++) {
				porSoc[i] = in.nextInt();
			}

			boolean[] sePuede = new boolean [101];
			double resp = 0;
			
			recurrencia(100,0, sePuede, porSoc);
			
			for(int i = 51; i <= 100; i++)
				if(sePuede[i])
				{
					resp = (double) porSoc[porSoc.length-1]*100/i;
					break;
				}
			
			resp = (double) Math.round(resp*100)/100;
			System.out.println(resp);
		}
	}

	public static void recurrencia(int a, int j, boolean[] sePuede ,int[] porc)
	{
		if(j == 0)
			sePuede[a] = (a==porc[porc.length-1]);
		else if(a<porc[(j+porc.length-1)%porc.length])
			sePuede[a] = sePuede[a];
		else if(a>=porc[(j+porc.length-1)%porc.length])
			sePuede[a] = sePuede[a] || sePuede[a-porc[(j+porc.length-1)%porc.length]];

		if(a==0)
		{
			j++;
			a=100;
		}
		else
			a--;
		if(j<porc.length)
			recurrencia(a, j, sePuede, porc);
	}

}
