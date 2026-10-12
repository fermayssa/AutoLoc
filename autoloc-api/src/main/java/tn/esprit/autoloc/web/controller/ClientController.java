package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.service.ClientService;
import tn.esprit.autoloc.service.IClientService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Client")
public class ClientController {
    private final IClientService ic;
    //add
    @PostMapping("/addClient")
    public Client addClient(@RequestBody Client c)
    {
        return ic.addClient(c);
    }
    // POST : ajouter une liste de clients
    @PostMapping("/addClients")
    public List<Client> addClients(@RequestBody List<Client> clients) {
        return ic.addClients(clients);
    }

    //get
    @GetMapping("/getClients")
    public List<Client> getAllClients()
    {
        return ic.retrieveAllClients();
    }

    // GET : un client par son id
    @GetMapping("/getClientById/{idc}")
    public Client getClientById(@PathVariable long idc) {
        return ic.retrieveClient(idc);
    }
    // DELETE : supprimer un client par son id
    @DeleteMapping("/deleteClient/{idc}")
    public void deleteClient(@PathVariable long idc) {
        ic.removeClient(idc);
    }
    // PUT : modifier un client (le JSON doit contenir idClient)
    @PutMapping("/updateClient")
    public Client updateClient(@RequestBody Client c) {
        return ic.updateClient(c);
    }

}
