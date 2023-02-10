import java.io.*;
import java.util.Scanner;;

public class App {

    public static double[] inputs = new double[195];
    public static double[] NewWeights = new double[195];
    public static double[] n = new double[15];
    public static double beta = ( 0.7 * Math.pow(15.0, (1.0 /  10.0)));

    //take the numbers from the file to save them in array
    public static void matrixCreator() throws Exception {
        Scanner sc = new Scanner(new File("D:\\ESCUELA\\REDES NEURONALES\\Red-neuronal-inicializador-pesos\\Red-neuronal-inicializador-pesos\\Hoja de cálculo sin título - Hoja 1.csv"));
        for(int i = 0; i < 195; i++){
            inputs[i] = Double.parseDouble(sc.next());
        }
    }

    public static void frecuenciCalc( double[] Weights ) {
        System.out.println();
        System.out.println("     w     |   f   ");
        for( double i = -10; i <= 10 ; i++ ){
            int cont = 0;
            for(int x = 0; x < 195; x++){
                if( (i/10) == Weights[x] ){
                    cont++;
                }
            }
            System.out.println("    "+ (i/10) +"   |   " + cont);
        }
    }

    public static void EuclidianNorm(){
        for(int i = 0; i < 150; i+=10){
            double sum = 0;
            for(int z = i; z < (i + 10); z++){
                sum += Math.pow(inputs[z], 2);
            }
            sum = Math.sqrt(sum);
            n[ (i/10) ] = sum;
        }
    }

    public static void newWeight(){
        int c = 0;
        for(int i = 0; i < 15; i++){
            for(int z = (i * 10); z < ((i+1) * 10); z++){
                c++;
                NewWeights[z] = ( beta * inputs[z]) / n[i];
            }
        }

        for(int i = 150; i < 195; i++){
            c++;
            NewWeights[i] = inputs[i];
        }
    }

    public static void main(String[] args) throws Exception {
        matrixCreator();
        System.out.println();
        System.out.print("    BEFORE NGUYEN-WIDROW         ");
        frecuenciCalc(inputs);
        EuclidianNorm();
        newWeight();
        System.out.println();
        System.out.print("    AFTER NGUYEN-WIDROW         ");
        frecuenciCalc(NewWeights);
    }
}
