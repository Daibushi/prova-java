package br.com.confidencecambio.javabasico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.confidencecambio.javabasico.service.ImcService;

@RestController
public class ImcRs {
	
	@Autowired
	private ImcService service;
	
	public void ImcService(final ImcService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/imc", method = RequestMethod.GET)
	public ResponseEntity<String> getImc(@RequestParam(value = "peso", required = false) String peso,
										 @RequestParam(value = "altura", required = false) String altura){
		String retorno = null;
		try {
			retorno = Float.toString(this.service.retornaImc(peso, altura));
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.PRECONDITION_FAILED);
		}
		return new ResponseEntity<String>(retorno, HttpStatus.OK);
	}
}
