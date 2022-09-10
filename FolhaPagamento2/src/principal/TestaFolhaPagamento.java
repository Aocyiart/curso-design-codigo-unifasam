package principal;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

import model.Pessoa;
import service.CalculaSalario;
import service.TipoCargo;

public class TestaFolhaPagamento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner entrada = new Scanner(System.in)) {
			
			System.out.println("Informe o salário bruto: ");
			BigDecimal salarioBruto = entrada.nextBigDecimal();
			
			System.out.println("Informe o cargo: \n 1 - COORDENADOR\n 2 - DIRETOR\n 3 - PROFESSOR");
			int opcaoCargo = entrada.nextInt();
			TipoCargo tipoCargo = TipoCargo.values()[opcaoCargo - 1];
			
			CalculaSalario calculaSalario = tipoCargo.getCargo();
			
//			Pessoa pessoaBuilder = new Pessoa.Builder()
//					.nome("Matheus")
//					.cargo(tipoCargo)
//					.dataAdmissao(LocalDate.now())
//					.salarioBruto(salarioBruto)
//					.build();100
			
//			Pessoa pessoa = new Pessoa(
//					"João",
//					tipoCargo,
//					LocalDate.of(2000, 1, 11),
//					LocalDate.now(),
//					22,
//					salarioBruto,
//					BigDecimal.ZERO);
			
			Pessoa pessoaBuilder = new Pessoa.Builder()
					.nome("Matheus")
					.cargo(tipoCargo)
					.salarioBruto(salarioBruto)
					.dataAdmissao(LocalDate.now())
					.build();
			
			Pessoa pessoaPagar = calculaSalario.calcularSalarioLiquido(pessoaBuilder);
			System.out.printf("O Salário líquido do "
					.concat(pessoaPagar.getNome())
					.concat(" com o cargo: ")
					.concat(pessoaPagar.getCargo().name())
					.concat("é R$%.2f"),
					pessoaPagar.getSalarioLiquido());
		}
	}

}
