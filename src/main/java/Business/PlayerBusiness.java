package Business;

import Entities.Player;
import Model.PlayerDTO;
import Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PlayerBusiness {

    @Autowired
    public PlayerService playerService;

    public List<Player> getAllPlayers(Integer page) {
        return playerService.getAllPlayers(page);
    }

    private Player convertDtoEntity(PlayerDTO dto){
        Player player = new Player();
        player.setName(dto.getName());
        player.setMatches(dto.getMatches() == null? 0 : dto.getMatches());
        player.setWins(dto.getWins() == null? 0 : dto.getWins());
        return player;
    }

    public String save(PlayerDTO player) {
        try{
            playerService.save(convertDtoEntity(player));
        }catch (Exception e) {
            return e.getMessage();
        }finally {
            return "adcionado com sucesso.";
        }
    }
}
