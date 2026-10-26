
/*

Definition:- 

Attach additional responsibilities to an object dynamically.
Decorators provide a flexible alternative to subclassing for extending functionality.


*/




interface Character {

    String getDetails();
}

class Mario implements Character {

    @Override
    public String getDetails(){
        return "Mario with base";
    }
}

interface CharacterDecorator extends Character{

    String getDetails();
}

class MarioWithHeightPower implements CharacterDecorator{

    private Character character;

    public MarioWithHeightPower(Character character) {
        this.character = character;
    }

    public MarioWithHeightPower(){}

    @Override
    public String getDetails(){
        return character.getDetails() + " With height power";
    }
}

class MarioWithGunPower implements CharacterDecorator{

    private Character character;

    public MarioWithGunPower(Character character){
        this.character = character;
    }

    public MarioWithGunPower(){}

    @Override
    public String getDetails(){
        return character.getDetails() + " with gun power";
    }
}

class MarioWithJumpPower implements CharacterDecorator{

    private Character character;

    public MarioWithJumpPower(Character character) {
        this.character = character;
    }

    public MarioWithJumpPower(){}

    @Override
    public String getDetails(){
        return character.getDetails() + " with jump power";
    }
}

public class DecoratorDesignPattern {
    
    public static void main(String[] args) {

        Character mario = new MarioWithHeightPower(
            new MarioWithGunPower(
                new MarioWithJumpPower(
                    new Mario()
                )
            )
        );

        System.out.println(mario.getDetails());
    }
}
