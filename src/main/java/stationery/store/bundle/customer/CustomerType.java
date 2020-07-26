package stationery.store.bundle.customer;

import java.util.stream.Stream;

public enum CustomerType {
    REGISTERED(1), ANONYMOUS(2);

    private int type;

    private CustomerType(int stage) {
        this.type = stage;
    }

    public int getType() {
        return this.type;
    }

    public static CustomerType of(int stage) {
        return Stream.of(CustomerType.values())
                .filter(p -> p.getType() == stage)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
