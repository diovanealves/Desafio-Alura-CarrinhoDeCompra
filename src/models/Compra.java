package models;

public class Compra implements Comparable<Compra> {
    private String descricao;
    private double valor;

    public Compra(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return """
                Descrição: %s
                Valor: %.2f
                """.formatted(descricao, valor);
    }

    @Override
    public int compareTo(Compra outraCompra) {
        return Double.compare(this.valor, outraCompra.valor);
    }
}