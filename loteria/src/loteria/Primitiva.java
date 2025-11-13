package loteria;

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Primitiva {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int[] usuarioa = new int[6];
        int zenb = 0;
        boolean sarreraEgokia;
        boolean errepikatuta;
        int i = 0;
        int j = 0;
        int reintegro = 0;
        // Zenbakiak eskatu
        while (i < (usuarioa.length)) {
            System.out.println("Sartu " + (i + 1) + ". zenbakia 1-etik 49-arte biak barne");
            try {
                zenb = sc.nextInt();
                errepikatuta = false;
                if ((zenb >= 1) && (zenb <= 49)) {
                    for (j = 0; j < i; j++) {
                        if (usuarioa[j] == zenb) {
                            errepikatuta = true;
                        }
                    }
                    // errepikatuta dagoen konprorbatu
                    if (errepikatuta) {
                        System.out.println("Sartu duzun zenbakia errepikatuta dago, sartu beste bat");
                    } else {
                        usuarioa[i] = zenb;
                        i++;
                    }
                } else {
                    System.out.println("Sartutako " + zenb + " zenbakia ez dago 1 eta 49 artean. ");
                }


            } catch (java.util.InputMismatchException e) {
                System.out.println("Sartutako zenbakia ez da egokia");
                System.out.println("Saiatu berriro");
                sc.nextLine();
            }
        }
        sarreraEgokia = false;
        while (!sarreraEgokia) {
            System.out.println("Sar ezazu reintegroa 0-tik 9-ra biak barne");
            try {
                zenb = sc.nextInt();
                errepikatuta = false;
                if (zenb < 0) {
                    System.out.println("Zenbakia txikia da, 0-etik 9-ra izan behar da. ");
                } else {
                    if (zenb > 9) {
                        System.out.println("Zenbakia handia da, 0-etik 9-ra izan behar da.");
                    } else {
                        reintegro = zenb;
                        sarreraEgokia = true;
                    }
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Sartutako zenbakia ez da egokia");
                System.out.println("Saiatu berriro");
                sc.nextLine();
            }
        }
        // Asazko irabazl-zenbakiak sortu
        Random random = new Random();
        int[] irabazlea = new int[6];
        int reintegroIrabazlea;
        int osagarria = 0;
        for (i = 0; i < irabazlea.length; i++) {
            boolean existitzen = true;
            while (existitzen) {
                zenb = random.nextInt(49) + 1;
                existitzen = false;
                for (j = 0; j < i; j++) {
                    if (irabazlea[j] == zenb) {
                        existitzen = true;
                        break;
                    }
                }
            }
            irabazlea[i] = zenb;
        }
        reintegroIrabazlea = random.nextInt(10);


        // Osagarria sortu (6 zenbaki irabazleetatik dezberdina)
        boolean osagarriaBalioduna = true;
        while (osagarriaBalioduna) {
            osagarria = random.nextInt(49) + 1;
            osagarriaBalioduna = false;
            for (i = 0; i < irabazlea.length; i++) {
                if (irabazlea[i] == osagarria) {
                    osagarriaBalioduna = true;
                    break;
                }
            }
        }


        System.out.println("Emaitzak");
        System.out.print("Zure zenbakiak: ");
        for (i = 0; i < usuarioa.length; i++) {
            System.out.print(usuarioa[i] + " ");
        }
        System.out.println("(Reintegro: " + reintegro + ")");
        System.out.print("Irabazleen zenbakiak: ");
        for (i = 0; i < irabazlea.length; i++) {
            System.out.print(irabazlea[i] + " ");
        }
        System.out.println("(Reintegro: " + reintegroIrabazlea + ", Osagarria: " + osagarria + ")");
        // asmatutakoak konporbatu
        int aciertos = 0;
        boolean osagarriaAsmatu = false;
        System.out.print("Asmatutako zenbakiak: ");
        for (i = 0; i < usuarioa.length; i++) {
            for (j = 0; j < irabazlea.length; j++) {
                if (usuarioa[i] == irabazlea[j]) {
                    System.out.print(usuarioa[i] + " ");
                    aciertos++;
                }
            }


            // Osagarria konprobatu
            if (usuarioa[i] == osagarria) {
                osagarriaAsmatu = true;
            }
        }


        boolean reintegroZuzena = (reintegro == reintegroIrabazlea);
        System.out.println(" | Guztira " + aciertos + " zenbaki asmatu dituzu.");
    
        // kalkulatu ostean bistaratzen du ze kategoria irabazi duzun.
        switch (aciertos) {
        case 6:
            if (reintegroZuzena)
                System.out.println("Espeziala");
            else
                System.out.println("1.Kategoria");
            break;
        case 5:
            if (osagarriaAsmatu)
                System.out.println("2.Kategoria");
            else
                System.out.println("3.Kategoria");
            break;
        case 4:
            System.out.println("4.Kategoria");
            break;
        case 3:
            System.out.println("5.Kategoria");
            break;
        default:
            if (reintegroZuzena)
                System.out.println("Reintegroa");
            else
                System.out.println("Ez duzu asmatu premio gabe geratu zara. ");
        }
	}
}



