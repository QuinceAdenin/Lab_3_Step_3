package Lab3;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
//1
public class CharacterStreamProcessor {
    public static void processString(String input) {
        // Создание Stream<Character> из строки
        CharacterSpliterator spliterator = new CharacterSpliterator(input);
        Stream<Character> characterStream = StreamSupport.stream(spliterator, false);

        // Фильтрация символов: оставить только буквы
        // Преобразование символов: привести все буквы к верхнему регистру
        // Подсчет частоты каждого символа (символы в верхнем регистре)
        Map<Character, Long> frequencyMap = characterStream
                .filter(Character::isLetter)
                .map(Character::toUpperCase)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        System.out.println("Frequency of characters: " + frequencyMap);
    }
}
//