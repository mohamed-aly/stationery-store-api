package stationary.store.dao.receipt;

import stationary.store.model.OrderItem;

import java.util.List;

public interface ReceiptDAO {

    List<OrderItem> getReceipts();

    void saveReceipt(OrderItem Receipt);

    OrderItem getReceipt(int id);

    void deleteReceipt(int id);

}
