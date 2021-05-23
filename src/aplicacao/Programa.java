package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Funcionario;
import entidades.FuncionarioTerceirizado;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Funcionario> list = new ArrayList<>();
		
		System.out.print("Informe o numero de funcionarios: ");
		int num = sc.nextInt();
		
		for (int i=1; i<=num; i++) {
			System.out.println("Dados do " + i + "º funcionario: ");
			System.out.print("O funcionairo é terceirizado (s/n) ?  ");
			char res = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			System.out.print("Horas: ");
			Integer horas = sc.nextInt();
			System.out.print("Valor por hora: ");
			Double valorPorHoras = sc.nextDouble();
			if (res == 's') {
				System.out.print("Cobrança adicional: ");
				Double cobrancaAdicional = sc.nextDouble();
				list.add(new FuncionarioTerceirizado(nome, horas, valorPorHoras, cobrancaAdicional));
			} else {
				list.add(new Funcionario(nome, horas, valorPorHoras));
			}
			
		}
		
		System.out.println();
		System.out.println("PAGAMENTOS: ");
		for (Funcionario f : list) {
			System.out.println(f.getNome() + " - $ " + String.format("%.2f", f.pagamento()));
		}
		

		sc.close();
	}

}
