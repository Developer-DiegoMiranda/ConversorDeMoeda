# Conversor de Moedas 💱

Este é um projeto de um **Conversor de Moedas** que utiliza uma API de taxas de câmbio em tempo real para realizar conversões entre diferentes moedas. 

O projeto é dividido em duas partes principais: uma classe que interage com a API e exibe um menu para o usuário, e outra classe que realiza as conversões com base nas taxas fornecidas pela API.

## Funcionalidades 🔧

- Conversão de valores entre diferentes moedas:
  - Dólar Americano (USD) para Peso Argentino (ARS), Real Brasileiro (BRL) e Peso Colombiano (COP).
  - Conversão reversa de ARS, BRL, e COP para USD.
- Integração com a API [ExchangeRate-API](https://www.exchangerate-api.com) para obter as taxas de câmbio em tempo real.
- Menu interativo para o usuário selecionar o tipo de conversão desejada.

## Tecnologias Utilizadas 🚀

- **Java 11+**: Linguagem de programação utilizada.
- **HttpClient**: Para realizar requisições HTTP à API de câmbio.
- **Gson**: Biblioteca usada para fazer o parsing do JSON retornado pela API.
  
## Como Usar 💻 

- **1º-Clone este repositório para sua máquina local:
- **git clone https://github.com/seu-usuario/conversor-moedas.git

 ## Exemplo de Execução 📋

- **Menu de Conversão:
- **1) Dólar => Peso Argentino
- **2) Peso Argentino => Dólar
- **3) Dólar => Real brasileiro
- **4) Real brasileiro => Dólar
- **5) Dólar => Peso colombiano
- **6) Peso colombiano => Dólar
- **7) Sair
- **Escolha uma opção válida: 1
- **Digite o valor para conversão: 100
- **100.00 USD = 35000.00 ARS




