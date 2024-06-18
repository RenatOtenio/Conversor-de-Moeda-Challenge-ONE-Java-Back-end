package menu;

import conversorApi.Conversor;
import conversorApi.ConversorApi;

import java.util.Scanner;

public class Menu {
    Scanner escolha = new Scanner(System.in);

    public void menu(){
        boolean exibeMenu = true;
        while (exibeMenu){
            System.out.println("""
                ______________________________________________________
                Bem vindo ao Conversor de Moeda !
                
                Escolha a moeda a ser convertida:
                ------------------------------------------------------

                        1) [USD] => [BRL]
                        2) [EUR] => [BRL]
                        3) [ARS] => [BRL]
                        4) [BRL] => [USD]
                        5) [BRL] => [EUR]
                        6) [BRL] => [ARS]
                        0) Sair
                ______________________________________________________
                """);

            System.out.println("Escolha uma opção de conversão:");
            String opcao = escolha.next();

            switch (opcao){
                case "1":
                    this.converter("USD","BRL");
                    break;

                case "2":
                    this.converter("EUR","BRL");
                    break;

                case "3":
                    this.converter("ARS","BRL");
                    break;

                case "4":
                    this.converter("BRL","USD" );
                    break;

                case "5":
                    this.converter("BRL","EUR");
                    break;

                case "6":
                    this.converter("BRL","ARS" );
                    break;

                default:
                    if (opcao.equals("0")){
                        System.out.println("Obrigado !!");
                        exibeMenu = false;
                    }else {
                        System.out.println("Opção Inválida ! " +
                                "Selecione uma opção valida, ou, Opção \"7\" para sair. ");
                    }
                    break;
            }
        }
    }

    public void converter (String base_code, String target_code){
        System.out.println("Informe um valor para conversão: ");
        try {
            double valor = this.escolha.nextDouble();
            Conversor conversor = new Conversor(base_code, target_code, valor);
            ConversorApi api = new ConversorApi(conversor);
            System.out.println(api.chamadaApi());
        } catch (Exception e) {
            System.out.println("Valor digitado é inválido... Utilize ',' para converter numeros decimais.");
        }

    }
}