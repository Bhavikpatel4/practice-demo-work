package demo.java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class MapToDtoContaingDtos {
    public static void main(String[] args) {
        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> map1 = new HashMap<>();
        map1.put("order_id", 1);
        map1.put("order_date", "30/06/2023");
        map1.put("item_name", "item11");
        map1.put("item_id", "itemId11");
        map1.put("item_amount", 100.00);

        Map<String, Object> map3 = new HashMap<>();
        map3.put("order_id", 1);
        map3.put("order_date", "30/06/2023");
        map3.put("item_name", "item12");
        map3.put("item_id", "itemId12");
        map3.put("item_amount", 500.00);

        Map<String, Object> map2 = new HashMap<>();
        map2.put("order_id", 2);
        map2.put("order_date", "29/06/2023");
        map2.put("item_name", "item21");
        map2.put("item_id", "itemId21");
        map2.put("item_amount", 1000.00);

        list.add(map1);
        list.add(map2);
        list.add(map3);

        List<Order> orders = convertToOrders(list);
        orders.forEach(System.out::println);
    }

    public static List<Order> convertToOrders(List<Map<String, Object>> list) {
        return list.stream()
                .collect(Collectors.groupingBy(
                        map -> new Order(
                                (int) map.get("order_id"),
                                (String) map.get("order_date")
                        ),
                        Collectors.mapping(
                                map -> new Item(
                                        (String) map.get("item_name"),
                                        (String) map.get("item_id"),
                                        (double) map.get("item_amount")
                                ),
                                Collectors.toList()
                        )
                ))
                .entrySet()
                .stream()
                .map(entry -> {
                    Order order = entry.getKey();
                    order.setItems(entry.getValue());
                    return order;
                })
                .collect(Collectors.toList());
    }
}

class Order {
    private int orderId;
    private String orderDate;
    private List<Item> items;

    public Order(int orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.items = new ArrayList<>();
    }

    public int getOrderId() {
        return orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
	public int hashCode() {
		return Objects.hash(orderDate, orderId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(orderDate, other.orderDate) && orderId == other.orderId;
	}

	@Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderDate='" + orderDate + '\'' +
                ", items=" + items +
                '}';
    }
}

class Item {
    private String itemName;
    private String itemId;
    private double itemAmount;

    public Item(String itemName, String itemId, double itemAmount) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.itemAmount = itemAmount;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemId() {
        return itemId;
    }

    public double getItemAmount() {
        return itemAmount;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", itemId='" + itemId + '\'' +
                ", itemAmount=" + itemAmount +
                '}';
    }
}