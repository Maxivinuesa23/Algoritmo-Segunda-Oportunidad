public class Main {
    public static void main(String[] args) {
        SegundaOportunidad simulador = new SegundaOportunidad(3);

        System.out.println("---------------------------------------------");
        System.out.println(" ");
        simulador.referenciarPagina(10, 1); // P1-Pag10
        System.out.println("---------------------------------------------");
        System.out.println(" ");
        simulador.referenciarPagina(20, 2); // P2-Pag20
        System.out.println("---------------------------------------------");
        System.out.println(" ");
        simulador.referenciarPagina(30, 3); // P3-Pag30
        System.out.println("---------------------------------------------");
        System.out.println(" ");

        simulador.referenciarPagina(10, 1);
        System.out.println("---------------------------------------------");
        System.out.println(" ");
        simulador.referenciarPagina(40, 4);


        simulador.referenciarPagina(20, 2);


        simulador.referenciarPagina(10, 1);
        simulador.referenciarPagina(50, 5);

        }
    }