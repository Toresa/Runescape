package com.saanum;

public interface ICharacter {
    public double getHealth();
    public void Attack(ICharacter enemy, double dmg);
    public void OnAttacked(ICharacter attacker, double dmg);
    public String getName();
    
}
