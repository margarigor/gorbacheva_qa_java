package lesson3;

public class Product {
    private String name;
    private String productionDate;
    private String manufacturer;
    private String countryOfOrigin;
    private int price;
    private boolean reservationStatus;

public Product (String name, String productionDate, String manufacturer, String countryOfOrigin, int price, boolean reservationStatus){
    this.name = name;
    this.productionDate = productionDate;
    this.manufacturer = manufacturer;
    this.countryOfOrigin = countryOfOrigin;
    this.price = price;
    this.reservationStatus = reservationStatus;
}

    public void info() {
        System.out.println("Название товара: " + name);
        System.out.println("дата производства: " + productionDate);
        System.out.println("производитель: " + manufacturer);
        System.out.println("страна происхождения: " + countryOfOrigin);
        System.out.println("цена: " + price);
        System.out.println("состояние бронирования покупателем: " + reservationStatus);
        System.out.println(". . .");
    }
}

