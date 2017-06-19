package application.repository;


import org.springframework.data.repository.CrudRepository;

import application.domain.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido , Long>{

	
}
