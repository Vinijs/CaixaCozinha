package br.com.caixacozinha.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="pedidos")
public class PedidoEntity {
	
	@Id
	@GeneratedValue
	private int id;
	
	@OneToMany(mappedBy = "produto", targetEntity = ProdutoEntity.class)
	@JoinColumn(name="id")
	private List<ProdutoEntity> produto;
	
	@OneToMany(mappedBy = "mesa", targetEntity = MesaEntity.class)
	@JoinColumn(name="id")
	private MesaEntity mesa;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<ProdutoEntity> getProduto() {
		return produto;
	}
	public void setProduto(List<ProdutoEntity> produto) {
		this.produto = produto;
	}
	public MesaEntity getMesa() {
		return mesa;
	}
	public void setMesa(MesaEntity mesa) {
		this.mesa = mesa;
	}
}
