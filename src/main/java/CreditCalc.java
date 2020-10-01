public class CreditCalc implements ICreditCalc {
    private final Credit credit;

    public CreditCalc(Credit credit) {
        this.credit = credit;
    }


    @Override
    public int monthlyPayment(Credit credit) {
        double k = credit.getPercent() / 12 / 100;
        return (int) Math.round(credit.getTotalAmount() *
                (k * (Math.pow(1 + k, 12)) /
                        ((Math.pow(1 + k, 12) - 1))));
    }

    @Override
    public double totalAmountPlusPercent(Credit credit) {
        return overpayment(credit) + (credit.getTotalAmount());
    }

    @Override
    public int overpayment(Credit credit) {
        return monthlyPayment(credit) * credit.getMonths() - credit.getTotalAmount();
    }
}
