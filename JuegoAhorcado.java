import java.util.Random;
import java.util.Scanner;

public class JuegoAhorcado {

    static final int BONUS = 6;

    public JuegoAhorcado() {

    }


    public void iniciarJuego() {
        boolean finalJuego = false;
        int vida = 6;

        Scanner sc = new Scanner(System.in);
        String[] palabras = {"Armario", "Mueble", "Radiador", "Estufa", "Enchufe", "Mesa", "Ordenador", "Radiocasette", "Libro", "Madrid"};
        Random r = new Random();
        int indicePalabra = r.nextInt(palabras.length);
        String palabraElegida = palabras[indicePalabra];
        int tamaño = palabraElegida.length();
        char[] palabraFinal = new char[tamaño];
        for (int i = 0; i < tamaño; i++) {
            palabraFinal[i] = '*';
        }
        //Hasta aqui el programa se enccarga de generar un una palabra escogida aleatoriamente de las del array
        //a su vez, se genera un array de elementos char, con el tamaño exactoque de caracteresque lapalabra esogida
        //y los rellena con asteriscos. Ahora entramos en el juego

        while (finalJuego == false || vida == 0) {//Se nos permite elegir si introducir una letra ointentar adivinar la palabra
            System.out.println("\nIntroduce una letra (1) o intenta probar suerte (2)");
            int eleccion = sc.nextInt();
            if (eleccion == 1) {
                // introducimos una letra mediante el escaner
                System.out.println("Introduce la letra");
                String letra = sc.next();
                
                //El programa comparala letracon la palabra y si la palabra contiene la letra elegida, 
                //se muestra por pantalla la palabra cubierta por asteriscos, sustituidos por la o las letras correctas;
                if (palabraElegida.contains(letra)) {

                    System.out.println("Correcto, esta letra esta en la palabra");

                    for (int i = 0; i < tamaño; i++) {//se sustituye en el array de char, las letras que coinciden en la palabra
                        if (palabraElegida.charAt(i) == letra.charAt(0)) {
                            palabraFinal[i] = letra.charAt(0);
                        }
                    }
                    for (int i = 0; i < tamaño; i++) {
                        System.out.print("__" + palabraFinal[i] + "__  ");
                    }
                } else {//En caso de que no exista la letra elegida en la palabra ,se pierde una vida
                    
                    vida--;
                    System.out.println("Te quedan " + vida + " vidas");
                    if (vida == 0) {//En caso de llegar a 0,se termina eljuego con derrota
                        System.out.println("HAS PERDIDO, SE ACABO EL JUEGO");
                    }
                }

            }
            if (eleccion == 2) {//ya sabemos la palabra y queremos acetarla y ganar el bonus
                System.out.println("Introduce la palabra, si fallas perderas vida");
                String palabra = sc.next();
                //si la palabra es correcta , nos muestra un mensaje de victoria por pantalla
                //junto con la puntuacion del jugador (la vida con la que termina + el bonus)
                if (palabra.equals(palabraElegida.toLowerCase())) {
                    
                    vida = vida + BONUS;
                    System.out.println("ENHORABUENA,HAS ACERTADO LA PALABRA,HAS GANADO");
                    System.out.println("TU PUNTUACION ES " + vida);
                    

                    //si es incorrecta, seresta vida y se continua jugando hasta que llega a 0
                    
                } else {
                    
                    System.out.println("Has fallado,perderás vida");
                    vida = vida - 1;
                    //si llega a 0 la vida, el juego se termina con derrota
                    if (vida == 0) {
                        finalJuego = true;
                        System.out.println("SE ACABÓ EL JUEGO, HAS PERDIDO");
                    }
                }
            }
        }

    }
}
