package br.pickfood.view.controller;


import br.pickfood.model.dto.endereco.EnderecoDTO;
import br.pickfood.service.endereco.EnderecoService;
import br.pickfood.model.endereco.Endereco;
import br.pickfood.service.endereco.EnderecoService;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/endereco")
public class EnderecoController {


    @Autowired
    private EnderecoService enderecoService;


    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDTO> getEnderecoById(@PathVariable Integer id) {
        EnderecoDTO enderecoDTO = enderecoService.findById(id);
        if (enderecoDTO != null) {
            return ResponseEntity.ok(enderecoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping
    public ResponseEntity<Object> getAllEnderecos() {
        List<EnderecoDTO> enderecoDTOList = enderecoService.listarTodos();

        if(enderecoDTOList.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(enderecoDTOList);
    }

    @PostMapping
    public ResponseEntity<EnderecoDTO> createEndereco(@RequestBody EnderecoDTO enderecoDTO) {
        Endereco entity = enderecoDTO.convertToEntity();
        EnderecoDTO createdEndereco = enderecoService.create(entity);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdEndereco);
    }

}
