package org.nlc.hsackathontracker.modal.db
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.nlc.hsackathontracker.modal.MyCustomConverter
import org.nlc.hsackathontracker.modal.dao.HackathonDao
import org.nlc.hsackathontracker.modal.dao.HackathonProjectDao
import org.nlc.hsackathontracker.modal.data.Hackathon
import org.nlc.hsackathontracker.modal.data.HackathonProject

@Database(entities = [Hackathon::class, HackathonProject::class], version = 7, exportSchema = false)
@TypeConverters(MyCustomConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun hackathonDao(): HackathonDao
    abstract fun hackathonProjectDao(): HackathonProjectDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "my_app_database"
                ).addCallback(object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            // Insert initial hackathon data when the database is created
                            GlobalScope.launch(Dispatchers.IO) {
                               insertSomeHackathon(getInstance(context).hackathonDao())
                            }
                        }
                    })
                    .build()
                INSTANCE = instance
                instance
            }
        }

        fun insertSomeHackathon(hackathonDao: HackathonDao) {
            val hackathon1 = Hackathon(
                hackathonName = "Hackathon A",
                date = "2023-08-10",
                location = "City X",
                organizer = "Tech Community Group",
                projectName = "Awesome Project",
                technologiesUsed = "Java, Spring Boot, React",
                projectDescription = "A web application for community engagement."
            )

            val hackathon2 = Hackathon(
                hackathonName = "Summer Hackfest",
                date = "2023-08-15",
                location = "Online",
                organizer = "Code Geeks",
                projectName = "Cool App",
                technologiesUsed = "Python, Django, Angular",
                projectDescription = "An interactive app for learning new coding skills."
            )

            val hackathon3 = Hackathon(
                hackathonName = "Data Science Challenge",
                date = "2023-08-20",
                location = "University Y",
                organizer = "Data Science Club",
                projectName = "Data Analyzer",
                technologiesUsed = "R, TensorFlow, Tableau",
                projectDescription = "A data analysis tool for research purposes."
            )

            val hackathon4 = Hackathon(
                hackathonName = "Designathon",
                date = "2023-08-25",
                location = "Art Center",
                organizer = "Design Community",
                projectName = "Artify",
                technologiesUsed = "Adobe Creative Suite, Sketch",
                projectDescription = "An art community platform for sharing designs."
            )

            val hackathon5 = Hackathon(
                hackathonName = "AI Hackathon",
                date = "2023-08-30",
                location = "Tech Hub",
                organizer = "AI Enthusiasts",
                projectName = "AI Bot",
                technologiesUsed = "Python, TensorFlow, OpenAI GPT",
                projectDescription = "An AI chatbot with natural language understanding."
            )

            hackathonDao.insertHackathon(hackathon1)
            hackathonDao.insertHackathon(hackathon2)
            hackathonDao.insertHackathon(hackathon3)
            hackathonDao.insertHackathon(hackathon4)
            hackathonDao.insertHackathon(hackathon5)
            //add all other
        }
    }

}
