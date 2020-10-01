public class Credit {
    private int totalAmount;
    private int months;
    private double percent;

    public Credit(int totalAmount, int months, double percent) {
        this.totalAmount = totalAmount;
        this.months = months;
        this.percent = percent;
    }

    public Credit() {

    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }
}
