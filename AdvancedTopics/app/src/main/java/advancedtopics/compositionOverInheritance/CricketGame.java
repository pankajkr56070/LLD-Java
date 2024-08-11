package advancedtopics.compositionOverInheritance;

public class CricketGame {

    public void createPlayers() {
    Player batsman = new Player("Dhoni");
    batsman.addBattingSkill(new StraighDriveSkill());
    batsman.setFieldingSkill(new FielderSkill());


    Player bowler = new Player("Bumrah");
    bowler.addBowlingSkill(new FastBowling());
    bowler.addBattingSkill(new StraighDriveSkill()); // Most bowlers can bat a bit
    bowler.setFieldingSkill(new FielderSkill());
    }
    
}
