import java.util.Random;
import java.util.Scanner;

public class JuegoAhorcado {

    /**
     * Constructor for objects of class JuegoAhorcado
     */
    public JuegoAhorcado() {

    }

    public void iniciarJuego() {
        boolean adivinada = false;
        int puntuacion = 1000;

        Scanner sc = new Scanner(System.in);
        String[] palabras = {"Armario", "Mueble", "Radiador", "Estufa", "Enchufe", "Mesa", "Ordenador", "Radiocasette", "Libro", "Madrid"};
        Random r = new Random();
        int indicePalabra = r.nextInt(palabras.length);
        String palabraElegida = palabras[indicePalabra];
        //Hasta aqui el juego elige la palabra a adivinar

        while (adivinada == false) {
            System.out.println("Introduce una letra (1) o intenta probar suerte (2)");
            int eleccion = sc.nextInt();
            if (eleccion == 1) {

                System.out.println("Introduce la letra");
                String letra = sc.next();
                if (!(letra.length() == 1)) {
                    System.out.println("Error, solo una letra");
                    letra = sc.nextLine();
                } else {
                    if (palabraElegida.contains(letra)) {
                        System.out.println("Correcto, la letra " + letra + " esta en la palabra elegida");
                    } else {
                        System.out.println("MUAHAHAHAHA, ESA LETRA NO ESTA");
                        puntuacion =puntuacion -10;
                    }
                }

            }
            if (eleccion == 2) {
                System.out.println("Introduce la palabra, si fallas perderas vida");
                String palabra = sc.next();
                if (palabra.equals(palabraElegida.toLowerCase())) {
                    System.out.println("ENHORABUENA,HAS ACERTADO LA PALABRA,HAS GANADO");
                    System.out.println("TU PUNTUACION ES " + puntuacion);
                    adivinada=true;
                }
                else{
                    System.out.println("Error");
                    puntuacion = puntuacion-10;
                }
            }
        }
    }
}
