package loteria;

import java.util.Scanner;
import java.util.Random;

import java.util.*;
public class Euromillones {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Random ausaz = new Random();
		boolean errepikatuta=false;
		int[] array = new int[5];
		int[] arrayIzarrak = new int[2];
		int[] emaitzaArray = new int[5];
		int[] emaitzaIzarrak = new int[2];
		int i=0;
		int j=0;
		int zenb;
		int kontadoreIzarrak=0;
		int kontadoreArray=0;
		int[] irabazleIzarrak = new int[2];
		int[] irabazleZenbakiak = new int[5];
		//datuak jasotzen duen eta ondo dagoen konprobatzen duten while bi egitura.
		//bi array egingo ditugu.
		//batek bost aldagai ditu eta bestea 2, honek izarrak izango dira
		//=============================================================
		while (i<5) {	
			System.out.println((i+1)+". zenbakia idatzi, 1-etik 50-era");
			try {
					zenb=sc.nextInt();
					if (zenb>=1 && zenb<=50) {
						errepikatuta=false;
						for (j=0; j<i;j++) {
							if (array[j] == zenb) {
								errepikatuta=true;
								break;
							}
						}
						if (errepikatuta==true) {
							System.out.println("sartutako zenbakia errepikatua dago! Beste bat sartu");
							continue;
							}
							array[i]=zenb;
							i++;
							}else {
								System.out.println("Sartutako karakterea ez da egokia!");
								System.out.println("Saiatu berriro");
								sc.nextLine();
								continue;
								}
				} catch (java.util.InputMismatchException e) {
						System.out.println("Sartutako karakterea ez da egokia!");
						System.out.println("Saiatu berriro");
						sc.nextLine();
				}
			}
		
		i=0;
		while (i<2) {	
			System.out.println((i+1)+". izarra idatzi. ");
			try {
					zenb=sc.nextInt();
					if (zenb>=1 && zenb<=12) {	
						errepikatuta=false;
						for (j=0; j<i;j++) {
							if (arrayIzarrak[j] == zenb) {
								errepikatuta=true;
								break;
							}
						}
						if (errepikatuta==true) {
						System.out.println("sartutako zenbakia errepikatua dago! Beste bat sartu");
						continue;
						}
						arrayIzarrak[i]=zenb;
						i++;
						} else {
							System.out.println("Sartutako karakterea ez da egokia!");
							System.out.println("Saiatu berriro");
							sc.nextLine();
							continue;
							}			
				}	catch (java.util.InputMismatchException e) {
					System.out.println("Sartutako karakterea ez da egokia!");
					System.out.println("Saiatu berriro");
					sc.nextLine();
				}
		}

	//=============================================================
	// zenbakiak ausaz sortu
		zenb = ausaz.nextInt(50)+1;
		for (i=0;i<emaitzaArray.length;i++) {
			do {
				zenb = ausaz.nextInt(50)+1;
				errepikatuta = false;
					for (j=0;j<i;j++) {
						if (emaitzaArray[j]==zenb) {
							errepikatuta=true;
							break;
						}
					}
					
				} while (errepikatuta==true);
			emaitzaArray[i]=zenb;
			}
		

		zenb = ausaz.nextInt(12)+1;
		for (i=0;i<emaitzaIzarrak.length;i++) {
			do {
				zenb = ausaz.nextInt(12)+1;
				errepikatuta = false;
					for (j=0;j<i;j++) {
						if (emaitzaIzarrak[j]==zenb) {
							errepikatuta=true;
							break;
						}
					}
					
				} while (errepikatuta==true);
			emaitzaIzarrak[i]=zenb;
			}
	//=============================================================
		
	// konparazioa ausaz sortutakoen eta erabiltzaileak emandakoen artean.
		
		for (i=0;i<5;i++) {
			for (j=0;j<5;j++) {
				if (array[i]==emaitzaArray[j]) {
					kontadoreArray++;
				}
			}

		}
		for (i=0;i<2;i++) {
			for (j=0;j<2;j++) {
				if (arrayIzarrak[i]==emaitzaIzarrak[j]) {
				kontadoreIzarrak++;
			}
		}
		}
	//==========================================================
	//Bistaraketa.
		System.out.println("Sartutako zenbakiak eta ausaz sortutakoak: ");
		for (i=0;i<5;i++) {
			System.out.println(array[i]+"  -  "+emaitzaArray[i]);
		}
		
		System.out.println("Sartutako izarrak eta ausaz sortutakoak: ");
		for (i=0;i<2;i++) {
			System.out.println(arrayIzarrak[i]+"  -  "+emaitzaIzarrak[i]);
		}
		System.out.println("Asmatutako apustu eta izar kopurua :"+ kontadoreArray +" -  "+kontadoreIzarrak );
		if (kontadoreArray==5 && kontadoreIzarrak==2) {
			System.out.println("1. Saria irabazi duzu!");
		}else if (kontadoreArray==5 && kontadoreIzarrak==1) {
			System.out.println("2. Saria irabazi duzu!");
		}else if (kontadoreArray==5) {
			System.out.println("3. Saria irabazi duzu!");
		}else if (kontadoreArray==4 && kontadoreIzarrak==2) {
			System.out.println("4. Saria irabazi duzu!");
		}else if (kontadoreArray==4 && kontadoreIzarrak==1) {
			System.out.println("5. Saria irabazi duzu!");
		}else if (kontadoreArray==3 && kontadoreIzarrak==2) {
			System.out.println("6. Saria irabazi duzu!");
		}else if (kontadoreArray==4) {
			System.out.println("7. Saria irabazi duzu!");
		}else if (kontadoreArray==2 && kontadoreIzarrak==2) {
			System.out.println("8. Saria irabazi duzu!");
		}else if (kontadoreArray==3 && kontadoreIzarrak==1) {
			System.out.println("9. Saria irabazi duzu!");
		}else if (kontadoreArray==3) {
			System.out.println("10. Saria irabazi duzu!");
		}else if (kontadoreArray==1 && kontadoreIzarrak==2) {
			System.out.println("11. Saria irabazi duzu!");
		}else if (kontadoreArray==2 && kontadoreIzarrak==1) {
			System.out.println("12. Saria irabazi duzu!");
		}else {
			System.out.println("Ez duzu saririk irabazi.");
		}
	}	
}
