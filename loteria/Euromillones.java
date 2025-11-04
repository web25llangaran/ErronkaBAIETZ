package Erronkaapustuak;

import java.util.*;

public class Euromillones {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1️ JASO APUSTUA 
        int[] apustua = jasoApustuaEuromilloi(sc);
        int[] zenbakiak = Arrays.copyOfRange(apustua, 0, 5);
        int[] izarrak = Arrays.copyOfRange(apustua, 5, 7);

        // 2️ KALKULATU EMAITZA 
        Emaitza emaitza = kalkulatuEmaitzaEuromilloi(zenbakiak, izarrak);

        // 3️ BISTARATU EMAITZA 
        bistaratuEmaitzaEuromilloi(emaitza);

        sc.close();
    }

    // ----------------------------------------------------------
    //  1. jasotzen du erabiltzailearen apustua
    public static int[] jasoApustuaEuromilloi(Scanner sc) {
        System.out.println("Sartu 7 zenbaki (5 nagusi [1-50] eta 2 izar [1-12]) espazioz banatuta:");
        

        while (true) {
            System.out.print("> ");
            String linea = sc.nextLine().trim();
            if (linea.isEmpty()) {
                System.out.println("Ez da ezer sartu. Mesedez, sartu 7 zenbaki.");
                continue;
            }

            String[] tokens = linea.split("\\s+");
            if (tokens.length != 7) {
                System.out.println("Errorea: 7 zenbaki behar dira (5 nagusi + 2 izar).");
                continue;
            }

            int[] nums = new int[7];
            try {
                for (int i = 0; i < 7; i++) {
                    nums[i] = Integer.parseInt(tokens[i]);
                }
            } catch (NumberFormatException e) {
                System.out.println("Errorea: zenbaki guztiak izan behar dira.");
                continue;
            }

            // Balidazioak
            boolean valid = true;
            for (int i = 0; i < 5; i++) {
                if (nums[i] < 1 || nums[i] > 50) {
                    System.out.println("Zenbaki nagusia " + nums[i] + " ez da egokia (1-50 artean).");
                    valid = false;
                }
            }
            for (int i = 5; i < 7; i++) {
                if (nums[i] < 1 || nums[i] > 12) {
                    System.out.println("Izarra " + nums[i] + " ez da egokia (1-12 artean).");
                    valid = false;
                }
            }
            if (!valid) continue;

            // Errepikapenak
            Set<Integer> zenbSet = new HashSet<>();
            Set<Integer> izarSet = new HashSet<>();
            boolean duplicate = false;

            for (int i = 0; i < 5; i++) {
                if (!zenbSet.add(nums[i])) {
                    System.out.println("Zenbaki nagusia " + nums[i] + " errepikatuta dago.");
                    duplicate = true;
                }
            }
            for (int i = 5; i < 7; i++) {
                if (!izarSet.add(nums[i])) {
                    System.out.println("Izarra " + nums[i] + " errepikatuta dago.");
                    duplicate = true;
                }
            }
            if (duplicate) continue;

            System.out.println("Apustua ondo sartu da!");
            return nums;
        }
    }

    // ----------------------------------------------------------
    //Kalkulatzen du emaitza eta zenbat asmatu den
    public static Emaitza kalkulatuEmaitzaEuromilloi(int[] apustuZenbakiak, int[] apustuIzarrak) {
        Random random = new Random();

        // Sortu ausazko emaitza ofiziala
        Set<Integer> zenbakiMultzoa = new HashSet<>();
        while (zenbakiMultzoa.size() < 5) {
            zenbakiMultzoa.add(random.nextInt(50) + 1);
        }
        int[] emaitzaZenbakiak = zenbakiMultzoa.stream().mapToInt(Integer::intValue).toArray();

        Set<Integer> izarMultzoa = new HashSet<>();
        while (izarMultzoa.size() < 2) {
            izarMultzoa.add(random.nextInt(12) + 1);
        }
        int[] emaitzaIzarrak = izarMultzoa.stream().mapToInt(Integer::intValue).toArray();

        // Konparatu eta kalkulatu asmatutakoak
        int zenbAsmatuta = 0;
        int izarAsmatuta = 0;

        for (int n : apustuZenbakiak) {
            for (int e : emaitzaZenbakiak) {
                if (n == e) zenbAsmatuta++;
            }
        }
        for (int n : apustuIzarrak) {
            for (int e : emaitzaIzarrak) {
                if (n == e) izarAsmatuta++;
            }
        }

        return new Emaitza(emaitzaZenbakiak, emaitzaIzarrak, zenbAsmatuta, izarAsmatuta);
    }

    // ----------------------------------------------------------
    // Bistaratu emaitzak eta sariaren maila
    public static void bistaratuEmaitzaEuromilloi(Emaitza e) {
        System.out.println("\n🎰 EMAITZA OFIZIALA 🎰");
        System.out.println("Zenbaki irabazleak: " + Arrays.toString(e.emaitzaZenbakiak));
        System.out.println("Izar irabazleak: " + Arrays.toString(e.emaitzaIzarrak));

        System.out.println("\nZure emaitza:");
        System.out.println("Zenbaki asmatuta: " + e.zenbAsmatuta);
        System.out.println("Izar asmatuta: " + e.izarAsmatuta);

        // Sariaren arabera mezua
        if (e.zenbAsmatuta == 5 && e.izarAsmatuta == 2) {
            System.out.println("Zorionak! Euromilioia lortu duzu!");
        } else if (e.zenbAsmatuta == 5 && e.izarAsmatuta == 1) {
            System.out.println("2. Saria!");
        } else if (e.zenbAsmatuta == 5) {
            System.out.println("3. Saria!");
        } else if (e.zenbAsmatuta == 4 && e.izarAsmatuta >= 1) {
            System.out.println("4. Saria!");
        } else if (e.zenbAsmatuta >= 2 || e.izarAsmatuta >= 2) {
            System.out.println("Zerbait irabazi duzu!");
        } else {
            System.out.println("Ez duzu ezer irabazi oraingoan.");
        }
    }

    // ----------------------------------------------------------
    //Laguntza klasea emaitzarako
    static class Emaitza {
        int[] emaitzaZenbakiak;
        int[] emaitzaIzarrak;
        int zenbAsmatuta;
        int izarAsmatuta;

        Emaitza(int[] z, int[] i, int zenb, int izar) {
            this.emaitzaZenbakiak = z;
            this.emaitzaIzarrak = i;
            this.zenbAsmatuta = zenb;
            this.izarAsmatuta = izar;
        }
    }
}
