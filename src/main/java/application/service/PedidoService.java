package application.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.domain.Pedido;
import application.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	public Iterable<Pedido> getAll() {
		return pedidoRepository.findAll();
	}

	public Pedido buscaPedidoId(Long id){
		return pedidoRepository.findOne(id);
	}
	
	public void save(Pedido pedido){
	
		
		if (pedido.getDtRegistro() == null){
					
			pedido.setDtRegistro(new Date());
		}
		if (pedido.getQuantidade() == null){
			pedido.setQuantidade(1);
		}
		
		BigDecimal valorFinal = pedido.getValorProduto().multiply(new BigDecimal(pedido.getQuantidade())).setScale(2, RoundingMode.HALF_EVEN);
		
		if(pedido.getQuantidade() >= 10) {
			pedido.setValorTotal(valorFinal.multiply(new BigDecimal(0.90)).setScale(2, RoundingMode.HALF_EVEN));
		}
		if (pedido.getQuantidade() >= 5){
			pedido.setValorTotal(valorFinal.multiply(new BigDecimal(0.95)).setScale(2, RoundingMode.HALF_EVEN));
		}else{
			pedido.setValorTotal(valorFinal);
		}
			
		pedidoRepository.save(pedido);
	}
	
	public Boolean existePedido(Long id) {
		if(id == null) {
			return false;
		}

		return pedidoRepository.exists(id);
	}
	
	
	
	
	
}
