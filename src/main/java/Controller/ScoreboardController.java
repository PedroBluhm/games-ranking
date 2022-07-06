package Controller;

import Business.PlayerBusiness;
import Entities.Player;
import Model.PlayerDTO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/players")
public class ScoreboardController {
    @Autowired
    public PlayerBusiness playerBusiness;

    /*
    * SERVIÇO: retorna a lista completa dos jogadores com partidas e vitórias
    * */
    @GetMapping("/getpagged/{page}")
    public List<Player> getPlayers (@RequestParam("page") Optional<Integer> page){
        return playerBusiness.getAllPlayers(page.get());
    }

    /*
     * SERVIÇO: insere um novo jogador, com possibilidade de inserir partidas e vitórias
     * */
    @PostMapping("/add")
    public String addPlayerDTO (@RequestBody PlayerDTO player){
        return playerBusiness.save(player);
    }


}
