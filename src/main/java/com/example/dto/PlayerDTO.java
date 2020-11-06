package com.example.dto;

import com.example.entity.Player;
import lombok.Data;

@Data
public class PlayerDTO
{
    private final Integer id;
    private final String name;
    private final Integer rating;

    public static PlayerDTO toDTO(Player player)
    {
        return new PlayerDTO(
                player.getId(),
                player.getName(),
                player.getRating()
        );
    }

}
