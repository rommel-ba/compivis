package model;


public class Item {
    private Produto produto;
    private float valor;
    private int quantidade;

    private void setValor(){
        this.valor = this.produto.getValor() * this.quantidade;
    }
    
    public float getValor(){
        return this.produto.getValor() * this.quantidade;
    }
    
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        setValor();
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
