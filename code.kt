// 1️⃣ Daypart Enum
enum class Daypart {
    MORNING, AFTERNOON, EVENING
}

// 2️⃣ Event Data Class
data class Event(
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val durationInMinutes: Int
)

// 3️⃣ Event için Extension Property (Bunu main fonksiyonunun dışında tanımlamalısın!)
val Event.durationOfEvent: String
    get() = if (this.durationInMinutes < 60) {
        "short"
    } else {
        "long"
    }

fun main() {
    // 4️⃣ Event Listesi
    val events = mutableListOf(
        Event(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, durationInMinutes = 0),
        Event(title = "Eat breakfast", daypart = Daypart.MORNING, durationInMinutes = 15),
        Event(title = "Learn about Kotlin", daypart = Daypart.AFTERNOON, durationInMinutes = 30),
        Event(title = "Practice Compose", daypart = Daypart.AFTERNOON, durationInMinutes = 60),
        Event(title = "Watch latest DevBytes video", daypart = Daypart.AFTERNOON, durationInMinutes = 10),
        Event(title = "Check out latest Android Jetpack library", daypart = Daypart.EVENING, durationInMinutes = 45)
    )

    println("Total number of events: ${events.size}")
    println(events[1].toString())

    // 5️⃣ Yeni Event Ekle
    events.add(Event(title = "Read a book", daypart = Daypart.EVENING, durationInMinutes = 20))

    println("Total number of events: ${events.size}")

    // 6️⃣ 60 dakikadan kısa eventler = short eventler
    val shortEvents = events.filter { it.durationInMinutes < 60 }
    println("Total number of short events: ${shortEvents.size}")

    // 7️⃣ Üç daypart için de gruplar oluşturalım
    val groupedEvents = events.groupBy { it.daypart }
    groupedEvents.forEach { (daypart, events) ->
        println("$daypart: ${events.size} events")

        // 8️⃣ Son elemanı yazdırma
        println("Last event of the day: ${events.last().title}")
    }

    // 9️⃣ İlk etkinliğin kısa mı uzun mu olduğunu yazdıralım
    println("Duration of first event of the day: ${events[0].durationOfEvent}")
}
