abstract class EstrategiaDeDesconto {
    public abstract double aplicar(double preco);
}

class DescontoFixo extends EstrategiaDeDesconto {
    private double valorDesconto;

    public DescontoFixo(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    @Override
    public double aplicar(double preco) {
        return preco - valorDesconto;
    }
}

class DescontoPercentual extends EstrategiaDeDesconto {
    private double percentual;

    public DescontoPercentual(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double aplicar(double preco) {
        return preco * (1 - percentual / 100);
    }
}

class DescontoPromocional extends EstrategiaDeDesconto {
    @Override
    public double aplicar(double preco) {
        return preco * 0.8;
    }
}

class Produto {
    private String nome;
    private double preco;
    private EstrategiaDeDesconto estrategiaDeDesconto;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
        this.estrategiaDeDesconto = null;
    }

    public void definirEstrategiaDeDesconto(EstrategiaDeDesconto estrategia) {
        this.estrategiaDeDesconto = estrategia;
    }

    public double calcularPrecoComDesconto() {
        if (estrategiaDeDesconto != null) {
            return estrategiaDeDesconto.aplicar(preco);
        }
        return preco;
    }

    public void exibir() {
        double precoComDesconto = calcularPrecoComDesconto();
        System.out.printf("%s: Preço original $%.2f, Preço com desconto $%.2f%n", nome, preco, precoComDesconto);
    }
}

public class Main {
    public static void main(String[] args) {
        Produto produto = new Produto("Jogo de Ação", 60);

        EstrategiaDeDesconto descontoFixo = new DescontoFixo(10);
        EstrategiaDeDesconto descontoPercentual = new DescontoPercentual(15);
        EstrategiaDeDesconto descontoPromocional = new DescontoPromocional();

        produto.definirEstrategiaDeDesconto(descontoFixo);
        produto.exibir();

        produto.definirEstrategiaDeDesconto(descontoPercentual);
        produto.exibir();

        produto.definirEstrategiaDeDesconto(descontoPromocional);
        produto.exibir();
    }
}
