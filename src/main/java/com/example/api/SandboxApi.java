package com.example.api;

import com.example.dto.PlayerDTO;
import com.example.serivce.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.HttpStatus.OK;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/")
public class SandboxApi
{
    @Autowired
    PlayerService playerService;

    @GetMapping("/player")
    public ResponseEntity<List<PlayerDTO>> getAll()
    {
        return new ResponseEntity<>(playerService.findAllPlayers(), OK);
    }

}
