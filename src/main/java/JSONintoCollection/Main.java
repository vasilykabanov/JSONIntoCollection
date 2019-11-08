package JSONintoCollection;

import JSONintoCollection.Objects.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
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

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n" + "Введите, какое условие Вы хотите посмотреть (1,2,3,4 или \"exit\" для выхода): ");
            String command = scanner.nextLine();
            if ("1".equals(command)) {
                firstTask();
            } else if ("2".equals(command)) {
                secondTask();
            } else if ("3".equals(command)) {
                thirdTask();
            } else if ("4".equals(command)) {
                fourthTask();
            } else if ("exit".equals(command)) {
                System.out.println("Good Bye!");
                break;
            } else {
                System.out.println("Неверная команда! Пожалуйста, введите: 1,2,3,4 or \"exit\"");
            }
        }
        scanner.close();
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

    private static void thirdTask() throws IOException, ParseException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\n" + "Введите дату в формате dd.MM.yyyy: ");
        String putDate = bufferedReader.readLine();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");

        Date date = simpleDateFormat.parse(putDate);

//         тестовый вывод введенной даты
//        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
//        System.out.println(simpleDateFormat1.format(date).toUpperCase());

        SimpleDateFormat simpleDateFormatInJSON = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Выводим название и дату создания всех организаций, основанных после " + simpleDateFormatInJSON.format(date) + "\n");
        for (Company company : companies) {
            Date egrulDate = simpleDateFormatInJSON.parse(company.getEgrul_date());
            //если дата позднее, то выводим её
            if (egrulDate.after(date)) {
                System.out.println(company.getName_full() + " " + company.getEgrul_date());
            }
        }
        thirdTask();
    }

    private static void fourthTask() {
        Scanner scanner = new Scanner(System.in);
        AtomicLong atomicLong = new AtomicLong();
        System.out.println("\n" + "Введите валюту (RUB, USD, EUR или UAH)" + ":");
        String s = scanner.next();
        if (s.equals("RUB") || s.equals("USD") || s.equals("EUR") || s.equals("UAH")) {
            System.out.println("id и коды ценных бумаг, использующих заданную валюту " + s + ":");
            for (Company company : companies) {
                company.securities
                        .stream()
                        .filter(x -> x.currency.getCode().equals(s))
                        .forEach(x -> {
                            atomicLong.getAndIncrement();
                            System.out.println(x.getId() + ", " + x.getCode());
                        });
            }
            System.out.println("\n" + "Кол-во: " + atomicLong);
        }
        else {
            System.out.println("Неверная валюта.");
        }
        fourthTask();
    }
}