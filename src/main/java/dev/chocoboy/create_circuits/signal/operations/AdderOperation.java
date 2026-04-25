package dev.chocoboy.create_circuits.signal.operations;

import dev.chocoboy.create_circuits.signal.SignalOperation;

public class AdderOperation implements SignalOperation {
    @Override
    public int apply(int a, int b) {
        return a + b;
    }
}

