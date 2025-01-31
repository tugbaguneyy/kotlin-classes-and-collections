# Kotlin Classes and Collections Exercise

This project is part of the **More Kotlin Fundamentals** section from Android Developers, specifically the **Classes and Collections** exercise.

## Overview

This Kotlin program demonstrates the use of:
- **Enums** (`enum class`)
- **Data Classes** (`data class`)
- **Mutable Lists** (`mutableListOf`) for storing objects
- **Filtering Lists** (`filter`)
- **Grouping Collections** (`groupBy`)
- **Extension Properties**
- **Looping through Collections** (`forEach`)

## Code Explanation

### 1️⃣ Enum Class - `Daypart`
```kotlin
enum class Daypart {
    MORNING, AFTERNOON, EVENING
}
```
- Represents different parts of the day (Morning, Afternoon, Evening).
- Used to categorize events based on when they occur.

### 2️⃣ Data Class - `Event`
```kotlin
data class Event(
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val durationInMinutes: Int
)
```
- Represents an event with a title, optional description, time of day (`Daypart`), and duration.
- The `description` field is optional (defaults to `null`).
- `data class` automatically provides useful functions like `toString()`, `equals()`, and `copy()`.

### 3️⃣ Extension Property - `durationOfEvent`
```kotlin
val Event.durationOfEvent: String
    get() = if (this.durationInMinutes < 60) "short" else "long"
```
- Adds a custom property `durationOfEvent` to the `Event` class.
- Determines if an event is "short" (< 60 minutes) or "long" (≥ 60 minutes).

### 4️⃣ Mutable List - `events`
```kotlin
val events = mutableListOf(
    Event("Wake up", "Time to get up", Daypart.MORNING, 0),
    Event("Eat breakfast", daypart = Daypart.MORNING, durationInMinutes = 15),
    Event("Learn about Kotlin", daypart = Daypart.AFTERNOON, durationInMinutes = 30),
    Event("Practice Compose", daypart = Daypart.AFTERNOON, durationInMinutes = 60),
    Event("Watch latest DevBytes video", daypart = Daypart.AFTERNOON, durationInMinutes = 10),
    Event("Check out latest Android Jetpack library", daypart = Daypart.EVENING, durationInMinutes = 45)
)
```
- Stores multiple `Event` objects in a **mutable list** (`mutableListOf`).
- Allows adding new events dynamically.

### 5️⃣ Adding a New Event
```kotlin
events.add(Event("Read a book", daypart = Daypart.EVENING, durationInMinutes = 20))
```
- Uses `add()` function to insert a new event into the list.

### 6️⃣ Filtering Events (`filter`)
```kotlin
val shortEvents = events.filter { it.durationInMinutes < 60 }
println("Total number of short events: ${shortEvents.size}")
```
- Filters events to only include those with `durationInMinutes < 60`.
- Uses `.filter { condition }` to create a new list of short events.

### 7️⃣ Grouping Events (`groupBy`)
```kotlin
val groupedEvents = events.groupBy { it.daypart }
groupedEvents.forEach { (daypart, events) ->
    println("$daypart: ${events.size} events")
    println("Last event of the day: ${events.last().title}")
}
```
- Groups events based on `daypart` (Morning, Afternoon, Evening).
- Uses `.groupBy { it.daypart }` to create a map where:
  - **Key** = `Daypart`
  - **Value** = List of `Event`s occurring in that time period.
- Iterates over the groups using `.forEach { (key, value) -> }`.
- Uses `.last()` to get the most recent event in each time period.

### 8️⃣ Printing Event Duration
```kotlin
println("Duration of first event of the day: ${events[0].durationOfEvent}")
```
- Uses the **extension property** `durationOfEvent` to determine whether the first event is "short" or "long".

## Sample Output
```
Total number of events: 6
Event(title=Eat breakfast, description=null, daypart=MORNING, durationInMinutes=15)
Total number of events: 7
Total number of short events: 6
MORNING: 2 events
Last event of the day: Eat breakfast
AFTERNOON: 3 events
Last event of the day: Watch latest DevBytes video
EVENING: 2 events
Last event of the day: Read a book
Duration of first event of the day: short
```

## Key Takeaways
✅ **Enums** help categorize data logically.
✅ **Data classes** simplify object creation and management.
✅ **Lists** allow dynamic storage of multiple items.
✅ **Filtering** and **grouping** collections make data processing easy.
✅ **Extension properties** provide additional functionality without modifying the class.
✅ **Loops (`forEach`)** help iterate over collections efficiently.

---

### 📌 Exercise Source
This exercise is from **Android Developers - More Kotlin Fundamentals: Classes and Collections**.

Happy coding! 🚀
