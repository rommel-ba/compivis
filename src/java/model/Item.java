package model;

/* Classe de itens do pedido
* contem os atributos e metodos relativos
* aos itens do pedido
*/

public class Item {
    
    private Produto produto; //Produto relativo a um item do pedido
    private float valor; // Valor do produto * a quantidade
    private int quantidade; // Quantidade do mesmo produto nesse item

    /*
    * Metodo que totaliza o valor do item com base
    * no produto selecionado e na quantidade
    * o metodo e privado para ser acessado somente pelos 
    * objetos da classe
    */
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
