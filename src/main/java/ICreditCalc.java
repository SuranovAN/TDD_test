public interface ICreditCalc {
    public int monthlyPayment(Credit credit);

    public double totalAmountPlusPercent(Credit credit);

    public double overpayment(Credit credit);
}
