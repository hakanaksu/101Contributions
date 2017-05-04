import org.softlang.company.entity.Company;
import org.softlang.company.logic.CompanyHandler;

public class Main {

	public static void main(String[] args) {
		CompanyHandler cHandler = new CompanyHandler();
		//cHandler.createSampleCompany();
		Company c = cHandler.loadCompany(1);
		System.out.println(cHandler.total(c));
		cHandler.cut(c);
		System.out.println(cHandler.total(c));
	}

}
