# Behavioral Design Patterns

Behavioral design patterns are about how objects communicate and share responsibilities.

They help us organize business logic, object interaction, algorithms, workflows, and state changes in a clean way.

The main goal is:

> Make object communication flexible without creating tightly coupled code.

Behavioral patterns are useful when an application has many objects that need to cooperate.

## Why Behavioral Patterns Matter

In real applications, objects do not just store data.

They also:

- Send requests to each other
- React to events
- Choose algorithms
- Change behavior based on state
- Execute commands
- Save and restore history
- Walk through collections
- Coordinate complex workflows

Behavioral patterns help keep these interactions clear and maintainable.

The most common behavioral design patterns are:

- Chain of Responsibility
- Command
- Iterator
- Mediator
- Memento
- Observer
- State
- Strategy
- Template Method
- Visitor

## 1. Chain of Responsibility Pattern

### Meaning

Chain of Responsibility passes a request through a chain of handlers.

Each handler decides whether it can process the request or pass it to the next handler.

### Real-world example

Think about customer support.

A simple problem goes to a support agent.
A technical problem goes to an engineer.
A billing problem goes to the finance department.

The customer does not need to know exactly who will solve the issue. The request moves through the correct chain.

### When to use Chain of Responsibility

Use this pattern when:

- More than one object may handle a request
- The handler should be selected dynamically
- You want to avoid many `if` statements
- You want to process requests step by step

Common examples:

- Logging levels
- Request filters
- Authentication and authorization
- Approval workflows
- Support ticket routing

### Java example

```java
abstract class SupportHandler {
    private SupportHandler nextHandler;

    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handle(String issueType) {
        if (canHandle(issueType)) {
            process(issueType);
        } else if (nextHandler != null) {
            nextHandler.handle(issueType);
        } else {
            System.out.println("No handler found for: " + issueType);
        }
    }

    protected abstract boolean canHandle(String issueType);

    protected abstract void process(String issueType);
}

class TechnicalSupport extends SupportHandler {
    protected boolean canHandle(String issueType) {
        return issueType.equalsIgnoreCase("TECHNICAL");
    }

    protected void process(String issueType) {
        System.out.println("Technical support is handling the issue");
    }
}

class BillingSupport extends SupportHandler {
    protected boolean canHandle(String issueType) {
        return issueType.equalsIgnoreCase("BILLING");
    }

    protected void process(String issueType) {
        System.out.println("Billing support is handling the issue");
    }
}
```

Usage:

```java
SupportHandler technical = new TechnicalSupport();
SupportHandler billing = new BillingSupport();

technical.setNextHandler(billing);

technical.handle("BILLING");
```

### Problem solved

The request sender does not need to know which exact handler will process the request.

We can add new handlers without changing the client code.

## 2. Command Pattern

### Meaning

Command turns a request into an object.

This lets us pass commands around, store them, queue them, log them, or undo them.

### Real-world example

Think about a restaurant order.

A customer tells the waiter what they want.
The waiter writes the order on paper.
The kitchen receives the order and prepares the food.

The written order is the command.

The customer does not directly control the kitchen.

### When to use Command

Use this pattern when:

- You want to represent actions as objects
- You need undo or redo
- You want to queue tasks
- You want to log operations
- You want to decouple the object that requests an action from the object that performs it

Common examples:

- Button clicks
- Text editor undo and redo
- Task queues
- Remote control actions
- Transaction logs

### Java example

```java
interface Command {
    void execute();
}

class Light {
    public void turnOn() {
        System.out.println("Light is on");
    }

    public void turnOff() {
        System.out.println("Light is off");
    }
}

class TurnOnLightCommand implements Command {
    private final Light light;

    public TurnOnLightCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }
}

class TurnOffLightCommand implements Command {
    private final Light light;

    public TurnOffLightCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOff();
    }
}

class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}
```

Usage:

```java
Light light = new Light();
Command turnOn = new TurnOnLightCommand(light);

RemoteControl remote = new RemoteControl();
remote.setCommand(turnOn);
remote.pressButton();
```

### Problem solved

The remote does not know how a light works.

It only executes a command.

## 3. Iterator Pattern

### Meaning

Iterator provides a way to access elements of a collection one by one without exposing its internal structure.

### Real-world example

Think about a TV remote changing channels.

You press "next" to go through channels.
You do not need to know how the TV stores channel data internally.

The remote gives a simple way to move through the collection.

### When to use Iterator

Use this pattern when:

- You want to loop through a collection
- You do not want to expose internal data structure
- You want the same traversal style for different collections

Common examples:

- Lists
- Menus
- Playlists
- Search results
- Tree traversal

### Java example

Java already has built-in iterator support.

```java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Playlist {
    private final List<String> songs = new ArrayList<>();

    public void addSong(String song) {
        songs.add(song);
    }

    public Iterator<String> iterator() {
        return songs.iterator();
    }
}
```

Usage:

```java
Playlist playlist = new Playlist();
playlist.addSong("Song A");
playlist.addSong("Song B");

Iterator<String> iterator = playlist.iterator();

while (iterator.hasNext()) {
    System.out.println(iterator.next());
}
```

### Problem solved

The client can go through songs without knowing how `Playlist` stores them internally.

## 4. Mediator Pattern

### Meaning

Mediator centralizes communication between objects.

Instead of objects talking directly to each other, they communicate through a mediator.

### Real-world example

Think about an airport control tower.

Airplanes do not directly negotiate with each other about landing and takeoff.

They communicate with the control tower.

The control tower coordinates everything.

### When to use Mediator

Use this pattern when:

- Many objects communicate with each other
- Direct communication creates messy dependencies
- You want one object to coordinate interactions
- You want to reduce coupling between objects

Common examples:

- Chat rooms
- UI form coordination
- Air traffic control
- Workflow coordination
- Event buses

### Java example

```java
interface ChatMediator {
    void sendMessage(String message, User userEntity);
}

class ChatRoom implements ChatMediator {
    private final List<User> users = new ArrayList<>();

    public void addUser(User userEntity) {
        users.add(userEntity);
    }

    public void sendMessage(String message, User sender) {
        for (User userEntity : users) {
            if (userEntity != sender) {
                userEntity.receive(message);
            }
        }
    }
}

class User {
    private final String name;
    private final ChatMediator mediator;

    public User(String name, ChatMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public void send(String message) {
        mediator.sendMessage(name + ": " + message, this);
    }

    public void receive(String message) {
        System.out.println(message);
    }
}
```

Usage:

```java
ChatRoom chatRoom = new ChatRoom();

User ali = new User("Ali", chatRoom);
User leyla = new User("Leyla", chatRoom);

chatRoom.addUser(ali);
chatRoom.addUser(leyla);

ali.send("Hello");
```

Required imports:

```java
import java.util.ArrayList;
import java.util.List;
```

### Problem solved

Users do not need references to every other userEntity.

The chat room coordinates communication.

## 5. Memento Pattern

### Meaning

Memento saves and restores an object's previous state without exposing its internal details.

### Real-world example

Think about undo in a text editor.

You write text.
The editor saves previous versions.
When you press undo, it restores an earlier state.

You do not need to know how the editor stores all internal details.

### When to use Memento

Use this pattern when:

- You need undo or rollback
- You want to save object state safely
- You do not want external code to directly access internal fields

Common examples:

- Text editor undo
- Game save points
- Form draft restoration
- Database transaction rollback
- Configuration snapshots

### Java example

```java
class TextEditor {
    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public TextMemento save() {
        return new TextMemento(content);
    }

    public void restore(TextMemento memento) {
        content = memento.getContent();
    }
}

class TextMemento {
    private final String content;

    public TextMemento(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
```

Usage:

```java
TextEditor editor = new TextEditor();

editor.setContent("Version 1");
TextMemento savedState = editor.save();

editor.setContent("Version 2");
System.out.println(editor.getContent());

editor.restore(savedState);
System.out.println(editor.getContent());
```

### Problem solved

The editor can restore previous content without exposing all of its internal implementation.

## 6. Observer Pattern

### Meaning

Observer allows objects to subscribe to events and get notified when something changes.

One object is called the subject.
Other objects are observers.

When the subject changes, it notifies all observers.

### Real-world example

Think about a YouTube channel.

Users subscribe to a channel.
When a new video is uploaded, all subscribers receive a notification.

The channel does not need to manually call each userEntity in a hardcoded way.

### When to use Observer

Use this pattern when:

- Many objects need to react to one object's changes
- You want loose coupling between sender and receivers
- Subscribers can be added or removed dynamically

Common examples:

- Event listeners
- Notification systems
- UI events
- Stock price updates
- Messaging systems

### Java example

```java
interface Observer {
    void update(String videoTitle);
}

class Subscriber implements Observer {
    private final String name;

    public Subscriber(String name) {
        this.name = name;
    }

    public void update(String videoTitle) {
        System.out.println(name + " received notification: " + videoTitle);
    }
}

class YouTubeChannel {
    private final List<Observer> subscribers = new ArrayList<>();

    public void subscribe(Observer observer) {
        subscribers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        subscribers.remove(observer);
    }

    public void uploadVideo(String title) {
        System.out.println("New video uploaded: " + title);
        notifySubscribers(title);
    }

    private void notifySubscribers(String title) {
        for (Observer subscriber : subscribers) {
            subscriber.update(title);
        }
    }
}
```

Usage:

```java
YouTubeChannel channel = new YouTubeChannel();

Observer ali = new Subscriber("Ali");
Observer leyla = new Subscriber("Leyla");

channel.subscribe(ali);
channel.subscribe(leyla);

channel.uploadVideo("Design Patterns in Java");
```

Required imports:

```java
import java.util.ArrayList;
import java.util.List;
```

### Problem solved

The channel does not need to know the concrete subscriber classes.

It only notifies observers.

## 7. State Pattern

### Meaning

State allows an object to change its behavior when its internal state changes.

In simple words, the object behaves differently depending on its current state.

### Real-world example

Think about a traffic light.

If the light is green, cars can move.
If the light is yellow, cars should prepare to stop.
If the light is red, cars must stop.

The traffic light object behaves differently based on state.

### When to use State

Use this pattern when:

- An object has different behavior depending on its state
- There are many `if` or `switch` statements checking state
- State transitions should be organized clearly

Common examples:

- Order status
- Document workflow
- Traffic lights
- Media player states
- Account status

### Java example

```java
interface OrderState {
    void next(Order order);
    void printStatus();
}

class NewOrderState implements OrderState {
    public void next(Order order) {
        order.setState(new PaidOrderState());
    }

    public void printStatus() {
        System.out.println("Order is new");
    }
}

class PaidOrderState implements OrderState {
    public void next(Order order) {
        order.setState(new ShippedOrderState());
    }

    public void printStatus() {
        System.out.println("Order is paid");
    }
}

class ShippedOrderState implements OrderState {
    public void next(Order order) {
        System.out.println("Order is already shipped");
    }

    public void printStatus() {
        System.out.println("Order is shipped");
    }
}

class Order {
    private OrderState state = new NewOrderState();

    public void setState(OrderState state) {
        this.state = state;
    }

    public void nextState() {
        state.next(this);
    }

    public void printStatus() {
        state.printStatus();
    }
}
```

Usage:

```java
Order order = new Order();

order.printStatus();
order.nextState();
order.printStatus();
order.nextState();
order.printStatus();
```

### Problem solved

State-specific behavior is moved into separate classes.

The `Order` class does not need a large `switch` statement for every status.

## 8. Strategy Pattern

### Meaning

Strategy lets us define different algorithms and choose one at runtime.

In simple words, if there are multiple ways to do something, put each way into its own class.

### Real-world example

Think about traveling from home to work.

You can choose different strategies:

- Drive a car
- Take a bus
- Ride a bicycle
- Walk

The goal is the same, but the strategy changes.

### When to use Strategy

Use this pattern when:

- You have multiple algorithms for the same task
- You want to switch behavior at runtime
- You want to avoid many `if` statements
- You want each algorithm to be tested separately

Common examples:

- Payment strategies
- Discount strategies
- Sorting strategies
- Delivery strategies
- Authentication strategies

### Java example

```java
interface PaymentStrategy {
    void pay(double amount);
}

class CardPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid by card: " + amount);
    }
}

class CashPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid by cash: " + amount);
    }
}

class PayPalPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid by PayPal: " + amount);
    }
}

class CheckoutService {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(double amount) {
        paymentStrategy.pay(amount);
    }
}
```

Usage:

```java
CheckoutService checkoutService = new CheckoutService();

checkoutService.setPaymentStrategy(new CardPayment());
checkoutService.checkout(100);

checkoutService.setPaymentStrategy(new PayPalPayment());
checkoutService.checkout(200);
```

### Problem solved

Payment logic is not hardcoded in `CheckoutService`.

New payment methods can be added as new strategy classes.

## 9. Template Method Pattern

### Meaning

Template Method defines the skeleton of an algorithm in a parent class, while child classes provide specific steps.

In simple words, the parent class controls the order of steps, and subclasses customize some steps.

### Real-world example

Think about making a hot drink.

The general steps are:

1. Boil water
2. Add main ingredient
3. Pour into cup
4. Add extras

For tea, the main ingredient is tea leaves.
For coffee, the main ingredient is coffee powder.

The process is similar, but some steps are different.

### When to use Template Method

Use this pattern when:

- Multiple classes share the same algorithm structure
- Some steps are different in each subclass
- You want to avoid duplicating the same workflow
- You want the parent class to control the process order

Common examples:

- Report generation
- Data import pipelines
- Payment processing flow
- File parsing
- Test setup workflows

### Java example

```java
abstract class DataImporter {
    public final void importData() {
        openFile();
        readData();
        validateData();
        saveData();
        closeFile();
    }

    private void openFile() {
        System.out.println("Opening file");
    }

    protected abstract void readData();

    protected abstract void validateData();

    private void saveData() {
        System.out.println("Saving data");
    }

    private void closeFile() {
        System.out.println("Closing file");
    }
}

class CsvDataImporter extends DataImporter {
    protected void readData() {
        System.out.println("Reading CSV data");
    }

    protected void validateData() {
        System.out.println("Validating CSV data");
    }
}

class JsonDataImporter extends DataImporter {
    protected void readData() {
        System.out.println("Reading JSON data");
    }

    protected void validateData() {
        System.out.println("Validating JSON data");
    }
}
```

Usage:

```java
DataImporter importer = new CsvDataImporter();
importer.importData();
```

### Problem solved

The common workflow is written once.

Subclasses only provide the steps that are different.

## 10. Visitor Pattern

### Meaning

Visitor lets us add new operations to objects without changing their classes.

The operation is moved into a separate visitor object.

### Real-world example

Think about a shopping cart.

The cart contains different products:

- Book
- Phone
- Food item

Different visitors can perform different operations:

- Calculate tax
- Calculate shipping
- Print invoice

Products do not need to contain all possible operations inside themselves.

### When to use Visitor

Use this pattern when:

- You have a stable set of object types
- You need to add many new operations
- You do not want to keep adding methods to existing classes
- Operations depend on concrete object types

Common examples:

- Tax calculation
- Report generation
- Exporting objects
- Compiler syntax tree processing
- File system operations

### Java example

```java
interface ShoppingItem {
    void accept(ShoppingCartVisitor visitor);
}

class Book implements ShoppingItem {
    private final double price;

    public Book(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void accept(ShoppingCartVisitor visitor) {
        visitor.visit(this);
    }
}

class Phone implements ShoppingItem {
    private final double price;

    public Phone(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void accept(ShoppingCartVisitor visitor) {
        visitor.visit(this);
    }
}

interface ShoppingCartVisitor {
    void visit(Book book);
    void visit(Phone phone);
}

class TaxCalculatorVisitor implements ShoppingCartVisitor {
    public void visit(Book book) {
        System.out.println("Book tax: " + book.getPrice() * 0.05);
    }

    public void visit(Phone phone) {
        System.out.println("Phone tax: " + phone.getPrice() * 0.18);
    }
}
```

Usage:

```java
ShoppingItem book = new Book(30);
ShoppingItem phone = new Phone(1000);

ShoppingCartVisitor taxCalculator = new TaxCalculatorVisitor();

book.accept(taxCalculator);
phone.accept(taxCalculator);
```

### Problem solved

Tax calculation is separated from product classes.

We can add another visitor, like `ShippingCalculatorVisitor`, without changing `Book` and `Phone`.

## Quick Comparison

| Pattern | Main idea | Real-world example | Best for |
| --- | --- | --- | --- |
| Chain of Responsibility | Pass request through handlers | Support ticket routing | Filters, approvals, routing |
| Command | Turn action into object | Restaurant order | Undo, queues, button actions |
| Iterator | Access collection items one by one | TV channel next button | Traversing collections |
| Mediator | Central communication object | Airport control tower | Reducing many object connections |
| Memento | Save and restore state | Text editor undo | Undo, rollback, snapshots |
| Observer | Notify subscribers about changes | YouTube subscribers | Events and notifications |
| State | Change behavior by state | Traffic light | Status-dependent behavior |
| Strategy | Choose algorithm dynamically | Travel method choice | Swappable algorithms |
| Template Method | Parent defines workflow steps | Making tea or coffee | Shared workflow structure |
| Visitor | Add operations separately | Shopping cart tax visitor | Many operations on stable objects |

## Practical Shopping App Example

Imagine an online shopping application.

### Chain of Responsibility

An order request can pass through validation, fraud check, payment check, and stock check.

```java
orderValidator.setNextHandler(fraudChecker);
fraudChecker.setNextHandler(stockChecker);
orderValidator.handle(order);
```

### Command

Each userEntity action can be represented as a command.

```java
Command placeOrder = new PlaceOrderCommand(orderService, order);
placeOrder.execute();
```

### Iterator

The app can iterate through products in a cart without exposing the cart's internal structure.

```java
Iterator<Product> iterator = cart.iterator();
```

### Mediator

A checkout mediator can coordinate cart, payment, inventory, and shipping services.

```java
checkoutMediator.completeCheckout();
```

### Memento

The app can save a draft order and restore it later.

```java
OrderMemento draft = order.save();
order.restore(draft);
```

### Observer

Customers can subscribe to product availability notifications.

```java
product.subscribe(customer);
product.setAvailable(true);
```

### State

An order can behave differently depending on its status.

```java
order.nextState();
order.printStatus();
```

### Strategy

The app can choose different discount strategies.

```java
cart.setDiscountStrategy(new BlackFridayDiscount());
```

### Template Method

Different report generators can share the same generation flow.

```java
ReportGenerator report = new PdfReportGenerator();
report.generate();
```

### Visitor

The app can calculate tax or shipping for different product types.

```java
product.accept(new TaxCalculatorVisitor());
```

## Common Mistakes

### Using Strategy and State interchangeably

They look similar because both use composition.

Strategy is about choosing an algorithm.

State is about changing behavior when an object's internal state changes.

### Making Mediator too powerful

Mediator should coordinate objects.

It should not become a huge class containing all business logic.

### Using Observer without unsubscribe logic

If observers are never removed, memory leaks or unwanted notifications can happen.

Always think about `unsubscribe`.

### Overusing Visitor

Visitor is useful when object types are stable and operations change often.

If you frequently add new object types, Visitor can become painful because every visitor interface must change.

### Making Template Method too rigid

Template Method is useful when workflow order is fixed.

If subclasses need very different workflows, Strategy or composition may be better.

## Final Advice

Behavioral design patterns are useful when object interaction becomes hard to manage.

Use them when:

- Requests need to pass through multiple handlers
- Actions need to be stored, queued, logged, or undone
- Collections should be traversed without exposing internals
- Many objects communicate in a messy way
- Object state needs undo or rollback
- Many objects should react to events
- Behavior changes based on state
- Algorithms need to be interchangeable
- Multiple classes share the same workflow
- New operations need to be added without changing existing classes

The best behavioral design makes communication between objects clear.

Good behavioral patterns reduce coupling, organize logic, and make future changes easier.
