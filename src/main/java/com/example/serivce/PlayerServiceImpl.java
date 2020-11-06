package com.example.serivce;

import com.example.dto.PlayerDTO;
import com.example.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service(value = "playerService")
@Transactional
public class PlayerServiceImpl implements PlayerService
{
    @Autowired
    PlayerRepository playerRepository;

    @Override
    public List<PlayerDTO> findAllPlayers()
    {
        List<PlayerDTO> ret = new ArrayList<>();
        playerRepository.findAll().forEach(p -> ret.add(PlayerDTO.toDTO(p)));
        return ret;
    }
}
