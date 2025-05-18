package br.com.gritti.application;

import br.com.gritti.interfaces.TextUserInterface;

import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException, InterruptedException {
    TextUserInterface ui = new TextUserInterface();
    ui.start();
  }
}