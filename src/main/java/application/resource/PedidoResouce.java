package application.resource;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import application.domain.Pedido;
import application.service.PedidoService;

@RestController
public class PedidoResouce {
	
	public static final Logger logger = LoggerFactory.getLogger(PedidoResouce.class);
	
	@Autowired
	private PedidoService pedidoService;
	
	@RequestMapping(path = "/pedidos", method = RequestMethod.GET,
            headers = {"Accept=application/json,application/xml"},
            produces = {"application/json", "application/xml"})
	public Iterable<Pedido> consultaTodosPedidos() {
		return pedidoService.getAll();
	}
	
	@PostMapping(path="/save",consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})

	public ResponseEntity<?> salvaPedido(@RequestBody List<Pedido> pedidos) throws Exception{
		if(pedidos.size() > 10) {
			throw new Exception("Execedeu o limite de 10 pedidos");
		}
		
		for (Pedido pedido : pedidos){
			pedidoService.save(pedido);
		}
		
		
		return new ResponseEntity<List<Pedido>>(pedidos, HttpStatus.OK);	
	}
public ResponseEntity<?> salvaPedido(@RequestBody Pedido pedido) throws Exception{
		
		
		if (pedidoService.existePedido(pedido.getNrControle())){
			throw new Exception("Este pedido ja foi cadastrado");
		}else{
			pedidoService.save(pedido);
		}
		return new ResponseEntity<Pedido>(pedido,HttpStatus.OK);
	}

	
	@RequestMapping(value = "/pedido/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.FOUND)
	public Pedido findOrderById(@PathVariable(value = "id") Long id) throws Exception {
		
		Pedido pedido = pedidoService.buscaPedidoId(id);

		if (pedido == null) {
			throw new Exception("O peido com o numero de controle " + id + " não foi encontrado");
		}
		
		return pedido;
	}
	

	
	
	
}
