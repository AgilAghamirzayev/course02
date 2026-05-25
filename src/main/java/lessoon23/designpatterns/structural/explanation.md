# Structural Design Patterns

Structural design patterns are about how classes and objects are connected together.

They help us build larger structures from smaller objects while keeping the code flexible, reusable, and easy to understand.

The main goal is:

> Organize classes and objects so they work together cleanly without creating messy dependencies.

Structural patterns are useful when your application has many classes that need to cooperate.

## Why Structural Patterns Matter

In real applications, classes rarely work alone.

For example:

- A service may need to talk to an external API
- A class may need extra behavior without changing its original code
- A complex system may need a simple interface
- A tree-like structure may contain both simple and grouped objects
- Expensive objects may need to be shared

Structural patterns help solve these design problems.

The most common structural design patterns are:

- Adapter
- Bridge
- Composite
- Decorator
- Facade
- Flyweight
- Proxy

## 1. Adapter Pattern

### Meaning

Adapter allows two incompatible classes to work together.

In simple words, it converts one interface into another interface that the client expects.

### Real-world example

Think about a phone charger adapter.

If your charger plug does not fit the wall socket, you use an adapter. The adapter does not change the charger or the wall socket. It simply makes them compatible.

### When to use Adapter

Use Adapter when:

- You want to use an existing class, but its methods do not match what your code expects
- You are working with third-party libraries
- You need to connect old code with new code
- You want to avoid modifying existing working classes

### Java example

Suppose our application expects this interface:

```java
interface PaymentProcessor {
    void pay(double amount);
}
```

But a third-party payment library has a different method:

```java
class StripePaymentService {
    public void makePayment(double money) {
        System.out.println("Paid with Stripe: " + money);
    }
}
```

We can create an adapter:

```java
class StripePaymentAdapter implements PaymentProcessor {
    private final StripePaymentService stripePaymentService;

    public StripePaymentAdapter(StripePaymentService stripePaymentService) {
        this.stripePaymentService = stripePaymentService;
    }

    public void pay(double amount) {
        stripePaymentService.makePayment(amount);
    }
}
```

Usage:

```java
StripePaymentService stripe = new StripePaymentService();
PaymentProcessor paymentProcessor = new StripePaymentAdapter(stripe);

paymentProcessor.pay(100);
```

### Problem solved

The application can use Stripe without changing the application payment interface.

The adapter translates between our code and the third-party code.

## 2. Bridge Pattern

### Meaning

Bridge separates abstraction from implementation so both can change independently.

In simple words, it avoids creating too many subclasses when two parts of a system can vary separately.

### Real-world example

Think about a remote control and a TV.

A remote control can work with different devices:

- Samsung TV
- LG TV
- Sony TV

Also, there can be different remotes:

- Basic remote
- Smart remote
- Voice remote

Instead of creating classes like `SamsungBasicRemote`, `SamsungSmartRemote`, `LgBasicRemote`, `LgSmartRemote`, we separate remotes from devices.

The remote is the abstraction.
The device is the implementation.

### When to use Bridge

Use Bridge when:

- You have two dimensions that can change independently
- Inheritance creates too many combinations
- You want to switch implementation at runtime
- You want to keep abstraction code separate from platform-specific code

### Bad design

```java
class SamsungBasicRemote {
}

class SamsungSmartRemote {
}

class LgBasicRemote {
}

class LgSmartRemote {
}
```

The number of classes grows quickly.

### Better example

```java
interface Device {
    void turnOn();
    void turnOff();
    void setVolume(int volume);
}

class SamsungTv implements Device {
    public void turnOn() {
        System.out.println("Samsung TV is on");
    }

    public void turnOff() {
        System.out.println("Samsung TV is off");
    }

    public void setVolume(int volume) {
        System.out.println("Samsung TV volume: " + volume);
    }
}

class LgTv implements Device {
    public void turnOn() {
        System.out.println("LG TV is on");
    }

    public void turnOff() {
        System.out.println("LG TV is off");
    }

    public void setVolume(int volume) {
        System.out.println("LG TV volume: " + volume);
    }
}

abstract class RemoteControl {
    protected Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    public abstract void power();
}

class BasicRemote extends RemoteControl {
    public BasicRemote(Device device) {
        super(device);
    }

    public void power() {
        device.turnOn();
    }
}

class SmartRemote extends RemoteControl {
    public SmartRemote(Device device) {
        super(device);
    }

    public void power() {
        device.turnOn();
    }

    public void mute() {
        device.setVolume(0);
    }
}
```

Usage:

```java
Device samsungTv = new SamsungTv();
RemoteControl remote = new SmartRemote(samsungTv);

remote.power();
```

### Problem solved

Now remotes and devices can change independently.

We can add a new device without changing remote classes.
We can add a new remote without changing device classes.

## 3. Composite Pattern

### Meaning

Composite lets us treat individual objects and groups of objects in the same way.

In simple words, it is useful for tree-like structures.

### Real-world example

Think about folders and files on your computer.

A file is a single item.
A folder can contain files and other folders.

But both files and folders can be opened, moved, renamed, or deleted.

Composite helps us work with both simple objects and grouped objects using the same interface.

### When to use Composite

Use Composite when:

- You have tree structures
- You want to treat single objects and groups uniformly
- Objects can contain other objects of the same general type

Common examples:

- File systems
- Organization charts
- Menu systems
- UI components
- Product categories

### Java example

```java
interface FileSystemItem {
    void showInfo();
}

class File implements FileSystemItem {
    private final String name;

    public File(String name) {
        this.name = name;
    }

    public void showInfo() {
        System.out.println("File: " + name);
    }
}

class Folder implements FileSystemItem {
    private final String name;
    private final List<FileSystemItem> items = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(FileSystemItem item) {
        items.add(item);
    }

    public void showInfo() {
        System.out.println("Folder: " + name);

        for (FileSystemItem item : items) {
            item.showInfo();
        }
    }
}
```

Usage:

```java
Folder root = new Folder("root");
Folder documents = new Folder("documents");

File cv = new File("cv.pdf");
File notes = new File("notes.txt");

documents.add(cv);
documents.add(notes);
root.add(documents);

root.showInfo();
```

Required imports:

```java
import java.util.ArrayList;
import java.util.List;
```

### Problem solved

The code can call `showInfo()` on both `File` and `Folder`.

It does not need to know whether the object is simple or a group.

## 4. Decorator Pattern

### Meaning

Decorator adds new behavior to an object without changing its original class.

In simple words, it wraps an object with extra features.

### Real-world example

Think about coffee.

You can order simple coffee.
Then you can add:

- Milk
- Sugar
- Caramel
- Cream

Each extra ingredient decorates the original coffee.

The original coffee does not need to change.

### When to use Decorator

Use Decorator when:

- You want to add behavior dynamically
- You do not want to modify the original class
- You want to combine features in different ways
- Inheritance would create too many subclasses

### Java example

```java
interface Coffee {
    double cost();
    String description();
}

class SimpleCoffee implements Coffee {
    public double cost() {
        return 2.0;
    }

    public String description() {
        return "Simple coffee";
    }
}

class MilkDecorator implements Coffee {
    private final Coffee coffee;

    public MilkDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public double cost() {
        return coffee.cost() + 0.5;
    }

    public String description() {
        return coffee.description() + ", milk";
    }
}

class SugarDecorator implements Coffee {
    private final Coffee coffee;

    public SugarDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public double cost() {
        return coffee.cost() + 0.2;
    }

    public String description() {
        return coffee.description() + ", sugar";
    }
}
```

Usage:

```java
Coffee coffee = new SimpleCoffee();
coffee = new MilkDecorator(coffee);
coffee = new SugarDecorator(coffee);

System.out.println(coffee.description());
System.out.println(coffee.cost());
```

### Problem solved

We can combine features without creating many subclasses like:

- `CoffeeWithMilk`
- `CoffeeWithSugar`
- `CoffeeWithMilkAndSugar`
- `CoffeeWithMilkSugarAndCaramel`

Decorator gives flexible combinations.

## 5. Facade Pattern

### Meaning

Facade provides a simple interface to a complex system.

In simple words, it hides complicated internal steps behind one easy method.

### Real-world example

Think about starting a car.

You press one start button.

Behind the scenes, many things happen:

- Fuel system starts
- Battery provides power
- Engine starts
- Sensors are checked

You do not need to manually control all those systems.

The start button is a facade.

### When to use Facade

Use Facade when:

- A system has many complex classes
- The client only needs a simple way to use the system
- You want to reduce dependency on internal details
- You want to make code easier to read

### Java example

```java
class InventoryService {
    public boolean isAvailable(String productId) {
        System.out.println("Checking inventory");
        return true;
    }
}

class PaymentService {
    public void pay(double amount) {
        System.out.println("Processing payment: " + amount);
    }
}

class ShippingService {
    public void ship(String productId) {
        System.out.println("Shipping product: " + productId);
    }
}

class OrderFacade {
    private final InventoryService inventoryService = new InventoryService();
    private final PaymentService paymentService = new PaymentService();
    private final ShippingService shippingService = new ShippingService();

    public void placeOrder(String productId, double amount) {
        if (inventoryService.isAvailable(productId)) {
            paymentService.pay(amount);
            shippingService.ship(productId);
            System.out.println("Order completed");
        }
    }
}
```

Usage:

```java
OrderFacade orderFacade = new OrderFacade();
orderFacade.placeOrder("LAPTOP-1", 2500);
```

### Problem solved

The client does not need to call inventory, payment, and shipping manually.

It uses one simple method: `placeOrder()`.

## 6. Flyweight Pattern

### Meaning

Flyweight reduces memory usage by sharing common data between many objects.

In simple words, if many objects have the same repeated data, store that shared data once and reuse it.

### Real-world example

Think about a game with thousands of trees.

Each tree has unique data:

- X position
- Y position

But many trees share the same data:

- Tree image
- Color
- Texture
- Type

Instead of storing the same image and texture in every tree object, the game stores shared tree type data once.

### When to use Flyweight

Use Flyweight when:

- Your application creates many similar objects
- Memory usage becomes a problem
- Many objects share the same data
- Shared data can be separated from unique data

Common examples:

- Game objects
- Text editor characters
- Icons
- Map markers
- Product catalog attributes

### Java example

```java
class TreeType {
    private final String name;
    private final String color;
    private final String texture;

    public TreeType(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    public void draw(int x, int y) {
        System.out.println("Drawing " + name + " tree at " + x + ", " + y);
    }
}

class Tree {
    private final int x;
    private final int y;
    private final TreeType type;

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw() {
        type.draw(x, y);
    }
}

class TreeTypeFactory {
    private static final Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, String color, String texture) {
        String key = name + "-" + color + "-" + texture;

        if (!treeTypes.containsKey(key)) {
            treeTypes.put(key, new TreeType(name, color, texture));
        }

        return treeTypes.get(key);
    }
}
```

Usage:

```java
TreeType oakType = TreeTypeFactory.getTreeType("Oak", "Green", "Oak texture");

Tree tree1 = new Tree(10, 20, oakType);
Tree tree2 = new Tree(50, 80, oakType);

tree1.draw();
tree2.draw();
```

Required imports:

```java
import java.util.HashMap;
import java.util.Map;
```

### Problem solved

Thousands of tree objects can share the same `TreeType`.

This saves memory because the heavy shared data is not duplicated.

## 7. Proxy Pattern

### Meaning

Proxy controls access to another object.

In simple words, a proxy stands between the client and the real object.

### Real-world example

Think about a bank card.

You do not directly access the bank vault when you buy something.

Your card acts as a proxy. It checks your account, validates the payment, and allows or denies access to your money.

### When to use Proxy

Use Proxy when:

- You want to control access to an object
- Object creation is expensive and should be delayed
- You need security checks
- You need logging or caching
- You want to represent a remote object

Common proxy types:

- Virtual proxy: creates expensive object only when needed
- Protection proxy: checks permissions before access
- Remote proxy: represents an object on another server
- Caching proxy: stores results to avoid repeated work

### Java example

```java
interface Image {
    void display();
}

class RealImage implements Image {
    private final String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading image from disk: " + fileName);
    }

    public void display() {
        System.out.println("Displaying image: " + fileName);
    }
}

class ImageProxy implements Image {
    private RealImage realImage;
    private final String fileName;

    public ImageProxy(String fileName) {
        this.fileName = fileName;
    }

    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }

        realImage.display();
    }
}
```

Usage:

```java
Image image = new ImageProxy("profile.png");

System.out.println("Image object created");
image.display();
image.display();
```

### Problem solved

The real image is loaded only when `display()` is called.

If the image is never displayed, expensive loading never happens.

## Quick Comparison

| Pattern | Main idea | Real-world example | Best for |
| --- | --- | --- | --- |
| Adapter | Make incompatible classes work together | Charger adapter | Connecting old, new, or third-party code |
| Bridge | Separate abstraction from implementation | Remote control and TV | Avoiding too many subclasses |
| Composite | Treat single objects and groups the same | Files and folders | Tree-like structures |
| Decorator | Add behavior by wrapping an object | Coffee with milk and sugar | Flexible feature combinations |
| Facade | Provide simple interface to complex system | Car start button | Simplifying complex subsystems |
| Flyweight | Share common data to save memory | Thousands of game trees | Many similar objects |
| Proxy | Control access to another object | Bank card | Lazy loading, security, caching |

## Practical Shopping App Example

Imagine an online shopping application.

### Adapter

The app can connect to a third-party payment provider whose API does not match your app's payment interface.

```java
PaymentProcessor processor = new StripePaymentAdapter(new StripePaymentService());
processor.pay(100);
```

### Bridge

The app can separate notification types from delivery channels.

For example, a notification can be urgent or normal, and delivery can be email or SMS.

### Composite

Product categories can contain products and subcategories.

```java
Category electronics = new Category("Electronics");
Category phones = new Category("Phones");
Product iphone = new Product("iPhone");

phones.add(iphone);
electronics.add(phones);
```

### Decorator

The app can add extra services to an order.

```java
Order order = new BasicOrder();
order = new GiftWrapOrder(order);
order = new InsuranceOrder(order);
```

### Facade

The app can hide order placement complexity behind one method.

```java
orderFacade.placeOrder("LAPTOP-1", 2500);
```

### Flyweight

The app can share product images, brand metadata, or category icons instead of duplicating them for every product card.

### Proxy

The app can use a proxy to load product images only when they are actually displayed.

```java
Image image = new ImageProxy("laptop.png");
image.display();
```

## Common Mistakes

### Using Adapter when you can change the original code

Adapter is useful when you cannot or should not modify an existing class.

If you own both classes and changing them is simple, an adapter may be unnecessary.

### Overusing Facade

Facade should simplify complexity.

It should not become a huge class that contains all business logic.

### Confusing Decorator and Inheritance

Inheritance adds behavior at compile time.

Decorator adds behavior at runtime by wrapping objects.

### Confusing Proxy and Decorator

Both wrap another object, but their goals are different.

Decorator adds new behavior.

Proxy controls access.

### Using Flyweight without a memory problem

Flyweight is useful when many objects share repeated data.

If your application only creates a few objects, Flyweight can add unnecessary complexity.

## Final Advice

Structural design patterns are useful when relationships between classes become complex.

Use them when:

- You need to connect incompatible code
- You have too many subclasses
- You need tree-like object structures
- You want to add behavior without changing original classes
- You want to simplify access to a complex system
- You need to save memory by sharing common data
- You need to control access to an object

The best structural design keeps objects connected clearly.

Good structure makes the system easier to extend, easier to test, and easier to understand.
