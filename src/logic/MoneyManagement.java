package logic;

public class MoneyManagement {
    private double guestMoney = 0;

    public double getCasinoMoney() {
        return casinoMoney;
    }

    public void setCasinoMoney(double casinoMoney) {
        this.casinoMoney = casinoMoney;
    }

    private double casinoMoney = 50000;

    public MoneyManagement() {
    }

    public double getGuestMoney() {
        return guestMoney;
    }

    public void setGuestMoney(double guestMoney) {
        this.guestMoney = guestMoney;
    }

    public void withdrawGuestMoney(double withdrewMoney){
        setGuestMoney(getGuestMoney() - withdrewMoney);
    }

    public void depositGuestMoney(double depositedMoney){
        setGuestMoney(getGuestMoney() + depositedMoney);
    }

    public void guestloseMoney(double lostMoney){
        setGuestMoney(getGuestMoney() - lostMoney);
    }

    public void guestwinMoney(double wonMoney){
        setGuestMoney(getGuestMoney() + wonMoney);
    }
    public void casinoloseMoney(double lostMoney){
        setCasinoMoney(getCasinoMoney() - lostMoney);
    }

    public void casinowinMoney(double wonMoney){
        setCasinoMoney(getCasinoMoney() + wonMoney);
    }

}
