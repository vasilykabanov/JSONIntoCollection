package JSONintoCollection;

import JSONintoCollection.Objects.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by yasup on 06.11.2019.
 */
public class Main {

    private static Company[] companies;
    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws Exception {
        try {
            companies = mapper.readValue(new File("file.json"), Company[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        firstTask();
        secondTask();
        fourthTask();
    }

    private static void firstTask() throws Exception {
        System.out.println("Все имеющиеся компании:" + "\n");
        for (Company company : companies) {
            System.out.println(company.getName_short() + ", " + company.getEgrul_date());
        }
        System.out.println();
    }

    private static void secondTask() {
        System.out.println("Все аннулированные ценные бумаги:" + "\n");
        AtomicLong atomicLong = new AtomicLong();
        for (Company company : companies) {
            company.securities
                    .stream()
                    .filter(x -> x.state.name.equals("Аннулирован"))
                    .forEach(y -> {
                        atomicLong.getAndIncrement();
                        System.out.println(y.getCode() + " " + y.getDate_to() + " " + company.getName_full());
                    });
        }
        System.out.println("\n" + "Кол-во аннулированных ценных бумаг: " + atomicLong);
    }

    private static void thirdTask() {
    }

    private static void fourthTask() {
        Scanner scanner = new Scanner(System.in);
        AtomicLong atomicLong = new AtomicLong();
        System.out.println("\n" + "Введите валюту (RUB, USD, EUR или UAH)" + ":");
        String s = scanner.next();
        if (s.equals("RUB") || s.equals("USD") || s.equals("EUR") || s.equals("UAH")) {
            System.out.println("Ценные бумаги, использующие валюту " + s + ":");
            for (Company company : companies) {
                company.securities
                        .stream()
                        .filter(x -> x.currency.getCode().equals(s))
                        .forEach(x -> {
                            atomicLong.getAndIncrement();
                            System.out.println(x.currency.getId() + ", " + x.currency.getCode());
                        });
            }
            System.out.println("\n" + "Кол-во: " + atomicLong);
        }
        else {
            System.out.println("Неверная валюта.");
        }
    }
}