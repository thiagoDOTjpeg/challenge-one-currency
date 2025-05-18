# Conversor de Moedas - Desafio Alura Oracle ONE

![Badge em Desenvolvimento](https://img.shields.io/badge/status-desenvolvido-green)
![Badge Java](https://img.shields.io/badge/linguagem-Java-red)
![Badge Licença](https://img.shields.io/badge/licença-MIT-blue)

## 📝 Descrição

Este projeto é um Conversor de Moedas desenvolvido como parte do Desafio da Alura Oracle ONE. Ele permite aos usuários converter valores entre 30 diferentes moedas internacionais utilizando uma API de taxas de câmbio em tempo real.

A aplicação oferece uma interface textual de console intuitiva, facilitando a navegação e conversão de valores monetários com taxas atualizadas.

## 🚀 Funcionalidades

- **Conversão entre diferentes moedas**: Converta valores entre 30 moedas internacionais
- **Taxas de câmbio em tempo real**: Utiliza a ExchangeRate API para obter taxas atualizadas
- **Interface textual amigável**: Menu intuitivo com navegação simples
- **Formatação de valores**: Exibe os valores monetários formatados com 2 casas decimais
- **Visualização de moedas suportadas**: Consulta rápida de todas as moedas disponíveis

## 📁 Estrutura do Projeto
``` 
currency-exchange/
├── .idea/                  # Configurações da IDE IntelliJ
├── .mvn/                   # Configurações do Maven Wrapper
├── src/                    # Código-fonte do projeto
│   ├── main/
│   │   ├── java/
│   │   │   └── br/
│   │   │       └── com/
│   │   │           └── gritti/
│   │   │               ├── application/
│   │   │               │   └── Main.java                      # Classe principal da aplicação
│   │   │               ├── entities/
│   │   │               │   ├── apiresponse/                   # Classes para respostas da API
│   │   │               │   │   ├── AllConvertionRateResponse.java
│   │   │               │   │   ├── BaseResponse.java
│   │   │               │   │   └── PairConvertionRateResponse.java
│   │   │               │   └── responses/                     # Classes para respostas internas da aplicação
│   │   │               │       └── ConvertedResponse.java
│   │   │               ├── interfaces/
│   │   │               │   └── TextUserInterface.java         # Interface de usuário baseada em texto
│   │   │               └── service/
│   │   │                   └── CurrencyExchangeService.java   # Serviço responsável pelas requisições à API
│   │   └── resources/                                         # Recursos da aplicação
│   └── test/                                                  # Testes unitários e de integração
├── target/                                                    # Arquivos compilados (gerado pelo Maven)
├── .env                                                       # Variáveis de ambiente (chaves da API)
├── .gitignore                                                 # Configuração de arquivos ignorados pelo Git
├── LICENSE                                                    # Arquivo de licença do projeto
├── pom.xml                                                    # Configuração do Maven (dependências e build)
└── readme.md                                                  # Documentação do projeto
```



## 🛠️ Tecnologias Utilizadas

- **Java 23**: Linguagem principal do projeto
- **Maven**: Gerenciamento de dependências e build
- **Gson**: Biblioteca para processamento de JSON
- **dotenv-java**: Para gerenciamento de variáveis de ambiente e segurança da API
- **ExchangeRate API**: API externa para obtenção das taxas de câmbio
- **IntelliJ IDEA**: IDE utilizada no desenvolvimento

## ⚙️ Configuração e Execução

### Pré-requisitos

- JDK 17 ou superior
- Maven 3.6.0 ou superior
- Uma chave de API da [ExchangeRate-API](https://www.exchangerate-api.com/)

### Instalação

1. Clone o repositório
```shell script
git clone https://github.com/seu-usuario/conversor-moedas.git
cd conversor-moedas
```


2. Crie um arquivo `.env` na raiz do projeto com o seguinte conteúdo:
```
API_KEY=sua_chave_de_api_aqui
API_URL=https://v6.exchangerate-api.com/v6
```


3. Compile o projeto com Maven
```shell script
mvn clean package
```


### Execução

Execute o aplicativo a partir do diretório raiz:
```shell script
java -cp target/currency-exchange-1.0-SNAPSHOT.jar br.com.gritti.application.Main
```


Ou abra o projeto em sua IDE de preferência e execute a classe `Main.java`.

## 📊 Moedas Suportadas

O aplicativo suporta 30 moedas internacionais:

| Código | Moeda                             | Código | Moeda                             |
|--------|-----------------------------------|--------|-----------------------------------|
| USD    | Dólar Americano                   | SGD    | Dólar de Singapura                |
| EUR    | Euro                              | SEK    | Coroa Sueca                       |
| JPY    | Iene Japonês                      | NZD    | Dólar da Nova Zelândia            |
| GBP    | Libra Esterlina                   | INR    | Rupia Indiana                     |
| CNY    | Yuan Chinês                       | BRL    | Real Brasileiro                   |
| AUD    | Dólar Australiano                 | RUB    | Rublo Russo                       |
| CAD    | Dólar Canadense                   | KRW    | Won Sul-Coreano                   |
| CHF    | Franco Suíço                      | ZAR    | Rand Sul-Africano                 |
| HKD    | Dólar de Hong Kong                | MXN    | Peso Mexicano                     |
| PLN    | Złoty Polonês                     | NOK    | Coroa Norueguesa                  |
| TRY    | Lira Turca                        | DKK    | Coroa Dinamarquesa                |
| SAR    | Riyal Saudita                     | ILS    | Novo Shekel Israelense            |
| AED    | Dirham dos Emirados Árabes Unidos | THB    | Baht Tailandês                    |
| PHP    | Peso Filipino                     | MYR    | Ringgit Malaio                    |
| IDR    | Rupia Indonésia                   | TWD    | Novo Dólar Taiwanês               |

## 📷 Capturas de Tela

### Menu Principal
```
======================================
=     CONVERSOR DE MOEDAS v1.0      =
======================================

Bem-vindo ao Conversor de Moedas!
Este aplicativo permite converter valores entre diferentes moedas.

======== MENU PRINCIPAL ========
1. Converter moedas
2. Ver moedas suportadas
3. Histórico de conversões
0. Sair

Escolha uma opção:
```


### Resultado de Conversão
```
==== RESULTADO DA CONVERSÃO ====
Valor original: 2.000,00 AUD
Taxa de conversão: 1 AUD = 3,65 BRL
Valor convertido: 7.290,60 BRL
```

### Histórico de Conversões
```
==== HISTÓRICO DE CONVERSÕES ====
Suas últimas 2 conversões:

Data                | De    | Para   | Valor Original | Valor Convertido
--------------------|-------|--------|----------------|------------------
18/05/2025 12:32:50 | BRL   | USD    | 2.000,00 BRL   | 351,80 USD      
18/05/2025 12:33:01 | AUD   | USD    | 5.000,00 AUD   | 3.202,50 USD    

Pressione ENTER para voltar ao menu principal...
```


## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 🧑‍💻 Autor

Feito com ❤️ por [Thiago Gritti](https://github.com/thiagoDOTjpeg)

---

*Este projeto faz parte do Challenge Oracle ONE - Java, proposto pela Alura e Oracle.*