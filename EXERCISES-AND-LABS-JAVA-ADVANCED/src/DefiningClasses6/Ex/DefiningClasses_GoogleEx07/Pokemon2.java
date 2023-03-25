package DefiningClasses6.Ex.DefiningClasses_GoogleEx07;

public class Pokemon2 {
    private String pokemonName;
    private String pokemonType;

    public Pokemon2(String pokemonName, String pokemonType) {
        this.pokemonName = pokemonName;
        this.pokemonType = pokemonType;
    }

    @Override
    public String toString() {
        return pokemonName + " " + pokemonType;
    }
}
