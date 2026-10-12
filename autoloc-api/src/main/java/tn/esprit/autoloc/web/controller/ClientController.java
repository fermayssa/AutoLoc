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
    @PostMapping("/addClient")
    public Client addClient(@RequestBody Client c)
    {
        return ic.addClient(c);
    }
    @GetMapping("/getClients")
    public List<Client> getAllClients()
    {
        return ic.retrieveAllClients();
    }


}
