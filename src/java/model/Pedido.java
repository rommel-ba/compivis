package model;

import java.util.ArrayList;

/*Classe Pedido 
* Define os atributos básicos de um pedido
*/

public class Pedido {
    private int numero;
    private String data;
    private Pessoa pessoa;
    private ArrayList<Item> items = new ArrayList<>();

    
    
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(Item item) {
        this.items.add(item);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    
}
