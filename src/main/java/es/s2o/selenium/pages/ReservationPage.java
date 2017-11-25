package es.s2o.selenium.pages;

import es.s2o.selenium.domain.Reservation;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static net.thucydides.core.pages.components.HtmlTable.inTable;

/**
 * Created by sacrists on 26.02.17.
 */

public class ReservationPage extends PageObject {

    // Form
    private WebElementFacade txtName;
    private WebElementFacade txtPhone;
    private WebElementFacade txtEmail;
    private WebElementFacade txtDate;
    private WebElementFacade txtNumber;
    private WebElementFacade txtSearch;
    private WebElementFacade txtColor;
    private WebElementFacade btnSave;

    private WebElementFacade display;
    private WebElementFacade display_txtName;

    private WebElementFacade tblList;

    public void registerUser(Reservation reservation) {
        typeInto(txtName, reservation.getName());
        typeInto(txtPhone, reservation.getPhone());
        typeInto(txtEmail, reservation.getEmail());
        typeInto(txtDate, reservation.getDate());
        display.click();
        typeInto(txtNumber, reservation.getNumber());
        typeInto(txtSearch, reservation.getTime());
        display.click();
        evaluateJavascript("arguments[0].value=arguments[1];", txtColor, reservation.getColor());
        btnSave.click();
    }

    public List<Reservation> getReservations(){
        List<Map<Object, String>> rows = inTable(tblList).getRows();
        List<Reservation> reservations = rows.stream().parallel().map(new Function<Map<Object, String>, Reservation>() {
            @Override
            public Reservation apply(Map<Object, String> rowMap) {
                Reservation reservation = new Reservation();
                reservation.setName(rowMap.get("Name"));
                reservation.setPhone(rowMap.get("Phone"));
                reservation.setEmail(rowMap.get("Email"));
                reservation.setDate(rowMap.get("Date"));
                reservation.setNumber(rowMap.get("Number"));
                reservation.setTime(rowMap.get("Time"));
                reservation.setColor(rowMap.get("Table"));
                return reservation;
            }
        }).collect(Collectors.toList());
        return reservations;
    }
}
