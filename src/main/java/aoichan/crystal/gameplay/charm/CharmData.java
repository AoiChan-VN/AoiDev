package aoichan.crystal.gameplay.charm;

// [!] Code: Charm object
public class CharmData {

    private final String id;
    private final double successBonus;
    private final boolean protectItem;

    public CharmData(
            String id,
            double successBonus,
            boolean protectItem
    ) {
        this.id = id;
        this.successBonus = successBonus;
        this.protectItem = protectItem;
    }

    public String getId() {
        return id;
    }

    public double getSuccessBonus() {
        return successBonus;
    }

    public boolean isProtectItem() {
        return protectItem;
    }
} 
