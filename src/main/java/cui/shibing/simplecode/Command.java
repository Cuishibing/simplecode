package cui.shibing.simplecode;

import java.util.ArrayList;
import java.util.List;

public abstract class Command {

    private final List<Operand> operands = new ArrayList<>();

    public Command() {
    }

    public void addOperand(Operand operand) {
        operands.add(operand);
    }

    protected abstract void run(Context context);
}
