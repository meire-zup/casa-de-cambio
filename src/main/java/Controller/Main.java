package Controller;

import dominio.Moeda;
import service.MoedaService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws  Exception{

        System.out.println("Code: ");
        String code = new Scanner(System.in).nextLine();
        System.out.println("Codein: ");
        String codein = new Scanner(System.in).nextLine();
        Moeda moeda = MoedaService.buscaMoeda(code, codein);
        System.out.println("Valor a ser convertido:");
        Double valor = new Scanner(System.in).nextDouble();
        System.out.println("Conversão: " + moeda.getName());
        System.out.println("Cotação do dia: " + moeda.getBid());
        System.out.println("Data da conversão: " + moeda.getCreateDate());
        System.out.println("Total convertido: " + Double.parseDouble(moeda.getBid()) * valor);
    }

}
