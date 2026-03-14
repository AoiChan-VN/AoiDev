package aoichan.crystal.gameplay.skill;

public class Skill {

    private final String id;
    private final String name;
    private final SkillType type;

    private final double manaCost;
    private final int cooldown;

    private final double damageScale;

    public Skill(String id,
                 String name,
                 SkillType type,
                 double manaCost,
                 int cooldown,
                 double damageScale) {

        // 【!】Code: skill id
        this.id = id;

        // 【!】Code: tên skill
        this.name = name;

        // 【!】Code: loại skill
        this.type = type;

        // 【!】Code: mana cost
        this.manaCost = manaCost;

        // 【!】Code: cooldown
        this.cooldown = cooldown;

        // 【!】Code: damage scale
        this.damageScale = damageScale;

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public SkillType getType() {
        return type;
    }

    public double getManaCost() {
        return manaCost;
    }

    public int getCooldown() {
        return cooldown;
    }

    public double getDamageScale() {
        return damageScale;
    }

}
 
