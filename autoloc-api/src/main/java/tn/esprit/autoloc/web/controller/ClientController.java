package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autoloc.service.IClientService;

@RestController
@RequiredArgsConstructor
public class ClientController {
    private final IClientService clientService;



}
