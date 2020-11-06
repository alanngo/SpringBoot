package com.example.serivce;

import com.example.dto.PlayerDTO;

import java.util.List;

public interface PlayerService
{
    List<PlayerDTO> findAllPlayers();
}
