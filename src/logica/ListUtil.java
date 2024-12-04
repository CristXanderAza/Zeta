package logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class ListUtil {
    public static <T> List<T> combinarYOrdenarPorFecha(List<T> lista1, List<T> lista2, Comparator<T> comparador) {
        // Combinar ambas listas
        List<T> listaCombinada = new ArrayList<>(lista1);
        listaCombinada.addAll(lista2);

        // Ordenar la lista combinada usando el comparador proporcionado
        Collections.sort(listaCombinada, comparador);

        return listaCombinada;
    }
}
