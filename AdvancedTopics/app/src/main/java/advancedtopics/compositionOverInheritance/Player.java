import java.util.ArrayList;
import java.util.List;

interface BattingSkill {
    void playShot();
}

interface BowlingSkill {
    void bowl();
}

interface FieldingSkill {
    void field();
}

interface KeepingSkill {
    void keep();
}

class CoverDriveSkill implements BattingSkill {

    public void playShot() {
        System.out.println("Plays a good cover drive");
    }

}

class StraighDriveSkill implements BattingSkill {
    public void playShot() {
        System.out.println("Plays a good  straight drive");
    }
}

class FastBowling implements BowlingSkill {
    public void bowl() {
        System.out.println("Bowls quite fast");
    }
}

class SpinBowling implements BowlingSkill {
    public void bowl() {
        System.out.println("Bowls good spin");
    }
}

class FielderSkill implements FieldingSkill {
    public void field() {
        System.out.println("Fields well");
    }
}

class KeeperSkill implements KeepingSkill {
    public void keep() {
        System.out.println("Keeps well");
    }
}

public class Player {

    private String name;
    private List<BattingSkill> battingSkills = new ArrayList<>();
    private List<BowlingSkill> bowlingSkills = new ArrayList<>();
    private FieldingSkill fieldingSkill;
    private KeepingSkill keepingSkill;

    
    public Player(String name) {
        this.name = name;
    }

    public void addBattingSkill(BattingSkill battingSkill) {
        this.battingSkills.add(battingSkill);
    }

    public void addBowlingSkill(BowlingSkill bowlingSkill) {
        this.bowlingSkills.add(bowlingSkill);
    }

    public void setFieldingSkill(FieldingSkill fieldingSkill) {
        this.fieldingSkill = fieldingSkill;
    }

    public void setKeepingSkill(KeepingSkill keepingSkill) {
        this.keepingSkill = keepingSkill;
    }


}
