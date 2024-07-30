package moomint.toy.github_grass_text_maker.util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

public class DateManager {

    private static final String DATE_TIME_PATTERN = "^(19|20)\\d\\d\\/(0[1-9]|1[0-2])\\/(0[1-9]|[12]\\d|3[01])\\s([01]\\d|2[0-3]):([0-5]\\d)$";

    public String formatDate() {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime localDateTime = null;

        while (localDateTime == null) {
            System.out.print("commit 날짜(yyyy/MM/dd HH:mm): ");
            String input = scanner.nextLine();

            // 입력 형식 검증
            while (!input.matches(DATE_TIME_PATTERN)) {
                System.out.println("올바르지 않은 형태입니다.");
                System.out.print("commit 날짜(yyyy/MM/dd HH:mm): ");
                input = scanner.nextLine();
            }

            // 날짜 범위 검증
            localDateTime = getDate(input);
            if (localDateTime == null) {
                System.out.println("1970년 이후, 현재 시간보다 이전이어야 합니다.");
            }
        }

        return localDateTime.atOffset(ZoneOffset.ofHours(9))
                .format(DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss yyyy +0900", Locale.ENGLISH));
    }

    private LocalDateTime getDate(String input) {
        try {
            LocalDateTime localDateTime = LocalDateTime.parse(input, DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
            if (isWithinValidRange(localDateTime)) {
                return localDateTime;
            } else {
                return null;
            }
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    private boolean isWithinValidRange(LocalDateTime localDateTime) {
        if (localDateTime.isAfter(LocalDateTime.now())) {
            return false;
        }
        LocalDateTime epoch = LocalDateTime.ofEpochSecond(0, 0, ZoneOffset.UTC);
        return !localDateTime.isBefore(epoch);
    }
}
