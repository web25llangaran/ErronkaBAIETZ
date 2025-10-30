package Erronkaapustuak;

import java.util.Scanner;

public class BistaratuEmaitzajava {

		public static void main1(String[] args) 	{
			// TODO Esbozo de método generado automáticamente

	}

		    public static int getPrizeTier(int zenbakiasma, int izarasma) {
		        if (zenbakiasma < 0 || zenbakiasma > 5 || izarasma < 0 || izarasma > 2) {
		            throw new IllegalArgumentException("Asmatutako zenbaki kopurua (0-5) eta izar kopurua (0-2) izan behar da");
		        }

		        if (zenbakiasma == 5) {
		            if (izarasma == 2) return 1;
		            if (izarasma == 1) return 2;
		            return 3; 
		        }

		        if (zenbakiasma == 4) {
		            if (izarasma == 2) return 4;
		            if (izarasma == 1) return 5;
		            return 6; 
		        }

		        if (zenbakiasma == 3) {
		            if (izarasma == 2) return 7;
		            if (izarasma == 1) return 9;
		            return 10; 
		        }

		        if (zenbakiasma == 2) {
		            if (izarasma == 2) return 8;
		            if (izarasma == 1) return 12;
		            return 0; 
		        }

		        if (zenbakiasma == 1) {
		            if (izarasma == 2) return 11;
		            return 0; 
		        }

		        
		        if (izarasma == 2) return 13;
		        return 0; 
		    }

		    
		    	public static String prizeDescription(int tier) {
		    		switch (tier) {
		            case 1: return "1. Premioa (5+2)";
		            case 2: return "2. Premioa (5+1)";
		            case 3: return "3. Premioa (5+0)";
		            case 4: return "4. Premioa (4+2)";
		            case 5: return "5. Premioa (4+1)";
		            case 6: return "6. Premioa (4+0)";
		            case 7: return "7. Premioa (3+2)";
		            case 8: return "8. Premioa (2+2)";
		            case 9: return "9. Premioa (3+1)";
		            case 10: return "10. Premioa (3+0)";
		            case 11: return "11. Premioa (1+2)";
		            case 12: return "12. Premioa (2+1)";
		            case 13: return "13. Premioa (0+2)";
		            default: return "Ez dago saririk";
		        }
		    }

			    public static void main(String[] args) 	{   
		    	Scanner sc = new Scanner(System.in);
		        System.out.print("Zenbat zenbaki asmatu dituzu? (0-5): ");
		        int nums = sc.nextInt();
		        System.out.print("Zenbat izar asmatu dituzu? (0-2): ");
		        int stars = sc.nextInt();

		        try {
		            int tier = getPrizeTier(nums, stars);
		            System.out.println("Saria: " + prizeDescription(tier));
		        } catch (IllegalArgumentException ex) {
		            System.err.println("Sartutako balioa baliogabea da: " + ex.getMessage());
		        } finally {
		            sc.close();
		        }
		    
		

	}

}
