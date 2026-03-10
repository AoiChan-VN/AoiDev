package aoichan.crystal.gameplay.socket;

public class GemData {

    private final String id;
    private final int level;

    // [!] Code: Gem object
    public GemData(String id, int level) {

        this.id = id;
        this.level = level;
    }

    public String getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }
} 
