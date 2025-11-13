/* Aplikazio honek quiniela loteria exekutatzen du:
 * 1.- Usuarioari apustua eskatu
 * 2.- Ausazko quiniela emaitzak sortu
 * 3.- Usuarioaren apustua ausaz sortutako emaitzekin konparatu
 * 4.- Emaitzak bistaratu
 * ------------Sariak ondorengo WEBean: https://www.quinielafutbol.info/------------
 */

package loteria;

import java.util.Scanner;

public class Quiniela {
	
	public static void main(String[] args) {
		// quinielako emaitzak hemen gordeko dira
		char[] ausazkoEmaitzak = new char[14];
		int[] ausazkoEmaitza15 = new int[2];
		// usuarioak quinielan eginiko apustua hemen gordeko da
		char[] apustuak = new char[14];
		int[] apustua15 = new int[2];
		int asmatutakoApustuKopurua;
		
		// 1.-Usuarioari apustua eskatu
		// ===========================================================================================================
		Scanner sn = new Scanner(System.in);
		String sartutakoApustua;
		int i = 0;
		String usuarioariEskaera;
		boolean sarreraEgokia;

		while (i < apustuak.length) {
			// apustua eskatu eta jaso
			System.out.println("Sar ezazu, 1, 2, edo x zure " + (i + 1) + ". apustua egiteko");
			sartutakoApustua = sn.next();
			// Konprobatu usuarioak sartutako balioa zuzena dela.
			if ((sartutakoApustua.length() == 1 && sartutakoApustua.charAt(0) == '1')
					|| (sartutakoApustua.length() == 1 && sartutakoApustua.charAt(0) == '2')
					|| (sartutakoApustua.length() == 1 && sartutakoApustua.charAt(0) == 'x')) {
				// sartutako balioa zuzena da
				apustuak[i] = sartutakoApustua.charAt(0);
				i++;
			} else// sartutako balioa ez da zuzena
			{
				System.out.println("Sartutako aukera ez da egokia! Saiatu berriro.");
			}
		}
		System.out.println("Azkenik: ");

		for (i = 0; i < apustua15.length; i++) {
			if (i == 0) {
				usuarioariEskaera = "Zenbat gol sartuko ditu ekipo lokalak?";
			} else {
				usuarioariEskaera = "Zenbat gol sartuko ditu kanpoko ekipoak?";
			}
			sarreraEgokia=false;
			while (!sarreraEgokia) {
				System.out.println(usuarioariEskaera);
				try {
					apustua15[i] = sn.nextInt(); // intentamos leer un número
					if (apustua15[i] >= 0) {
						sarreraEgokia = true; // Sarrera egokia bada programarekin jarraituko du
					} else {
						System.out.println("Sartutako aukera ez da egokia!");
						System.out.println("Saiatu berriro.");
					}
				} catch (java.util.InputMismatchException e) {
					System.out.println("Sartutako aukera ez da egokia!");
					System.out.println("Saiatu berriro.");
					sn.nextLine();// limpiar el búfer del scanner (descartar la entrada incorrecta)
				}
			}
		}

		// Usuarioak sartutako apustua bistaratu
		System.out.println("Ondorengo apustua burutu duzu:");
		for (i = 0; i < apustuak.length; i++) {
			System.out.println((i + 1) + ". apustua: " + apustuak[i]);
		}
		System.out.println("15. Partidoaren emaitza apustua:");
		System.out.println(apustua15[0] + " - " + apustua15[1] + " da");
		// ===========================================================================================================
		
		// 2.- Ausazko quiniela emaitzak sortu
		// ===========================================================================================================
		// quinielako apustu posibleak. Emaitza ausaz kalkulatzeko erabiliko dira
		char[] apustuPosibleak = { '1', '2', 'x' };
		int randomZenb;

		for (i = 0; i < ausazkoEmaitzak.length; i++) {
			randomZenb = (int) (Math.random() * apustuPosibleak.length); // 0 to 2
			ausazkoEmaitzak[i] = apustuPosibleak[randomZenb];
		}
		for (i = 0; i < ausazkoEmaitza15.length; i++) {
			randomZenb = (int) (Math.random() * 10); // 0 to 9
			ausazkoEmaitza15[i] = randomZenb;
		}
		// Quinielaren emaitza bistaratu
		System.out.println("Hau da Quinielako emaitza oraingoan:");
		for (i = 0; i < ausazkoEmaitzak.length; i++) {
			System.out.println((i + 1) + ". emaitza: " + ausazkoEmaitzak[i]);
		}
		System.out.println("15. Partidoaren emaitza:");
		System.out.println(ausazkoEmaitza15[0] + " - " + ausazkoEmaitza15[1] + " da");
		// ===========================================================================================================

		// 3.-Usuarioaren apustua ausaz sortutako emaitzekin konparatu
		// ===========================================================================================================
			asmatutakoApustuKopurua = 0;

			for (i = 0; i < apustuak.length; i++) {
				if (apustuak[i] == ausazkoEmaitzak[i]) {
					asmatutakoApustuKopurua += 1;
				}
			}
			if (asmatutakoApustuKopurua == 14 && apustua15[0] == ausazkoEmaitza15[0] && apustua15[1] == ausazkoEmaitza15[1]) {
				asmatutakoApustuKopurua += 1;
			}
		// ===========================================================================================================

		// 4.- Emaitzak bistaratu
		// ===========================================================================================================
		switch (asmatutakoApustuKopurua) {
		case 15:
			System.out.println("ZORIONAK!!! PLENO AL 15 Sari nagusia irabazi duzu. 15 apustuak asmatu dituzu eta.");
			System.out.println("=================================================================================");
			break;
		case 14:
			System.out.println("Zorionak! Lehen saria lortu duzu, 14 apustu asmatu dituzu eta.");
			System.out.println("==============================================================");
			break;
		case 13:
			System.out.println("Zorionak! Bigarren saria lortu duzu, 13 apustu asmatu dituzu eta.");
			System.out.println("=================================================================");
			break;
		case 12:
			System.out.println("Zorionak! Hirugarren saria lortu duzu, 12 apustu asmatu dituzu eta.");
			System.out.println("===================================================================");
			break;
		case 11:
			System.out.println("Zorionak! Laugarren saria lortu duzu, 11 apustu asmatu dituzu eta.");
			System.out.println("==================================================================");
			break;
		case 10:
			System.out.println("Zorionak! Bostgarren saria lortu duzu, 10 apustu asmatu dituzu eta.");
			System.out.println("===================================================================");
			break;
		default:
			System.out.println("Oraingoan ez duzu saririk, " + asmatutakoApustuKopurua + " apustu asmatu dituzu eta.");
			System.out.println("====================================================================================");
		}
		// ===========================================================================================================
		
	}
}
