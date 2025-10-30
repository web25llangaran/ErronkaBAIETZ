package Erronkaapustuak;

import java.util.Scanner;

public class jasoApustuaEuromilloi {

	public static void main(String[] args) {
		// TODO Esbozo de método generado automáticamente

				int[] apustuaEuromilioi = new int[5];
		        int[] apustuaEuromilioiIzarrak = new int[2];
		        jasoApustuaEuromilioi(apustuaEuromilioi, apustuaEuromilioiIzarrak);

		       
		        System.out.println("\nZure Euromilloi apustua:");
		        System.out.print("Zenbakiak: ");
		        for (int n : apustuaEuromilioi) {
		            System.out.print(n + " ");
		        }
		        System.out.print("\nIzarrak: ");
		        for (int n : apustuaEuromilioiIzarrak) {
		            System.out.print(n + " ");
		        }
		    }

	public static void jasoApustuaEuromilioi(int[] apustuaEuromilioi, int[] apustuaEuromilioiIzarrak) {
		        Scanner sc = new Scanner(System.in);
		        int zenb;
		        int i = 0;

		        
		        while (i < 5) {
		            System.out.print("Sartu " + (i + 1) + ". zenbakia (1-50): ");
		            zenb = sc.nextInt();

		            if (zenb >= 1 && zenb <= 50) {
		                apustuaEuromilioi[i] = zenb;
		                i++;
		            } else {
		                System.out.println("Sartutako zenbakia ez da egokia!");
		            }
		        }

		
		        i = 0;
		        while (i < 2) {
		            System.out.print("Sartu " + (i + 1) + ". izarra (1-12): ");
		            zenb = sc.nextInt();

		            if (zenb >= 1 && zenb <= 12) {
		                apustuaEuromilioiIzarrak[i] = zenb;
		                i++;
		            } else {
		                System.out.println("Sartutako zenbakia ez da egokia!");
		            }
		        }

		        sc.close();
		    }
		

	}
