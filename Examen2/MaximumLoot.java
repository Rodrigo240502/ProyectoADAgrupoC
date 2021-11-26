//https://kth.kattis.com/problems/maxloot

import java.util.*;
public class MaximumLoot {
    public static void main(String[] args) {
        maximumLoot();
    }
    static void maximumLoot(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el numero de pruebas: ");
        int nTest = sc.nextInt();
        for (int i = 0; i < nTest; i++) {
            System.out.println("Ingrese el numero de elementos que puede cargar");
            int n = sc.nextInt();
            System.out.println("Ingrese el peso maximo a cargar");
            int peso = sc.nextInt();
            int[] valores = new int[n];
            int[] pesos = new int[n];

            for (int j = 0; j < n; j++) {
                System.out.println("Ingrese los "+n+" valores de cada objeto");
                valores[j] = sc.nextInt();
                System.out.println("Ingrese los "+n+" pesos de cada objeto");
                pesos[j] = sc.nextInt();
            }
            imprimir(mochilaDinamic(valores, pesos, n, peso));
            
        }
        sc.close();
    }
    //Codigo de elaboracion propia en curso de EDA LAB 
    static int[][] mochilaDinamic(int[]peso,int[]costo,int capaci,int cantidad){
        int[][] costoTotal = new int[cantidad+1][capaci+1];
        for(int i=0;i<=cantidad;i++){
            costoTotal[i][0] = 0;
        }
        for(int i=0;i<=capaci;i++){
            costoTotal[0][i] = 0;
        }
        for(int i=1;i<=cantidad;i++){
            for(int j=1;j<=capaci;j++){
                if((j-costo[i])<0){
                    costoTotal[i][j] = costoTotal[i-1][j];
                }
                else{
                    if(costoTotal[i-1][j] > (costo[i-1] + costoTotal[i-1][j-peso[i-1]])){
                        costoTotal[i][j] = costoTotal[i-1][j];
                    }
                    else{
                        costoTotal[i][j] = costo[i-1] + costoTotal[i-1][j-peso[i-1]];
                    }
                }
            }
        }
        return costoTotal;
    }
    static void imprimir(int[][]a){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                System.out.print(a[i][j]+"\t");
            }
            System.out.println("");
        }
    }
}
