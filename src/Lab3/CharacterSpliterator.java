package Lab3;

import java.util.Spliterator;
import java.util.function.Consumer;
//1
public class CharacterSpliterator implements Spliterator<Character> {
    private final String string;
    private int currentIndex = 0;

    public CharacterSpliterator(String string) {
        this.string = string;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Character> action) {
        if (currentIndex < string.length()) {
            action.accept(string.charAt(currentIndex++));
            return true;
        }
        return false;
    }

    @Override
    public Spliterator<Character> trySplit() {
        int currentSize = string.length() - currentIndex;
        if (currentSize < 10) {
            return null;
        }
        int splitPos = currentIndex + currentSize / 2;
        String newString = string.substring(currentIndex, splitPos);
        currentIndex = splitPos;
        return new CharacterSpliterator(newString);
    }

    @Override
    public long estimateSize() {
        return string.length() - currentIndex;
    }

    @Override
    public int characteristics() {
        return ORDERED | SIZED | SUBSIZED | NONNULL | IMMUTABLE;
    }
}
//