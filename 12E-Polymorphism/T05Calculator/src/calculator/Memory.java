package calculator;

import java.util.ArrayDeque;

public class Memory {
    private static ArrayDeque<Integer> memory;

    public Memory() {
        if (memory == null)
            memory = new ArrayDeque<>();
    }

    public void add(Integer operand) {
        memory.push(operand);
    }

    public Integer remove() {
        return memory.pop();
    }
}
