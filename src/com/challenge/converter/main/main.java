package com.challenge.converter.main;

import com.challenge.converter.models.CurrencyExchangeRate;
import com.challenge.converter.models.QueryCurrency;

import java.util.Scanner;

public class main {
    public static String message(double value, String inputCurrency, double finalValue, String outputCurrency){
        return "El valor "+value+" ["+inputCurrency+"] corresponde al valor final de => "+finalValue+" ["+outputCurrency+"]";
    }

    public static void main(String[] args) {
        int option = 0;
        double value = 0.0;
        String inputCurrency = "";
        String outputCurrency = "";
        String menu = """
                ********************************************
                Sea bienvenido/a al Conversor de Moneda
                
                1) Dólar => Peso argentino
                2) Peso argentino => Dólar
                3) Dólar => Real brasileño
                4) Real brasileño => Dólar
                5) Dólar => Peso colombiano
                6) Peso colombiano => Dólar
                7) Salir
                Elija una opcíon válida:
                ********************************************
                """;

        Scanner keyboard = new Scanner(System.in);
        QueryCurrency queryCurrency = new QueryCurrency();

        while (option != 7){
            System.out.println(menu);
            try {
                option = keyboard.nextInt();
            } catch (Exception e) {
                keyboard.nextLine();
                option = 0;
            }

            if(option < 7 && option > 0){
                System.out.println("Ingrese el valor que deseas convertir: ");
                try {
                    value = Double.valueOf(keyboard.nextDouble());
                } catch (Exception e) {
                    keyboard.nextLine();
                    value = 0.0;
                }
            }

            switch (option){
                case 1:
                    inputCurrency = "USD";
                    outputCurrency = "ARS";
                    break;
                case 2:
                    inputCurrency = "ARS";
                    outputCurrency = "USD";
                    break;
                case 3:
                    inputCurrency = "USD";
                    outputCurrency = "BRL";
                    break;
                case 4:
                    inputCurrency = "BRL";
                    outputCurrency = "USD";
                    break;
                case 5:
                    inputCurrency = "USD";
                    outputCurrency = "COP";
                    break;
                case 6:
                    inputCurrency = "COP";
                    outputCurrency = "USD";
                    break;
                case 7:
                    System.out.println("Finalizando el programa. Muchas gracias por usar nuestros servicios");
                    inputCurrency = "";
                    outputCurrency = "";
                    break;
                default:
                    System.out.println("Opción inválida");
                    inputCurrency = "";
                    outputCurrency = "";
                    break;
            }
            if(inputCurrency != "" && outputCurrency != "") {
                CurrencyExchangeRate currencyConversionResult = queryCurrency.getCurrency(inputCurrency,outputCurrency,value);
                double conversionResult = Double.valueOf(currencyConversionResult.conversion_result());
                String messageFinal = message(value,inputCurrency,conversionResult,outputCurrency);
                System.out.println(messageFinal);
            }
        }
    }
}
