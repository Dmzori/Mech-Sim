package System.Generators;


public class GameCharacter {
    private String name;
    private int dex;//dexterity
    private int intelect;
    private int charisma;
    private int end;//endurance
    private int savvy;
    private int ID;//player character will be 0 and go up from there as created
    private boolean isThisAPC;
    
        public GameCharacter(String name,
                            int dex,
                            int intelect,
                            int charisma,
                            int end,
                            int savvy,
                            int ID,
                            boolean isThisAPC){
            this.name = name;
            this.dex = dex;
            this.intelect = intelect;
            this.charisma = charisma;
            this.end = end;
            this.savvy = savvy;
            this.ID = ID;
            this.isThisAPC = isThisAPC;
            
        }
        
        public GameCharacter CharacterGen(String name,
                                          int dex, //main character gen and npc gen will be the same but MC gen will take a primary stat and secondary stat to increase by +3 and +1
                                          int intelect,
                                          int charisma,
                                          int end,
                                          int savvy,
                                          int ID,
                                          boolean isThisAPC){
            GameCharacter Character = new GameCharacter(name, dex, intelect, charisma, end, savvy, ID, isThisAPC);
            return Character;
        }
    
            
            
            
}
