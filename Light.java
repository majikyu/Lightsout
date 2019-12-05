public class Light{
    private boolean isOn;

    public void change(){
        if(isOn == false) this.isOn = true;
        else this.isOn = false;
    }

    Light(){
        this.isOn = true;
    }

    public boolean getisOn(){
        return isOn;
    }

    public void setisOn(boolean isOn){
        this.isOn = isOn;
    }

    public void printstate(){
        if(isOn == true)System.out.print("O");
        else System.out.print("X");
    }
}