package com.vramires.springapi.rest_integration.api;

import com.vramires.springapi.rest_integration.domain.ClientDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("import")
public class CSVimportController {


    //if decides consume some file external  Another way to consume CSV file.
    @Valid
    @PostMapping(value = "/clients", consumes = "application/json")
    public ResponseEntity<?> importClients(@RequestBody List<ClientDTO> clientDTO){

        clientDTO.forEach(
                clientDTO1 -> {
                    System.out.println("Importing: "+ clientDTO1.getEmail());
                });
        return ResponseEntity.ok("Imported" + clientDTO.size() + "clients.");
    }


}
