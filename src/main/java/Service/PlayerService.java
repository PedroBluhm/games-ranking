package Service;

import Entities.Player;
import Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    public PlayerRepository playerRepository;

    public List<Player> getAllPlayers(Integer page) {
        return playerRepository.findAll();
    }

    public void save(Player player) {
        if(playerRepository.findByName(player.getName()) != null){
            Player playerEdit = playerRepository.findByName(player.getName());
            playerEdit.setMatches(player.getMatches());
            playerEdit.setWins(player.getWins());
            playerRepository.save(playerEdit);
        }else playerRepository.save(player);
    }
}
