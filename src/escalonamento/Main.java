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

		
		System.out.println("Para SJF");
		imprimir(alg.fifo(alg.sjf(lp)));


		System.out.println();
		System.out.println();

		System.out.println("Para FIFO");
		imprimir(alg.fifo(lp2));

	}

	private static ArrayList<ProcessoService> insereDados() {

		ArrayList<ProcessoService> processos = new ArrayList<>();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		int cont = 0;
		int dado;

		while (cont != -1) {
			ProcessoService p = new ProcessoService();

			System.out.println("Adicione o tempo para o processo (Digite um valor negativo para sair");
			dado = scanner.nextInt();
			if (dado < 0)
				break;
			System.out.println("Adicione o nome do processo ");
			p.setNome(scanner.next());

			p.setTempoNecessario(dado);
			processos.add(p);

		}

		System.out.println("Finalizado!");

		return processos;

	}
	
	private static void imprimir(List<ProcessoService> lista ) {
		
		double media = 0;
		int cont = 0;
		
		System.out.println("Processo\tTempo Necessário\tTempo Turnaround\ttempo de Espera");
		for (ProcessoService p : lista) {
			
			System.out.println(p.getNome() + "\t" + p.getTempoNecessario() + "\t\t" + p.getTempoTurnaround() + "\t\t" + p.getTempoEspera() );
			
			media += p.getTempoEspera();
			cont++;
		}
		System.out.printf("Tempo médio de processamento: %.2f ", (media / cont));


	}
}
