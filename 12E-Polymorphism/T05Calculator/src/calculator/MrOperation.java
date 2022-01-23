package calculator;

import java.util.ArrayList;
import java.util.List;

public class MrOperation implements Operation {
    private Memory memory;
    private List<Integer> operands;
    private int result;

    public MrOperation() {
        memory = new Memory();
        operands = new ArrayList<>();
    }

    @Override
    public void addOperand(int operand) {
        /*this.operands.add(operand);

        if (this.isCompleted()) {
            this.result = this.operands.get(0);
        }
*/
    }

    @Override
    public int getResult() {

        return memory.remove();
    }

    @Override
    public boolean isCompleted() {
        return this.operands.size() == 0;
    }
}
