package entities;

public class TaxPayer {

	private double salaryIncome;
    private double servicesIncome;
    private double capitalIncome;
    private double healthSpending;
    private double educationSpending;
    
    public TaxPayer() {
		
	}

	public TaxPayer(double salaryIncome, double servicesIncome, double capitalIncome, double healthSpending,
			double educationSpending) {
	
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}
    
	 public double salaryTax() {
	        if (salaryIncome < 36000) { // Abaixo de 3000 por mês
	            return 0.0;
	        } else if (salaryIncome < 60000) { // Entre 3000 e 5000 por mês
	            return salaryIncome * 0.10;
	        } else { // Acima de 5000 por mês
	            return salaryIncome * 0.20;
	        }
	    }

	    public double servicesTax() {
	        return servicesIncome * 0.15;
	    }

	    public double capitalTax() {
	        return capitalIncome * 0.20;
	    }

	    public double grossTax() {
	        return salaryTax() + servicesTax() + capitalTax();
	    }

	    public double taxRebate() {
	        double maxRebate = grossTax() * 0.30;
	        double actualRebate = healthSpending + educationSpending;
	        return Math.min(maxRebate, actualRebate);
	    }

	    public double netTax() {
	        return grossTax() - taxRebate();
	    }

	    @Override
	    public String toString() {
	        return String.format(
	            "Imposto bruto total: %.2f\nAbatimento: %.2f\nImposto devido: %.2f",
	            grossTax(), taxRebate(), netTax()
	        );
	    }
	}