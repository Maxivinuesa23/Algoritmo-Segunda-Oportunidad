//Realizamos las importaciones para poder manejar listas y mapeos.
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Clase que se encargara de manejar el algoritmo.
public class SegundaOportunidad {
    private int capacidadMarcos;
    private List<Pagina> marcos;
    private int punteroCircular;
    private int fallosDePagina;

    private HashMap<Integer, Integer> paginasEnMemoriaMap;

    //Este constructor se encarga de recibir por parte del usuario la capacidad que puede soportar e inicializar el arreglo en "null" (vacio)
    public  SegundaOportunidad(int capacidad){
        this.capacidadMarcos = capacidad;
        this.marcos = new ArrayList<>(capacidad);
        for (int i = 0; i < capacidad; i++){
            this.marcos.add(null); //Cargamos los marcos necesarios pero vacios.
        }
        this.punteroCircular = 0;
        this.fallosDePagina = 0;
        this.paginasEnMemoriaMap = new HashMap<>();
    }

    //Aca comienza el verdadero algoritmo, toma como parametro el id de página y el id de proceso, una vez que lo hace imprime el estado actual (vacio)
    public void referenciarPagina(int idPagina, int idProceso){
        imprimirEstadoActual();
        //Consulta si alguna página contiene el id que fue ingresado anteriormente, en caso de que el bit se encuentre se ejecuta la condición if
        if (paginasEnMemoriaMap.containsKey(idPagina)){
            int indiceMarco = paginasEnMemoriaMap.get(idPagina); //Marcamos el indice del marco como la posicion donde está el id de página.
            Pagina paginaEnMarco = marcos.get(indiceMarco); //Genera una nueva variable del tipo clase Página el cual le guarda el valor del índice del marco
            paginaEnMarco.setBitUso(true); //Marca el bit como en uso (True)
            System.out.println("HIT: Página: " + paginaEnMarco + " Ya esta en el marco: " + indiceMarco + " Bit de uso puesto a 1.");

        }
        else{
            fallosDePagina++; //Caso contrario de no entrar al if se genera un fallo de página y realiza un contador sobre la cantidad de fallos en la página
            System.out.println("Fallo de pagina: P " + idPagina + " No esta en memoria");

            int marcoLibre = -1;  //Marca la variable en -1 para referenciarlo como "no encontrado" (cumple la función de un centinela o bandera)
            for (int i = 0; i < capacidadMarcos; i++){
                if (marcos.get(i) == null){ //En caso de encontrar un marco vacio
                    marcoLibre = i; //Guarda ese índice en la variable creada anteriormente, dando a enteder que en esa posición hay un lugar libre
                    break; //Genera un break para salir del bucle antes de seguir recorriéndolo.
                }

            }
            if (marcoLibre != -1){ //En caso de haber encontrado un marco libre entra al if
                Pagina nuevaPagina = new Pagina(idPagina, idProceso); //Genera una nueva variable de tipo clase Página
                marcos.set(marcoLibre, nuevaPagina);
                paginasEnMemoriaMap.put(idPagina, marcoLibre); //Cargamos el id de la página y el marco a utilizar y lo metemos en la lista
                System.out.println("Pagina " + nuevaPagina + " cargada en el marco " + marcoLibre);

            }else{ //En caso de no haber encontrado un lugar libre buscamos una víctima
                Pagina paginaVictima = null;
                int indiceVictima = -1;
                System.out.println("Memoria llena. Buscando victima...");

                while (true){
                    paginaVictima = marcos.get(punteroCircular);

                    if (paginaVictima.getBitUso()){
                        paginaVictima.setBitUso(false);
                        System.out.println("  Página " + paginaVictima + " en marco " + punteroCircular + " tiene bit de uso 1. Dándole segunda oportunidad. Bit a 0.");
                        punteroCircular = (punteroCircular + 1) % capacidadMarcos;
                    }else{
                        indiceVictima = punteroCircular;
                        System.out.println("  Página " + paginaVictima + " en marco " + punteroCircular + " tiene bit de uso 0. Es la víctima");
                        paginasEnMemoriaMap.remove(paginaVictima.getIdPagina());
                        break;
                    }
                }
                Pagina nuevaPagina = new Pagina(idPagina, idProceso);
                marcos.set(indiceVictima, nuevaPagina);
                paginasEnMemoriaMap.put(idPagina, indiceVictima);
                System.out.println("Pagina " + nuevaPagina + " cargada en el marco " + indiceVictima);

                punteroCircular = (punteroCircular + 1) % capacidadMarcos;
            }
        }
        imprimirEstadoActual();
        System.out.println("Fallos de Página Totales: " + fallosDePagina);
    }

    public void imprimirEstadoActual(){
        System.out.println("Estado de marcos");
        for (int i = 0; i < capacidadMarcos; i++){
            if (marcos.get(i) != null){
                System.out.println(marcos.get(i));
            }else{
                System.out.println("VACIO");
            }
            if (i < capacidadMarcos -1){
                System.out.println(", ");
            }
        }
        System.out.println("] Puntero: " + punteroCircular);
    }

    public int getFallosDePagina() {
        return fallosDePagina;
    }


}
