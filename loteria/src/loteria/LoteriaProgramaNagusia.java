package loteria;

import java.util.Scanner;

public class LoteriaProgramaNagusia {

	public static void main(String[] args) {
		Scanner sn=new Scanner(System.in);
		int menua=0;
		boolean sarreraEgokia;
		Quiniela quinielaAukera=new Quiniela();
		Euromillones euromillonesAukera=new Euromillones();
		Primitiva primitivaAukera=new Primitiva();
		
		System.out.println("-----------------     Kaixo   	-----------------");
		System.out.println("--- Ongi etorri gure loteria administraziora  ---");
		do{
			sarreraEgokia=false;
			while (!sarreraEgokia)
			{
				System.out.println("--------------------------------------------------");
				System.out.println("   Aukeratu zein loteria egiaztatu nahi duzun:");
				System.out.println("--------------------------------------------------");
				System.out.println("1.- Sakatu 1 Primitiva egiaztatzeko");
				System.out.println("2.- Sakatu 2 Quiniela egiaztatzeko");
				System.out.println("3.- Sakatu 3 Euromillones egiaztatzeko");
				System.out.println("0.- Sakatu 0 programatik irteteko");
				System.out.println("--------------------------------------------------");
				try{
			    	menua = sn.nextInt();   // Teklatutik datorrena irakurtzen saiatu
			        sarreraEgokia = true;   // Sarrera egokia bada programarekin jarraituko du
			    } catch (java.util.InputMismatchException e)
			    	{
			    	System.out.println("Sartutako aukera ez da egokia!");
					System.out.println("Saiatu berriro.");
					sn.nextLine();// limpiar el búfer del scanner (descartar la entrada incorrecta)
			    	}
			}			
			
			switch (menua) {
				case 1://Primitiva funtzioa deitu
					primitivaAukera.main(null);
					sn.nextLine(); // Salto de linea hartu. Hau gabe azpiko System.out.println aurrera pasatzen dau.
					System.out.println("Sakatu ENTER jarraitzeko.");
					sn.nextLine(); // Orain hemen enter aren zai geratzen da.
					break;
				case 2://La Quiniela funtzioa deitu
					quinielaAukera.main(null);
					sn.nextLine(); // Salto de linea hartu. Hau gabe azpiko System.out.println aurrera pasatzen dau.
					System.out.println("Sakatu ENTER jarraitzeko.");
					sn.nextLine(); // Orain hemen enter aren zai geratzen da.
					break;
				case 3://Euromillones funtzioa deitu
					euromillonesAukera.main(null);
					sn.nextLine(); // Salto de linea hartu. Hau gabe azpiko System.out.println aurrera pasatzen dau.
					System.out.println("Sakatu ENTER jarraitzeko.");
					sn.nextLine(); // Orain hemen enter aren zai geratzen da.
					break;
				case 0: 
					System.out.println("Eskerrik asko, gurekin jokatzearren! Beste bat arte.");
					break;
				default:
					System.out.println("Sartutako aukera ez da egokia!");
					System.out.println("Saiatu berriro.");
			}
		}while (menua!=0);
		
		sn.close();
	}
}
