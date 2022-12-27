public class calcMirath {

    public boolean isSound() {
        return sound;
    }

    public void setSound(boolean sound) {
        this.sound = sound;
    }

    private calcMirath() {

    }

  
    private static calcMirath instance=null;
    
    public static calcMirath GetInstance(){
    if(instance==null){
        instance=new calcMirath();
    }
    return instance;
    }
    

    

    public double getFather() {
        return (amount * (father / 6));
    }

    public void setFather(double father) {
        this.father = father;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public double getWife() {
        if (gender == true) {
            return (amount * (wife / 4));
        } else {
            return (amount * (wife / 8));
        }
    }

    public void setWife(double wife) {
        this.wife = wife;
    }

    public double getMother() {
        return( amount * (mother / 6));
    }

    public void setMother(double mother) {
        this.mother = mother;
    }


    public double getSons() {
        return calc()*2*sons;
    }

    public void setSons(double sons) {
        this.sons = sons;
    }

    public double getDaughters() {
        return (calc()*daughters);
    }

    public void setDaughters(double daughters) {
        this.daughters = daughters;
    }
    private double calc (){
     return ((amount - (getFather() + getMother() + getWife())) / (daughters + (sons*2)));
    }
    private boolean gender , sound;
    private double wife, father, mother,  sons, daughters, amount;

}
