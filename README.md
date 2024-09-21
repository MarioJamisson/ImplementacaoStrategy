# Estratégias de Desconto

Este projeto é um exemplo de aplicação do padrão de design **Strategy** em Java. O padrão Strategy define uma família de algoritmos, encapsula cada um deles e os torna intercambiáveis. O padrão permite que o algoritmo varie independentemente dos clientes que o utilizam.

## Estrutura do Código

O código é composto pelas seguintes classes e interfaces:

1. **EstrategiaDeDesconto**: Interface abstrata que define o método `aplicar(double preco)` para aplicar uma estratégia de desconto sobre um preço.

2. **DescontoFixo**: Implementação da estratégia de desconto que aplica um desconto fixo ao preço do produto.

3. **DescontoPercentual**: Implementação da estratégia de desconto que aplica um desconto percentual ao preço do produto.

4. **DescontoPromocional**: Implementação da estratégia de desconto que aplica um desconto promocional fixo de 20% ao preço do produto.

5. **Produto**: Representa um produto com um nome, preço e uma estratégia de desconto. Permite definir a estratégia de desconto e calcular o preço com desconto. Exibe as informações do produto com e sem desconto.

6. **Main**: Classe principal que demonstra a utilização das diferentes estratégias de desconto. Cria um produto, aplica diferentes estratégias de desconto e exibe o resultado.

## Como Utilizar

1. **Crie um produto**:
   ```java
   Produto produto = new Produto("Jogo de Ação", 60);
2. **Crie e defina as estratégias de desconto:**
   ```java
   EstrategiaDeDesconto descontoFixo = new DescontoFixo(10);
   EstrategiaDeDesconto descontoPercentual = new DescontoPercentual(15);
   EstrategiaDeDesconto descontoPromocional = new DescontoPromocional();
3. **Aplique as estratégias de desconto ao produto e exiba as informações:**
   ```java
   produto.definirEstrategiaDeDesconto(descontoFixo);
   produto.exibir();

   produto.definirEstrategiaDeDesconto(descontoPercentual);
   produto.exibir();

   produto.definirEstrategiaDeDesconto(descontoPromocional);
   produto.exibir();

  ## Exemplo de execução
  **Quando o código é executado, a saída será:**
  ```java
  Jogo de Ação: Preço original $60.00, Preço com desconto $50.00
  Jogo de Ação: Preço original $60.00, Preço com desconto $51.00
  Jogo de Ação: Preço original $60.00, Preço com desconto $48.00

