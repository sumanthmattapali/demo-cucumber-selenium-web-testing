package es.s2o.selenium.stepsdefs.registration;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java8.En;
import es.s2o.selenium.domain.Reservation;
import es.s2o.selenium.pages.ReservationPage;
import es.s2o.selenium.steps.registration.ReservationSteps;
import net.thucydides.core.annotations.Steps;

import java.net.URL;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by sacrists on 26.02.17.
 */
public class CllientRegistrationStepdef implements En {

    @Steps
    private ReservationSteps reservationSteps;
    private ReservationPage reservationPage;
    private List<Reservation> reservations;

    public CllientRegistrationStepdef() {

        Given("^I'm in the reservations page$", () -> {
            URL resourceFile = Thread.currentThread().getContextClassLoader().getResource("web/index.html");
            reservationPage.openAt("file:" + resourceFile.getPath());
        });

        When("^I register the following reservations$", (DataTable dataTable) -> {
            reservations = dataTable.asList(Reservation.class);
            reservations.forEach(reservation -> reservationPage.registerUser(reservation));
        });

        Then("^I get the reservation in the reservations list$", () -> {
            List<Reservation> actualReservations = reservationPage.getReservations();
            assertThat(actualReservations).usingFieldByFieldElementComparator().containsExactlyElementsOf(reservations);
        });
    }
}
