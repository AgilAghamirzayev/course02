# Creational Design Patterns

Creational design patterns are about object creation.

They help us create objects in a clean, flexible, and reusable way instead of spreading `new` everywhere in the code.

The main goal is:

> Create objects without making the rest of the application too dependent on exact concrete classes.

Creational patterns are useful when object creation becomes complex, repetitive, or likely to change.

## Why Creational Patterns Matter

In small programs, creating objects directly is usually fine.

```java
User userEntity = new User("Ali", "ali@example.com");
```

But in bigger applications, object creation may involve:

- Many constructor parameters
- Different object types based on conditions
- Families of related objects
- Expensive object creation
- Reusing existing object structure
- Making sure only one object exists

Creational patterns help solve these problems.

The most common creational design patterns are:

- Singleton
- Factory Method
- Abstract Factory
- Builder
- Prototype

## 1. Singleton Pattern

### Meaning

Singleton makes sure that only one object of a class exists in the whole application.

It also gives one global access point to that object.

### Real-world example

Think about a school principal.

A school can have many teachers, students, and classrooms, but usually there is only one principal responsible for the whole school.

Everyone can access the principal, but there should not be multiple different principals making conflicting decisions.

### When to use Singleton

Use Singleton when there must be exactly one shared instance.

Common examples:

- Application configuration
- Logger
- Cache manager
- Database connection manager
- Thread pool manager

### Java example

```java
class AppConfig {
    private static AppConfig instance;

    private String databaseUrl;

    private AppConfig() {
        this.databaseUrl = "jdbc:mysql://localhost:3306/app";
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }
}
```

Usage:

```java
AppConfig config = AppConfig.getInstance();
System.out.println(config.getDatabaseUrl());
```

### Problem solved

Without Singleton, many parts of the program might create different configuration objects.

```java
AppConfig config1 = new AppConfig();
AppConfig config2 = new AppConfig();
```

That could cause inconsistent settings.

### Important note

Singleton should be used carefully.

Too many Singletons can make code harder to test because they behave like global state.

In modern Java applications, frameworks like Spring often manage single shared objects for us using dependency injection.

## 2. Factory Method Pattern

### Meaning

Factory Method creates objects through a method instead of directly using `new` everywhere.

The exact object type can be decided inside the factory method.

### Real-world example

Think about a pizza restaurant.

A customer orders pizza by name:

- Cheese pizza
- Chicken pizza
- Vegetarian pizza

The customer does not go into the kitchen and create the pizza. The restaurant receives the order and creates the correct pizza.

The restaurant acts like a factory.

### When to use Factory Method

Use Factory Method when object creation depends on a condition or type.

Common examples:

- Creating payment method by payment type
- Creating notification sender by channel
- Creating document parser by file extension
- Creating userEntity role object by role name

### Bad example

```java
class NotificationService {
    public void send(String type, String message) {
        if (type.equals("EMAIL")) {
            EmailNotification email = new EmailNotification();
            email.send(message);
        } else if (type.equals("SMS")) {
            SmsNotification sms = new SmsNotification();
            sms.send(message);
        }
    }
}
```

The service knows too much about object creation.

Every time we add a new notification type, we must change this service.

### Better example

```java
interface Notification {
    void send(String message);
}

class EmailNotification implements Notification {
    public void send(String message) {
        System.out.println("Sending email: " + message);
    }
}

class SmsNotification implements Notification {
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

class PushNotification implements Notification {
    public void send(String message) {
        System.out.println("Sending push notification: " + message);
    }
}

class NotificationFactory {
    public static Notification createNotification(String type) {
        if (type.equalsIgnoreCase("EMAIL")) {
            return new EmailNotification();
        }

        if (type.equalsIgnoreCase("SMS")) {
            return new SmsNotification();
        }

        if (type.equalsIgnoreCase("PUSH")) {
            return new PushNotification();
        }

        throw new IllegalArgumentException("Unknown notification type: " + type);
    }
}
```

Usage:

```java
Notification notification = NotificationFactory.createNotification("EMAIL");
notification.send("Welcome to the system");
```

### Problem solved

The object creation logic is now in one place.

If we add a new notification type, the main business code does not need to know how it is created.

## 3. Abstract Factory Pattern

### Meaning

Abstract Factory creates families of related objects without specifying their concrete classes.

Factory Method usually creates one kind of object.
Abstract Factory creates multiple related objects that belong together.

### Real-world example

Think about furniture sets.

A furniture factory can produce:

- Modern chair
- Modern sofa
- Modern table

Another factory can produce:

- Classic chair
- Classic sofa
- Classic table

You do not want to mix a modern chair with a classic sofa if the room must follow one style.

Abstract Factory helps create related objects from the same family.

### When to use Abstract Factory

Use Abstract Factory when your application needs families of related objects.

Common examples:

- Windows UI components and Mac UI components
- Light theme components and dark theme components
- Modern furniture and classic furniture
- SQL database factory and NoSQL database factory

### Java example

```java
interface Button {
    void render();
}

interface Checkbox {
    void render();
}

class WindowsButton implements Button {
    public void render() {
        System.out.println("Rendering Windows button");
    }
}

class WindowsCheckbox implements Checkbox {
    public void render() {
        System.out.println("Rendering Windows checkbox");
    }
}

class MacButton implements Button {
    public void render() {
        System.out.println("Rendering Mac button");
    }
}

class MacCheckbox implements Checkbox {
    public void render() {
        System.out.println("Rendering Mac checkbox");
    }
}

interface UiFactory {
    Button createButton();
    Checkbox createCheckbox();
}

class WindowsUiFactory implements UiFactory {
    public Button createButton() {
        return new WindowsButton();
    }

    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacUiFactory implements UiFactory {
    public Button createButton() {
        return new MacButton();
    }

    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}
```

Usage:

```java
class Application {
    private final Button button;
    private final Checkbox checkbox;

    public Application(UiFactory factory) {
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
    }

    public void render() {
        button.render();
        checkbox.render();
    }
}
```

```java
UiFactory factory = new WindowsUiFactory();
Application app = new Application(factory);
app.render();
```

### Problem solved

The application does not care whether it is using Windows UI or Mac UI.

It only depends on the `UiFactory` abstraction.

This keeps related objects consistent.

## 4. Builder Pattern

### Meaning

Builder helps create complex objects step by step.

It is useful when a class has many optional fields or constructor parameters.

### Real-world example

Think about ordering a burger.

You can choose:

- Bread type
- Meat type
- Cheese
- Sauce
- Vegetables
- Extra toppings

It would be confusing if the restaurant asked for everything in one long sentence.

Instead, the burger is built step by step.

### When to use Builder

Use Builder when constructors become too long or unclear.

Common examples:

- Creating userEntity profiles
- Creating HTTP requests
- Creating reports
- Creating complex configuration objects
- Creating objects with many optional fields

### Bad example

```java
class User {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private int age;

    public User(String firstName, String lastName, String email, String phone, String address, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.age = age;
    }
}
```

Usage:

```java
User userEntity = new User("Ali", "Mammadov", "ali@example.com", null, null, 25);
```

This is hard to read.

It is not clear what each value means, and `null` values make it worse.

### Better example

```java
class User {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phone;
    private final String address;
    private final int age;

    private User(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.phone = builder.phone;
        this.address = builder.address;
        this.age = builder.age;
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String email;
        private String phone;
        private String address;
        private int age;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
```

Usage:

```java
User userEntity = new User.Builder()
        .firstName("Ali")
        .lastName("Mammadov")
        .email("ali@example.com")
        .age(25)
        .build();
```

### Problem solved

The object creation is now readable and flexible.

We can set only the fields we need.

Builder also helps make objects immutable because fields can be `final`.

## 5. Prototype Pattern

### Meaning

Prototype creates new objects by copying existing objects.

Instead of building an object from zero, we clone an existing object and modify what we need.

### Real-world example

Think about a document template.

If a company sends similar contracts to many clients, it does not write every contract from zero.

It copies an existing contract template and changes:

- Client name
- Date
- Price
- Address

The original template is the prototype.

### When to use Prototype

Use Prototype when creating an object from zero is expensive or repetitive.

Common examples:

- Copying document templates
- Copying game characters
- Copying shapes in a drawing application
- Creating similar configuration objects
- Duplicating objects with many fields

### Java example

```java
class Document implements Cloneable {
    private String title;
    private String content;
    private String author;

    public Document(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public Document clone() {
        try {
            return (Document) super.clone();
        } catch (CloneNotSupportedException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void print() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Content: " + content);
    }
}
```

Usage:

```java
Document contractTemplate = new Document(
        "Contract Template",
        "This contract is between Company and Client.",
        "Legal Department"
);

Document clientContract = contractTemplate.clone();
clientContract.setTitle("Contract for Ali");
clientContract.setContent("This contract is between Company and Ali.");

clientContract.print();
```

### Problem solved

We reuse the structure of an existing object instead of creating everything again.

This is useful when the original object has many fields or expensive setup logic.

### Important note

Be careful with shallow copy and deep copy.

A shallow copy copies the object but may still share nested objects.

For example, if a `Document` has a `List<String> comments`, a shallow clone may share the same list between the original and copied document.

In that case, changing comments in the copy could affect the original.

## Quick Comparison

| Pattern | Main idea | Real-world example | Best for |
| --- | --- | --- | --- |
| Singleton | Only one instance exists | School principal | Shared configuration, logger, cache |
| Factory Method | Create object based on type | Pizza restaurant | Choosing one object type |
| Abstract Factory | Create families of related objects | Furniture style factory | Related objects that must match |
| Builder | Create complex object step by step | Custom burger order | Many optional fields |
| Prototype | Create object by copying another | Contract template | Similar objects or expensive creation |

## Practical Shopping App Example

Imagine an online shopping application.

### Singleton

The application can have one shared configuration object.

```java
AppConfig config = AppConfig.getInstance();
```

### Factory Method

The app can create payment methods based on userEntity choice.

```java
PaymentMethod payment = PaymentFactory.create("CARD");
payment.pay(100);
```

### Abstract Factory

The app can create UI components for mobile and desktop themes.

```java
UiFactory factory = new MobileUiFactory();
Button button = factory.createButton();
Menu menu = factory.createMenu();
```

### Builder

The app can build an order with optional fields.

```java
Order order = new Order.Builder()
        .customerId(10)
        .deliveryAddress("Baku")
        .couponCode("SALE20")
        .giftWrap(true)
        .build();
```

### Prototype

The app can copy a product campaign template and customize it.

```java
Campaign summerCampaign = defaultCampaign.clone();
summerCampaign.setName("Summer Sale");
```

## Common Mistakes

### Using patterns too early

Do not use a design pattern just because it exists.

If simple object creation is enough, use simple object creation.

```java
Product product = new Product("Laptop", 2500);
```

This is perfectly fine when there is no complexity.

### Creating too many interfaces

Patterns should make code simpler, not more confusing.

If a pattern adds many classes but does not solve a real problem, it is probably unnecessary.

### Overusing Singleton

Singleton can make code hard to test because it creates global state.

Prefer dependency injection when possible.

### Confusing Factory Method and Abstract Factory

Factory Method usually creates one product.

```java
Notification notification = NotificationFactory.createNotification("EMAIL");
```

Abstract Factory creates a family of related products.

```java
Button button = uiFactory.createButton();
Checkbox checkbox = uiFactory.createCheckbox();
```

## Final Advice

Creational design patterns are useful when object creation becomes a design problem.

Use them when:

- Object creation logic is repeated in many places
- Constructors become too long
- You need to choose object types dynamically
- You need related objects that must work together
- Object creation is expensive
- You need one shared object across the application

The best design is not the design with the most patterns.

The best design is the one that keeps the code clear, flexible, and easy to change.
