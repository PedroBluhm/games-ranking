package Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PlayerDTO {
    private String name;
    private Integer matches;
    private Integer wins;

    @Override
    public String toString(){
        return this.name + " : " + "Partidas : " + this.matches + " Vitórias : " + this.wins;
    }

}