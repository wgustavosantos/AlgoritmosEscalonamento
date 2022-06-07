package escalonamento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Wenderson, Leandro & Taylor
 */
public class FifoeSJF implements Comparator<ProcessoService> {

    public ArrayList<ProcessoService> fifo(ArrayList<ProcessoService> p) {
        ArrayList<ProcessoService> listaFifo = new ArrayList<>();

        int tempoEspera = 0;
        for (ProcessoService p1 : p) {
            p1.setTempoEspera(tempoEspera);
            tempoEspera = tempoEspera + p1.getTempoNecessario();
            p1.setTempoTurnaround(tempoEspera);
            listaFifo.add(p1);
        }
        return listaFifo;
    }

    public ArrayList<ProcessoService> sjf(ArrayList<ProcessoService> p) {
        ArrayList<ProcessoService> listaSjf = new ArrayList<>();
        Collections.sort(p, new FifoeSJF());
        int tempoEspera = 0;
        for (ProcessoService p1 : p) {
            p1.setTempoEspera(tempoEspera);
            tempoEspera = tempoEspera + p1.getTempoNecessario();
            p1.setTempoTurnaround(tempoEspera);
            listaSjf.add(p1);
        }
        Collections.sort(listaSjf, new FifoeSJF());
        return listaSjf;
    }
    

    @Override
    public int compare(ProcessoService p1, ProcessoService p2) {
        if (p1.getTempoNecessario() < p2.getTempoNecessario()) {
            return -1;
        }
        if (p1.getTempoNecessario() > p2.getTempoNecessario()) {
            return 1;
        }
        return 0;
    }
}
