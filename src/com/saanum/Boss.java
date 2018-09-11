package com.saanum;

public class Boss implements ICharacter{
    //constructor - her kan vi sette startverdier for klassen
    public Boss(double health){
        this.m_health = health;
    }

    public Boss(String name, double health){
        this.m_health = health;
        this.m_Name = name;
    }

    public String getName(){
        return this.m_Name;
    }

    //denne er bare synlig inni klassen
    private double m_health;
    private String m_Name = ""; //this.getClass().getSimpleName(); //standard dersom navn ikke settes

    ///
    public void OnAttacked(ICharacter attacker, double dmg){
        this.m_health = this.m_health - dmg;
        // hvis det er en spillerklasse (hvilken som helst) så gjør et motangrep
        // men dette er dårlig kode, vet ikke hvilken klasse det er så vi må teste på alle.

        //når vi bruker interface trenger vi ikke å sjekke klassen lenger. Mye kortere kode
        attacker.OnAttacked(this, attacker.getHealth() * .09);
        /* Kommenterer ut dette med /*
        switch(attacker.getClass().getSimpleName()){
            case "Ranged":
                //Må gjøre om attacker til riktig klasse - dette gjøres med å "caste" om et Object til klassen med ()
                Ranged rangedAttacker = (Ranged) attacker;
                // og gjøre et motangrep der vi tar 7% av livet

                rangedAttacker.OnAttacked(this, rangedAttacker.getHealth() *0.07);
                break;
            case "Magic":
                //Må gjøre om attacker til riktig klasse;
                Magic magicAttacker = (Magic) attacker;
                // og gjøre et motangrep der vi tar 13% av livet - tåler mindre
                magicAttacker.OnAttacked(this, magicAttacker.getHealth() *0.13);
                break;
            case "Melee":
                //Må gjøre om attacker til riktig klasse;
                Melee meleeAttacker = (Melee) attacker;
                // og gjøre et motangrep der vi tar 4% av livet
                meleeAttacker.OnAttacked(this, meleeAttacker.getHealth() *0.04);
                break;
            default: //fant ikke klassen - feil
                throw new Error("Fant ikke klassen!");

        }
        */
        System.out.println(this.getName() + " is attacked for " + Double.toString(Math.round(dmg)));
        this.m_health = this.m_health - dmg;
        System.out.println(this.getName() + " life is now " + Double.toString(Math.round(this.m_health)));
        //pauser 0,5 sek mellom hvert angrep
        try
        {
            Thread.sleep(1500);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void Attack(ICharacter enemy, double dmg) {
        //ingenting ennå, bosser er passive inntil de blir angrepet.
    }

    public double getHealth()
    {
        return m_health;
    }
}
