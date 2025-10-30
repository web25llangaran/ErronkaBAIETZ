package Erronkaapustuak;

import java.util.Arrays;

import java.util.Random;

public class kalkulatuEmaitzaEuromilloi {

	public static void main(String[] args) {
		// TODO Esbozo de método generado automáticamente
		        
				int i = 0, j = 0, z = 0;
		        int zenbAsmatuKopurua = 0;
		        int izarAsmatuKopurua = 0;

		        int[] emaitzaEuromilioi = new int[5];          
		        int[] emaitzaEuromilioiIzarrak = new int[2];   
		        int[] zenbAsmatuak = new int[5];               
		        int[] izarAsmatuak = new int[2];               

		        
		        emaitzaEuromilioi = ausazkoZenbakiakSortu(5, 1, 50);
		        emaitzaEuromilioiIzarrak = ausazkoZenbakiakSortu(2, 1, 12);

		        
		        int[] apustuaZenbakiak = {3, 15, 27, 42, 50};
		        int[] apustuaIzarrak = {2, 11};

		        
		        Emaitza emaitza = kalkulatuEmaitzaEuromilioi(
		            apustuaZenbakiak, apustuaIzarrak,
		            emaitzaEuromilioi, emaitzaEuromilioiIzarrak
		        );

		        
		        System.out.println("Ausazko zenbakiak: " + Arrays.toString(emaitzaEuromilioi));
		        System.out.println("Ausazko izarrak: " + Arrays.toString(emaitzaEuromilioiIzarrak));
		        System.out.println("Asmatutako zenbakiak: " + emaitza.zenbAsmatuKopurua);
		        System.out.println("Asmatutako izarrak: " + emaitza.izarAsmatuKopurua);
		        System.out.println("Zenbaki asmatutakoak: " + Arrays.toString(emaitza.zenbAsmatutakoak));
		        System.out.println("Izar asmatutakoak: " + Arrays.toString(emaitza.izarAsmatutakoak));
		    }

		   
		    public static Emaitza kalkulatuEmaitzaEuromilioi(
		            int[] apustuaZenbakiak, int[] apustuaIzarrak,
		            int[] emaitzaZenbakiak, int[] emaitzaIzarrak) {

		        int zenbAsmatuKopurua = 0;
		        int izarAsmatuKopurua = 0;
		        int[] zenbAsmatutakoak = new int[5];
		        int[] izarAsmatutakoak = new int[2];

		        int z = 0;
		        
		        for (int i = 0; i < emaitzaZenbakiak.length; i++) {
		            for (int j = 0; j < apustuaZenbakiak.length; j++) {
		                if (emaitzaZenbakiak[i] == apustuaZenbakiak[j]) {
		                    zenbAsmatutakoak[zenbAsmatuKopurua] = emaitzaZenbakiak[i];
		                    zenbAsmatuKopurua++;
		                    z++;
		                    break;
		                }
		            }
		        }

		        
		        z = 0;
		        for (int i = 0; i < emaitzaIzarrak.length; i++) {
		            for (int j = 0; j < apustuaIzarrak.length; j++) {
		                if (emaitzaIzarrak[i] == apustuaIzarrak[j]) {
		                    izarAsmatutakoak[izarAsmatuKopurua] = emaitzaIzarrak[i];
		                    izarAsmatuKopurua++;
		                    z++;
		                    break;
		                }
		            }
		        }

		        return new Emaitza(zenbAsmatuKopurua, izarAsmatuKopurua, zenbAsmatutakoak, izarAsmatutakoak);
		    }

		    
		    public static int[] ausazkoZenbakiakSortu(int kop, int min, int max) {
		        Random rnd = new Random();
		        int[] zenbakiak = new int[kop];
		        int i = 0;

		        while (i < kop) {
		            int zenb = rnd.nextInt(max - min + 1) + min;
		            boolean dago = false;

		            for (int j = 0; j < i; j++) {
		                if (zenbakiak[j] == zenb) {
		                    dago = true;
		                    break;
		                }
		            }

		            if (!dago) {
		                zenbakiak[i] = zenb;
		                i++;
		            }
		        }
		        Arrays.sort(zenbakiak);
		        return zenbakiak;
		    }

		    static class Emaitza {
		        int zenbAsmatuKopurua;
		        int izarAsmatuKopurua;
		        int[] zenbAsmatutakoak;
		        int[] izarAsmatutakoak;

		        public Emaitza(int zenbAsmatuKopurua, int izarAsmatuKopurua, int[] zenbAsmatutakoak, int[] izarAsmatutakoak) {
		            this.zenbAsmatuKopurua = zenbAsmatuKopurua;
		            this.izarAsmatuKopurua = izarAsmatuKopurua;
		            this.zenbAsmatutakoak = zenbAsmatutakoak;
		            this.izarAsmatutakoak = izarAsmatutakoak;
		        }
		    }
		

	}
