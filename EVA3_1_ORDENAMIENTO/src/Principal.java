
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author martin
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] datos = new int[20];
        /*llenar(datos);
         imprimir(datos);
        
         long ini, fin;
         ini = System.nanoTime();
         selectionSort(datos);
         fin = System.nanoTime();
         imprimir(datos);
         System.out.println("Tiempo selection = "+(fin-ini));
        
         llenar(datos);
         imprimir(datos);
         ini = System.nanoTime();
         insertionSort(datos);
         fin = System.nanoTime();
         imprimir(datos);
         System.out.println("Tiempo insertion = "+(fin-ini));
        
         llenar(datos);
         imprimir(datos);
         ini = System.nanoTime();
         bubbleSort(datos);
         fin = System.nanoTime();
         imprimir(datos);
         System.out.println("Tiempo buble = "+(fin-ini));*/

        llenar(datos);
        imprimir(datos);
        //quickSort(datos);
        selectionSort(datos);
        imprimir(datos);
        
        Scanner input = new Scanner(System.in);
        System.out.println("Valor a buscars");
        int iVal = input.nextInt();
        System.out.println("Posicion " + busquedaBin(datos, iVal));
    }

    public static void llenar(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = (int) (Math.random() * 100);
        }
    }

    public static void imprimir(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("[" + arreglo[i] + "]");
        }
        System.out.println("");
    }

    //O(N^2)
    //mas comparaciones, menos intercambios
    public static void selectionSort(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            int iMin = i;//i min marca el elemento mas pequeño
            for (int j = (i + 1); j < arreglo.length; j++) {
                if (arreglo[iMin] > arreglo[j]) {
                    iMin = j;
                }
            }
            //swap
            int temp;
            temp = arreglo[iMin];
            arreglo[iMin] = arreglo[i];
            arreglo[i] = temp;
        }
    }

    //O(N^2)
    //mas intercambios, menos comparaciones
    public static void insertionSort(int[] arreglo) {
        for (int i = 1; i < arreglo.length; i++) {
            int temp = arreglo[i];
            int iPoint;
            for (iPoint = i; iPoint > 0; iPoint--) {
                int iPrev = (iPoint - 1);
                if (arreglo[iPrev] > temp) {
                    //swap                   
                    arreglo[iPoint] = arreglo[iPrev];
                } else {
                    break;
                }
            }
            arreglo[iPoint] = temp;
        }
    }

    public static void bubbleSort(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo.length - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    //swap
                    int iTemp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = iTemp;
                }
            }
        }
    }

    public static void quickSort(int[] arreglo) {
        quickSortRec(arreglo, 0, arreglo.length - 1);
    }

    private static void quickSortRec(int[] arreglo, int ini, int fin) {
        if ((ini < fin) && (ini >= 0) && (fin < arreglo.length)) {
            int iTemp;
            int iPiv = ini;
            int too_big = ini + 1;
            int too_small = fin;

            while (too_big < too_small) {
                while ((arreglo[too_big] < arreglo[iPiv]) && (too_big < fin)) {
                    too_big++;
                }

                while ((arreglo[too_small] > (arreglo[iPiv]) && (too_small > (ini + 1)))) {
                    too_small--;
                }

                //swap too_big con too_small
                if (too_big < too_small) {//no hay cruce
                    iTemp = arreglo[too_big];
                    arreglo[too_big] = arreglo[too_small];
                    arreglo[too_small] = iTemp;
                }
            }
            //swap del pivote
            iTemp = arreglo[iPiv];
            arreglo[iPiv] = arreglo[too_small];
            arreglo[too_small] = iTemp;

            quickSortRec(arreglo, ini, (too_small - 1));//izq
            quickSortRec(arreglo, (too_small + 1), fin);//der
        }
    }

    public static int busquedaBin(int[] arreglo, int val) {
        return busquedaBinRec(arreglo, val, 0, (arreglo.length - 1));
    }

    private static int busquedaBinRec(int[] arreglo, int val, int ini, int fin) {
        if (ini <= fin) {
            int mid = ini + (fin - ini) / 2;

            if (val == arreglo[mid]) {
                return mid;
            } else if (val > arreglo[mid]) {
                return busquedaBinRec(arreglo, val, (mid + 1), fin);
            } else {
                return busquedaBinRec(arreglo, val, ini, (mid - 1));
            }
        }else
            return -1;
    }
}
