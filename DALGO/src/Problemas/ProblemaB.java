package Problemas;

import java.util.Scanner;

public class ProblemaB {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		while(true)
		{
			int nSocios = in.nextInt();
			int[] porSoc = new int [nSocios];

			for (int i = 0; i < porSoc.length; i++) 
				porSoc[i] = in.nextInt();

			boolean[] sePuede = new boolean [101];
			double resp = 0;

			for (int j = 0; j < porSoc.length; j++) 
				for (int porcentaje = 100; porcentaje >= 0; porcentaje--) 
					sePuede(porcentaje,j, sePuede, porSoc);


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

	public static void sePuede(int porcentaje, int j, boolean[] sePuede ,int[] porc)
	{
		if(j == 0)
			sePuede[porcentaje] = (porcentaje==porc[porc.length-1]);
		else if(porcentaje>=porc[(j+porc.length-1)%porc.length])
			sePuede[porcentaje] = sePuede[porcentaje] || sePuede[porcentaje-porc[(j+porc.length-1)%porc.length]];
	}

}
