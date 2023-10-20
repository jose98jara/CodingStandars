import java.util.Scanner;

public class main {

	private static final int BASE_COST = 1000;
	private static final int PARIS_surcharge = 500;
	private static final int NYC_surcharge = 600;
	private static final double GROUP_DISCOUNT_10 = 0.9;
	private static final double GROUP_DISCOUNT_20 = 0.8;
	private static final int PENALTY_FEE = 200;
	private static final int PROMOTION_DISCOUNT = 200;
	private static final int MAX_GROUP_SIZE = 80;

	// CHECKSTYLE:OFF
	public static void main(String[] args) {
		// CHECKSTYLE:ON
		Scanner scanner = new Scanner(System.in);

		System.out.println("Ingrese el destino de las vacaciones: ");
		String destination = scanner.nextLine();
		System.out.println("Ingrese el número de viajeros: ");
		int numberOfTravelers = scanner.nextInt();
		System.out.println("Ingrese la duración de las vacaciones en días: ");
		int durationOfVacationInDays = scanner.nextInt();

		if (numberOfTravelers > MAX_GROUP_SIZE) {
			System.out.println("El paquete de vacaciones no está disponible para grupos de más de 80 personas.");
			return;
		}

		int baseCost = BASE_COST;

		if (destination.equals("Paris")) {
			baseCost += PARIS_surcharge;
		} else if (destination.equals("New York City")) {
			baseCost += NYC_surcharge;
		}

		double groupDiscount = 1;
		if (numberOfTravelers > 4 && numberOfTravelers < 10) {
			groupDiscount = GROUP_DISCOUNT_10;
		} else if (numberOfTravelers > 10) {
			groupDiscount = GROUP_DISCOUNT_20;
		}

		if (durationOfVacationInDays < 7) {
			baseCost += PENALTY_FEE;
		}

		if (durationOfVacationInDays > 30 || numberOfTravelers == 2) {
			baseCost -= PROMOTION_DISCOUNT;
		}

		double totalCost = baseCost * groupDiscount;

		System.out.println("El costo total del paquete de vacaciones es: $" + totalCost);
	}
}
