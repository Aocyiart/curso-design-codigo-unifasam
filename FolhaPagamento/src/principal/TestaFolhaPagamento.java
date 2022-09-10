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
			
			System.out.println("Informe o sal�rio bruto: ");
			BigDecimal salarioBruto = entrada.nextBigDecimal();
			
			System.out.println("Informe o cargo: \n 1 - COORDENADOR\n 2 - DIRETOR\n 3 - PROFESSOR");
			int opcaoCargo = entrada.nextInt();
			TipoCargo tipoCargo = TipoCargo.values()[opcaoCargo - 1];
			
			CalculaSalario calculaSalario = new CalculaSalario(tipoCargo);
			
			Pessoa pessoa = new Pessoa(
					"Jo�o",
					tipoCargo,
					LocalDate.of(2000, 1, 11),
					LocalDate.now(),
					22,
					salarioBruto,
					BigDecimal.ZERO);
			
			Pessoa pessoaPagar = calculaSalario.calcularSalarioLiquido(pessoa);
			System.out.printf("O Sal�rio l�quido do "
					.concat(pessoaPagar.getNome())
					.concat(" com o cargo: ")
					.concat(pessoaPagar.getCargo().name())
					.concat("� R$%.2f"),
					pessoaPagar.getSalarioLiquido());
		}
	}

}
