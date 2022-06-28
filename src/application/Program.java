package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Renda anual com salário: ");
		double salaryIncome = sc.nextDouble();
		System.out.print("Renda anual com prestação de serviço: ");
		double serviceIncome = sc.nextDouble();
		System.out.print("Renda anual com ganho de capital: ");
		double cg = sc.nextDouble();
		System.out.print("Gastos médicos: ");
		double medical = sc.nextDouble();
		System.out.print("Gastos educacionais: ");
		double education = sc.nextDouble();

		double salaryTax;
		double seviceTax = 0.0;
		double cgTax = 0.0;
		
		if ((salaryIncome / 12.0) < 3000.00) {
			salaryTax = 0.0;
		} else if ((salaryIncome / 12.0) < 5000.00) {
			salaryTax = salaryIncome * 0.10;
		} else {
			salaryTax = salaryIncome * 0.20;
		}
		if (serviceIncome > 0) {
			seviceTax = serviceIncome * 0.15;
		}
		if (cg > 0) {
			cgTax = cg * 0.20;
		}
		double grossTax = salaryTax + seviceTax + cgTax;
		double rebate = education + medical, spentDedu = education + medical;
		double maxDedu = grossTax * 0.30;
		if (maxDedu <= rebate) {
			rebate = maxDedu;
		}
		double payableTax = grossTax - rebate;

		System.out.println();
		System.out.println("RELATÓRIO DE IMPOSTO DE RENDA");
		System.out.println();
		System.out.println("CONSOLIDADO DE RENDA:");
		System.out.printf("Imposto sobre salário: %.2f %n", salaryTax);
		System.out.printf("Imposto sobre serviços: %.2f %n", seviceTax);
		System.out.printf("Imposto sobre ganho de capital: %.2f %n", cgTax);
		System.out.println();
		System.out.println("DEDUÇÕES:");
		System.out.printf("Máximo dedutível: %.2f %n", maxDedu);
		System.out.printf("Gastos dedutíveis: %.2f %n", spentDedu);
		System.out.println();
		System.out.println("RESUMO:");
		System.out.printf("Imposto bruto total: %.2f %n", grossTax);
		System.out.printf("Abatimento: %.2f %n", rebate);
		System.out.printf("Imposto devido: %.2f %n", payableTax);

		sc.close();
	}

}
