package calculator;

import java.util.ArrayList;
import java.util.List;

public class MsOperation implements Operation {
    private Memory memory;
    private List<Integer> operands;
    private int result;

    public MsOperation() {
        memory = new Memory();
        operands = new ArrayList<>();
    }

    @Override
    public void addOperand(int operand) {
        this.operands.add(operand);

        if (this.isCompleted()) {
            this.result = this.operands.get(0);
        }

    }

    @Override
    public int getResult() {
        memory.add(result);
        return result;
    }

    @Override
    public boolean isCompleted() {
        return this.operands.size() == 1;
    }
}
