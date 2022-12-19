abstract class Employee {
    private String firstName;
    private String lastName;
    private int Id;

    public Employee() {
        this.firstName = "plony";
        this.lastName = "almony";
        this.Id = 0;
    }

    public Employee(String firstName, String lastName, int Id) {
        setFirstName(firstName);
        setId(Id);
        setLastName(lastName);
    }

    
    /** 
     * @param firstName
     * @return 
     */
    private void setFirstName(String firstName) {
        this.firstName = firstName;
    } // set firstName

    
    /** 
     * @param lastName
     * @return 
     */
    private void setLastName(String lastName) {
        this.lastName = lastName;
    } // set lastName

    
    /** 
     * @param Id
     * @return 
     */
    private void setId(int Id) {
        if (Id < 0) {
            throw new IllegalArgumentException("the Id must be positive");
        }
        this.Id = Id;
    } // set Id

    
    /** 
     * @return 
     */
    private String getFirstName() {
        return firstName;
    } // returns the firstName

    
    /** 
     * @return 
     */
    private String getLastName() {
        return lastName;
    } // returns the lastName

    
    /** 
     * @return 
     */
    private int getId() {
        return Id;
    } // returns the Id

    
    /** 
     * @return 
     */
    @Override
    public String toString() {
        return "first name: " + getFirstName() + ", last name: " + getLastName() + ", ID: " + getId();
    }

    
    /** 
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        return (((Employee) obj).getId() == getId() && ((Employee) obj).getFirstName() == getFirstName()
                && ((Employee) obj).getLastName() == getLastName());
    }

    public abstract float earnings();
}

class HourlyEmployee extends Employee {
    private int hours;
    private float wage;

    public HourlyEmployee() {
        super();
        setHours(0);
        setWage((float) 0);
    }

    public HourlyEmployee(String firstName, String lastName, int Id, int hours, float wage) {
        super(firstName, lastName, Id);
        setHours(hours);
        setWage(wage);
    }

    private void setHours(int hours) {
        if (hours < 0) {
            throw new IllegalArgumentException("the hours must be positive");
        }
        this.hours = hours;
    } // set hours

    private void setWage(Float wage) {
        if (wage < 0) {
            throw new IllegalArgumentException("the wage must be positive");
        }
        this.wage = wage;
    } // set wage

    private int getHours() {
        return hours;
    } // returns the firstName

    private Float getWage() {
        return wage;
    } // returns the lastName

    @Override
    public String toString() {
        return super.toString() + ", hours: " + getHours() + ", wage: " + getWage();
    }

    @Override
    public boolean equals(Object obj) {
        return (super.equals(obj) && ((HourlyEmployee) obj).hours == getHours()
                && ((HourlyEmployee) obj).wage == getWage());
    }

    @Override
    public float earnings() {
        return getHours() * getWage();
    }
}

class CommissionEmployee extends Employee {
    private int commision;
    private float grossSales;

    public CommissionEmployee(String firstName, String lastName, int Id, float grossSales, int commision) {
        super(firstName, lastName, Id);
        setGrossSales(grossSales);
        setCommision(commision);
    }

    public CommissionEmployee() {
        super();
        setGrossSales(0);
        setCommision(0);
    }

    private void setGrossSales(float grossSales) {
        if (grossSales < 0) {
            throw new IllegalArgumentException("the gross Sales must be positive");
        }
        this.grossSales = grossSales;
    }

    private void setCommision(int commision) {
        if (commision < 0) {
            throw new IllegalArgumentException("the commision must be positive");
        }
        this.commision = commision;
    }

    private float getGrossSales() {
        return this.grossSales;
    }

    private int getCommision() {
        return this.commision;
    }

    @Override
    public String toString() {
        return super.toString() + ", gross sales: " + getGrossSales() + ", commision: " + getCommision();
    }

    @Override
    public boolean equals(Object obj) {
        return (super.equals(obj) && ((CommissionEmployee) obj).getCommision() == this.getCommision()
                && ((CommissionEmployee) obj).getGrossSales() == this.getGrossSales());
    }

    @Override
    public float earnings() {
        return ((float) getCommision() / (float) 100 * getGrossSales());
    }
}

class BasePlusCommissionEmployee extends CommissionEmployee {
    private float baseSalary;

    public BasePlusCommissionEmployee() {
        super();
        setBaseSalary(0);
    }

    public BasePlusCommissionEmployee(String firstName, String lastName, int Id, float grossSales, int commision,
            float baseSalary) {
        super(firstName, lastName, Id, grossSales, commision);
        setBaseSalary(baseSalary);
    }

    private void setBaseSalary(float baseSalary) {
        if (baseSalary < 0) {
            throw new IllegalArgumentException("Base salary must be positive");
        }
        this.baseSalary = baseSalary;
    }

    private float getBaseSalary() {
        return baseSalary;
    }

    @Override
    public String toString() {
        return super.toString() + ", baseSalary: " + getBaseSalary();
    }

    @Override
    public boolean equals(Object obj) {
        return (super.equals(obj) && ((BasePlusCommissionEmployee) obj).getBaseSalary() == getBaseSalary());
    }

    @Override
    public float earnings() {
        return super.earnings() + getBaseSalary();
    }
}

class Payroll {
    public static void main(String[] args) {
        Employee arr[] = new Employee[3];
        arr[0] = new HourlyEmployee("qw", "asd", 1, 15, 17);
        arr[1] = new CommissionEmployee("qw", "asd", 2, 7000, 12);
        arr[2] = new BasePlusCommissionEmployee("qw", "asd", 1, 7000, 12, 5000);
        for (Employee employee : arr) {
            if (employee instanceof BasePlusCommissionEmployee)
                System.out.printf(employee.toString() + ", earnings: %.2f" + "\n", employee.earnings() * 1.10);
            else
                System.out.printf(employee.toString() + ", earnings: %.2f" + "\n", employee.earnings());
        }
    }

}