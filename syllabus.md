# Seven-Month Java to Advanced Backend Development Syllabus (112 Hours)

## Program Format

- **Audience:** Beginners (no prior programming experience required)
- **Duration:** 7 months (28 weeks)
- **Class Load:** 2 lessons per week x 2 hours = 4 hours/week
- **Total Instructor-Led Hours:** 112
- **Target Outcome:** Advanced junior Java backend readiness

## Learning Goal

By the end of the program, students can design, build, test, secure, and deploy a production-style Java backend service
with Spring Boot, PostgreSQL, Docker, and Kubernetes fundamentals.

## Month 1 (Lessons 1–8): Java and Programming Foundations

### Lesson 1: Program Orientation, Java Ecosystem, and Environment Setup

**In-class coverage:**

- [x] Course roadmap, expectations, grading, and class workflow
- [ ] How computers work: CPU, RAM, storage, process model
- [ ] JDK vs JRE vs JVM and why Java is platform-independent
- [ ] Installing JDK and IntelliJ IDEA, project setup
- [ ] Writing and running the first Java program

### Lesson 2: Git and GitHub Fundamentals

**In-class coverage:**

- [ ] Why version control matters in real projects
- [ ] Git architecture (working tree, staging, local repository)
- [ ] Core commands: `init`, `add`, `commit`, `status`, `log`
- [ ] Git Branching Strategies: `main`, `feature`, `bugfix` and mering
- [ ] `.gitignore` and clean repository practices
- [ ] GitHub remote workflow and README basics
- [ ] How to use git in IntelliJ productively

### Lesson 3: Variables, Data Types, Operators, and Console I/O

**In-class coverage:**

- [ ] Variables, declaration, initialization, and naming conventions
- [ ] Primitive types and type selection strategy
- [ ] Data types underflow, overflow, and precision issues
- [ ] Java - Unicode System, ASCII, ISO 8859-1
- [ ] Type casting and automatic type conversion, Type Conversion Error
- [ ] Arithmetic, assignment, comparison, logical, and bitwise operators
- [ ] Input with `Scanner`, output formatting best practices
- [ ] Debugging small logic programs

### Lesson 4: Control Flow, Loops, and Methods

**In-class coverage:**

- [ ] `if/else` and `switch` decision-making patterns
- [ ] Looping with `for`, `while`, and `do-while`
- [ ] Method design: parameters, return types, scope
- [ ] Decomposing tasks into reusable methods
- [ ] Practice problems for algorithmic thinking

### Lesson 5: Arrays, Strings, and Iteration Patterns

**In-class coverage:**

- [ ] Array creation, indexing, traversal, and boundaries
- [ ] Operations in array, 2D array, 3D array 
- [ ] String internals, immutability, and common APIs
- [ ] Stack, Heap, and String Pool
- [ ] `StringBuilder` and `StringBuffer` for efficient string manipulation
- [ ] Searching and counting patterns in arrays/strings
- [ ] Edge-case handling and defensive checks

### Lesson 6: Algorithm and Data Structure, Problem-Solving, and Big-O Basics

**In-class coverage:**

- [ ] Decomposition and DRY principle in coding tasks
- [ ] Method extraction and clean-code refactoring
- [ ] Intro to time complexity and space complexity
- [ ] Common algorithm patterns for entry-level interviews
- [ ] Guided HackerRank/LeetCode-style exercises

### Lesson 7: OOP Fundamentals

**In-class coverage:**

- [ ] Classes, objects, fields, methods, constructors
- [ ] Encapsulation and access modifiers
- [ ] `this` keyword and object state management
- [ ] Designing simple domain models
- [ ] OOP coding lab with mini assignment

### Lesson 8: Recap, Quiz, and Coding Checkpoint

**In-class coverage:**

- [ ] Consolidated review of Lessons 1-7
- [ ] Quiz on syntax, logic, OOP basics, and Git workflow
- [ ] Guided debugging session and corrective feedback
- [ ] Homework review and study improvement plan

## Month 2 (Lessons 9-16): Core Java for Backend Development

### Lesson 9: Inheritance, Polymorphism, and Object Class

**In-class coverage:**

- [ ] Inheritance model and `extends`
- [ ] Method overriding, dynamic dispatch, and `super`
- [ ] `Object` class methods: `toString`, `equals`, `hashCode`
- [ ] Polymorphism in real coding scenarios
- [ ] Refactoring procedural code into OOP design

### Lesson 10: Abstraction, Interfaces, and Design for Testability

**In-class coverage:**

- [ ] Abstract classes vs interfaces: selection criteria
- [ ] Interface-based architecture and loose coupling
- [ ] Composition over inheritance principle
- [ ] Designing code for easier unit testing
- [ ] Practical interface-driven implementation exercise

### Lesson 11: Enums, Wrapper Types, var, and Parameter Passing

**In-class coverage:**

- [ ] Using `enum` for domain-safe constants
- [ ] Primitive wrappers (`Integer`, `Long`, `Double`) and boxing
- [ ] Local variable type inference with `var`
- [ ] Java pass-by-value behavior and common misunderstandings
- [ ] Method invocation patterns and parameter clarity

### Lesson 12: Collections Framework I (List)

**In-class coverage:**

- [ ] Collections architecture and interface hierarchy
- [ ] `List` implementations: `ArrayList` vs `LinkedList`
- [ ] Iteration patterns (`for`, enhanced for, iterator)
- [ ] Sorting with `Comparator`
- [ ] Big-O intuition for list operations

### Lesson 13: Collections Framework II (Set and Map)

**In-class coverage:**

- [ ] `Set` semantics and uniqueness constraints
- [ ] Hashing fundamentals and collision intuition
- [ ] `Map` as key-value store and iteration strategies
- [ ] Key mutability pitfalls and null-handling practices
- [ ] Choosing the right collection for backend use cases

### Lesson 14: Exceptions, Validation Basics, and Logging Intro

**In-class coverage:**

- [ ] Checked vs unchecked exceptions
- [ ] `try/catch/finally`, `throw`, and `throws`
- [ ] Designing custom exceptions
- [ ] Defensive programming mindset
- [ ] Intro to structured logging principles

### Lesson 15: Generics and Wildcards

**In-class coverage:**

- [ ] Why generics matter for type safety
- [ ] Generic classes and generic methods
- [ ] Wildcards: `?`, `? extends`, `? super`
- [ ] PECS rule for producer/consumer APIs
- [ ] Refactoring raw-type code into generic code

### Lesson 16: Recap, Quiz, and Practical Evaluation

**In-class coverage:**

- [ ] Review of OOP, collections, exceptions, and generics
- [ ] Quiz and live coding assessment
- [ ] Error analysis and personalized correction points
- [ ] Preparation plan for modern Java topics

## Month 3 (Lessons 17-24): Modern Java and Concurrency

### Lesson 17: Functional Interfaces, Lambdas, and Method References

**In-class coverage:**

- [ ] Functional programming mindset in Java
- [ ] Core functional interfaces (`Predicate`, `Function`, `Consumer`)
- [ ] Lambda syntax and readability practices
- [ ] Method references for cleaner code
- [ ] Refactoring anonymous classes to lambdas

### Lesson 18: Streams, Collectors, and Optional

**In-class coverage:**

- [ ] Stream pipeline model (source, intermediate, terminal)
- [ ] Filtering, mapping, grouping, and reduction
- [ ] `Collectors` patterns for backend transformations
- [ ] `Optional` for null-safety intent
- [ ] Stream debugging and anti-patterns

### Lesson 19: Java I/O and NIO.2

**In-class coverage:**

- [ ] Byte streams vs character streams
- [ ] Encoding/charset fundamentals and data correctness
- [ ] Buffering and performance considerations
- [ ] NIO.2 APIs: `Path`, `Files`, directory operations
- [ ] Safe file handling in backend utilities

### Lesson 20: Reflection and Annotations

**In-class coverage:**

- [ ] Reflection fundamentals and runtime metadata
- [ ] Inspecting fields, methods, constructors
- [ ] Custom annotation creation and usage
- [ ] Practical framework examples (Spring/JPA context)
- [ ] Reflection boundaries, performance, and safety

### Lesson 21: Thread Fundamentals

**In-class coverage:**

- [ ] Process vs. a thread model
- [ ] Thread lifecycle and scheduling intuition
- [ ] Creating threads (`Runnable` vs `Thread`)
- [ ] Interruption and cooperative cancellation
- [ ] Concurrency hazards overview

### Lesson 22: Advanced Concurrency and Virtual Threads

**In-class coverage:**

- [ ] `ExecutorService`, `Callable`, `Future`
- [ ] Coordination tools and lock concepts
- [ ] Deadlock patterns and prevention strategies
- [ ] `ReentrantLock` vs intrinsic locks
- [ ] Virtual threads and structured concurrency mindset

### Lesson 23: SOLID and Core Design Patterns

**In-class coverage:**

- [ ] SOLID principles for maintainable backend systems
- [ ] Factory, Builder, and Strategy patterns
- [ ] Decorator, Proxy, and Observer patterns
- [ ] Pattern trade-offs and misuse risks
- [ ] Pattern usage in Java/Spring codebases

### Lesson 24: Recap, Quiz, and Refactoring Lab

**In-class coverage:**

- [ ] Consolidated revision for functional Java and concurrency
- [ ] Quiz and short design exercise
- [ ] Refactoring lab on code quality and readability
- [ ] Feedback loop before backend stack expansion

## Month 4 (Lessons 25-32): Backend Foundations (DB, Network, Build, Spring)

### Lesson 25: Docker and Local Infrastructure

**In-class coverage:**

- [ ] Containers vs virtualization
- [ ] Docker images, containers, volumes, and networks
- [ ] Docker Hub workflow and image lifecycle
- [ ] Docker Compose for local multi-service setup
- [ ] Running PostgreSQL/Redis/RabbitMQ locally

### Lesson 26: SQL Foundations

**In-class coverage:**

- [ ] Relational model, tables, keys, and relationships
- [ ] SQL statement categories: DDL, DML, DQL
- [ ] Creating tables and inserting/updating/deleting rows
- [ ] Basic querying with filtering and ordering
- [ ] Database design hygiene for beginners

### Lesson 27: Advanced SQL and Transactions

**In-class coverage:**

- [ ] Joins (`INNER`, `LEFT`, `RIGHT`) and multi-table queries
- [ ] Aggregations and grouping
- [ ] Constraints and index fundamentals
- [ ] ACID properties and transaction boundaries
- [ ] `COMMIT`, `ROLLBACK`, and `SAVEPOINT`

### Lesson 28: HTTP and REST Fundamentals

**In-class coverage:**

- [ ] Client-server architecture and TCP/IP overview
- [ ] URI vs URL, HTTP methods, status codes
- [ ] REST constraints and resource-oriented design
- [ ] Consuming APIs with Java `HttpClient`
- [ ] Request/response modeling basics

### Lesson 29: JDBC and DAO Pattern

**In-class coverage:**

- [ ] JDBC architecture and driver concept
- [ ] Safe SQL with `PreparedStatement`
- [ ] Executing queries/updates and mapping `ResultSet`
- [ ] Transaction handling with JDBC
- [ ] DAO pattern and separation of concerns

### Lesson 30: Build Tooling and Project Lifecycle

**In-class coverage:**

- [ ] Why build tools are essential in backend teams
- [ ] Dependency management and version alignment
- [ ] Maven/Gradle lifecycle concepts
- [ ] Test/build/package pipeline
- [ ] Artifact and environment consistency practices

### Lesson 31: Spring Boot Fundamentals and First API

**In-class coverage:**

- [ ] Spring Boot architecture and autoconfiguration
- [ ] IoC container, beans, and dependency injection
- [ ] Bean scopes and wiring patterns
- [ ] Creating a first REST controller/service
- [ ] Project structure conventions in Spring Boot

### Lesson 32: Recap, Quiz, and Backend Checkpoint

**In-class coverage:**

- [ ] Review of Docker, SQL, HTTP, JDBC, and Spring basics
- [ ] Practical quiz and debugging challenge
- [ ] Checkpoint mini project discussion
- [ ] Readiness evaluation for persistence layer depth

## Month 5 (Lessons 33-40): Spring API, Persistence, and Data Integrity

### Lesson 33: REST Controller Design and API Layer Practices

**In-class coverage:**

- [ ] Controller-service-repository layering
- [ ] `@RequestParam`, `@PathVariable`, `@RequestBody`, headers
- [ ] DTO design and mapping strategy
- [ ] Postman workflow and API verification
- [ ] Clean endpoint naming and response standards

### Lesson 34: Configuration, Profiles, Logging, and API Docs

**In-class coverage:**

- [ ] `application.properties` vs `application.yml`
- [ ] Profiles and environment-specific configuration
- [ ] Externalized configuration with env variables and `@Value`
- [ ] Logging levels and structured logging patterns
- [ ] Swagger/OpenAPI documentation workflow

### Lesson 35: Spring Data JPA and CRUD Implementation

**In-class coverage:**

- [ ] JPA/Hibernate architecture fundamentals
- [ ] Entity modeling with `@Entity`, `@Table`, `@Id`
- [ ] `CrudRepository` and `JpaRepository`
- [ ] CRUD endpoints backed by database operations
- [ ] Transactional service layer basics

### Lesson 36: Entity Relationships and Fetch Strategy

**In-class coverage:**

- [ ] `@OneToOne`, `@OneToMany`, `@ManyToMany`
- [ ] Owning side, join columns, and cascading
- [ ] Lazy vs eager loading decisions
- [ ] N+1 query problem and mitigation with `@EntityGraph`
- [ ] Relationship mapping lab with sample domain

### Lesson 37: Query Optimization and Transaction Boundaries

**In-class coverage:**

- [ ] JPQL and native query use cases
- [ ] Pagination, sorting, and filtering patterns
- [ ] Transaction boundaries and consistency guarantees
- [ ] Connection pool concepts and performance impact
- [ ] Caching introduction and safe usage boundaries

### Lesson 38: Database Versioning with Liquibase

**In-class coverage:**

- [ ] Why schema versioning is mandatory in teams
- [ ] Liquibase setup and changelog structure
- [ ] Creating migrations for schema evolution
- [ ] Seed data strategy and rollback planning
- [ ] Common migration troubleshooting scenarios

### Lesson 39: Validation and Global Error Handling

**In-class coverage:**

- [ ] Bean Validation annotations (`@NotNull`, `@Size`, `@Email`, etc.)
- [ ] `@Valid` and `@Validated` in request flow
- [ ] Custom validators for domain rules
- [ ] Centralized exception handling (`@ControllerAdvice`)
- [ ] Standardized API error response structure

### Lesson 40: Recap, Quiz, and Feature Delivery Assessment

**In-class coverage:**

- [ ] Full review of Spring API and data layer topics
- [ ] Quiz and service hardening exercise
- [ ] Feedback on architecture and coding style
- [ ] Preparation for the security module

## Month 6 (Lessons 41–48): Security, Integration, Testing, and Architecture

### Lesson 41: Spring Security Foundations

**In-class coverage:**

- [ ] Authentication vs. authorization
- [ ] Security filter chain fundamentals
- [ ] Password hashing principles
- [ ] Endpoint access rules and CORS setup
- [ ] Baseline secure configuration in Spring Boot

### Lesson 42: JWT and Applied Security Patterns

**In-class coverage:**

- [ ] JWT structure and lifecycle
- [ ] Token generation, signing, and verification
- [ ] Access token validation filters
- [ ] Method-level authorization strategies
- [ ] Intro to practical cryptography choices

### Lesson 43: Scheduling and Background Processing

**In-class coverage:**

- [ ] Scheduled task use cases in backend systems
- [ ] `@EnableScheduling` and `@Scheduled`
- [ ] `fixedRate`, `fixedDelay`, `initialDelay`, and cron
- [ ] Reliability considerations for scheduled jobs
- [ ] Monitoring and failure-handling basics

### Lesson 44: Calling External Services

**In-class coverage:**

- [ ] Integration strategies with third-party APIs
- [ ] `RestTemplate`, `WebClient`, and Feign overview
- [ ] Headers, authentication, and timeout configuration
- [ ] Serialization/deserialization concerns
- [ ] Error handling and retry fundamentals

### Lesson 45: Testing Strategy (Unit + Integration)

**In-class coverage:**

- [ ] Testing pyramid and backend test scope
- [ ] Unit testing with JUnit and Mockito
- [ ] Integration tests for repository/service/API layers
- [ ] Test data setup patterns and isolation
- [ ] Intro to Testcontainers for realistic environments

### Lesson 46: Microservices Fundamentals

**In-class coverage:**

- [ ] Monolith vs microservices trade-offs
- [ ] Service boundaries and bounded contexts
- [ ] Synchronous vs. asynchronous communication options
- [ ] Deployment and operational complexity awareness
- [ ] Migration strategy from monolith to services

### Lesson 47: Microservice Design Patterns

**In-class coverage:**

- [ ] API Gateway and BFF patterns
- [ ] Database per service pattern
- [ ] Saga pattern for distributed transactions
- [ ] CQRS overview and practical boundaries
- [ ] Pattern selection by business and team constraints

### Lesson 48: Recap, Quiz, and Architecture Case Review

**In-class coverage:**

- [ ] Security, testing, and microservices revision
- [ ] Architecture case analysis and trade-off discussion
- [ ] Quiz with design and debugging components
- [ ] Capstone planning guidance

## Month 7 (Lessons 49-56): Deployment, Observability, and Career Readiness

### Lesson 49: Dockerfile, Integration Testing, and Contract Testing

**In-class coverage:**

- [ ] Production-ready Dockerfile structure
- [ ] Multi-stage builds and image size reduction
- [ ] Integration testing in CI-friendly workflows
- [ ] Contract testing basics and provider-consumer alignment
- [ ] Release-readiness checklist

### Lesson 50: Kubernetes Fundamentals

**In-class coverage:**

- [ ] Kubernetes architecture and core components
- [ ] Pods, Deployments, ReplicaSets, and scaling
- [ ] Declarative manifests and rollout workflow
- [ ] Local cluster practice (Minikube or equivalent)
- [ ] Basic troubleshooting commands

### Lesson 51: Service Exposure and Runtime Configuration in Kubernetes

**In-class coverage:**

- [ ] Service types: ClusterIP, NodePort, LoadBalancer
- [ ] Ingress fundamentals and routing
- [ ] Readiness and liveness probes
- [ ] ConfigMaps and Secrets for configuration
- [ ] Safe deployment patterns for backend APIs

### Lesson 52: Monitoring and Metrics

**In-class coverage:**

- [ ] Observability pillars and operational visibility
- [ ] Metrics collection with Micrometer
- [ ] Prometheus scraping model
- [ ] Grafana dashboard creation and alert baselines
- [ ] Health/SLA monitoring essentials

### Lesson 53: Centralized Logging and Tracing Basics

**In-class coverage:**

- [ ] Structured logging standards
- [ ] Log aggregation with Loki (or equivalent stack)
- [ ] Correlation IDs and request traceability
- [ ] Intro to distributed tracing concepts
- [ ] Incident triage workflow

### Lesson 54: Agile Delivery and Project Management

**In-class coverage:**

- [ ] Agile values and Scrum ceremonies
- [ ] Backlog management and sprint planning
- [ ] Task tracking with Jira
- [ ] Team Git workflow in enterprise projects
- [ ] Communication and delivery accountability

### Lesson 55: Interview Preparation and CV/GitHub Review

**In-class coverage:**

- [ ] Java and Spring interview question drills
- [ ] Backend system design fundamentals for juniors
- [ ] Behavioral interview response structure
- [ ] CV optimization for backend roles
- [ ] GitHub project presentation and storytelling

### Lesson 56: Final Exam and Capstone Presentation

**In-class coverage:**

- [ ] End-to-end capstone demonstration
- [ ] Technical viva: architecture and implementation decisions
- [ ] Final practical/technical evaluation
- [ ] Individual feedback and next-step roadmap
- [ ] Job-readiness action plan

## Final Capstone Minimum Requirements

- REST API with meaningful business endpoints
- PostgreSQL integration via Spring Data JPA
- Liquibase migrations for schema versioning
- JWT-based authentication and authorization
- Validation and global exception handling
- Unit and integration tests for key flows
- Dockerized application and local run instructions
- Kubernetes manifests for deployment and service exposure
