package Problemas;

import java.util.Scanner;

public class ProblemaC {

	public String[] letrasDistintas(String[] arreglo)
	{
		String[] resultado = new String[2];
		String letras = "";
		String letrasNoCero = "";
		for (int i = 0; i < arreglo.length; i++) {
			if(i%2 == 0)
			{
				for (int j = 0; j < arreglo[i].length(); j++) {
					if(!letras.contains(""+arreglo[i].charAt(j)))
						letras+=arreglo[i].charAt(j);
					if(j==0 && !letrasNoCero.contains(""+arreglo[i].charAt(j)))
						letrasNoCero += arreglo[i].charAt(j);
				}
			}
		}
		resultado[0] = letras;
		String posNoCero = "";
		for (int i = 0; i < letrasNoCero.length(); i++) {
			posNoCero += letras.indexOf(letrasNoCero.charAt(i));
		}
		resultado[1] = posNoCero;
		return resultado;
	}

	public int[] signaturas(String[] arreglo, String letras)
	{

		int[] rs = new int[letras.length()];
		for (int i = 0; i < letras.length(); i++) {
			char sigLet = letras.charAt(i);
			boolean igual = false;
			int temp = 0;
			for (int j = 0; j < arreglo.length; j++) {
				String respuesta = "";
				String actual = arreglo[j];
				if(j%2 == 0)
				{
					for (int k = 0; k < actual.length(); k++) {
						if(sigLet==actual.charAt(k))
							respuesta += "1";
						else
							respuesta += "0";
					}
					if(!igual)
					{
						if(j==0||arreglo[j-1].equals("+"))
						{
							int ds = Integer.parseInt(respuesta);
							temp += ds;
						}
						else if(arreglo[j-1].equals("-"))
						{
							int ds = Integer.parseInt(respuesta);
							temp -= ds;
						}
					}
					else
					{
						if(arreglo[j-1].equals("=") || arreglo[j-1].equals("+"))
							temp -= Integer.parseInt(respuesta);
						else if(arreglo[j-1].equals("-"))
							temp += Integer.parseInt(respuesta);
					}
				}
				else if(actual.equals("="))
					igual = true;
			}
			rs[i] = temp;
			System.out.println(rs[i]);
		}
		return rs;
	}

	private static String Perm2(String[] elem, String act, int n, int r, int[] arreglo, String letrasNoCero, String total ) {
		if(total.isEmpty())
		{	
			if (n == 0) {
				{
					boolean noCero = false;
					for (int i = 0; i < letrasNoCero.length(); i++) {
						char l = act.charAt(Integer.parseInt(""+letrasNoCero.charAt(i)));
						if(l=='0')
							noCero = true;
					}
					if(!noCero)
					{
						int result = 0;
						String nn = act;
						char[] numLet = nn.toCharArray();
						for (int i = 0; i < arreglo.length; i++) 
						{
							result += (arreglo[i] * Integer.parseInt(""+numLet[i]));
						}
						if(result == 0)
						{
							total = nn;
						}
					}
				}
			} else {
				for (int i = 0; i < r; i++) {
					if (!act.contains(elem[i])) {
						total = Perm2(elem, act + elem[i], n - 1, r, arreglo, letrasNoCero, total);
					}
				}
			}
		}
		return total;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProblemaC pc = new ProblemaC();
		Scanner in = new Scanner(System.in);
		while(true){
			String todo = in.nextLine();
			String[] resultado;
			String[] separado = todo.split(" ");
			long time_start, time_end;
			time_start = System.currentTimeMillis();
			//Llenar mi arreglo con las letras distintas
			resultado = pc.letrasDistintas(separado);
			String letras = resultado[0];
			String posLetrasNoCero = resultado[1];
			//Signaturas
			int[] signaturas = new int[letras.length()];
			if(letras.length()<=10)
			{
				signaturas = pc.signaturas(separado, letras);
			}
			String[] elementos = "1,2,3,4,5,6,7,8,9,0".split(",");
			int n = letras.length();                  
			int r = elementos.length;
			String total = pc.Perm2(elementos,"", n, r, signaturas, posLetrasNoCero,"");
			String respuesta = ""; 
			for (int i = 0; i < 10; i++) {
				int pos= total.indexOf(""+i);
				if(pos==-1)
					respuesta+= "*";
				else
					respuesta+=letras.charAt(pos);
			}
			System.out.println(respuesta);
			time_end = System.currentTimeMillis();
			System.out.println("the task has taken "+ ( (time_end - time_start) ) +" milliseconds");
		}
	}
}
