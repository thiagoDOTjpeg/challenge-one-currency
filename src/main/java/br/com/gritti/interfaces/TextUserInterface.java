
package br.com.gritti.interfaces;

import br.com.gritti.entities.responses.ConvertedResponse;
import br.com.gritti.service.CurrencyExchangeService;
import com.google.gson.Gson;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class TextUserInterface {
  private final CurrencyExchangeService service;
  private final Scanner scanner;
  private final Gson gson;
  private boolean running;

  private final String[] supportedCurrencies = {
          "USD", "EUR", "JPY", "GBP", "CNY", "AUD", "CAD", "CHF", "HKD", "SGD",
          "SEK", "NZD", "INR", "BRL", "RUB", "KRW", "ZAR", "MXN", "PLN", "TRY",
          "SAR", "AED", "NOK", "DKK", "ILS", "THB", "PHP", "IDR", "MYR", "TWD"
  };

  public TextUserInterface() {
    this.service = new CurrencyExchangeService();
    this.scanner = new Scanner(System.in);
    this.gson = new Gson();
    this.running = true;
  }

  public void start() {
    showWelcomeMessage();

    while (running) {
      showMainMenu();
      int option = readIntOption();

      processMainMenuOption(option);
    }

    scanner.close();
    System.out.println("\nObrigado por usar o Conversor de Moedas!");
  }

  private void showWelcomeMessage() {
    System.out.println("======================================");
    System.out.println("=     CONVERSOR DE MOEDAS v1.0      =");
    System.out.println("======================================");
    System.out.println("\nBem-vindo ao Conversor de Moedas!");
    System.out.println("Este aplicativo permite converter valores entre diferentes moedas.");
  }

  private void showMainMenu() {
    System.out.println("\n======== MENU PRINCIPAL ========");
    System.out.println("1. Converter moedas");
    System.out.println("2. Ver moedas suportadas");
    System.out.println("3. Histórico de conversões");
    System.out.println("0. Sair");
    System.out.print("\nEscolha uma opção: ");
  }

  private int readIntOption() {
    try {
      return Integer.parseInt(scanner.nextLine());
    } catch (NumberFormatException e) {
      return -1;
    }
  }

  private void processMainMenuOption(int option) {
    switch (option) {
      case 0:
        running = false;
        break;
      case 1:
        showCurrencyConversionMenu();
        break;
      case 2:
        showSupportedCurrencies();
        break;
      case 3:
        showConversionHistory();
        break;
      default:
        System.out.println("\nOpção inválida. Por favor, tente novamente.");
    }
  }

  private void showCurrencyConversionMenu() {
    System.out.println("\n==== CONVERSÃO DE MOEDAS ====");

    System.out.print("Digite a moeda de origem (ex: BRL): ");
    String fromCurrency = scanner.nextLine().toUpperCase();

    System.out.print("Digite a moeda de destino (ex: USD): ");
    String toCurrency = scanner.nextLine().toUpperCase();

    System.out.print("Digite o valor a ser convertido: ");
    double amount;
    try {
      amount = Double.parseDouble(scanner.nextLine().replace(",", "."));
    } catch (NumberFormatException e) {
      System.out.println("\nValor inválido. Voltando ao menu principal.");
      return;
    }

    try {
      String jsonResponse = service.getConvertionRateFrom(fromCurrency, toCurrency, amount);
      ConvertedResponse response = gson.fromJson(jsonResponse, ConvertedResponse.class);
      displayConversionResult(response);
    } catch (IOException | InterruptedException e) {
      System.out.println("\nErro na conversão: " + e.getMessage());
      System.out.println("Verifique se as moedas estão corretas e tente novamente.");
    }
  }

  private void displayConversionResult(ConvertedResponse response) {
    NumberFormat formatter = new DecimalFormat("#,##0.00");

    System.out.println("\n==== RESULTADO DA CONVERSÃO ====");
    System.out.println("Valor original: " + formatter.format(response.getAmount()) + " " + response.getBase_currency());
    System.out.println("Taxa de conversão: 1 " + response.getBase_currency() + " = " +
            formatter.format(response.getConversion_rate()) + " " + response.getTarget_currency());
    System.out.println("Valor convertido: " + formatter.format(response.getConverted_amount()) + " " + response.getTarget_currency());
  }

  private void showSupportedCurrencies() {
    System.out.println("\n==== MOEDAS SUPORTADAS ====");
    System.out.println("Códigos das principais moedas:");

    int count = 0;
    for (String currency : supportedCurrencies) {
      System.out.print(currency + "\t");
      count++;
      if (count % 5 == 0) {
        System.out.println();
      }
    }

    System.out.println("\n\nPressione ENTER para voltar ao menu principal...");
    scanner.nextLine();
  }

  private void showConversionHistory() {
    System.out.println("\n==== HISTÓRICO DE CONVERSÕES ====");

    var history = service.getHistory();

    if (history.isEmpty()) {
      System.out.println("Nenhuma conversão realizada ainda.");
    } else {
      NumberFormat formatter = new DecimalFormat("#,##0.00");
      SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

      System.out.println("Suas últimas " + history.size() + " conversões:\n");
      System.out.println("Data                | De    | Para   | Valor Original | Valor Convertido");
      System.out.println("--------------------|-------|--------|----------------|------------------");

      for (Map.Entry<Date, ConvertedResponse> entry : history) {
        Date date = entry.getKey();
        ConvertedResponse conv = entry.getValue();

        System.out.printf("%-19s | %-5s | %-6s | %-14s | %-16s\n",
                dateFormat.format(date),
                conv.getBase_currency(),
                conv.getTarget_currency(),
                formatter.format(conv.getAmount()) + " " + conv.getBase_currency(),
                formatter.format(conv.getConverted_amount()) + " " + conv.getTarget_currency());
      }
    }

    System.out.println("\nPressione ENTER para voltar ao menu principal...");
    scanner.nextLine();
  }
}