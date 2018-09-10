package com.saanum;

public class Magic {
    //constructor - her kan vi sette startverdier for klassen
    public Magic(double health){
        this.m_health = health;
    }
    public Magic(String name, double health){
        this.m_health = health;
        this.m_Name = name;
    }

    public String getName(){
        return this.m_Name;
    }

    //denne er bare synlig inni klassen
    private double m_health;
    private String m_Name = this.getClass().getSimpleName(); //standard dersom navn ikke settes

    public void Attack(Boss enemy, double dmg){
        System.out.println("\t" + this.getName() + " attacks " + enemy.getName() + " for " + Double.toString(Math.round(dmg)));
        //pauser 0,5 sek mellom hvert angrep
        try
        {
            Thread.sleep(1500);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        enemy.OnAttacked(this, dmg);
    }

    public void OnAttacked(Boss attacker, double dmg){
        System.out.println("\t" + attacker.getName() + " attacks " + this.getName() + " for " + Double.toString(Math.round(dmg)));
        this.m_health = this.m_health - dmg;
        System.out.println("\t" + this.getName() + " life is now " + Double.toString( Math.round(this.m_health)));
    }

    public double getHealth()
    {
        return m_health;
    }
}
