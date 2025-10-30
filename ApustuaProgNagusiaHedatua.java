package ERRONKA;
import java.util.Scanner;
public class Orri_nagusia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int menua;
		System.out.println("1 = Primitiva");
		System.out.println("2 = La Quiniela");
		System.out.println("3 = La Euromillones");
		System.out.println("0 = Programa Bukatu");
		menua = sc.nextInt();
	
		while (menua!=0) {
			switch (menua) {
				case 1:
					//Primitiva funtzioa deitu
					break;
				case 2:
					//La Quiniela funtzioa deitu
					break;
				case 3:
					//Euromillones funtzioa deitu
					break;
				default:
					System.out.println("Sartutako zenbakia ez da egokia!");
					break;
					}
			if (menua!=0) {
				System.out.println("1 = Primitiva");
				System.out.println("2 = La Quiniela");
				System.out.println("3 = La Euromillones");
				System.out.println("0 = Programa Bukatu");
				menua = sc.nextInt();
				}
			} sc.close();
		}
	}
	
