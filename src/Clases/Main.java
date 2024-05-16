package Clases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import Clases.Nota;
import Clases.Escala;

public class Main {

    public static void main(String[] args) {
        Nota[] notas = {
            new Nota(1, "DO"),
            new Nota(2, "Do#"),
            new Nota(3, "RE"),
            new Nota(4, "RE#"),
            new Nota(5, "MI"),
            new Nota(6, "FA"),
            new Nota(7, "FA#"),
            new Nota(8, "SOL"),
            new Nota(9, "SOL#"),
            new Nota(10, "LA"),
            new Nota(11, "LA#"),
            new Nota(12, "SI")
        };

        List<Integer> progresion = List.of(2, 2, 1, 2, 2, 2, 1);
        List<Integer> circuloQuintas = List.of(0, 5, 7, 2, 9);

        Escala escalaMayor = new Escala(Arrays.asList(notas), progresion, "Mayor", 1);

        Scanner scanner = new Scanner(System.in);
        System.out.println("¿De qué nota quieres la escala?");
        String notaInicial = scanner.nextLine();

        List<Nota> notasEscala = escalaMayor.getNotas();
        List<Integer> progresionEscala = escalaMayor.getProgresion();

        String[] escalaMayorGenerada = generarEscala(notasEscala, notaInicial, progresionEscala);
        List<String> acordesCirculoQuintas = generarAcordesCirculoQuintas(notasEscala, notaInicial, circuloQuintas);

        System.out.println("--------------------------------------------------");

        if (escalaMayorGenerada != null) {
            System.out.println("La escala Mayor de " + notaInicial + " es:");
            for (String nota : escalaMayorGenerada) {
                System.out.print(nota + " ");
            }
        } else {
            System.out.println("La nota inicial no es válida para la escala mayor.");
        }

        System.out.println("\n--------------------------------------------------");

        if (acordesCirculoQuintas != null) {
            System.out.println("Los acordes del círculo de " + notaInicial + " son:");
            for (String acorde : acordesCirculoQuintas) {
                System.out.print(acorde + " ");
            }
            System.out.println("\n--------------------------------------------------");
            System.out.println("\n");
        } else {
            System.out.println("La nota inicial no es válida para los acordes del círculo de quintas.");
        }
    }

    public static String[] generarEscala(List<Nota> notas, String notaInicial, List<Integer> progresion) {
        String[] escala = new String[progresion.size() + 1];

        // Encontrar la posición inicial de la nota
        int posInicial = -1;
        for (Nota nota : notas) {
            if (nota.getNombre().equalsIgnoreCase(notaInicial)) {
                posInicial = nota.getNumero() - 1;
                break;
            }
        }

        if (posInicial == -1) {
            return null;
        }

        escala[0] = notas.get(posInicial).getNombre();
        int posicionActual = posInicial;
        for (int i = 0; i < progresion.size(); i++) {
            posicionActual += progresion.get(i);
            if (posicionActual >= notas.size()) {
                posicionActual -= notas.size();
            }
            escala[i + 1] = notas.get(posicionActual).getNombre();
        }

        return escala;
    }

    public static List<String> generarAcordesCirculoQuintas(List<Nota> notas, String notaInicial, List<Integer> circuloQuintas) {
        List<String> acordes = new ArrayList<>();

        int posInicial = -1;
        for (Nota nota : notas) {
            if (nota.getNombre().equalsIgnoreCase(notaInicial)) {
                posInicial = nota.getNumero() - 1;
                break;
            }
        }

        if (posInicial == -1) {
            return null;
        }

        for (int indice : circuloQuintas) {
            int posicionActual = (posInicial + indice) % notas.size();
            String acorde = notas.get(posicionActual).getNombre();
            if (indice == 2 || indice == 9) {
                acorde += "m";
            }
            acordes.add(acorde);
        }

        return acordes;
    }
}
