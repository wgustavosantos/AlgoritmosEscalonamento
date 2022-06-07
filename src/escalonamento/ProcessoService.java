package escalonamento;

/**
 *
 * @author Wenderson, Leandro & Taylor
 */
public class ProcessoService implements Comparable<ProcessoService> {
    private int id;
    private String nome;
    private int tempoNecessario;
    private int tempoTurnaround;
    private int tempoEspera;

    public ProcessoService(){
    }

    public ProcessoService(int id, String nome,  int tempoNecessario) {
        this.id = id;
        this.nome = nome;
        this.tempoNecessario = tempoNecessario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTempoTurnaround() {
        return tempoTurnaround;
    }

    public void setTempoTurnaround(int tempoTurnaround) {
        this.tempoTurnaround = tempoTurnaround;
    }

    public int getTempoNecessario() {
        return tempoNecessario;
    }

    public void setTempoNecessario(int tempoNecessario) {
        this.tempoNecessario = tempoNecessario;
    }

    public int getTempoEspera() {
        return tempoEspera;
    }


    public void setTempoEspera(int tempoEspera) {
        this.tempoEspera = tempoEspera;
    }

    @Override
    public int compareTo(ProcessoService p) {
        if(this.getId() < p.getId()){
            return -1;
        }
        if(this.getId() > p.getId()){
            return 1;
        }
        return 0;
    }
    
    
}
