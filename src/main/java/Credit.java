public class Credit {
    private Double totalAmount;
    private int months;
    private double percent;

    public Credit(Double totalAmount, int months, double percent) {
        this.totalAmount = totalAmount;
        this.months = months;
        this.percent = percent;
    }

    public Credit() {

    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
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
