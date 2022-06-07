package escalonamento;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Wenderson, Leandro & Taylor
 */
public class Main {

    public static void main(String[] args) {

        FifoeSJF alg = new FifoeSJF();
        
        System.out.println("****ALGORITMO FIFO****");
        ArrayList<ProcessoService> lp = insereDados();
        
        System.out.println("****ALGORITMO SJF****");
        ArrayList<ProcessoService> lp2 = insereDados();

        
        ArrayList<ProcessoService> listaSjf = alg.sjf(lp);
        System.out.println("Para SJF");
        for(ProcessoService p : listaSjf){
            System.out.println("Processo: " + p.getNome() + " - Tempo necessario: " + p.getTempoNecessario() +
                    " Tempo Turnaround: " + p.getTempoTurnaround() + 
                    " Tempo de espera: " + p.getTempoEspera());
        }
        System.out.println();
        System.out.println();
        
        System.out.println("Para FIFO");
        ArrayList<ProcessoService> listaFifo = alg.fifo(lp2);
        for(ProcessoService p : listaFifo){
            System.out.println("Processo: " + p.getNome() + " - Tempo necessario: " + p.getTempoNecessario() +
                    " Tempo Turnaround: " + p.getTempoTurnaround() + 
                    " Tempo de espera: " + p.getTempoEspera());
        }
        
        
    }
    
    private static ArrayList<ProcessoService> insereDados() {
    	
    	ArrayList<ProcessoService> processos  = new ArrayList<>();
    	@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		int cont = 0;
		int dado;

		while(cont != -1) {
			ProcessoService p = new ProcessoService();
			
			System.out.println("Adicione o tempo para o processo (Digite um valor negativo para sair");
			dado = scanner.nextInt();
			if(dado < 0)
				break;
			System.out.println("Adicione o nome do processo ");
    		p.setNome(scanner.next());
			
			p.setTempoNecessario(dado);
			processos.add(p);
			
		}
		
		System.out.println("Finalizado!");
    	   	   	
    	 return processos;
    	
    }
}
